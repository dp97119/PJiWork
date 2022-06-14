package tw.com.ourProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="calendar")
public class Calendar {
	@Id
	@Column(name = "calendarid")
	private Integer calendarId;
	
	@Column(name = "calendartype",columnDefinition="ENUM('個人','部門','公司')")
	private String calendarType;
	
	@Column(name = "calendartitle")
	private String calendarTitle;
	
	@Column(name = "eventstart")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date eventStart;
	
	@Column(name = "eventend")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date eventEnd;
	
	@Column(name = "allday",columnDefinition="ENUM('Y','N')")
	private String allDay;
	
}
