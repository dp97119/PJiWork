package com.ourProject.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ourProject.service.EmployeeService;
import com.ourProject.utils.JWTUtil;

@RestController
public class SecurityController {
	@Autowired
	JWTUtil jwtToken;
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/loginAction")
	public JSONObject LoginAction(@RequestBody String inputdata) {
		JSONArray jsonArray = JSONObject.parseArray(inputdata);
	 	JSONObject obj = null;
	 	HashMap<String, String> userInfo = new HashMap<>();
	 	
	 	for(int i = 0 ;i<jsonArray.size();i++) {
	 		obj = jsonArray.getJSONObject(i) ;
//			employeeService.userVerify(Integer. parseInt(obj.get("userEmp").toString()),obj.get("userPsw").toString());
//			employeeService.userVerify(1,"root");
	 		employeeService.selectAll();
	 		
	 		userInfo.put("empId",obj.get("userEmp").toString());
	 		userInfo.put("passwd",obj.get("userPsw").toString());
	 		userInfo.put("adm",obj.get("userEmp").toString());
	 	}
	 	String token = jwtToken.generateToken(userInfo);
	 	try {
	 	jwtToken.validateToken(token);
	 	}catch(Exception e) {
	 		System.out.println(e.toString());
	 	}
	 	obj.clear();
	 	obj.put("state","100");
	 	obj.put("token",token);
	 	System.out.println("生成的Token"+token);
		return obj;
	}
	


}

