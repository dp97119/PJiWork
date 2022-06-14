package tw.com.ourProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Date time;
	
	@Column(name = "person",columnDefinition="char(11)")
	private String empId;
	
	@Column(name = "locationlat")
	private String locationLat;
	
	@Column(name = "locationlng")
	private String locationLng;

	@Override
	public String toString() {
		return "Punch [punchId=" + punchId + ", status=" + status + ", time=" + time + ", empId=" + empId
				+ ", locationLat=" + locationLat + ", locationLng=" + locationLng + "]";
	}

	public Integer getPunchId() {
		return punchId;
	}

	public void setPunchId(Integer punchId) {
		this.punchId = punchId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getLocationLat() {
		return locationLat;
	}

	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}

	public String getLocationLng() {
		return locationLng;
	}

	public void setLocationLng(String locationLng) {
		this.locationLng = locationLng;
	}
	
	
}
