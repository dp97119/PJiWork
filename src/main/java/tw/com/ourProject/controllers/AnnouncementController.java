package tw.com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.model.Announcement;
import tw.com.ourProject.service.AnnouncementService;
import tw.com.ourProject.service.AttachService;

@RestController
public class AnnouncementController {
	@Autowired
	public AnnouncementService announcementService;
	
	@Autowired
	public AttachService attachService;
	
	@GetMapping("/showAnnouncement")
	public List<Announcement> findannouncement(){
		List<Announcement> announs = announcementService.findAnnouncementn();
		return announs;
	}

	@PostMapping("/Announcement/addAnn")
	public JSONObject addAnn(@RequestBody JSONObject data) {
		return announcementService.addAnn(data);
	}
	
	@PostMapping("/Announcement/uploadAttach")
	public void uploadUserPhoto(@RequestParam("file[]") MultipartFile[] multipartFile,
								@RequestParam("annId") String annId,
								@RequestParam("userToken") String userToken ) {
		attachService.addAttach(multipartFile,annId,userToken);
		
		
	}
}
