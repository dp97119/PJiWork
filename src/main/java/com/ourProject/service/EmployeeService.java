package com.ourProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourProject.model.Employee;
import com.ourProject.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepo employeeRepo;
	
	public String userVerify(String empId ,String passwd) {
		 Optional<Employee> checkId = employeeRepo.findById(empId);
		if(checkId.isEmpty()) {
			return "300";//查無帳號
		}

		if(employeeRepo.findById(empId).get().getPasswd().equals(passwd)) {
			
			return employeeRepo.findById(empId).get().getAdm();
		}else {
			return "200";//密碼不符
		}
		
		
	}
	public void selectAll() {
		List<Employee> result = employeeRepo.findAll();
		System.out.println(result);
	}
}
