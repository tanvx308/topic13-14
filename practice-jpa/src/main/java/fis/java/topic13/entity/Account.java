package fis.java.topic13.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "account")
@NoArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "balance")
	private Double balance = 100000d;
	
	@Column(name ="status")
	private Integer status = 1;
	
	@OneToMany(mappedBy = "account")
	Set<Transaction> transactions;
}
