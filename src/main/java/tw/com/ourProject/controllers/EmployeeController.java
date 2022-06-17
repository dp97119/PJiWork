package tw.com.ourProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/emp/getEmpsInfo")
	public JSONArray getEmpsInfo() {
		return employeeService.getEmpsInfo();
	}
	
	@PostMapping("/emp/getUserInfo")
	public JSONObject getUserInfo(@RequestBody JSONObject data) {
		System.out.println(data.getString("userToken"));
		return employeeService.getUserInfo(data.getString("userToken"));
	}

}
