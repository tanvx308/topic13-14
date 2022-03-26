package fis.java.topic13.dto;

import lombok.Data;

@Data
public class TransactionDto {
	private Long fromAccount;
	
	private Long toAccount;
	
	private Double amount;
	
	private String content;
	
}
