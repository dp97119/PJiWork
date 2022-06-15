package tw.com.ourProject.service;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
		String str =JSON.toJSONString(s);
		JSONObject jSONObject = JSONObject.parseObject(str);
		
		Set<String> a =jSONObject.keySet();
		Collection<Object> c = jSONObject.values();
		System.out.println(a);
		System.out.println(a.toArray()[3]);
		System.out.println(c);
		System.out.println(c.toArray()[3]);
		pdfUtil.converPdf(a,c);
	}
}
