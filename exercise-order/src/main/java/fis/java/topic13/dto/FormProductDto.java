package fis.java.topic13.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fis.java.topic13.constant.MyConstant;
import fis.java.topic13.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormProductDto {
	@NotEmpty(message = "Name is required")
	private String name;
	
	@NotNull(message = "Price is required")
	@Min(value = 50000)
	private Double price;
	
	public Product transfer() {
		Product product = new Product();
		product.setName(this.name);
		product.setPrice(this.price);
		product.setAvailable(MyConstant.ACTIVE);
		return product;
	}
}
