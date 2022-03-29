package fis.java.topic13.dto;

import javax.validation.constraints.NotNull;

import fis.java.topic13.entity.Detail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormDetailDto {
	@NotNull(message = "Quantity is required")
	private Integer quantity;
	
	public Detail transfer() {
		Detail detail = new Detail();
		detail.setQuantity(this.quantity);
		return detail;
	}
}
