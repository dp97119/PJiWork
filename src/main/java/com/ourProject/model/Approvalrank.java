package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="approvalrank")
public class Approvalrank {
	@Id
	@Column(name = "approvalRankId")
	
	private Integer approvalRankId;
}
