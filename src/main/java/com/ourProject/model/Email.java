package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="email")
public class Email {
	@Id
	@Column(name = "emailid")
	private Integer emailId;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="sender",referencedColumnName = "empid")
	@JoinColumn(name="recipient",referencedColumnName = "empid")
	private Employee employees;
	
	@Column(name = "sendtime")
	private java.util.Date sendtime;
	
}
