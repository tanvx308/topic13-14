package fis.java.topic13.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import fis.java.topic13.entity.Customer;
import fis.java.topic13.entity.Order;

public interface IOrderService {
	List<Order> findByCustomer(Long id);
	
	Order save(Order order, Customer customer);	
	
	Order fidById(Long id);
}
