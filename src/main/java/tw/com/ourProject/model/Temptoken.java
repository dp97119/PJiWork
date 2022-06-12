package tw.com.ourProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temptoken")
public class Temptoken {
	@Id
	@Column(name = "tokenid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tokenId;
	
	@Column(name = "tokenvalue")
	private String tokenValue;

	public Integer getTokenId() {
		return tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	@Override
	public String toString() {
		return "Temptoken [tokenId=" + tokenId + ", tokenValue=" + tokenValue + "]";
	}
	
	
}
