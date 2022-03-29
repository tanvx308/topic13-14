package fis.java.topic13.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import fis.java.topic13.entity.Customer;

public interface ICustomerService {
	List<Customer> findAll(Pageable pageable);
	
	Customer save(Customer customer);
	
	Customer findById(Long id);
	
	Customer update(Customer customer);
	
	void deleteById(Long id);
}
