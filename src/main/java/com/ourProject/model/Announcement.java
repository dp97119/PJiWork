package com.ourProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="announcement")
public class Announcement {
	@Id
	@Column(name = "announceid")
	private Integer announceId;
	
//	@Column(name = "type")
//	private String type;
//	
//	@Column(name = "uploaddate")
//	private Date uploadDate;
//	
//	@Column(name = "uploader")
//	private Integer uploader;
//	
//	@Column(name = "removed")
//	private Date removed;
//	
//	@Column(name = "content")
//	private String content;
//	
//	@Column(name = "updatedate")
//	private Date updateDate;
//	
//	@Column(name = "createdate")
//	private Date createDate;
//	
//	@Column(name = "createperson")
//	private Integer createPerson;
//	
//	@Column(name = "updateperson")
//	private Integer updatePerson;
	
}
