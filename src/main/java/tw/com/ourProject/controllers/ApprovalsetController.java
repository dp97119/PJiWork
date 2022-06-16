package tw.com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;

import tw.com.ourProject.model.Apart;
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
	
	@Autowired
	public Apart apid;
	public Employee emp1 = new Employee();
	public Employee emp2 = new Employee();
	
	@PostMapping("/saveApprovalset")
	public void insertApprovalset(@RequestBody JSONArray approvalInfo) {
		String obj1 = approvalInfo.getJSONObject(0).get("apartId").toString();
		
		apid.setApartId(Integer.parseInt(obj1));
		String obj2 = approvalInfo.getJSONObject(0).get("fisrtApproval").toString();
		String obj3 = approvalInfo.getJSONObject(0).get("secondApproval").toString();
		
		emp1.setEmpId(obj2);
		emp2.setEmpId(obj3);

		approvalsetService.saveApprovalset(apid , emp1 , emp2);
	}
	
	@DeleteMapping("/deleteApprovalset")
	public void delApprovalset(@RequestBody JSONArray approvalInfo) {
		Integer obj1 = Integer.parseInt(approvalInfo.getJSONObject(0).get("").toString());
		approvalsetService.deleteApprovalset(obj1);
	}
	
}
