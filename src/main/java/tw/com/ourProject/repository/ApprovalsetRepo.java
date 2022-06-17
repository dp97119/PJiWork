package tw.com.ourProject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Apart;
import tw.com.ourProject.model.Approvalset;
import tw.com.ourProject.model.Employee;

@Transactional
public interface ApprovalsetRepo extends JpaRepository<Approvalset, Integer>{
//	List<Approvalset> saveApart(Apart apartid);
//	List<Approvalset> saveFirstApproval(Employee firstapproval);
//	List<Approvalset> saveSecondApproval(Employee secondapproval);
}
