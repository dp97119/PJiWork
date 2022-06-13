package tw.com.ourProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.ourProject.model.Apart;

@Repository
public interface ApartRepo extends JpaRepository<Apart, Integer>{
	List<Apart> findByapartId(Integer apartid);
}
