package tw.com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Approvalset;
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
	
	public List<Approvalset> findApprovalset(){
		return approvalsetRepo.findAll();
	}
	

}
