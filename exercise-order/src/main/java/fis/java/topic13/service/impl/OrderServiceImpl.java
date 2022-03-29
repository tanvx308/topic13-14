package fis.java.topic13.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.topic13.entity.Customer;
import fis.java.topic13.entity.Order;
import fis.java.topic13.exception.AppException;
import fis.java.topic13.repo.ICustomerRepo;
import fis.java.topic13.repo.IOrderRepo;
import fis.java.topic13.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	ICustomerRepo customerRepo;

	@Autowired
	IOrderRepo orderRepo;

	@Override
	public Order save(Order order, Customer customer) {
		customer.getOrders().add(order);
		customerRepo.save(customer);
		return customer.getOrders().get(customer.getOrders().size() - 1);
	}

	@Override
	public List<Order> findByCustomer(Long id) {
		// TODO Auto-generated method stub
		if (!customerRepo.existsById(id)) {
			throw new AppException(404, String.format("Customer with id %d is not exist", id));
		}
		Customer customer = customerRepo.findById(id).orElse(null);
		return customer.getOrders();
	}

	@Override
	public Order fidById(Long id) {
		// TODO Auto-generated method stub
		return orderRepo.findById(id).orElse(null);
	}

}
