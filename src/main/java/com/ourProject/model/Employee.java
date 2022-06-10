package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@OneToMany(targetEntity = Announcement.class)
	@Column(name = "empid",columnDefinition="char(11)")
	private String empId;
	@Column(name = "passwd")
	private String passwd;
	@Column(name = "empname")
	private String empName;
	@Column(name = "photo")
	private String photo;
	@Column(name = "apartid")
	private Integer apartId;
	@Column(name = "adm",columnDefinition="ENUM('admin','user')")
	private String adm;
	
	
	public String getAdm() {
		return adm;
	}
	public void setAdm(String adm) {
		this.adm = adm;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", passwd=" + passwd + ", empName=" + empName + ", photo=" + photo
				+ ", apartId=" + apartId + ", adm=" + adm + "]";
	}
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
	public Integer getApartId() {
		return apartId;
	}
	public void setApartId(Integer apartId) {
		this.apartId = apartId;
	}
}
