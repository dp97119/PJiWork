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
@Table(name="salaryslip")
public class Salaryslip {

	@Id
	@Column(name = "salaryid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salaryId;
	
	@ManyToOne
	@JoinColumn(name="empid",referencedColumnName = "empid")
	private Employee employees;
	
	@Column(name = "paymonth")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private java.util.Date payMonth;
	
	@Column(name = "basesalary")
	private Integer baseSalary;
	
	@Column(name = "supervisorydifferentialpay")
	private Integer supervisoryDifferentialPay;
	
	@Column(name = "transpallowance")
	private Integer transpAllowance;
	
	@Column(name = "assignallowance")
	private Integer assignAllowance;
	
	@Column(name = "attendancebonus")
	private Integer attendanceBonus;
	
	@Column(name = "performancebonus")
	private Integer performanceBonus;
	
	@Column(name = "professionallowance")
	private Integer professionAllowance;
	
	@Column(name = "dueamount")
	private Integer dueAmount;
	
	@Column(name = "incometax")
	private Integer incomeTax;
	
	@Column(name = "laborinsurance")
	private Integer laborInsurance;
	
	@Column(name = "healthinsurancepremium")
	private Integer healthInsurancePremium;
	
	@Column(name = "empbenefit")
	private Integer empBenefit;
	
	@Column(name = "retirecompensation")
	private Integer retireCompensation;
	
	@Column(name = "empleave")
	private Integer empLeave;
	
	@Column(name = "cashadvance")
	private Integer cashAdvance;
	
	@Column(name = "deductionsubtotal")
	private Integer deductionSubtotal;
	
	@Column(name = "nettotal")
	private Integer netTotal;
	
	@Column(name = "allowance")
	private Integer allowance;
	
	@Column(name = "overtimepay")
	private Integer overtimePay;
	
	@Column(name = "nettotalovertime")
	private Integer netTotalOvertime;
	
	@Column(name = "overtimemultiple")
	private Float overtimeMultiple;
	
	@Column(name = "extrahours")
	private Integer extraHours;
	
	@Column(name = "annualleave")
	private Integer annualLeave;
	
	@Column(name = "usedannualleave")
	private Integer usedAnnualLeave;
	
}
