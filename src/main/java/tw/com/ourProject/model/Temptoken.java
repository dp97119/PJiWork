package tw.com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temptoken")
public class Temptoken {
	@Id
	@Column(name = "tokenid")
	private Integer tokenId;
	
	@Column(name = "tokenvalue")
	private String tokenValue;
}
