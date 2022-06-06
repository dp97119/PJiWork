package com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ourProject.model.Test;


public interface TestRepo extends JpaRepository<Test, Long> {

}
