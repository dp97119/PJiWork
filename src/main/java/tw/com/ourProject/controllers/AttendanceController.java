package tw.com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ourProject.model.Attendance;
import tw.com.ourProject.service.AttendanceService;

@RestController
public class AttendanceController {
	@Autowired
	public AttendanceService attendanceService;
	
	@GetMapping("/Attendance/show")
	public List<Attendance> findattendance(){
		List<Attendance> attendance = attendanceService.showAttendance();
		return attendance;
	}
}
