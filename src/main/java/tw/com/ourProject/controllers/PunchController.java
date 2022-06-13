package tw.com.ourProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import tw.com.ourProject.service.PunchService;

@RestController
public class PunchController {

	
	@Autowired
	public PunchService punchService;
	
	@PostMapping("/Punch/saveInfo")
	public void savePunchInfo(@RequestBody String punchData) {
		JSONObject infoObj = JSONObject.parseArray(punchData).getJSONObject(0);
		punchService.savePunchInfo(infoObj.getString("status"),
									infoObj.getString("time"),
									infoObj.getString("empId"),
									infoObj.getString("locationLat"),
									infoObj.getString("locationLng")
									);
		
	}
	
	@PostMapping("/Punch/getInfo")
	public void getPunchInfo(@RequestBody String punchData) {
		
	}
}
