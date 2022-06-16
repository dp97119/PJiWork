package tw.com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Calendar;

public interface CalendarRepo extends JpaRepository<Calendar, Integer> {

}
