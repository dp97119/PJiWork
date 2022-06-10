package com.ourProject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="apart")
public class Apart {
	@OneToMany(mappedBy = "aparts",cascade = CascadeType.ALL)
	private Set<Approvalset> approvalsets;
	@OneToMany(mappedBy = "aparts",cascade = CascadeType.ALL)
	private Set<Employee> employees;
	
	@Id
	@Column(name = "apartid")
	private Integer apartId;
	
	@Column(name = "apart")
	private String apart;
}
