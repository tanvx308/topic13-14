package fis.java.topic13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fis.java.topic13.entity.Account;
import fis.java.topic13.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/account/save")
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody Account account) {
		return ResponseEntity.ok().body(accountService.save(account));
	}
	
	@PostMapping("/account/update")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Account account) {
		return ResponseEntity.ok().body(accountService.update(account));
	}
	
	@GetMapping("/account/delete/{accountId}")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable("accountId") Optional<Long> accountId) {
		accountService.deleteById(accountId.get());
		return ResponseEntity.ok().body("Successfully");
	}
	
	@GetMapping("/account/id/{accountId}")
	@ResponseBody
	public ResponseEntity<?> getById(@PathVariable("accountId") Optional<Long> accountId) {
		return ResponseEntity.ok().body(accountService.getById(accountId.get()));
	}
	
	@GetMapping("/account/fullname/{fullname}")
	@ResponseBody
	public ResponseEntity<?> getByFullname(@PathVariable("fullname") Optional<String> fullname) {
		return ResponseEntity.ok().body(accountService.getByFullname(fullname.get()));
	}
}
