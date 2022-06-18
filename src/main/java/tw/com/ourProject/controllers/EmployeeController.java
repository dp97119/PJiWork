package tw.com.ourProject.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
	private final static String FILE_UPLOAD_PATH = "/Users/sjk/JinKuan/myPic/";
	@PostMapping("/emp/uploadUserPhoto")
	public String uploadUserPhoto(@RequestParam("file") MultipartFile multipartFile ,HttpServletRequest request) {
		if (multipartFile.isEmpty()) {
            return "上傳失敗";
        }
		System.out.println(multipartFile);
		String fileName = multipartFile.getOriginalFilename();
		System.out.println(fileName);
		Path path = Paths.get(FILE_UPLOAD_PATH + fileName);
		
	      File dest = new File(path.toString());
	      if(!dest.getParentFile().exists()){
	    	  dest.getParentFile().mkdir();
	    	  }
	      try {
	      multipartFile.transferTo(dest);
	      return "上傳成功";
		}catch(IOException e) {
			System.out.println(e.toString());
            return e.toString();

		}

	}

}
