package com.ourProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SecurityController {

	@GetMapping("/login_page")
	public String ToLoginPage() {

		return "LoginPage.html";
	}
	
	@GetMapping("/logout_page")
	@ResponseBody
	public String ToLogoutPage() {

		return "logoutPage 還沒寫";
	}
	
	@PostMapping("/welcome")
	public String Wellcome1() {

		return "登入成功 這是首頁";
	}
	

}

