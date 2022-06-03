package com.ourProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ourProject.model.Product;
import com.ourProject.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> selectUser(@RequestBody String str){
		 List<Product> result =  productRepo.findAll();
		return result;
	}
}
