package tw.com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Punch;

public interface PunchRepo  extends JpaRepository<Punch, Integer> {

}
