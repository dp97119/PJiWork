package tw.com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Approvalrank;
import tw.com.ourProject.repository.ApprovalrankRepo;

@Service
public class ApprovalrankService {
	@Autowired
	public ApprovalrankRepo approvalrankRepo;
	
	public List<Approvalrank> findRank() {
		return approvalrankRepo.findAll();
	}
}
