package tw.com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, String> {
	Attendance findByAttendanceId(Integer attendanceId);
}
