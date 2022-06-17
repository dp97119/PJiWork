package tw.com.ourProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Apart;
import tw.com.ourProject.model.Approvalset;
import tw.com.ourProject.model.Employee;
import tw.com.ourProject.repository.ApartRepo;
import tw.com.ourProject.repository.ApprovalsetRepo;
import tw.com.ourProject.repository.EmployeeRepo;

@Service
@Transactional
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
	
	public List<Approvalset> findApprovalset(){
		return approvalsetRepo.findAll();
	}
	
	public void saveApprovalset(Apart apartid, Employee firstapproval, Employee secondapproval) {
		Approvalset approvalInfo = new Approvalset();
		approvalInfo.setAparts(apartid);
		approvalInfo.setEmployees(firstapproval);
		approvalInfo.setEmployee(secondapproval);
		approvalsetRepo.save(approvalInfo);
		
	}
	
	public void deleteApprovalset(Integer approvalsetid) {
		approvalsetRepo.deleteById(approvalsetid);
	}
	
//	public void updateApprovalset(Integer approvalsetid,Apart apartid, Employee firstapproval, Employee secondapproval) {
//		approvalsetRepo.findById(approvalsetid);
//		approvalsetRepo.saveApart(apartid);
//		approvalsetRepo.saveFirstApproval(firstapproval);
//		approvalsetRepo.saveSecondApproval(secondapproval);
//		
//	}
}
