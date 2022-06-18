package tw.com.ourProject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.security.auth.message.AuthException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
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
	
	public JSONArray getEmpsInfo() {
		List<Employee> emps = employeeRepo.findAll();
		JSONArray arry = new JSONArray();
		for(Employee emp : emps) {
			JSONObject obj = new JSONObject();
			obj.put("apart", emp.getAparts().getApart());
			obj.put("empName", emp.getEmpName());
			obj.put("empTel", emp.getTel());
			obj.put("empPhone", emp.getCellphone1());
			obj.put("empEmail", emp.getEmail());
			arry.add(obj);
		}
		return arry;
	}
	
	public JSONObject getUserInfo(String userToken) {
		String empId = jwtToken.getInfoFromJwtToken(userToken,"empId");
		Employee emp = employeeRepo.findById(empId).get();
			JSONObject obj = new JSONObject();
			obj.put("apart", emp.getAparts().getApart());
			obj.put("empId", empId);
			obj.put("empName", emp.getEmpName());
			obj.put("empPwd", emp.getPasswd());
			obj.put("empTel", emp.getTel());
			obj.put("empPhone", emp.getCellphone1());
			obj.put("empEmail", emp.getEmail());
			obj.put("empAddr", emp.getAddr());		
			return obj;
	}
	
	@Transactional
	public void updateUserInfoById(JSONObject userInfo) {
		 Employee employee = employeeRepo.findById(jwtToken.getInfoFromJwtToken(userInfo.getString("userToken"),"empId")).get();
		 employee.setEmpName(userInfo.getString("empName"));
		 employee.setPasswd(userInfo.getString("empPwd"));
		 employee.setTel(userInfo.getString("empTel"));
		 employee.setCellphone1(userInfo.getString("empPhone"));
		 employee.setEmail(userInfo.getString("empEmail"));
		 employee.setAddr(userInfo.getString("empAddr"));
		 employeeRepo.save(employee);
	}

}
