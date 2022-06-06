package com.ourProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

	@GetMapping("/login_page")
	public String Wellcome() {

		return "登入畫面.html";
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

