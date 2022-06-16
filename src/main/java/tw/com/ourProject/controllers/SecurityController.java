package tw.com.ourProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.repository.TempTokenRepo;
import tw.com.ourProject.service.EmployeeService;
import tw.com.ourProject.service.TokenService;

@RestController
public class SecurityController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	TokenService tokenService;

	@PostMapping("/security/login")
	public JSONObject login(@RequestBody String inputdata) {
		JSONArray jsonArray = JSONObject.parseArray(inputdata);
		System.out.println(jsonArray);
		JSONObject obj = null;

		for (int i = 0; i < jsonArray.size(); i++) {
			obj = jsonArray.getJSONObject(i);
		}
		//驗證帳號密碼 （成功：回傳token ;查無帳號：101 ;密碼錯誤：102)
		String result = employeeService.userVerify(obj.get("empId").toString(), obj.get("passwd").toString());
		System.out.println(result);
		//帳號密碼正確  獲得token
		if (result != "101" && result != "102") {
			obj.clear();
			obj.put("state", "100");// 成功
			obj.put("token",result);
			return obj;
		} else {
			obj.clear();
			obj.put("state", result);// 失敗,傳入狀態101,102
			return obj;
		}

	}
	
	@PostMapping("/security/verifyToken")
	public JSONObject verifyToken(@RequestBody JSONObject userToken) {
		JSONObject obj = new JSONObject();
		obj.put("state", employeeService.verifyToken(userToken.getString("userToken")));
		return obj;
		
	}

	@PostMapping("/security/countToken")
	public JSONObject countToken() {
		JSONObject obj = new JSONObject();
		obj.put("countRs",tokenService.countToken().toString());
		return obj;
	}
	
	@PostMapping("/security/logOut")
	public void logOut(@RequestBody JSONObject userToken) {
		tokenService.deleteToken(userToken.getString("userToken"));
	}
	
	@PostMapping("/security/checkAdm")
	public JSONObject checkAdm(@RequestBody JSONObject userToken) {
	
		return employeeService.checkAdm(userToken.getString("userToken"));
	}
}
