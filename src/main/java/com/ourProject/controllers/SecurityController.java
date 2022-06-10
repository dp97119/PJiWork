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
	EmployeeService employeeService;

	@PostMapping("/loginAction")
	public JSONObject LoginAction(@RequestBody String inputdata) {
		JSONArray jsonArray = JSONObject.parseArray(inputdata);
		System.out.println(jsonArray);
		JSONObject obj = null;

		for (int i = 0; i < jsonArray.size(); i++) {
			obj = jsonArray.getJSONObject(i);
		}
		//驗證帳號密碼 （成功：回傳token ;查無帳號：101 ;密碼錯誤：102)
		String result = employeeService.userVerify(obj.get("empId").toString(), obj.get("passwd").toString());
		//帳號密碼正確  獲得token
		if (result != "101" && result != "102") {
			obj.clear();
			obj.put("state", "100");// 成功
			obj.put("token",result);
			return obj;
		} else {
			obj.clear();
			obj.put("state", result);// 失敗,傳入狀態101,102
			return obj;
		}

	}
	
	@PostMapping("/loginAction/1")
	public JSONObject verifyToken(@RequestBody String userToken) {
		JSONArray jsonArray = JSONObject.parseArray(userToken);
		System.out.println(jsonArray);
		JSONObject obj = null;
		for (int i = 0; i < jsonArray.size(); i++) {
			obj = jsonArray.getJSONObject(i);
		}
		System.out.println(obj.getString("usertoken"));
		String rb = employeeService.verifyToken(obj.getString("usertoken"));
		obj.put("state", rb);
		return obj;
		
	}

}
