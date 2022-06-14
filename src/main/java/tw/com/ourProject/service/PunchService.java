package tw.com.ourProject.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Punch;
import tw.com.ourProject.repository.PunchRepo;

@Service
public class PunchService {

	@Autowired
	public PunchRepo punchRepo;
	
	public void savePunchInfo(String status,Date time,String empId,String locationLat,String locationLng) {
		Punch punchInfo = new Punch();
		punchInfo.setStatus(status);
		punchInfo.setTime(time);
		punchInfo.setEmpId(empId);
		punchInfo.setLocationLat(locationLat);
		punchInfo.setLocationLng(locationLng);
		punchRepo.save(punchInfo);
		
	}
	
}
