package com.ourProject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="leaves")
public class Leaves {
	@OneToMany(mappedBy = "leaves",cascade = CascadeType.ALL)
	private Set<Attendance> attendances;
	
	@Id
	@Column(name = "leaveid")
	private Integer leaveId;
	
	@Column(name = "leavetype")
	private String leaveType;
}
