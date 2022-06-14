package tw.com.ourProject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="attendance")
public class Attendance {
	@OneToMany(mappedBy = "attendances",cascade = CascadeType.ALL)
	private Set<Approvalrank> approvalranks;
	
	@Id
	@Column(name = "attendanceid",columnDefinition="char(11)")
	private String attendanceId;
	
	@ManyToOne
	@JoinColumn(name="empid",referencedColumnName = "empid")
	private Employee employees;
	
	@ManyToOne
	@JoinColumn(name="leaveid",referencedColumnName = "leaveid")
	private Leaves leaves;
	
	@Column(name = "startdate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date startDate;
	
	@Column(name = "enddate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date endDate;
	
	@Column(name = "hours")
	private Integer hours;
	
	@ManyToOne
	@JoinColumn(name="approvalid",referencedColumnName = "approvalid")
	private Approval approvals;
}
