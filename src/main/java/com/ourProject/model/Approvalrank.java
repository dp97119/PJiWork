package com.ourProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="approvalrank")
public class Approvalrank {
	@Id
	@Column(name = "approvalrankid")
	private Integer approvalRankId;
	
	@ManyToOne
	@JoinColumn(name="attendanceid",referencedColumnName = "attendanceid")
	private Attendance attendances;
	
	@Column(name = "attendancedate")
	private java.util.Date attendanceDate;
	
	@Column(name = "approver1")
	private String approver1;
	
	@Column(name = "dateapproved1")
	private java.util.Date dateApproved1;
	
	@Column(name = "approver2")
	private String approver2;
	
	@Column(name = "dateapproved2")
	private java.util.Date dateApproved2;
}
