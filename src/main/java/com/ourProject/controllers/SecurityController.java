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
		System.out.println(jsonArray);
		JSONObject obj = null;
		
		HashMap<String, String> userInfo = new HashMap<>();

		for (int i = 0; i < jsonArray.size(); i++) {
			obj = jsonArray.getJSONObject(i);
		}
			System.out.println(obj.get("empId"));
			String result = employeeService.userVerify(obj.get("empId").toString(), obj.get("passwd").toString());
			if (result != "密碼不符") {
				userInfo.put("empId", obj.get("empId").toString());
				userInfo.put("passwd", obj.get("passwd").toString());
				userInfo.put("adm", result);
				String token = jwtToken.generateToken(userInfo);
				try {
					jwtToken.validateToken(token);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				obj.clear();
				obj.put("state", "100");
				obj.put("token", token);
				System.out.println("生成的Token" + token);
				return obj;
			} else {
				obj.clear();
				obj.put("state", "200");
				return obj;
			}
		

	}

}
