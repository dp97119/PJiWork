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

	private final static String FILE_UPLOAD_PATH_FINAL = "/src/main/resources/static/img/userPhoto/";

	@PostMapping("/emp/uploadUserPhoto")
	public String uploadUserPhoto(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
		if (multipartFile.isEmpty()) {
			return "上傳失敗";
		}
        System.out.println(System.getProperty("user.dir"));
		String fileName = multipartFile.getOriginalFilename();
		try {
			File photo = new File(System.getProperty("user.dir") + FILE_UPLOAD_PATH_FINAL + fileName);
			if (!photo.getParentFile().exists()) {
				photo.getParentFile().mkdir();
			}
			multipartFile.transferTo(photo);

			return "上傳成功";
		} catch (Exception e) {
			return e.toString();

		}

	}

}
