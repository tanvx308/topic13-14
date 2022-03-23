package fis.java.topic12.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fis.java.topic12.mapper.ProductMapper;
import fis.java.topic12.model.Product;
import fis.java.topic12.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM store.products LIMIT 8";
		List<Product> list = jdbcTemplate.query(sql, new ProductMapper());
		return list;
	}

	@Override
	public Optional<Product> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
