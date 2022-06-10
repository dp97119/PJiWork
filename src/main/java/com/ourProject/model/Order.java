package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@Column(name = "orderid")
	private Integer orderId;
	
	@ManyToOne
	@JoinColumn(name="empid",referencedColumnName = "empid")
	private Employee employees;
	
	@Column(name = "date")
	private java.util.Date date;
	
	@ManyToOne
	@JoinColumn(name="dishid ",referencedColumnName = "dishid")
	private Dish dishes;
	
	@Column(name = "qty")
	private Integer qty;
	
	@Column(name = "ordermemo")
	private String orderMemo;
	
	@Column(name = "type",columnDefinition="ENUM('購物車','出貨')")
	private String type;
}
