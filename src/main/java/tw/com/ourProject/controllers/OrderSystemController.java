package tw.com.ourProject.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
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
	
	@PostMapping("/orderSys/getMenu")
	public JSONArray getMenu(@RequestBody JSONObject data) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
		Date date = format.parse(data.getString("setDate"));
		return orderSystemService.findMenuByDate(date);
		}catch(Exception e) {
			System.out.println(e.toString());
			return JSON.parseArray("[{state : "+ e.toString()+"}]");
		}
	}
	
	@PostMapping("/orderSys/saveToDb")
	public void saveToDb(@RequestBody JSONArray data) {
		String empId = jwt.getInfoFromJwtToken(data.getJSONObject(0).getString("userToken"), "empId");
		data.remove(0);
		orderSystemService.saveToDb(empId,data);
	}
	
	@PostMapping("/orderSys/getOrder")
	public JSONArray getOrders(@RequestBody JSONObject data) {
		String empId = jwt.getInfoFromJwtToken(data.getString("userToken"), "empId");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
		Date startDate = format.parse(data.getString("startDate"));
		Date endDate = format.parse(data.getString("endDate"));
		JSONArray orders= orderSystemService.getOrderInCar(empId,startDate,endDate);
		return orders;
		}catch(Exception e) {
			JSONArray error = JSON.parseArray("[{state : "+ e.toString()+"}]");
			return error;
		}
	}
}
