package fis.java.topic13.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.topic13.entity.Account;
import fis.java.topic13.repo.AccountRepo;
import fis.java.topic13.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepo accountRepo;

	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		account.setIssuedDate(new Date());
		return accountRepo.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		account.setUpdateDate(new Date());
		return accountRepo.save(account);
	}

	@Override
	public void deleteById(Long accountId) {
		// TODO Auto-generated method stub
		accountRepo.deleteById(accountId);
	}

	@Override
	public Account getById(Long accountId) {
		// TODO Auto-generated method stub
		return accountRepo.findById(accountId).get();
	}

	@Override
	public List<Account> getByFullname(String fullname) {
		// TODO Auto-generated method stub
		return accountRepo.getByFullname(fullname);
	}

}
