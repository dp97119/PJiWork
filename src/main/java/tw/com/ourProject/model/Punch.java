package tw.com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="punch")
public class Punch {

	
	@Id
	@Column(name = "punchid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer punchId;
	
	@Column(name = "status",columnDefinition="ENUM('上班','下班')")
	private String status;
	
	@Column(name = "time")
	private java.util.Date time;
	
	@ManyToOne
	@JoinColumn(name="person",referencedColumnName = "empid")
	private Employee employees;
	
	@Column(name = "locationlat")
	private String locationLat;
	
	@Column(name = "locationlng")
	private String locationLng;
}
