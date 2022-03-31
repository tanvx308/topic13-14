package fis.java.topic13.model;

import fis.java.topic13.entity.Category;
import fis.java.topic13.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
	private Category category;
	
	private Double amount;
}
