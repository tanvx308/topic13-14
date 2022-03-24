package fis.java.topic13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fis.java.topic13.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
