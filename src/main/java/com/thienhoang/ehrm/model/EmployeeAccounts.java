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
 * EmployeeAccounts generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE_ACCOUNTS", catalog = "eHRM_JavaResearching")
public class EmployeeAccounts implements java.io.Serializable {

	private Integer employeeAccountId;
	private Employees employees;
	private MasterDatas masterDatas;
	private String accountNumber;
	private String accountHolderName;
	private String benifiter;
	private boolean active;
	private String bankAddress;

	public EmployeeAccounts() {
	}

	public EmployeeAccounts(Employees employees, MasterDatas masterDatas, String accountNumber,
			String accountHolderName, boolean active) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.active = active;
	}

	public EmployeeAccounts(Employees employees, MasterDatas masterDatas, String accountNumber,
			String accountHolderName, String benifiter, boolean active, String bankAddress) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.benifiter = benifiter;
		this.active = active;
		this.bankAddress = bankAddress;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EMPLOYEE_ACCOUNT_ID", unique = true, nullable = false)
	public Integer getEmployeeAccountId() {
		return this.employeeAccountId;
	}

	public void setEmployeeAccountId(Integer employeeAccountId) {
		this.employeeAccountId = employeeAccountId;
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
	@JoinColumn(name = "BANK_ID", nullable = false)
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

	@Column(name = "ACCOUNT_NUMBER", nullable = false)
	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name = "ACCOUNT_HOLDER_NAME", nullable = false)
	public String getAccountHolderName() {
		return this.accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	@Column(name = "BENIFITER")
	public String getBenifiter() {
		return this.benifiter;
	}

	public void setBenifiter(String benifiter) {
		this.benifiter = benifiter;
	}

	@Column(name = "ACTIVE", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "BANK_ADDRESS")
	public String getBankAddress() {
		return this.bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

}
