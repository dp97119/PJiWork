package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="punch")
public class Punch {

	
	@Id
	@Column(name = "punchId")
	private Integer punchId ;
}
