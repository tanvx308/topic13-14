package fis.java.topic13.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fis.java.topic13.dao.AccountDao;
import fis.java.topic13.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>, AccountDao{

}
