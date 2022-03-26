package fis.java.topic13.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.topic13.dto.AccountDto;
import fis.java.topic13.entity.Account;
import fis.java.topic13.exception.NotValidAccountException;
import fis.java.topic13.service.AccountService;


@Service
public class AccountHelper {
	
	private static Logger LOG = LogManager.getLogger(AccountHelper.class);
	
	public void checkAccountDto(AccountDto accountDto) throws NotValidAccountException {
		String accountNumber = accountDto.getAccountNumber();
		if(accountNumber.trim().length() != 12) {
			LOG.error("Error: Account number length is 12 character");
			throw new NotValidAccountException("3000", "Account number length is 12 character");
		}
		
		String accountName = accountDto.getAccountName();
		if(accountName.trim().length() < 5 || accountName.trim().length() > 100) {
			LOG.error("Error: Account name length is between 5 and 100 character");
			 throw new NotValidAccountException("3001", "Account name length is between 5 and 100 character");
		}
			
	}
	
	public void checkAccount(Account account) throws NotValidAccountException {
		Integer status = account.getStatus();
		if(status < 0 || status > 2) {
			LOG.error("Error: Invalid status");
			throw new NotValidAccountException("3003", "Invalid status");
		}
	}
		
	public Account transfer(AccountDto accountDto) {
		Account account = new Account();
		account.setAccountName(accountDto.getAccountName());
		account.setAccountNumber(accountDto.getAccountNumber());
		account.setBalance(100000d);
		account.setStatus(1);
		return account;
	}
	
}
