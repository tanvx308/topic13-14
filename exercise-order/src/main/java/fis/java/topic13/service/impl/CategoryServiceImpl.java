package fis.java.topic13.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fis.java.topic13.entity.Category;
import fis.java.topic13.entity.Product;
import fis.java.topic13.repo.ICategoryRepo;
import fis.java.topic13.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	ICategoryRepo categoryRepo;

	@Override
	public List<Category> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Category> page = categoryRepo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public List<Object[]> report() {
		// TODO Auto-generated method stub
		return categoryRepo.report();
	}
}
