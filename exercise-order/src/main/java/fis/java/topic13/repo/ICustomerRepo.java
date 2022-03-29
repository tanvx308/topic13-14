package fis.java.topic13.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fis.java.topic13.entity.Customer;
@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Long>{

}
