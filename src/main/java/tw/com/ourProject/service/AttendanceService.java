package tw.com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Attendance;
import tw.com.ourProject.model.Calendar;
import tw.com.ourProject.repository.AttendanceRepo;

@Service
public class AttendanceService {
	@Autowired
	public AttendanceRepo attendanceRepo;
	
	public List<Attendance> showAttendance() {
		return attendanceRepo.findAll();
	}
	
//	public void saveAttendance() {
//		Calendar calendarInfo = new Calendar();
//		calendarInfo.setCalendarType(calendartype);
//		calendarInfo.setCalendarTitle(calendartitle);
//		calendarInfo.setEventStart(eventstart);
//		calendarInfo.setEventEnd(eventEnd);
//		calendarInfo.setAllDay(allday);
//		calendarRepo.save(calendarInfo);
//	}
}
