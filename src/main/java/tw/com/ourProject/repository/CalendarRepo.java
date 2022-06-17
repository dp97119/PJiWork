package tw.com.ourProject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Calendar;

@Transactional
public interface CalendarRepo extends JpaRepository<Calendar, Integer> {

}
