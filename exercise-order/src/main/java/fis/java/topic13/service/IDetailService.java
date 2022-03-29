package fis.java.topic13.service;

import java.util.List;

import fis.java.topic13.entity.Detail;

public interface IDetailService {
	Detail save(Detail detail);
	
	List<Detail> findByOrder(Long id);
}
