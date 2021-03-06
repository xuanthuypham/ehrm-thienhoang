package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
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
 * EmployeeDisciplines generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE_DISCIPLINES", catalog = "eHRM_JavaResearching")
public class EmployeeDisciplines implements java.io.Serializable {

	private Integer employeeDisciplineId;
	private Employees employees;
	private FinancialYears financialYears;
	private Date dateViolate;
	private Serializable disciplinaryForm;
	private Serializable sanction;
	private Serializable remark;

	public EmployeeDisciplines() {
	}

	public EmployeeDisciplines(Employees employees, FinancialYears financialYears, Date dateViolate) {
		this.employees = employees;
		this.financialYears = financialYears;
		this.dateViolate = dateViolate;
	}

	public EmployeeDisciplines(Employees employees, FinancialYears financialYears, Date dateViolate,
			Serializable disciplinaryForm, Serializable sanction, Serializable remark) {
		this.employees = employees;
		this.financialYears = financialYears;
		this.dateViolate = dateViolate;
		this.disciplinaryForm = disciplinaryForm;
		this.sanction = sanction;
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EMPLOYEE_DISCIPLINE_ID", unique = true, nullable = false)
	public Integer getEmployeeDisciplineId() {
		return this.employeeDisciplineId;
	}

	public void setEmployeeDisciplineId(Integer employeeDisciplineId) {
		this.employeeDisciplineId = employeeDisciplineId;
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
	@JoinColumn(name = "FINANCIAL_YEAR_ID", nullable = false)
	public FinancialYears getFinancialYears() {
		return this.financialYears;
	}

	public void setFinancialYears(FinancialYears financialYears) {
		this.financialYears = financialYears;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_VIOLATE", nullable = false, length = 10)
	public Date getDateViolate() {
		return this.dateViolate;
	}

	public void setDateViolate(Date dateViolate) {
		this.dateViolate = dateViolate;
	}

	@Column(name = "DISCIPLINARY_FORM")
	public Serializable getDisciplinaryForm() {
		return this.disciplinaryForm;
	}

	public void setDisciplinaryForm(Serializable disciplinaryForm) {
		this.disciplinaryForm = disciplinaryForm;
	}

	@Column(name = "SANCTION")
	public Serializable getSanction() {
		return this.sanction;
	}

	public void setSanction(Serializable sanction) {
		this.sanction = sanction;
	}

	@Column(name = "REMARK")
	public Serializable getRemark() {
		return this.remark;
	}

	public void setRemark(Serializable remark) {
		this.remark = remark;
	}

}
