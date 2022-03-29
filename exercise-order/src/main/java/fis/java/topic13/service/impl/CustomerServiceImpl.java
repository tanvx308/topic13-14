package fis.java.topic13.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fis.java.topic13.constant.MyConstant;
import fis.java.topic13.entity.Customer;
import fis.java.topic13.exception.AppException;
import fis.java.topic13.repo.ICustomerRepo;
import fis.java.topic13.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	ICustomerRepo customerRepo;

	@Override
	public List<Customer> findAll(Pageable pageable) {
		Page<Customer> page = customerRepo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public Customer findById(Long id) {
		if(!customerRepo.existsById(id)) {
			throw new AppException(404, String.format("Customer with id %d is not exist", id));
		}
		return customerRepo.findById(id).orElse(null);
	}

	@Override
	public Customer update(Customer customer) {
		if(!customerRepo.existsById(customer.getId())) {
			throw new AppException(404, String.format("Customer with id %d is not exist", customer.getId()));
		}
		return customerRepo.save(customer);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		if(!customerRepo.existsById(id)) {
			throw new AppException(404, String.format("Customer with id %d is not exist", id));
		}
		Customer customer = customerRepo.findById(id).get();
		customer.setAvailable(MyConstant.IN_ACTIVE);
		customerRepo.save(customer);
	}
}
