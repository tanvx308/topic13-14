package fis.java.topic13.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import fis.java.topic13.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormOrderDto {
	@NotEmpty
	private String address;
	
	@NotNull
	@PastOrPresent
	private Date created;
	
	public Order transfer() {
		Order order = new Order();
		order.setAddress(this.address);
		order.setCreated(this.created);
		return order;
	}
}
