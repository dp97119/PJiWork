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

	@PostMapping("/loginAction")
	public JSONObject loginAction(@RequestBody String inputdata) {
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
	
	@PostMapping("/loginAction/1")
	public JSONObject verifyToken(@RequestBody JSONArray userToken) {
		System.out.println(userToken);
		JSONObject obj = null;
		for (int i = 0; i < userToken.size(); i++) {
			obj = userToken.getJSONObject(i);
		}
		System.out.println(obj.getString("userToken"));
		String rb = employeeService.verifyToken(obj.getString("userToken"));
		obj.put("state", rb);
		return obj;
		
	}

	@PostMapping("/countToken")
	public JSONObject countToken() {
		JSONObject obj = new JSONObject();
		obj.put("countRs",tokenService.countToken().toString());
		return obj;
	}
	
	@PostMapping("/logOut")
	public void logOut(@RequestBody String userToken) {
		String obj = JSONObject.parseArray(userToken).getJSONObject(0).get("userToken").toString();
		tokenService.deleteToken(obj);
	}
}
