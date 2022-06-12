package tw.com.ourProject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restautant")
public class Restautant {
	@OneToMany(mappedBy = "restautants",cascade = CascadeType.ALL)
	private Set<Dish> dishes;
	@OneToMany(mappedBy = "restautants",cascade = CascadeType.ALL)
	private Set<Restaurantset> restaurantsets;
	
	@Id
	@Column(name = "restaurantid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId ;
	
	@Column(name = "restaurantname")
	private String restaurantName ;
	
	@Column(name = "tel")
	private String tel ;
	
	@Column(name = "addr")
	private String addr ;
}
