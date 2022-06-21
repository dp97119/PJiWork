package tw.com.ourProject.service;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.model.Approval;
import tw.com.ourProject.model.Attendance;
import tw.com.ourProject.model.Employee;
import tw.com.ourProject.model.Leaves;
import tw.com.ourProject.repository.AttendanceRepo;

@Service
@Transactional
public class AttendanceService {
	@Autowired
	public AttendanceRepo attendanceRepo;
	
	public List<Attendance> showAttendance() {
		return attendanceRepo.findAll();
	}
	
	public void saveAttendance(Employee empid, Leaves leaveid, Date startdate, Date enddate, Integer hours, Approval approvalid,
			Date createdate, Employee createperson, Employee updateperson) {
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
	
	public JSONArray findsetData(Employee data) {
		List<Attendance> findpd = attendanceRepo.findByEmployees(data);
		JSONArray arraypd = new JSONArray();
		for (int i = 0; i<findpd.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("attendanceId", findpd.get(i).getAttendanceId());
			obj.put("empId", findpd.get(i).getEmployees().getEmpId());
			obj.put("leaveId", findpd.get(i).getLeaves().getLeaveId());
			obj.put("leaveType", findpd.get(i).getLeaves().getLeaveType());
			obj.put("startDate", findpd.get(i).getStartDate().toInstant().atOffset(ZoneOffset.ofHours(+8)).format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
			obj.put("endDate", findpd.get(i).getEndDate().toInstant().atOffset(ZoneOffset.ofHours(+8)).format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
			obj.put("hours", findpd.get(i).getHours());
			obj.put("approvalId", findpd.get(i).getApprovals().getApprovalId());
			obj.put("approvalType", findpd.get(i).getApprovals().getApprovalType());
			arraypd.add(obj);
		}
		return arraypd;
	}
	
	public void deleteAttendance(Integer attendanceid) {
		attendanceRepo.deleteById(attendanceid);
	}
	
	public void updateattendance(Integer attendanceid, Leaves leaveid, Date startdate, Date enddate, Integer hours,
			Approval approvalid, Employee updateperson) {
		Attendance attendanceInfo = attendanceRepo.findByAttendanceId(attendanceid);
		attendanceInfo.setLeaves(leaveid);
		attendanceInfo.setStartDate(startdate);
		attendanceInfo.setEndDate(enddate);
		attendanceInfo.setHours(hours);
		attendanceInfo.setApprovals(approvalid);
		attendanceInfo.setEmployeesss(updateperson);
		attendanceRepo.save(attendanceInfo);
	}
	
	public void updateapproval1(Integer attendanceid, Approval approvalid, Employee updateperson) {
		Attendance attendanceInfo = attendanceRepo.findByAttendanceId(attendanceid);
		attendanceInfo.setApprovals(approvalid);
		attendanceInfo.setEmployeesss(updateperson);
		attendanceRepo.save(attendanceInfo);
	}
}
