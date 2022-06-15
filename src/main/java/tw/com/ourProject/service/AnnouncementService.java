package tw.com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Announcement;
import tw.com.ourProject.repository.AnnouncementRepo;

@Service
public class AnnouncementService {
	@Autowired
	public AnnouncementRepo announcementRepo;
	
	public List<Announcement> findAnnouncementn(){
		return announcementRepo.findAll();
	}
}
