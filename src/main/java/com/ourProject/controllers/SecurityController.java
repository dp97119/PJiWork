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
import com.ourProject.utils.JWTUtil;

@RestController
public class SecurityController {
	@Autowired
	JWTUtil jwtToken;

	@GetMapping("/login_page")
	public String ToLoginPage() {

		return "LoginPage.html";
	}
	
	@GetMapping("/logout_page")
	public String ToLogoutPage() {

		return "logoutPage 還沒寫";
	}
	
	@PostMapping("/loginAction")
	public JSONObject LoginAction(@RequestBody String data) {
		JSONArray jsonArray = JSONObject.parseArray(data);
	 	JSONObject obj = null;
	 	for(int i = 0 ;i<jsonArray.size();i++) {
	 		obj = jsonArray.getJSONObject(i) ;
		 	System.out.println("fastJson: account="+obj.get("username")+" ;passwd="+obj.get("password"));  
		 	System.out.println(obj.toJSONString());  
	 	}
	 	HashMap<String, String> test = new HashMap<>();
        test.put( "empId", "20220609001" );
        test.put( "passwd", "root" );
        test.put( "adm", "admin" );
        System.out.println(""+test);
	 	String token = jwtToken.generateToken(test);
	 	obj.clear();
	 	obj.put("state","100");
	 	obj.put("token",token);
	 	System.out.println("生成的Token"+token);
		return obj;
	}
	
	
	
	@PostMapping("/welcome")
	public String Wellcome1() {

		return "登入成功 這是首頁";
	}
	

}

