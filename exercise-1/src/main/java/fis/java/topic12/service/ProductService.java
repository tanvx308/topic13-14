package fis.java.topic12.service;

import java.util.List;
import java.util.Optional;

import fis.java.topic12.model.Product;

public interface ProductService {

	Optional<Product> findById(Integer id);

	List<Product> findAll();

}
