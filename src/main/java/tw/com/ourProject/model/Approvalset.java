package tw.com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="approvalset")
public class Approvalset {
	@Id
	@Column(name = "approvalsetid")
	private Integer approvalSetId;
	
	@ManyToOne
	@JoinColumn(name="apartid",referencedColumnName = "apartid")
	private Apart aparts;
	
	@ManyToOne
	@JoinColumn(name="firstapproval",referencedColumnName = "empid")
	@JoinColumn(name="secondapproval",referencedColumnName = "empid")
	private Employee employees;

	public Integer getApprovalSetId() {
		return approvalSetId;
	}

	public void setApprovalSetId(Integer approvalSetId) {
		this.approvalSetId = approvalSetId;
	}

	public Apart getAparts() {
		return aparts;
	}

	public void setAparts(Apart aparts) {
		this.aparts = aparts;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Approvalset [approvalSetId=" + approvalSetId + ", aparts=" + aparts + ", employees=" + employees + "]";
	}
	
	

}
