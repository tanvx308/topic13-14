package fis.java.topic13.service;

import java.util.List;

import fis.java.topic13.entity.Account;

public interface AccountService {

	List<Account> findAll();

	<S extends Account> S save(S entity);

}
