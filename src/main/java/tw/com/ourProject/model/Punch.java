package tw.com.ourProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="punch")
public class Punch {

	
	@Id
	@Column(name = "punchid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer punchId;
	
	@Column(name = "status",columnDefinition="ENUM('上班','下班')")
	private String status;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "time")
	private java.util.Date time;
	
	@Column(name = "person",columnDefinition="char(11)")
	private String person;
	
	@Column(name = "locationlat")
	private String locationLat;
	
	@Column(name = "locationlng")
	private String locationLng;

	@Override
	public String toString() {
		return "Punch [punchId=" + punchId + ", status=" + status + ", time=" + time + ", person=" + person
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
		return person;
	}

	public void setEmpId(String person) {
		this.person = person;
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
