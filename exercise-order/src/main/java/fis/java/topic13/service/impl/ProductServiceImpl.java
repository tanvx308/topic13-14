package fis.java.topic13.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fis.java.topic13.constant.MyConstant;
import fis.java.topic13.entity.Product;
import fis.java.topic13.exception.AppException;
import fis.java.topic13.repo.IProductRepo;
import fis.java.topic13.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	IProductRepo productRepo;

	@Override
	public List<Product> findAll(Pageable pageable) {
		return productRepo.findAll(pageable).getContent();
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Product product = productRepo.findById(id).orElse(null);
		product.setAvailable(MyConstant.IN_ACTIVE);
		productRepo.save(product);
	}

}
