package fis.java.topic13.service;

import java.util.List;

import fis.java.topic13.dto.AccountDto;
import fis.java.topic13.entity.Account;
import fis.java.topic13.exception.NotValidAccountException;

public interface AccountService {

	List<Account> findAll();

	Account save(Account account) throws NotValidAccountException;
	
	Account findByAccountNumber(String accountNumber);
	
	Account findById(Long id);
	
	void deleteById(Long id);
}
