package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
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
 * Taxes generated by hbm2java
 */
@Entity
@Table(name = "TAXES", catalog = "eHRM_JavaResearching")
public class Taxes implements java.io.Serializable {

	private Integer taxId;
	private MasterDatas masterDatasByTaxCategoryId;
	private MasterDatas masterDatasByCurrencyId;
	private VariableIntermediates variableIntermediates;
	private String taxName;
	private BigDecimal taxValue;
	private boolean isPercentage;
	private Date startDate;
	private Date endDate;
	private boolean isCalculatedWorkingDays;
	private Set<EmployeeTaxes> employeeTaxeses = new HashSet<EmployeeTaxes>(0);
	private Set<EmployeeIncomeTaxStats> employeeIncomeTaxStatses = new HashSet<EmployeeIncomeTaxStats>(0);

	public Taxes() {
	}

	public Taxes(MasterDatas masterDatasByTaxCategoryId, MasterDatas masterDatasByCurrencyId,
			VariableIntermediates variableIntermediates, String taxName, BigDecimal taxValue,
			boolean isPercentage, boolean isCalculatedWorkingDays) {
		this.masterDatasByTaxCategoryId = masterDatasByTaxCategoryId;
		this.masterDatasByCurrencyId = masterDatasByCurrencyId;
		this.variableIntermediates = variableIntermediates;
		this.taxName = taxName;
		this.taxValue = taxValue;
		this.isPercentage = isPercentage;
		this.isCalculatedWorkingDays = isCalculatedWorkingDays;
	}

	public Taxes(MasterDatas masterDatasByTaxCategoryId, MasterDatas masterDatasByCurrencyId,
			VariableIntermediates variableIntermediates, String taxName, BigDecimal taxValue,
			boolean isPercentage, Date startDate, Date endDate, boolean isCalculatedWorkingDays,
			Set<EmployeeTaxes> employeeTaxeses, Set<EmployeeIncomeTaxStats> employeeIncomeTaxStatses) {
		this.masterDatasByTaxCategoryId = masterDatasByTaxCategoryId;
		this.masterDatasByCurrencyId = masterDatasByCurrencyId;
		this.variableIntermediates = variableIntermediates;
		this.taxName = taxName;
		this.taxValue = taxValue;
		this.isPercentage = isPercentage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isCalculatedWorkingDays = isCalculatedWorkingDays;
		this.employeeTaxeses = employeeTaxeses;
		this.employeeIncomeTaxStatses = employeeIncomeTaxStatses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TAX_ID", unique = true, nullable = false)
	public Integer getTaxId() {
		return this.taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAX_CATEGORY_ID", nullable = false)
	public MasterDatas getMasterDatasByTaxCategoryId() {
		return this.masterDatasByTaxCategoryId;
	}

	public void setMasterDatasByTaxCategoryId(MasterDatas masterDatasByTaxCategoryId) {
		this.masterDatasByTaxCategoryId = masterDatasByTaxCategoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURRENCY_ID", nullable = false)
	public MasterDatas getMasterDatasByCurrencyId() {
		return this.masterDatasByCurrencyId;
	}

	public void setMasterDatasByCurrencyId(MasterDatas masterDatasByCurrencyId) {
		this.masterDatasByCurrencyId = masterDatasByCurrencyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VARIABLE_INTERMEDIATE_ID", nullable = false)
	public VariableIntermediates getVariableIntermediates() {
		return this.variableIntermediates;
	}

	public void setVariableIntermediates(VariableIntermediates variableIntermediates) {
		this.variableIntermediates = variableIntermediates;
	}

	@Column(name = "TAX_NAME", nullable = false)
	public String getTaxName() {
		return this.taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	@Column(name = "TAX_VALUE", nullable = false, precision = 18, scale = 4)
	public BigDecimal getTaxValue() {
		return this.taxValue;
	}

	public void setTaxValue(BigDecimal taxValue) {
		this.taxValue = taxValue;
	}

	@Column(name = "IS_PERCENTAGE", nullable = false)
	public boolean isIsPercentage() {
		return this.isPercentage;
	}

	public void setIsPercentage(boolean isPercentage) {
		this.isPercentage = isPercentage;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", length = 10)
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

	@Column(name = "IS_CALCULATED_WORKING_DAYS", nullable = false)
	public boolean isIsCalculatedWorkingDays() {
		return this.isCalculatedWorkingDays;
	}

	public void setIsCalculatedWorkingDays(boolean isCalculatedWorkingDays) {
		this.isCalculatedWorkingDays = isCalculatedWorkingDays;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taxes")
	public Set<EmployeeTaxes> getEmployeeTaxeses() {
		return this.employeeTaxeses;
	}

	public void setEmployeeTaxeses(Set<EmployeeTaxes> employeeTaxeses) {
		this.employeeTaxeses = employeeTaxeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taxes")
	public Set<EmployeeIncomeTaxStats> getEmployeeIncomeTaxStatses() {
		return this.employeeIncomeTaxStatses;
	}

	public void setEmployeeIncomeTaxStatses(Set<EmployeeIncomeTaxStats> employeeIncomeTaxStatses) {
		this.employeeIncomeTaxStatses = employeeIncomeTaxStatses;
	}

}
