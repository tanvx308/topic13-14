package fis.java.topic12.repository;

import java.util.List;
import java.util.Optional;

import fis.java.topic12.model.Product;

public interface ProductRepository {
	
	List<Product> findAll();
	
	Optional<Product> findById(Integer id);

}
