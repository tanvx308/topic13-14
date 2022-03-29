package fis.java.topic13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import fis.java.topic13.dto.FormOrderDto;
import fis.java.topic13.entity.Customer;
import fis.java.topic13.entity.Order;
import fis.java.topic13.exception.AppException;
import fis.java.topic13.service.ICustomerService;
import fis.java.topic13.service.IOrderService;

@RestController
@RequestMapping(path = ContextUrl.API_URL)
public class OrderController {
	@Autowired
	IOrderService orderService;
	
	@Autowired
	ICustomerService customerService;
	
	@GetMapping(path = ContextUrl.ORDER_FIND_BY_CUSTOMER)
	public ResponseEntity<?> findByCustomer(@RequestParam("customer_id") Optional<Long> id){
		try {
			return ResponseEntity.ok().body(orderService.findByCustomer(id.get()));
		}catch (AppException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping(path = ContextUrl.ORDER_SAVE)
	public ResponseEntity<?> saveOrder(@PathVariable("id") Optional<Long> id,
			@Validated @RequestBody FormOrderDto orderDto){
		if(customerService.findById(id.get()) == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Customer with id %d is not exist", id));
		}
		Customer customer = customerService.findById(id.get());
		return ResponseEntity.ok().body(orderService.save(orderDto.transfer(), customer));
	}
}
