package fis.java.topic13.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import fis.java.topic13.entity.Product;

public interface IProductService {
	List<Product> findAll(Pageable pageable);
	
	Product save(Product product);
	
	Product update(Product product);
	
	Product findById(Long id);
	
	void deleteById(Long id);
}
