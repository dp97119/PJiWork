package tw.com.ourProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ourProject.model.Salaryslip;
import tw.com.ourProject.service.SalaryslipService;

@RestController
public class SalaryslipController {

	@Autowired
	public SalaryslipService test;
	
	@GetMapping("/testPdf")
	public void sss (){
		test.convertPdf();
	}
	
}
