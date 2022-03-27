package fis.java.topic13.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDto {

	private Long id;

	private String accountNumber;

	private String accountName;

	private Double balance;

	private Integer status;

}
