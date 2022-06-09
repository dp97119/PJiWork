package com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourProject.model.Employee;
import com.ourProject.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepo employeeRepo;
	
	public void userVerify(Integer empId ,String passwd) {
		System.out.println(employeeRepo.findById(1)); 
	}
	public void selectAll() {
		List<Employee> result = employeeRepo.findAll();
		System.out.println(result);
	}
}
