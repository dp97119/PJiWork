package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="approvalset")
public class Approvalset {
	@Id
	@Column(name = "approvalsetid")
	private Integer approvalSetId;
	
	@ManyToOne
	@JoinColumn(name="apartid",referencedColumnName = "apartid")
	private Apart aparts;
	
	@ManyToOne
	@JoinColumn(name="firstapproval",referencedColumnName = "empid")
	@JoinColumn(name="secondapproval",referencedColumnName = "empid")
	private Employee employees;

}
