package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance {
	@Id
	@Column(name = "attendanceid")
	private Integer attendanceId;
}
