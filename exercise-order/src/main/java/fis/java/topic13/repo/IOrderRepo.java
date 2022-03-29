package fis.java.topic13.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fis.java.topic13.entity.Order;

@Repository
public interface IOrderRepo extends JpaRepository<Order, Long>{
}
