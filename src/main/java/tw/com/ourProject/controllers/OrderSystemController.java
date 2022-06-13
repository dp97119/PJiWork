package tw.com.ourProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;

import tw.com.ourProject.service.OrderSystemService;

@RestController
public class OrderSystemController {
	@Autowired
	public OrderSystemService orderSystemService;
	

	//測試版 尚未加入時間參數
	@GetMapping("/getMenu")
	public JSONArray getMenu() {
		return orderSystemService.findDishByRestaurantId(1);
	}
}
