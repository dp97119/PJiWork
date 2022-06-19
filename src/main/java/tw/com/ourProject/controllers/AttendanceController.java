package tw.com.ourProject.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;

import tw.com.ourProject.model.Approval;
import tw.com.ourProject.model.Attendance;
import tw.com.ourProject.model.Employee;
import tw.com.ourProject.model.Leaves;
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
	
	@Autowired
	public Leaves leaveid;
	public Approval approvalId;
	public Employee emp1 = new Employee();
	public Employee emp2 = new Employee();
	public Employee emp3 = new Employee();
	@PostMapping("/Attendance/insert")
	public void addAttendance(@RequestBody JSONArray attendanceInfo) {
		try {
			String obj1 = attendanceInfo.getJSONObject(0).get("empId").toString();
			emp1.setEmpId(obj1);
			leaveid.setLeaveId(Integer.parseInt(attendanceInfo.getJSONObject(0).get("leaveId").toString())); 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date obj3 = format.parse(attendanceInfo.getJSONObject(0).get("startDate").toString());
			Date obj4 = format.parse(attendanceInfo.getJSONObject(0).get("endDate").toString());
			Integer obj5 = (Integer.parseInt(attendanceInfo.getJSONObject(0).get("hours").toString()));
			approvalId.setApprovalId(Integer.parseInt(attendanceInfo.getJSONObject(0).get("approvalId").toString()));
			String obj7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			String obj8 = attendanceInfo.getJSONObject(0).get("empId").toString();
			emp1.setEmpId(obj8);
			String obj9 = attendanceInfo.getJSONObject(0).get("empId").toString();
			emp2.setEmpId(obj9);
			
			attendanceService.saveAttendance(emp1, leaveid, obj3, obj4, obj5, approvalId, obj7, emp1, emp2);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
}
