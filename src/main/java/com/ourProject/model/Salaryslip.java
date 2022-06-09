package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salaryslip")
public class Salaryslip {

	@Id
	@Column(name = "salaryId ")
	private Integer salaryId ;
}
