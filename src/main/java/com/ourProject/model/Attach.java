package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attach")
public class Attach {
	@Id
	@Column(name = "attachmentid")
	private Integer attachmentId;
}
