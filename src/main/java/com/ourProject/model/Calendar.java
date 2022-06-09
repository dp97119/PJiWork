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
	@Column(name = "calendarid")
	private Integer calendarId;
//	
//	@Column(name = "calendartype")
//	private String calendarType;
//	
//	@Column(name = "calendartitle")
//	private String calendarTitle;
//	
//	@Column(name = "eventstart")
//	private Date eventStart;
//	
//	@Column(name = "eventend")
//	private Date eventEnd;
//	
//	@Column(name = "allday")
//	private String allDay;
	
}
