package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaves")
public class Leaves {
	@Id
	@Column(name = "leaveid")
	private Integer leaveId;
}
