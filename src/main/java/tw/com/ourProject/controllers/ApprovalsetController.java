package tw.com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;

import tw.com.ourProject.model.Apart;
import tw.com.ourProject.model.Employee;
import tw.com.ourProject.service.ApprovalsetService;

@RestController
public class ApprovalsetController {
	@Autowired
	public ApprovalsetService approvalsetService;
	
	@GetMapping("/setAdm")
	public List<Employee> findEmp(){
		List<Employee> empAdm = approvalsetService.findemp();
		return empAdm;
	}
	
//	@GetMapping("/test")
//	public JSONArray findapartAdm(){
//		return approvalsetService.findApart(1);
//	}
	
	@GetMapping("/test1")
	public List<Apart> findid(){
		List<Apart> idid = approvalsetService.findaparts(5);
		return idid;
	}
	
	
}
