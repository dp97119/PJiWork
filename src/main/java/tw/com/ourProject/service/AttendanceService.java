package tw.com.ourProject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Approval;
import tw.com.ourProject.model.Attendance;
import tw.com.ourProject.model.Calendar;
import tw.com.ourProject.model.Employee;
import tw.com.ourProject.model.Leaves;
import tw.com.ourProject.repository.AttendanceRepo;

@Service
public class AttendanceService {
	@Autowired
	public AttendanceRepo attendanceRepo;
	
	public List<Attendance> showAttendance() {
		return attendanceRepo.findAll();
	}
	
	public void saveAttendance(Employee empid, Leaves leaveid, Date startdate, Date enddate, Integer hours, Approval approvalid,
			String createdate, Employee createperson, Employee updateperson) {
		Attendance attendanceInfo = new Attendance();
		attendanceInfo.setEmployees(empid);
		attendanceInfo.setLeaves(leaveid);
		attendanceInfo.setStartDate(startdate);
		attendanceInfo.setEndDate(enddate);
		attendanceInfo.setHours(hours);
		attendanceInfo.setApprovals(approvalid);
		attendanceInfo.setEmployeess(createperson);
		attendanceInfo.setEmployeesss(updateperson);
		attendanceInfo.setCreateDate(createdate);
		attendanceRepo.save(attendanceInfo);
	}
}
