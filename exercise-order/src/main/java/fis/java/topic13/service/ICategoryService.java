package fis.java.topic13.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import fis.java.topic13.entity.Category;
import fis.java.topic13.entity.Product;

public interface ICategoryService {
	List<Category> findAll(Pageable pageable);
	
	List<Object[]> report();
}
