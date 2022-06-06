package com.ourProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="dish")
@EntityListeners(AuditingEntityListener.class)
public class Dish {

	@Id
	@Column(name = "dishId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dishId ;
	
	@Column(name = "dishItem")
	private String dishItem ;
	
	@Column(name = "dishPhoto")
	private String dishPhoto ;
	
	@Column(name = "dishPrice")
	private Integer dishPrice ;
	
	@Column(name = "restaurantId")
	private Integer restaurantId ;
	
	@LastModifiedDate 
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "updateDate")
	private Date updateDate ;
	
	@CreatedDate 
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "createDate")
	private Date createDate ;
	
	@CreatedBy
	@Column(name = "createPerson")
	private Integer createPerson ;
	
	@LastModifiedBy
	@Column(name = "updatePerson")
	private Integer updatePerson ;


	public Integer getDishId() {
		return dishId;
	}


	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}


	public String getDishItem() {
		return dishItem;
	}


	public void setDishItem(String dishItem) {
		this.dishItem = dishItem;
	}


	public String getDishPhoto() {
		return dishPhoto;
	}


	public void setDishPhoto(String dishPhoto) {
		this.dishPhoto = dishPhoto;
	}


	public Integer getDishPrice() {
		return dishPrice;
	}


	public void setDishPrice(Integer dishPrice) {
		this.dishPrice = dishPrice;
	}


	public Integer getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Integer getCreatePerson() {
		return createPerson;
	}


	public void setCreatePerson(Integer createPerson) {
		this.createPerson = createPerson;
	}


	public Integer getUpdatePerson() {
		return updatePerson;
	}


	public void setUpdatePerson(Integer updatePerson) {
		this.updatePerson = updatePerson;
	}


	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishItem=" + dishItem + ", dishPhoto=" + dishPhoto + ", dishPrice="
				+ dishPrice + ", restaurantId=" + restaurantId + ", updateDate=" + updateDate + ", createDate="
				+ createDate + ", createPerson=" + createPerson + ", updatePerson=" + updatePerson + "]";
	}
	
	
	
}
