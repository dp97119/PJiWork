package tw.com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Approval;

public interface ApprovalRepo extends JpaRepository<Approval, Integer>{

}
