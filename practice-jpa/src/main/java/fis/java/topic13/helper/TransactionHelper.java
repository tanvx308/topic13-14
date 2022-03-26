package fis.java.topic13.helper;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fis.java.topic13.dto.TransactionDto;
import fis.java.topic13.entity.Account;
import fis.java.topic13.entity.Transaction;
import fis.java.topic13.exception.ErrorTransactionException;
import fis.java.topic13.exception.NotValidAccountException;
import fis.java.topic13.repository.AccountRepository;
import fis.java.topic13.repository.TransactionRepository;
import fis.java.topic13.service.AccountService;

@Service
public class TransactionHelper {
	@Autowired
	private AccountService accountService;
	
	private static Logger LOG = LogManager.getLogger(TransactionHelper.class);
	
	public Transaction convertFromDto(TransactionDto transactionDto) {
		Account from = accountService.findById(transactionDto.getFromAccount());
		
		Transaction transaction = new Transaction();
		transaction.setAccount(from);
		transaction.setToAccount(transactionDto.getToAccount());
		transaction.setAmount(transactionDto.getAmount());
		transaction.setContent(transactionDto.getContent());
		transaction.setTransactionDate(new Date());
		return transaction;
	}
	
	public void checkTransaction(TransactionDto transactionDto) throws ErrorTransactionException {
		Account from = accountService.findById(transactionDto.getFromAccount());
		if(from == null) {
			LOG.error("From account is not exist");
			throw new ErrorTransactionException("4004", "From account is not exist");
		}else {
			if(from.getStatus() != 1) {
				LOG.error("From account is out of date");
				throw new ErrorTransactionException("4005", "From account is out of date");
			}
			if(from.getBalance() < transactionDto.getAmount()) {
				LOG.error("From account`s balance is not enough");
				throw new ErrorTransactionException("4005", "From account`s balance is not enough");
			}
		}
		
		Account to = accountService.findById(transactionDto.getToAccount());
		if(to == null) {
			LOG.error("To account is not exist");
			throw new ErrorTransactionException("4004", "To account is not exist");
		}else {
			if(to.getStatus() != 1) {
				LOG.error("To account is out of date");
				throw new ErrorTransactionException("4005", "To account is out of date");
			}
		}
	}
	@Transactional(propagation = Propagation.MANDATORY)
	public void sendMoney(Transaction transaction) {
		Account from = transaction.getAccount();
		Account to = accountService.findById(transaction.getId());
		
		from.setBalance(from.getBalance() - transaction.getAmount());
		accountService.update(from);
		to.setBalance(to.getBalance() + transaction.getAmount());
		accountService.update(to);
	}
}
