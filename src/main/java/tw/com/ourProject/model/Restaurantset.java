package tw.com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurantset")
public class Restaurantset {

	@Id
	@Column(name = "setid")
	private Integer setId;
	
	@Column(name = "setdate")
	private java.util.Date setDate;
	
	@ManyToOne
	@JoinColumn(name="restaurantid",referencedColumnName = "restaurantid")
	private Restautant restautants;
	

	
}