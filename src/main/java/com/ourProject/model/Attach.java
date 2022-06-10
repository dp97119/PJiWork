package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attach")
public class Attach {
	@Id
	@Column(name = "attachmentid")
	private Integer attachmentId;
	
	@Column(name = "attname")
	private String attName;
	
	@ManyToOne
	@JoinColumn(name="announceid",referencedColumnName = "announceid")
	private Announcement announcements;
}
