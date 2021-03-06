package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IncomeConfigs generated by hbm2java
 */
@Entity
@Table(name = "INCOME_CONFIGS", catalog = "eHRM_JavaResearching")
public class IncomeConfigs implements java.io.Serializable {

	private Integer incomeConfigId;
	private Employees employees;
	private Incomes incomes;
	private BigDecimal grossValue;
	private BigDecimal netValue;
	private BigDecimal payValue;
	private BigDecimal customValue;
	private BigDecimal incomeValue;
	private Date startDate;
	private Date endDate;

	public IncomeConfigs() {
	}

	public IncomeConfigs(Employees employees, Incomes incomes, BigDecimal grossValue, BigDecimal netValue,
			BigDecimal payValue, BigDecimal customValue, Date startDate) {
		this.employees = employees;
		this.incomes = incomes;
		this.grossValue = grossValue;
		this.netValue = netValue;
		this.payValue = payValue;
		this.customValue = customValue;
		this.startDate = startDate;
	}

	public IncomeConfigs(Employees employees, Incomes incomes, BigDecimal grossValue, BigDecimal netValue,
			BigDecimal payValue, BigDecimal customValue, BigDecimal incomeValue, Date startDate, Date endDate) {
		this.employees = employees;
		this.incomes = incomes;
		this.grossValue = grossValue;
		this.netValue = netValue;
		this.payValue = payValue;
		this.customValue = customValue;
		this.incomeValue = incomeValue;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "INCOME_CONFIG_ID", unique = true, nullable = false)
	public Integer getIncomeConfigId() {
		return this.incomeConfigId;
	}

	public void setIncomeConfigId(Integer incomeConfigId) {
		this.incomeConfigId = incomeConfigId;
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

	@Column(name = "GROSS_VALUE", nullable = false, precision = 18, scale = 4)
	public BigDecimal getGrossValue() {
		return this.grossValue;
	}

	public void setGrossValue(BigDecimal grossValue) {
		this.grossValue = grossValue;
	}

	@Column(name = "NET_VALUE", nullable = false, precision = 18, scale = 4)
	public BigDecimal getNetValue() {
		return this.netValue;
	}

	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}

	@Column(name = "PAY_VALUE", nullable = false, precision = 18, scale = 4)
	public BigDecimal getPayValue() {
		return this.payValue;
	}

	public void setPayValue(BigDecimal payValue) {
		this.payValue = payValue;
	}

	@Column(name = "CUSTOM_VALUE", nullable = false, precision = 18, scale = 4)
	public BigDecimal getCustomValue() {
		return this.customValue;
	}

	public void setCustomValue(BigDecimal customValue) {
		this.customValue = customValue;
	}

	@Column(name = "INCOME_VALUE", precision = 18, scale = 4)
	public BigDecimal getIncomeValue() {
		return this.incomeValue;
	}

	public void setIncomeValue(BigDecimal incomeValue) {
		this.incomeValue = incomeValue;
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

}
