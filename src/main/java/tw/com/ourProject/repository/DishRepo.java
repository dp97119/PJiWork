package tw.com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Dish;

public interface DishRepo extends JpaRepository<Dish, Integer> {

}
