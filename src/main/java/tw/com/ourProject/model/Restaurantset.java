package tw.com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="restaurantset")
public class Restaurantset {

	@Id
	@Column(name = "setid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer setId;
	
	@Column(name = "setdate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date setDate;
	
	@ManyToOne
	@JoinColumn(name="restaurantid",referencedColumnName = "restaurantid")
	private Restaurant restaurants;
	

	
}
