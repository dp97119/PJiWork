package tw.com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;

import tw.com.ourProject.model.Approvalset;
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
	
	@GetMapping("/findApprovalset")
	public List<Approvalset> findApprovalset(){
		List<Approvalset> approvalsets = approvalsetService.findApprovalset();
		return approvalsets;
	}
//	@PostMapping("/saveApprovalset")
//	public JSONArray insertApprovalset() {
//		
//	}
	
	
}
