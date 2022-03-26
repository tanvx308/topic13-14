package fis.java.topic13.service;

import java.util.List;

import fis.java.topic13.dto.TransactionDto;
import fis.java.topic13.entity.Transaction;

public interface TransactionService {
	Transaction save(TransactionDto transactionDto);
	
	List<Transaction> findAll();
}
