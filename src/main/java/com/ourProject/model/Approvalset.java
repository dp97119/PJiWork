package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="approvalset")
public class Approvalset {
	@Id
	@Column(name = "approvalsetid")
	private Integer approvalSetId;
}
