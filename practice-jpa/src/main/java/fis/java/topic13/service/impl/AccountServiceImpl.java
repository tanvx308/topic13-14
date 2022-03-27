package fis.java.topic13.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.topic13.dto.AccountDto;
import fis.java.topic13.entity.Account;
import fis.java.topic13.exception.NotValidAccountException;
import fis.java.topic13.helper.AccountHelper;
import fis.java.topic13.repository.AccountRepository;
import fis.java.topic13.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountHelper accountHelper;

	private static Logger LOG = LogManager.getLogger(AccountServiceImpl.class);
	
	@Override
	public Account save(Account account){
		return accountRepository.save(account);
	}


	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		LOG.info("Find all account in database");
		return accountRepository.findAll();
	}


	@Override
	public Account findByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		LOG.info("Find account by account number {} in database", accountNumber);
		return accountRepository.findByAccountNumber(accountNumber);
	}


	@Override
	public Account findById(Long id) {
		// TODO Auto-generated method stub
		LOG.info("Find account by id {} in database", id);
		return accountRepository.findById(id).orElse(null);
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		LOG.info("Delete account by id {} in database", id);
		accountRepository.deleteById(id);
	}

}
