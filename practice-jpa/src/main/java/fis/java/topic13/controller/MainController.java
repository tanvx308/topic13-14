package fis.java.topic13.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fis.java.topic13.entity.Account;
import fis.java.topic13.service.AccountService;

@Controller
public class MainController {
	@Autowired
	AccountService accountService;

	@GetMapping("/index")
	public String getIndex(Model model) {
		List<Account> accounts = accountService.findAll();
		model.addAttribute("account", accounts);
		return "index";
	}
	
	@PostMapping("/account/add")
	public String addAccount(Model model, 
			@RequestParam("accountNumber") Optional<String> accountNumber,
			@RequestParam("accountName") Optional<String> accountName) {
		Account account = new Account();
		account.setAccountName(accountName.get());
		account.setAccountNumber(accountNumber.get());
		accountService.save(account);
		return "redirect:/index";
	}
}
