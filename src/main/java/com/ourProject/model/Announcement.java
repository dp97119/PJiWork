package com.ourProject.model;

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

}
