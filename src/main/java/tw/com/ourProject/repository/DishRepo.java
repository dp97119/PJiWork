package tw.com.ourProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Dish;

public interface DishRepo extends JpaRepository<Dish, Integer> {
	
	List<Dish> findByRestaurantid(Integer restaurantId);

}
 