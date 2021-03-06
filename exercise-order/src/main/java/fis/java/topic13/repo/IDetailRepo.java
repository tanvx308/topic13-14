package fis.java.topic13.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fis.java.topic13.entity.Category;
import fis.java.topic13.entity.Detail;
import fis.java.topic13.entity.Product;
@Repository
public interface IDetailRepo extends JpaRepository<Detail, Long>{
}
