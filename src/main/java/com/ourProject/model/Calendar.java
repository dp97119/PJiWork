package com.ourProject.model;

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
	private String calendarType;
	private String calendarTitle;
}
