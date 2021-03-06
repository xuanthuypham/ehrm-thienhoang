package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EmployeeIncomes generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE_INCOMES", catalog = "eHRM_JavaResearching")
public class EmployeeIncomes implements java.io.Serializable {

	private Integer employeeIncomeId;
	private Employees employees;
	private Incomes incomes;
	private Periods periods;
	private BigDecimal exchangeRate;
	private Date startDate;
	private Date endDate;
	private String affectValue;
	private String payValue;
	private String calculatedValue;
	private String affectAmount;
	private String payAmount;
	private String calculatedAmount;
	private String customValue;
	private String incomeValue;
	private boolean isPay;
	private int payPeriodId;
	private Set<EmployeeIncomeTaxStats> employeeIncomeTaxStatses = new HashSet<EmployeeIncomeTaxStats>(0);

	public EmployeeIncomes() {
	}

	public EmployeeIncomes(Employees employees, Incomes incomes, Periods periods, BigDecimal exchangeRate,
			Date startDate, boolean isPay, int payPeriodId) {
		this.employees = employees;
		this.incomes = incomes;
		this.periods = periods;
		this.exchangeRate = exchangeRate;
		this.startDate = startDate;
		this.isPay = isPay;
		this.payPeriodId = payPeriodId;
	}

	public EmployeeIncomes(Employees employees, Incomes incomes, Periods periods, BigDecimal exchangeRate,
			Date startDate, Date endDate, String affectValue, String payValue, String calculatedValue,
			String affectAmount, String payAmount, String calculatedAmount, String customValue, String incomeValue,
			boolean isPay, int payPeriodId, Set<EmployeeIncomeTaxStats> employeeIncomeTaxStatses) {
		this.employees = employees;
		this.incomes = incomes;
		this.periods = periods;
		this.exchangeRate = exchangeRate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.affectValue = affectValue;
		this.payValue = payValue;
		this.calculatedValue = calculatedValue;
		this.affectAmount = affectAmount;
		this.payAmount = payAmount;
		this.calculatedAmount = calculatedAmount;
		this.customValue = customValue;
		this.incomeValue = incomeValue;
		this.isPay = isPay;
		this.payPeriodId = payPeriodId;
		this.employeeIncomeTaxStatses = employeeIncomeTaxStatses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EMPLOYEE_INCOME_ID", unique = true, nullable = false)
	public Integer getEmployeeIncomeId() {
		return this.employeeIncomeId;
	}

	public void setEmployeeIncomeId(Integer employeeIncomeId) {
		this.employeeIncomeId = employeeIncomeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID", nullable = false)
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INCOME_ID", nullable = false)
	public Incomes getIncomes() {
		return this.incomes;
	}

	public void setIncomes(Incomes incomes) {
		this.incomes = incomes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERIOD_ID", nullable = false)
	public Periods getPeriods() {
		return this.periods;
	}

	public void setPeriods(Periods periods) {
		this.periods = periods;
	}

	@Column(name = "EXCHANGE_RATE", nullable = false, precision = 18, scale = 10)
	public BigDecimal getExchangeRate() {
		return this.exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", nullable = false, length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE", length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "AFFECT_VALUE", length = 1000)
	public String getAffectValue() {
		return this.affectValue;
	}

	public void setAffectValue(String affectValue) {
		this.affectValue = affectValue;
	}

	@Column(name = "PAY_VALUE", length = 1000)
	public String getPayValue() {
		return this.payValue;
	}

	public void setPayValue(String payValue) {
		this.payValue = payValue;
	}

	@Column(name = "CALCULATED_VALUE", length = 1000)
	public String getCalculatedValue() {
		return this.calculatedValue;
	}

	public void setCalculatedValue(String calculatedValue) {
		this.calculatedValue = calculatedValue;
	}

	@Column(name = "AFFECT_AMOUNT", length = 1000)
	public String getAffectAmount() {
		return this.affectAmount;
	}

	public void setAffectAmount(String affectAmount) {
		this.affectAmount = affectAmount;
	}

	@Column(name = "PAY_AMOUNT", length = 1000)
	public String getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	@Column(name = "CALCULATED_AMOUNT", length = 1000)
	public String getCalculatedAmount() {
		return this.calculatedAmount;
	}

	public void setCalculatedAmount(String calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	@Column(name = "CUSTOM_VALUE", length = 1000)
	public String getCustomValue() {
		return this.customValue;
	}

	public void setCustomValue(String customValue) {
		this.customValue = customValue;
	}

	@Column(name = "INCOME_VALUE", length = 1000)
	public String getIncomeValue() {
		return this.incomeValue;
	}

	public void setIncomeValue(String incomeValue) {
		this.incomeValue = incomeValue;
	}

	@Column(name = "IS_PAY", nullable = false)
	public boolean isIsPay() {
		return this.isPay;
	}

	public void setIsPay(boolean isPay) {
		this.isPay = isPay;
	}

	@Column(name = "PAY_PERIOD_ID", nullable = false)
	public int getPayPeriodId() {
		return this.payPeriodId;
	}

	public void setPayPeriodId(int payPeriodId) {
		this.payPeriodId = payPeriodId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeIncomes")
	public Set<EmployeeIncomeTaxStats> getEmployeeIncomeTaxStatses() {
		return this.employeeIncomeTaxStatses;
	}

	public void setEmployeeIncomeTaxStatses(Set<EmployeeIncomeTaxStats> employeeIncomeTaxStatses) {
		this.employeeIncomeTaxStatses = employeeIncomeTaxStatses;
	}

}
