package tw.com.ourProject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
@Entity
@Table(name="dish")
@EntityListeners(AuditingEntityListener.class)
public class Dish implements Serializable {

	@Id
	@Column(name = "dishid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dishId ;
	
	@Column(name = "dishitem")
	private String dishItem ;
	
	@Column(name = "dishphoto")
	private String dishPhoto ;
	
	@Column(name = "dishprice")
	private Integer dishPrice ;
	
	@ManyToOne
	@JoinColumn(name="restaurantid",referencedColumnName = "restaurantid")
	private Restaurant restaurants;
	
	
	@Column(name = "createperson",columnDefinition="char(11)")
	private String createPerson ;
	
	@Column(name = "updateperson",columnDefinition="char(11)")
	private String updatePerson ;
	
	@LastModifiedDate 
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "updatedate")
	private Date updateDate ;
	
	@CreatedDate 
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "createdate")
	private Date createDate ;

	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishItem=" + dishItem + ", dishPhoto=" + dishPhoto + ", dishPrice="
				+ dishPrice + ", restautants=" + restaurants + ", createPerson=" + createPerson + ", updatePerson="
				+ updatePerson + ", updateDate=" + updateDate + ", createDate=" + createDate + "]";
	}

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

	public Restaurant getRestautants() {
		return restaurants;
	}

	public void setRestautants(Restaurant restautants) {
		this.restaurants = restautants;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
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

	

}