package tw.com.ourProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.ourProject.model.Salaryslip;
import tw.com.ourProject.repository.SalaryslipRepo;
import tw.com.ourProject.utils.PdfUtil;


@Service
public class SalaryslipService {
	@Autowired
	public PdfUtil pdfUtil;
	@Autowired
	public SalaryslipRepo salaryslipRepo ;

	public void convertPdf(){
		
		Salaryslip s = salaryslipRepo.findByEmpId("iworka00001");
		
		System.out.println(s);
		pdfUtil.converPdf(s);
	}
}
