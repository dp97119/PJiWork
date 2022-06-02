package com.ourProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourProject.model.Product;

public interface ProductDAO  extends JpaRepository<Product, Long>{

}
