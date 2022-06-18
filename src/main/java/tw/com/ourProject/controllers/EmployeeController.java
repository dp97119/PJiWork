package tw.com.ourProject.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/emp/getEmpsInfo")
	public JSONArray getEmpsInfo() {
		System.out.println("取得所有資料");
		return employeeService.getEmpsInfo();
	}

	@PostMapping("/emp/getUserInfo")
	public JSONObject getUserInfo(@RequestBody JSONObject data) {
		System.out.println("取得個人資料");
		return employeeService.getUserInfo(data.getString("userToken"));
	}

	@PutMapping("/emp/updateUserInfo")
	public void updateUserInfo(@RequestBody JSONObject data) {
		System.out.println("更新個人資料");
		employeeService.updateUserInfoById(data);

	}

	@PostMapping("/emp/uploadUserPhoto")
	public JSONObject uploadUserPhoto(@RequestParam("file") MultipartFile multipartFile , @RequestParam("userToken")String userToken) {
		String userImgUrl = employeeService.updateUserPhoto(multipartFile, userToken);
		JSONObject obj = new JSONObject();
		obj.put("empPhoto", userImgUrl);
		return obj;
		

	}

}
