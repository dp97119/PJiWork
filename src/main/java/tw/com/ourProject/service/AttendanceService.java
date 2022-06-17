package tw.com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Attendance;
import tw.com.ourProject.repository.AttendanceRepo;

@Service
public class AttendanceService {
	@Autowired
	public AttendanceRepo attendanceRepo;
	
	public List<Attendance> showAttendance() {
		return attendanceRepo.findAll();
	}
}
