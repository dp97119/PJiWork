package tw.com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ourProject.model.Approval;
import tw.com.ourProject.service.ApprovalService;

@RestController
public class ApprovalController {
	@Autowired
	public ApprovalService approvalService;
	
	@GetMapping("/approval")
	public List<Approval> findApproval(){
		List<Approval> approvals = approvalService.findApproval();
		return approvals;
	}
}
