package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="apart")
public class Apart {
	@Id
	@Column(name = "apartid")
	private Integer apartId;
	
	@Column(name = "apart")
	private String apart;
}
