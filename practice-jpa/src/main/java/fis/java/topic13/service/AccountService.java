package fis.java.topic13.service;

import java.util.List;

import fis.java.topic13.dto.AccountDto;
import fis.java.topic13.entity.Account;
import fis.java.topic13.exception.NotValidAccountException;

public interface AccountService {

	List<Account> findAll();

	Account save(AccountDto accountDto) throws NotValidAccountException;

	Account update(Account account);
	
	Account findByAccountNumber(String accountNumber);
	
	Account findById(Long id);
	
	void deleteById(Long id);
}
