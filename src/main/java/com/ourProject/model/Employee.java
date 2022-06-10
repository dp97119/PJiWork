package com.ourProject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Announcement> announcements;
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Attendance> attendances;
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Email> emails;
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Order> orders;
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	private Set<Punch> punches;
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
	

}
