package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

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
 * EmployeeRanks generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE_RANKS", catalog = "eHRM_JavaResearching")
public class EmployeeRanks implements java.io.Serializable {

	private Integer employeeRankId;
	private Employees employees;
	private MasterDatas masterDatas;
	private Date startDate;
	private Date endDate;

	public EmployeeRanks() {
	}

	public EmployeeRanks(Employees employees, MasterDatas masterDatas, Date startDate) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.startDate = startDate;
	}

	public EmployeeRanks(Employees employees, MasterDatas masterDatas, Date startDate, Date endDate) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EMPLOYEE_RANK_ID", unique = true, nullable = false)
	public Integer getEmployeeRankId() {
		return this.employeeRankId;
	}

	public void setEmployeeRankId(Integer employeeRankId) {
		this.employeeRankId = employeeRankId;
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
	@JoinColumn(name = "MASTER_DATA_ID", nullable = false)
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
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