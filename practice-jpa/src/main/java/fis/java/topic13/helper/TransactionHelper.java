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
		Transaction transaction = new Transaction();
		Account from = accountService.findById(transactionDto.getFromAccount());
		transaction.setAccount(from);
		transaction.setToAccount(transactionDto.getToAccount());
		transaction.setAmount(transactionDto.getAmount());
		transaction.setContent(transactionDto.getContent());
		transaction.setTransactionDate(new Date());
		try {
			sendMoney(transactionDto.getFromAccount(), transactionDto.getToAccount(), transactionDto.getAmount());
		} catch (NotValidAccountException e) {
			transaction.setErrorReason(e.getMessage());
		}
		return transaction;	
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public synchronized void addAmount(Long id, double amount) {
		Account acc = accountService.findById(id);
		if (acc == null) {
			LOG.error("From account is not exist");
			throw new NotValidAccountException("4004", "Account is not exist");
		}else {
			if(acc.getStatus() != 1) {
				LOG.error("From account is out of date");
				throw new ErrorTransactionException("4005", "From account is out of date");
			}
		}
		double newBalance = acc.getBalance() + amount;
		if (newBalance < 0) {
			LOG.error("From account`s balance is not enough");
			throw new NotValidAccountException("4006", "Account's balance is not enough");
		}
		acc.setBalance(newBalance);
		accountService.save(acc);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = NotValidAccountException.class)
	public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws NotValidAccountException {

		addAmount(toAccountId, amount);
		addAmount(fromAccountId, -amount);
	}
	
	public String notice(Transaction transaction) {
		StringBuilder sb = new StringBuilder();
		Account from = transaction.getAccount();
		sb.append(from.getAccountName()).append(" - ").append(from.getAccountNumber()).append(" - ");
		sb.append("tăng ").append(transaction.getAmount()).append(" VND vào lúc ").append(transaction.getTransactionDate().toString());
		return sb.toString();
	}
}
