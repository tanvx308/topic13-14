package fis.java.topic13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.java.topic13.constant.ContextUrl;

import fis.java.topic13.service.ICategoryService;

@RestController
@RequestMapping(path = ContextUrl.API_URL)
public class CategoryController {
	
	@Autowired
	ICategoryService categoryService;
	
	@GetMapping(path = ContextUrl.CATEGORY_FIND_ALL)
	public ResponseEntity<?> findAll(){
			return ResponseEntity.ok().body(categoryService.findAll(PageRequest.of(0, 6)));		
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> report(){
		return ResponseEntity.ok().body(categoryService.report());
	}
}
