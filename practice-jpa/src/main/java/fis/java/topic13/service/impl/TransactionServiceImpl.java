package fis.java.topic13.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.topic13.dto.TransactionDto;
import fis.java.topic13.entity.Transaction;
import fis.java.topic13.exception.ErrorTransactionException;
import fis.java.topic13.helper.TransactionHelper;
import fis.java.topic13.repository.TransactionRepository;
import fis.java.topic13.service.TransactionService;


@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	TransactionHelper transactionHelper;
	
	private static Logger LOG = LogManager.getLogger(TransactionServiceImpl.class);

	@Override
	public Transaction save(TransactionDto transactionDto) {
		Transaction transaction = transactionHelper.convertFromDto(transactionDto);	
		
		String error = transaction.getErrorReason();
		if(error == null || error.isEmpty()) {
			transaction.setStatus(1);
		}else {
			transaction.setStatus(0);
		}
		LOG.info("Adding transaction to database {}", transaction);
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> findAll() {
		// TODO Auto-generated method stub
		LOG.info("Find all transaction to database");
		return transactionRepository.findAll();
	}

}
