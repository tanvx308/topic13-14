package fis.java.topic13.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fis.java.topic13.constant.ContextUrl;
import fis.java.topic13.dto.FormCustomerDto;
import fis.java.topic13.entity.Customer;
import fis.java.topic13.entity.Order;
import fis.java.topic13.exception.AppException;
import fis.java.topic13.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = ContextUrl.API_URL)
@Slf4j
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	
	@GetMapping(path = ContextUrl.CUSTOMER_FIND_ALL)
	public ResponseEntity<?> findAll(@RequestParam("page") Optional<Integer> page){
		Pageable pageable = PageRequest.of(page.orElse(1) - 1, 6);
		return ResponseEntity.ok().body(customerService.findAll(pageable));
	}
	
	@PostMapping(path = ContextUrl.CUSTOMER_SAVE)
	public ResponseEntity<?> saveCustomer(@Validated @RequestBody FormCustomerDto customerDto){
		Customer customer = customerDto.transfer();
		return ResponseEntity.ok().body(customerService.save(customer));
	}
	
	@GetMapping(path = ContextUrl.CUSTOMER_FIND_ONE)
	public ResponseEntity<?> findCustomerById(@PathVariable("id") Optional<Long> id){
		try {
			return ResponseEntity.ok().body(customerService.findById(id.get()));
		} catch (AppException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping(path = ContextUrl.CUSTOMER_UPDATE)
	public ResponseEntity<?> updateCustomer(@Validated @RequestBody FormCustomerDto customerDto,
			@PathVariable("id") Optional<Long> id){
		Customer customer = customerService.findById(id.orElse(null));
		try {
			customer.setName(customerDto.getName());
			customer.setBirthday(customerDto.getBirthday());
			customer.setEmail(customerDto.getEmail());
			return ResponseEntity.ok().body(customerService.update(customer));
		} catch (AppException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(path = ContextUrl.CUSTOMER_DELETE)
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") Optional<Long> id){
		try {
			customerService.deleteById(id.get());
			return ResponseEntity.ok().body(String.format("Customer with id %d is in_active now", id.get()));
		}catch (AppException e)  {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
