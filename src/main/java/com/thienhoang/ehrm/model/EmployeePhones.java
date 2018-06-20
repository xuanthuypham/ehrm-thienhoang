package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EmployeePhones generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE_PHONES", catalog = "eHRM_JavaResearching")
public class EmployeePhones implements java.io.Serializable {

	private Integer employeePhoneId;
	private Employees employees;
	private MasterDatas masterDatas;
	private String phoneNumber;
	private boolean active;

	public EmployeePhones() {
	}

	public EmployeePhones(Employees employees, MasterDatas masterDatas, String phoneNumber, boolean active) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.phoneNumber = phoneNumber;
		this.active = active;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EMPLOYEE_PHONE_ID", unique = true, nullable = false)
	public Integer getEmployeePhoneId() {
		return this.employeePhoneId;
	}

	public void setEmployeePhoneId(Integer employeePhoneId) {
		this.employeePhoneId = employeePhoneId;
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
	@JoinColumn(name = "PHONE_TYPE_ID", nullable = false)
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

	@Column(name = "PHONE_NUMBER", nullable = false)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "ACTIVE", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}