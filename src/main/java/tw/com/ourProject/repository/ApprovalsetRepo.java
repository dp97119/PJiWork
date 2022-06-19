package tw.com.ourProject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Apart;
import tw.com.ourProject.model.Approvalset;

@Transactional
public interface ApprovalsetRepo extends JpaRepository<Approvalset, Integer>{
	Approvalset findByApprovalSetId(Integer approvalSetId);
	Approvalset findByAparts(Apart apartId);
}
