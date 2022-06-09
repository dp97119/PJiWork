package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurantset")
public class Restaurantset {

	@Id
	@Column(name = "setId")
	private Integer setId ;
}
