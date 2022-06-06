package com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourProject.model.Test;
import com.ourProject.repository.TestRepo;


@Service
public class TestService {
	@Autowired	
	public TestRepo testRepo;
	
	public List<Test> selectAll() {
		List<Test> result = testRepo.findAll();
		System.out.println(result);
		return result;
	}
	
	public void updatetest(Test test) {
		testRepo.save(test);
	}
	
	
}
