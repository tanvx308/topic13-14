package fis.java.topic13.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import fis.java.topic13.constant.MyConstant;
import fis.java.topic13.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormCustomerDto {
	@NotEmpty(message = "Name is required")
	private String name;
	
	@Past
	@NotNull(message = "Birthday is required")
	private Date birthday;
	
	@NotEmpty(message = "Email is required")
	private String email;
	
	public Customer transfer() {
		Customer customer = new Customer();
		customer.setName(this.name);
		customer.setBirthday(this.birthday);
		customer.setEmail(this.email);
		customer.setAvailable(MyConstant.ACTIVE);
		return customer;
	}
}
