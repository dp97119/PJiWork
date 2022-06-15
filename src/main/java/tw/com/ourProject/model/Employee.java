package tw.com.ourProject.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Configuration;

@Embeddable
@Entity
@Table(name="employee")
public class Employee implements Serializable {
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Announcement> announcements;
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Attendance> attendances;
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Approvalset> approvalsets;
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private Set<Approvalset> approvalset;
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Email> emails;
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Order> orders;
//	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
//	private Set<Punch> punches;
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Salaryslip> salaryslips;
	
	@Id
	@Column(name = "empid",columnDefinition="char(11)")
	private String empId;
	@Column(name = "passwd")
	private String passwd;
	@Column(name = "empname")
	private String empName;
	@Column(name = "photo")
	private String photo;
	@ManyToOne
	@JoinColumn(name="apartid",referencedColumnName = "apartid")
	private Apart aparts;
	@Column(name = "tel")
	private String tel;
	@Column(name = "gender",columnDefinition="ENUM('男','女')")
	private String gender;
	@Column(name = "cellphone1",columnDefinition="char(10)")
	private String cellphone1;
	@Column(name = "cellphone2",columnDefinition="char(10)")
	private String cellphone2;
	@Column(name = "email")
	private String email;
	@Column(name = "adm",columnDefinition="ENUM('admin','user')")
	private String adm;
	@Column(name = "addr")
	private String addr;

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Apart getAparts() {
		return aparts;
	}
	public void setAparts(Apart aparts) {
		this.aparts = aparts;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCellphone1() {
		return cellphone1;
	}
	public void setCellphone1(String cellphone1) {
		this.cellphone1 = cellphone1;
	}
	public String getCellphone2() {
		return cellphone2;
	}
	public void setCellphone2(String cellphone2) {
		this.cellphone2 = cellphone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdm() {
		return adm;
	}
	public void setAdm(String adm) {
		this.adm = adm;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", passwd=" + passwd + ", empName=" + empName + ", photo=" + photo
				+ ", aparts=" + aparts + ", tel=" + tel + ", gender=" + gender + ", cellphone1=" + cellphone1
				+ ", cellphone2=" + cellphone2 + ", email=" + email + ", adm=" + adm + ", addr=" + addr + "]";
	}

	
	

}
