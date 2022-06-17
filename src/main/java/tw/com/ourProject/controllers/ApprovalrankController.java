package tw.com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ourProject.model.Approvalrank;
import tw.com.ourProject.service.ApprovalrankService;

@RestController
public class ApprovalrankController {
	@Autowired
	public ApprovalrankService approvalrankService;
	
	@GetMapping("/Approval/showrank")
	public List<Approvalrank> findrank(){
		List<Approvalrank> showrank = approvalrankService.findRank();
		return showrank;
	}
}
