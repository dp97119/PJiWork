package com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "product")
public class Product {
	
		@Id
		@Column(name = "id")
		private Integer id;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "price")
		private Double price;
		
		@Column(name = "make")
		private java.util.Date make;
		
		@Column(name = "expire")
		private Integer expire;
		
		@Override
		public String toString() {
			return "model.ProductBean ["+ id+ ","+ name+ ","+ price+ ","+ make+ ","+ expire+ "]";
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public java.util.Date getMake() {
			return make;
		}
		public void setMake(java.util.Date make) {
			this.make = make;
		}
		public Integer getExpire() {
			return expire;
		}
		public void setExpire(Integer expire) {
			this.expire = expire;
		}
	}


