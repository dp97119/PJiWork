package tw.com.ourProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Attendance;
import tw.com.ourProject.model.Employee;

public interface AttendanceRepo extends JpaRepository<Attendance, String> {
	Attendance findByAttendanceId(Integer attendanceId);
	List<Attendance> findByEmployees(Employee employees);
}
