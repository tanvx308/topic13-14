package fis.java.topic13.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.topic13.entity.Detail;
import fis.java.topic13.exception.AppException;
import fis.java.topic13.repo.IDetailRepo;
import fis.java.topic13.repo.IOrderRepo;
import fis.java.topic13.repo.IProductRepo;
import fis.java.topic13.service.IDetailService;
import fis.java.topic13.service.IOrderService;
@Service
public class DetailServiceImpl implements IDetailService{
	@Autowired
	IOrderRepo orderRepo;
	
	@Autowired
	IDetailRepo detailRepo;
	
	@Autowired
	IProductRepo productRepo;

	@Override
	public Detail save(Detail detail) {
		if(!orderRepo.existsById(detail.getOrder().getId())) {
			throw new AppException(404, String.format("Order with id %d is not exist", detail.getOrder().getId()));
		}
		if(!productRepo.existsById(detail.getProduct().getId())) {
			throw new AppException(404, String.format("Product with id %d is not exist", detail.getProduct().getId()));
		}
		return detailRepo.save(detail);
	}

	@Override
	public List<Detail> findByOrder(Long id) {
		if(!orderRepo.existsById(id)) {
			throw new AppException(404, String.format("Order with id %d is not exist", id));
		}
		return orderRepo.findById(id).get().getDetails();
	}

}
