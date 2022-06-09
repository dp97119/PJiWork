package com.ourProject.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="calendar")
public class Calendar {
	
	private Integer calendarId;
	private String calendarType;
	private String calendarTitle;
}
