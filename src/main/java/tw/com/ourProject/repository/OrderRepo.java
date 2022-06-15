package tw.com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Order;

public interface OrderRepo  extends JpaRepository<Order, Integer>{

}
