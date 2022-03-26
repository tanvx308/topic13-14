package fis.java.topic13.service;

import java.util.List;

import fis.java.topic13.entity.Account;

public interface AccountService {
	Account save(Account account);
	
	Account update(Account account);
	
	void deleteById(Long accountId);
	
	Account getById(Long accountId);
	
	List<Account> getByFullname(String fullname);
}
