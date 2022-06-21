package tw.com.ourProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import tw.com.ourProject.model.Attach;
import tw.com.ourProject.service.AttachService;

public class AttachController {
	@Autowired
	public AttachService attachService;
	
	@GetMapping("/Attach/find")
	public List<Attach> findattach(){
		List<Attach> attach = attachService.findAttach();
		return attach;
	}
}
