package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="approval")
public class Approval {
	@Id
	@Column(name = "approvalid")
	private Integer approvalId;
}
