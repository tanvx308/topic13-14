package fis.java.topic13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.java.topic13.dto.AccountDto;
import fis.java.topic13.entity.Account;
import fis.java.topic13.exception.NotValidAccountException;
import fis.java.topic13.helper.AccountHelper;
import fis.java.topic13.service.AccountService;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
	@Autowired
	AccountService accountService;

	@Autowired
	AccountHelper accountHelper;
	
	@GetMapping("/accounts")
	public ResponseEntity<?> getAccounts(){
		return ResponseEntity.ok().body(accountService.findAll());
	}
	
	@PostMapping("/account/save")
	public ResponseEntity<?> saveAccount(@RequestBody AccountDto accountDto){	
		try {
			accountHelper.checkAccountDto(accountDto);
			Account account = accountHelper.transfer(accountDto);
			return ResponseEntity.ok().body(accountService.save(account));
		} catch (NotValidAccountException e) {
			return ResponseEntity.ok().body(e);
		}
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Optional<Long> id){
		Account account = accountService.findById(id.get());
		if(account == null) {
			return ResponseEntity.ok().body("Not exist Account");
		}
		return ResponseEntity.ok().body(account);
	}
	
	@DeleteMapping("/account/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Optional<Long> id){
		Account account = accountService.findById(id.get());
		if(account == null) {
			return ResponseEntity.ok().body("Not exist Account");
		}
		accountService.deleteById(account.getId());
		return ResponseEntity.ok().body("Delete successfully");
	}
	
}
