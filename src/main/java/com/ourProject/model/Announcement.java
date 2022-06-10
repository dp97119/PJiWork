package com.ourProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="announcement")

public class Announcement {
	@ManyToOne(optional=false)
	@JoinColumn(name="uploader",referencedColumnName = "empid")
	private Employee employees;

	@Id
	@Column(name = "announceid")
	private Integer announceId;
	
	@Column(name = "type",columnDefinition="ENUM('最新公告')")
	private String type;
	
	@Column(name = "uploaddate")
	private java.util.Date uploadDate;
	
	
//	@Column(name = "uploader",columnDefinition="char(11)")
	private String uploader;
	
	@Column(name = "removed")
	private java.util.Date removed;
	
	@Column(name = "content")
	private String content;
	
//	@Column(name = "updatedate")
//	private java.util.Date updateDate;
//	
//	@Column(name = "createdate")
//	private java.util.Date createDate;
//	
//	@Column(name = "createperson")
//	private String createPerson;
//	
//	@Column(name = "updateperson")
//	private String updatePerson;
	
}
