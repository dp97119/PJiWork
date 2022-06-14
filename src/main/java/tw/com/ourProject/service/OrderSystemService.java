package tw.com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.model.Dish;
import tw.com.ourProject.repository.DishRepo;
import tw.com.ourProject.repository.RestaurantRepo;

@Service
public class OrderSystemService {
	
	@Autowired
	public DishRepo dishRepo;
	
	@Autowired
	public RestaurantRepo restaurantRepo;
	
	
	public void findMenuByDate(String date) {
		dishRepo.findAll();
	}
	
	public JSONArray findDishByRestaurantId(Integer restaurantId) {
		List<Dish> menus =dishRepo.findByRestaurantid(restaurantId);
		JSONArray jsonArr = new JSONArray();
		for(int i = 0 ;i<menus.size() ;i++) {
			JSONObject obj = new JSONObject();
			obj.put("dishId",menus.get(i).getDishId());
			obj.put("dishItem",menus.get(i).getDishItem());
			obj.put("dishPrice",menus.get(i).getDishPrice());
			obj.put("dishPhoto",menus.get(i).getDishPhoto());
			jsonArr.add(obj);
		}
		return jsonArr;
	}
}