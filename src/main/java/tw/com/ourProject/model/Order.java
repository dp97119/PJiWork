package tw.com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@Column(name = "orderid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@ManyToOne
	@JoinColumn(name="empid",referencedColumnName = "empid")
	private Employee employees;
	
	@Column(name = "date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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
