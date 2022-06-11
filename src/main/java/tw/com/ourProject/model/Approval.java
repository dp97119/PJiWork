package tw.com.ourProject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="approval")
public class Approval {
	@OneToMany(mappedBy = "approvals",cascade = CascadeType.ALL)
	private Set<Attendance> attendances;
	
	@Id
	@Column(name = "approvalid")
	private Integer approvalId;
	
	@Column(name = "approvaltype")
	private String approvalType;
}
