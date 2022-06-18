package tw.com.ourProject.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.model.Dish;
import tw.com.ourProject.model.Order;
import tw.com.ourProject.model.Restaurant;
import tw.com.ourProject.repository.DishRepo;
import tw.com.ourProject.repository.OrderRepo;
import tw.com.ourProject.repository.RestaurantRepo;
import tw.com.ourProject.repository.RestaurantSetRepo;

@Service
public class OrderSystemService {
	
	@Autowired
	public DishRepo dishRepo;
	
	@Autowired
	public RestaurantRepo restaurantRepo;
	
	@Autowired
	public OrderRepo orderRepo ;
	
	@Autowired
	public RestaurantSetRepo restaurantSetRepo;

	public Order order = new Order();
	
	public Dish dish = new Dish();

	public Restaurant restaurant = new Restaurant();

	
	public JSONArray findMenuByDate(Date date) {
		restaurant = restaurantSetRepo.findBySetDate(date).getRestaurants();
		List<Dish> menus =dishRepo.findByRestaurantid(restaurant.getRestaurantId());
		JSONArray jsonArr = new JSONArray();
		JSONObject restaurantName = new JSONObject();
		restaurantName.put("restaurantName", restaurant.getRestaurantName());
		jsonArr.add(restaurantName);
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
	
	public void saveToDb(String empId , JSONArray data) {
		for(int i=0 ; i<data.size() ;i++) {
			order = new Order();
			dish.setDishId(Integer.parseInt(data.getJSONObject(i).get("dishId").toString()));
			order.setEmpId(empId);
			order.setDishes(dish);
			order.setQty(Integer.parseInt(data.getJSONObject(i).get("qty").toString()));
			order.setType("購物車");
			orderRepo.save(order);

		}
		
	}

	public JSONArray getOrderInCar(String empId , Date startDate , Date endDate) {
		List<Order> rs = orderRepo.findByEmpIdAndDateBetweenAndType(empId,startDate,endDate,"購物車");
		
		JSONArray jArry = new JSONArray();
		for(Order order : rs) {
			JSONObject obj = new JSONObject();
			obj.put("orderId", order.getOrderId());
			obj.put("dishItem", order.getDishes().getDishItem());
//			obj.put("dishPhoto", order.getDishes().getDishPhoto());
			obj.put("dishPrice", order.getDishes().getDishPrice());
			obj.put("qty", order.getQty());
//			obj.put("orderMemo", order.getOrderMemo());
			jArry.add(obj);
		}
		return jArry;
	}
	
	@Transactional
	public void deleteOrderInCar(Integer orderId) {
		orderRepo.deleteById(orderId);
	}

	@Transactional
	public void changeOrderType(JSONArray data) {
		for(int i = 0 ; i<data.size() ;i++) {
		Integer orderId = Integer.parseInt(data.getJSONObject(i).getString("orderId"));
		order = orderRepo.findById(orderId).get();
		order.setType("出貨");
		orderRepo.save(order);
		}
	}
	
}
