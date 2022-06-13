package tw.com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Approval;
import tw.com.ourProject.repository.ApprovalRepo;

@Service
public class ApprovalService {
	@Autowired
	public ApprovalRepo approvalRepo;
	
	public List<Approval> findApproval() {
		return approvalRepo.findAll();
	}
}
