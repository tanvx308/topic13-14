package fis.java.topic13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fis.java.topic13.constant.ContextUrl;
import fis.java.topic13.dto.FormDetailDto;
import fis.java.topic13.entity.Detail;
import fis.java.topic13.exception.AppException;
import fis.java.topic13.service.IDetailService;
import fis.java.topic13.service.IOrderService;
import fis.java.topic13.service.IProductService;

@RestController
@RequestMapping(path = ContextUrl.API_URL)
public class DetailController {
	@Autowired
	IProductService productService;
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IDetailService detailService;

	@PostMapping(path = ContextUrl.DETAIL_SAVE)
	public ResponseEntity<?> saveDetail(@Validated FormDetailDto detailDto,
			@RequestParam("order_id") Optional<Long> order_id,
			@RequestParam("product_id") Optional<Long> product_id){
		Detail detail = detailDto.transfer();
		detail.setOrder(orderService.fidById(order_id.get()));
		detail.setProduct(productService.findById(product_id.get()));
		try {
			return ResponseEntity.ok().body(detailService.save(detail));
		} catch (AppException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(path = ContextUrl.DETAIL_FIND_BY_ORDER)
	public ResponseEntity<?> findByOrder(@RequestParam("order_id") Optional<Long> id){
		try {
			return ResponseEntity.ok().body(detailService.findByOrder(id.get()));
		} catch (AppException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
