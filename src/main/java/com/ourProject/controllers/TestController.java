package com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ourProject.model.Test;
import com.ourProject.service.TestService;

@RestController
public class TestController {

	@Autowired
	public TestService testService;
	
	@GetMapping("/selectTest")
	public List<Test> selectTest(){
		List<Test> rs =  testService.selectAll();
		return rs ;
	}
	
	@PostMapping("/update")
	public String updateTest(@RequestBody Test test){
		testService.updatetest(test);
		return "saving ok" ;
	}
	
	
}
