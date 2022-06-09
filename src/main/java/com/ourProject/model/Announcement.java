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
	@Column(name = "announceId")
	private Integer announceId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "uploadDate")
	private Date uploadDate;
	
	@Column(name = "uploader")
	private Integer uploader;
	
	@Column(name = "removed")
	private Date removed;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "updateDate")
	private Date updateDate;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name = "createPerson")
	private Integer createPerson;
	
	@Column(name = "updatePerson")
	private Integer updatePerson;
	
}
