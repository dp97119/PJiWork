package tw.com.ourProject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.security.auth.message.AuthException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.model.Employee;
import tw.com.ourProject.model.Temptoken;
import tw.com.ourProject.repository.EmployeeRepo;
import tw.com.ourProject.repository.TempTokenRepo;
import tw.com.ourProject.utils.JWTUtil;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepo employeeRepo;
	@Autowired
	JWTUtil jwtToken;
	@Autowired
	public TempTokenRepo tempTokenRepo;
	public Temptoken tempToken = new Temptoken();

	
	public String userVerify(String empId ,String passwd) {
		 Optional<Employee> checkId = employeeRepo.findById(empId);
		 
		if(checkId.isEmpty()) {
			return "101";//查無帳號
		}
		//帳號密碼正確 -->取得身份 -->回傳token,同時存進資料庫
		if(employeeRepo.findById(empId).get().getPasswd().equals(passwd)) {
			HashMap<String, String> userInfo = new HashMap<>();
			userInfo.put("empId", empId);
			userInfo.put("passwd", passwd);
			userInfo.put("adm", employeeRepo.findById(empId).get().getAdm());
			String token = jwtToken.generateToken(userInfo);
			tempToken.setTokenValue(token);//存進tempToken
			tempTokenRepo.save(tempToken);
			return token ;
		}else {
			return "102";//密碼不符
		}
	}
	
	public void selectAll() {
		List<Employee> result = employeeRepo.findAll();
		System.out.println(result);
	}
	@Transactional
	public String verifyToken(String userToken) {
		try {
		jwtToken.validateToken(userToken);
		}catch(AuthException e) {
			System.out.println(e.toString());
			tempTokenRepo.deleteByTokenValue(userToken);
			return "201";
		}
		return "200";
	}

	public JSONObject checkAdm(String userToken) {
		JSONObject obj = new JSONObject();
		obj.put("userAdm", jwtToken.getInfoFromJwtToken(userToken, "adm"));
		return obj;
	}
}
