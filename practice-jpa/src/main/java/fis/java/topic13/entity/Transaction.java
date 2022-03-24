package fis.java.topic13.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "transaction_date")
	private Date transactionDate;	
	
	@Column(name = "to_account")
	private Number toAccount;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "error_reason")
	private String errorReason;
	
	@ManyToOne
	@JoinColumn(name = "from_account", nullable = false)
	Account account;
}
