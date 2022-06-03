package com.ourProject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ourProject.model.Product;
import com.ourProject.repository.ProductRepo;

@RestController
public class UserController {
	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("/user/1")
	public List<Product> getUser(){
		return productRepo.findAll();
	}
	
	@PostMapping("/user/2")
	public List<Product> postUser(@RequestBody String str){
		 List<Product> result =  productRepo.findAll();
		return result;
	}
	
	
	 @PostMapping(value="/user/0")
	 @ResponseBody
	 public JSONObject postUser1(@RequestBody String jsonStr) {
		 
		 	JSONArray jsonArray = JSONObject.parseArray(jsonStr);
		 	JSONObject obj = null;
		 	for(int i = 0 ;i<jsonArray.size();i++) {
		 		obj = jsonArray.getJSONObject(i) ;
			 	System.out.println("fastJson: account="+obj.get("account")+" ;passwd="+obj.get("passwd"));  
			 	System.out.println(obj.toJSONString());  
		 	}
		 	return obj;
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