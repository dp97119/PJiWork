package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restautant")
public class Restautant {
	
	@Id
	@Column(name = "restaurantId")
	private Integer restaurantId ;
}
