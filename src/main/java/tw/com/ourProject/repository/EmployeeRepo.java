package tw.com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, String>{
	
	
	Employee findByEmpId(String empId);
}
