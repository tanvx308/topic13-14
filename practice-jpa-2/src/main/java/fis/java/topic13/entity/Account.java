package fis.java.topic13.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long accountId;
	
	@Column(name = "account_no")
	private String accountNo;
	
	@Column(name = "card_no")
	private String cardNo;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "amount")
	private Double amount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "issued_date")
	private Date issuedDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;
}
