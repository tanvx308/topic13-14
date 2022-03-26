package fis.java.topic13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.java.topic13.dto.TransactionDto;
import fis.java.topic13.exception.NotValidAccountException;
import fis.java.topic13.service.TransactionService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")

public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transactions")
	public ResponseEntity<?> getTransactions(){
		return ResponseEntity.ok().body(transactionService.findAll());
	}
	
	@PostMapping("/transaction/save")
	public ResponseEntity<?> saveTransaction(@RequestBody TransactionDto transactionDto){
		return ResponseEntity.ok().body( transactionService.save(transactionDto));	
	}
}
