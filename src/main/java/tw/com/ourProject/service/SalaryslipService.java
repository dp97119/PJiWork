package tw.com.ourProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.repository.SalaryslipRepo;

@Service
public class SalaryslipService {
	
	@Autowired
	public SalaryslipRepo salaryslipRepo ;

	public void convertPdf(){
		
	}
}
