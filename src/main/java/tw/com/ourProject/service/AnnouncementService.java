package tw.com.ourProject.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.model.Announcement;
import tw.com.ourProject.model.Employee;
import tw.com.ourProject.repository.AnnouncementRepo;
import tw.com.ourProject.repository.EmployeeRepo;
import tw.com.ourProject.utils.JWTUtil;

@Service
public class AnnouncementService {
	@Autowired
	public AnnouncementRepo announcementRepo;
	@Autowired
	public JWTUtil jwt;
	@Autowired
	public EmployeeRepo employeeRepo;
	
	Employee employee = new Employee();
	
	Announcement announcement = new Announcement();
	
	public List<Announcement> findAnnouncementn(){
		return announcementRepo.findAll();
	}
	
	public JSONObject addAnn(JSONObject data) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject obj =  new JSONObject();
		
		try {
		announcement.setType(data.getString("type"));
		announcement.setUploadDate(format.parse(data.getString("uploadDate")));
		announcement.setEmployees(employeeRepo.findByEmpId(jwt.getInfoFromJwtToken(data.getString("userToken"), "empId")));
		announcement.setRemoved(format.parse(data.getString("removed")));
		announcement.setTitle(data.getString("title"));
		announcement.setContent(data.getString("content"));
		announcement.setCreatePerson(jwt.getInfoFromJwtToken(data.getString("userToken"), "empId"));
		announcement.setUpdatePerson(jwt.getInfoFromJwtToken(data.getString("userToken"), "empId"));
		announcementRepo.save(announcement);
		obj.put("annId", announcement.getAnnounceId());
		System.out.println(announcement.getAnnounceId());
		return obj;

		}catch(Exception e) {
			obj.put("annId", null);
			return obj;
		}
		
	}

}
