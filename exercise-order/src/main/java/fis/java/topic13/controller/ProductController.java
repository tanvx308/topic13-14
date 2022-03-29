package fis.java.topic13.controller;

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
import fis.java.topic13.dto.FormProductDto;
import fis.java.topic13.entity.Customer;
import fis.java.topic13.entity.Product;
import fis.java.topic13.service.IProductService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = ContextUrl.API_URL)
@Slf4j
public class ProductController {
	@Autowired
	IProductService productService;
	
	@GetMapping(path = ContextUrl.PRODUCT_FIND_ALL)
	public ResponseEntity<?> findAll(@RequestParam("page") Optional<Integer> page){
		Pageable pageable = PageRequest.of(page.orElse(1) - 1, 6);
		return ResponseEntity.ok().body(productService.findAll(pageable));
	}
	
	@PostMapping(path = ContextUrl.PRODUCT_SAVE)
	public ResponseEntity<?> saveCustomer(@Validated @RequestBody FormProductDto productDto){
		Product product = productDto.transfer();
		return ResponseEntity.ok().body(productService.save(product));
	}
	
	@GetMapping(path = ContextUrl.PRODUCT_FIND_ONE)
	public ResponseEntity<?> findCustomerById(@PathVariable("id") Optional<Long> id){
		Product product = productService.findById(id.get());
		if(product == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Product with id %d is not exist", id.get()));
		}else {
			return ResponseEntity.ok().body(product);
		}
	}
	
	@PostMapping(path = ContextUrl.PRODUCT_UPDATE)
	public ResponseEntity<?> updateCustomer(@Validated @RequestBody FormProductDto productDto,
			@PathVariable("id") Optional<Long> id){
		Product product = productService.findById(id.get());
		if(product == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Product with id %d is not exist", id.get()));
		}else {
			product.setName(productDto.getName());
			product.setPrice(productDto.getPrice());
			return ResponseEntity.ok().body(productService.update(product));
		}	
	}
	
	@GetMapping(path = ContextUrl.PRODUCT_DELETE)
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") Optional<Long> id){
		Product product = productService.findById(id.get());
		if(product == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Product with id %d is not exist", id.get()));
		}else {
			productService.deleteById(id.get());
			return ResponseEntity.ok().body(String.format("Product with id %d is in_active now", id.get()));
		}
	}
}
