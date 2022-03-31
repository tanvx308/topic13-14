package fis.java.topic13.service;

import java.util.List;

import fis.java.topic13.entity.Category;
import fis.java.topic13.entity.Detail;
import fis.java.topic13.entity.Product;

public interface IDetailService {
	Detail save(Detail detail);
	
	List<Detail> findByOrder(Long id);
}
