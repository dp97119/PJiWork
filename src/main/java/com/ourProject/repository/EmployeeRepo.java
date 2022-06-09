package com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ourProject.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, String>{

}
