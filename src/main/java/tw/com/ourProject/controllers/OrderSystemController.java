package tw.com.ourProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.service.OrderSystemService;
import tw.com.ourProject.utils.JWTUtil;

@RestController
public class OrderSystemController {
	@Autowired
	public OrderSystemService orderSystemService;
	@Autowired
	public JWTUtil jwt;
	

	//測試版 尚未加入時間參數
	@PostMapping("/orderSys/getMenu")
	public JSONArray getMenu(@RequestBody JSONObject data) {
		System.out.println(data.toJSONString());
		return orderSystemService.findDishByRestaurantId(1);
	}
	
	@PostMapping("/orderSys/saveToDb")
	public void saveToDb(@RequestBody JSONArray data) {
		String empId = jwt.getInfoFromJwtToken(data.getJSONObject(0).getString("userToken"), "empId");
		data.remove(0);
		orderSystemService.saveToDb(empId,data);
	}
}
