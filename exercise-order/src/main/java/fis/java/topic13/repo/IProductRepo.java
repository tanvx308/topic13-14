package fis.java.topic13.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fis.java.topic13.entity.Product;
@Repository
public interface IProductRepo extends JpaRepository<Product, Long>{

}
