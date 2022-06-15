package tw.com.ourProject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Punch;
import tw.com.ourProject.repository.PunchRepo;

@Service
public class PunchService {

	@Autowired
	public PunchRepo punchRepo;
	
	public void savePunchInfo(String status,Date time,String person,String locationLat,String locationLng) {
		Punch punchInfo = new Punch();
		punchInfo.setStatus(status);
		punchInfo.setTime(time);
		punchInfo.setPerson(person);
		punchInfo.setLocationLat(locationLat);
		punchInfo.setLocationLng(locationLng);
		punchRepo.save(punchInfo);
		
	}
	
	public List<Punch> getPunchInfo(String person) {
		return punchRepo.findByPerson(person);
	}
	
}
