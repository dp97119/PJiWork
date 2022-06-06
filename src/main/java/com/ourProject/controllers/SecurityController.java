package com.ourProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/")
	public String Wellcome() {

		return "success to login1";
	}
	@PostMapping("/welcome")
	public String Wellcome1() {
		
		
		return "登入成功 這是首頁";
	}
	
	@GetMapping("/test")
	public String Wellcome2() {
		
		
		return "success to login test";
	}

}

