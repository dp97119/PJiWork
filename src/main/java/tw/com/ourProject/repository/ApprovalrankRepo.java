package tw.com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Approvalrank;

public interface ApprovalrankRepo extends JpaRepository<Approvalrank, Integer> {
	Approvalrank findByApprovalRankId(Integer approvalRankId);
}
