package tw.com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ourProject.model.Announcement;
import tw.com.ourProject.service.AnnouncementService;

@RestController
public class AnnouncementController {
	@Autowired
	public AnnouncementService announcementService;
	
	@GetMapping("/showAnnouncement")
	public List<Announcement> findannouncement(){
		List<Announcement> announs = announcementService.findAnnouncementn();
		return announs;
	}
}
