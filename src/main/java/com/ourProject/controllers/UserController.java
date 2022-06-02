package com.ourProject.controllers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RestController
public class UserController {
	 @PostMapping(value="/user/0")
	 @ResponseBody
	 public JSONArray getUser1(@RequestBody String jsonStr) {
		 	JSONArray jsonArray = JSONObject.parseArray(jsonStr);
		 	JSONObject obj = null;
		 	for(int i = 0 ;i<jsonArray.size();i++) {
		 		obj = jsonArray.getJSONObject(i) ;
			 	System.out.println("fastJson: account="+obj.get("account")+" ;passwd="+obj.get("passwd"));  
			 	System.out.println(obj.toJSONString());  
		 	}
		 	return jsonArray;
	    }
	
	
	 @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8" )
    public String getUser2(HttpServletRequest req) {
		 try {
		 String json = req.getReader().readLine(); 
	     System.out.println(json); 
		 }catch(Exception e) {
			 
		 }
        
        return "ok";
    }
}