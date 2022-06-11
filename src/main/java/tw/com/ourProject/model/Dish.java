package tw.com.ourProject.model;

import java.util.Date;

import javax.persistence.Column;
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

@Entity
@Table(name="dish")
@EntityListeners(AuditingEntityListener.class)
public class Dish {

	@Id
	@Column(name = "dishid")
	private Integer dishId ;
	
	@Column(name = "dishitem")
	private String dishItem ;
	
	@Column(name = "dishphoto")
	private String dishPhoto ;
	
	@Column(name = "dishprice")
	private Integer dishPrice ;
	
	@ManyToOne
	@JoinColumn(name="restaurantid",referencedColumnName = "restaurantid")
	private Restautant restautants;
//	@LastModifiedDate 
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//	@Column(name = "updatedate")
//	private Date updateDate ;
//	
//	@CreatedDate 
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//	@Column(name = "createdate")
//	private Date createDate ;
//	
//	@CreatedBy
//	@Column(name = "createperson")
//	private Integer createPerson ;
//	
//	@LastModifiedBy
//	@Column(name = "updateperson")
//	private Integer updatePerson ;
//
}