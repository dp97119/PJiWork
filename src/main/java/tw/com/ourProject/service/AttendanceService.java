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

import tw.com.ourProject.model.Apart;
import tw.com.ourProject.model.Approval;
import tw.com.ourProject.model.Approvalset;
import tw.com.ourProject.model.Attendance;
import tw.com.ourProject.model.Employee;
import tw.com.ourProject.model.Leaves;
import tw.com.ourProject.repository.ApartRepo;
import tw.com.ourProject.repository.ApprovalsetRepo;
import tw.com.ourProject.repository.AttendanceRepo;
import tw.com.ourProject.repository.EmployeeRepo;

@Service
@Transactional
public class AttendanceService {
	@Autowired
	public AttendanceRepo attendanceRepo;
	
	@Autowired
	public EmployeeRepo employeeRepo;
	
	@Autowired
	public ApprovalsetRepo approvalsetRepo;
	
	@Autowired
	public ApartRepo apartRepo;
	
	public List<Attendance> showAttendance() {
		return attendanceRepo.findAll();
	}
	
	public void saveAttendance(Employee empid, Leaves leaveid, String contenttext, Date startdate, Date enddate, 
			Integer hours, Approval approvalid, Date createdate, Employee createperson, Employee updateperson) {
		Attendance attendanceInfo = new Attendance();
		attendanceInfo.setEmployees(empid);
		attendanceInfo.setLeaves(leaveid);
		attendanceInfo.setContentText(contenttext);
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
	
	public void updateattendance(Integer attendanceid, Leaves leaveid, String contenttext, Date startdate, Date enddate,
			Integer hours, Approval approvalid, Employee updateperson) {
		Attendance attendanceInfo = attendanceRepo.findByAttendanceId(attendanceid);
		attendanceInfo.setLeaves(leaveid);
		attendanceInfo.setContentText(contenttext);
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
	
	public JSONObject UpdateViewAttendance(Integer attendanceid) {
		Attendance attendanceInfo = attendanceRepo.findByAttendanceId(attendanceid);
		JSONObject obj = new JSONObject();
		obj.put("attendanceId", attendanceInfo.getAttendanceId());
		obj.put("leaveId", attendanceInfo.getLeaves().getLeaveId()) ;
		obj.put("leaveType", attendanceInfo.getLeaves().getLeaveType());
		obj.put("ContentText", attendanceInfo.getContentText());
		obj.put("startDate", attendanceInfo.getStartDate().toInstant().atOffset(ZoneOffset.ofHours(+8)).format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
		obj.put("endDate", attendanceInfo.getEndDate().toInstant().atOffset(ZoneOffset.ofHours(+8)).format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
		obj.put("hours", attendanceInfo.getHours());
		return obj;
	}
	
	public JSONArray findApproval1attendance(String empid) {
		//找出第一審核人員
		Employee emp = employeeRepo.findByEmpId(empid);
		Approvalset apart = approvalsetRepo.findByAparts(emp.getAparts());
		Approvalset approval1 = approvalsetRepo.findByEmployees(apart.getEmployees());
		Employee approvalemp1 = approval1.getEmployees();
		
		JSONArray Jarray = new JSONArray();
		//若token的人跟層級審核設定第一層級的人相同
		if (approvalemp1 == emp) {
			//撈出出勤所有資料
			List<Attendance> attendancelist = attendanceRepo.findAll();
			for (int i = 0; i<attendancelist.size(); i++) {
				//若出勤資料的部門跟層級設定的部門相同
				if((attendancelist.get(i).getEmployees().getAparts().getApartId()) == (approvalemp1.getAparts().getApartId())){
					//就把該部門審核狀態是部門主管審核中的出勤資料抓出來，送給前端顯示待審核的畫面
					if(attendancelist.get(i).getApprovals().getApprovalId()==3) {
						JSONObject obj = new JSONObject();
						obj.put("attendanceId", attendancelist.get(i).getAttendanceId());
						obj.put("apart", attendancelist.get(i).getEmployees().getAparts().getApart());
						obj.put("empId", attendancelist.get(i).getEmployees().getEmpId());
						obj.put("empName", attendancelist.get(i).getEmployees().getEmpName());
						obj.put("leaveId", attendancelist.get(i).getLeaves().getLeaveId()) ;
						obj.put("leaveType", attendancelist.get(i).getLeaves().getLeaveType());
						obj.put("startDate", attendancelist.get(i).getStartDate().toInstant().atOffset(ZoneOffset.ofHours(+8)).format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
						obj.put("endDate", attendancelist.get(i).getEndDate().toInstant().atOffset(ZoneOffset.ofHours(+8)).format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
						obj.put("hours", attendancelist.get(i).getHours());
						Jarray.add(obj);
					}
				}
			}		
		}
		System.out.println(Jarray);
		return Jarray;
	}
	
	public void updateapproval2(Integer attendanceid, Approval approvalid, Employee updateperson) {
		Attendance attendanceInfo = attendanceRepo.findByAttendanceId(attendanceid);
		attendanceInfo.setApprovals(approvalid);
		attendanceInfo.setEmployeesss(updateperson);
		attendanceRepo.save(attendanceInfo);
	}
	
	public JSONArray findApproval2attendance(String empid) {
		//找出第二審核人員
		Employee emp = employeeRepo.findByEmpId(empid);
		Approvalset apart = approvalsetRepo.findByAparts(emp.getAparts());
		Approvalset approval2 = approvalsetRepo.findByEmployees(apart.getEmployee());
		Employee approvalemp2 = approval2.getEmployee();
		
		JSONArray Jarray = new JSONArray();
		//若token的人跟層級審核設定第二層級的人相同
		if (approvalemp2 == emp) {
			//撈出出勤所有資料
			List<Attendance> attendancelist = attendanceRepo.findAll();
			for (int i = 0; i<attendancelist.size(); i++) {
				//若出勤資料的部門跟層級設定的部門相同
				if((attendancelist.get(i).getEmployees().getAparts().getApartId()) == (approvalemp2.getAparts().getApartId())){
					//就把該部門審核狀態是部門主管審核中的出勤資料抓出來，送給前端顯示待審核的畫面
					if(attendancelist.get(i).getApprovals().getApprovalId()==6) {
						JSONObject obj = new JSONObject();
						obj.put("attendanceId", attendancelist.get(i).getAttendanceId());
						obj.put("apart", attendancelist.get(i).getEmployees().getAparts().getApart());
						obj.put("empId", attendancelist.get(i).getEmployees().getEmpId());
						obj.put("empName", attendancelist.get(i).getEmployees().getEmpName());
						obj.put("leaveId", attendancelist.get(i).getLeaves().getLeaveId()) ;
						obj.put("leaveType", attendancelist.get(i).getLeaves().getLeaveType());
						obj.put("startDate", attendancelist.get(i).getStartDate().toInstant().atOffset(ZoneOffset.ofHours(+8)).format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
						obj.put("endDate", attendancelist.get(i).getEndDate().toInstant().atOffset(ZoneOffset.ofHours(+8)).format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
						obj.put("hours", attendancelist.get(i).getHours());
						Jarray.add(obj);
					}
				}
			}		
		}
		System.out.println(Jarray);
		return Jarray;
	}
}
