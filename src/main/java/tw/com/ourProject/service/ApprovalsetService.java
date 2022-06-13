package tw.com.ourProject.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.model.Apart;
import tw.com.ourProject.model.Employee;
import tw.com.ourProject.repository.ApartRepo;
import tw.com.ourProject.repository.ApprovalsetRepo;
import tw.com.ourProject.repository.EmployeeRepo;

@Service
public class ApprovalsetService {
	@Autowired
	public ApprovalsetRepo approvalsetRepo;
	
	@Autowired
	public EmployeeRepo employeeRepo;
	
	@Autowired
	public ApartRepo apartRepo;
	
	
	public List<Employee> findemp(){
		return employeeRepo.findAll();
	}
	
	public List<Apart> findaparts(Integer apartid){
		return apartRepo.findByapartId(apartid);
	}
	
//	public JSONArray findApart(Integer apartid){
//		List<Employee> adm = apartRepo.findByaparts(1);
//		JSONArray jsonE = new JSONArray();
//		JSONObject obj = new JSONObject();
//		obj.put("empId",adm.get(0).getEmpId());
//		obj.put("empName",adm.get(0).getEmpName());
//		jsonE.add(obj);
//		return jsonE;
//	}
	
	

}
