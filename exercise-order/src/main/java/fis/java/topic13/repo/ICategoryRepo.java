package fis.java.topic13.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fis.java.topic13.entity.Category;
@Repository
public interface ICategoryRepo extends JpaRepository<Category, Long>{
	@Query(name = "report")
	List<Object[]> report();
}
