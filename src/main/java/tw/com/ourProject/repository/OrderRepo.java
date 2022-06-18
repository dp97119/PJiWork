package tw.com.ourProject.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Order;

public interface OrderRepo  extends JpaRepository<Order, Integer>{

	List<Order> findByEmpIdAndDateBetweenAndType(String empId,Date startDate,Date endDate,String type);
	
	List<Order> findByEmpIdAndDateAndType(String empId,Date date ,String type);
	
	List<Order> findByDateBetweenAndType(Date startDate,Date endDate,String type);

}
