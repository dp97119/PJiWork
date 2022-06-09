package com.ourProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calendar")
public class Calendar {
	@Id
	@Column(name = "calendarId")

	private Integer calendarId;
	
	@Column(name = "calendarType")
	private String calendarType;
	
	@Column(name = "calendarTitle")
	private String calendarTitle;
	
	@Column(name = "eventStart")
	private Date eventStart;
	
	@Column(name = "eventEnd")
	private Date eventEnd;
	
	@Column(name = "allDay")
	private String allDay;
	
}
