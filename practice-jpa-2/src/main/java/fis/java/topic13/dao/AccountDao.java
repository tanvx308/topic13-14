package fis.java.topic13.dao;

import java.util.List;

import fis.java.topic13.entity.Account;

public interface AccountDao {
	List<Account> getByFullname(String fullname);
}
