package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

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
 * RoleDepartments generated by hbm2java
 */
@Entity
@Table(name = "ROLE_DEPARTMENTS", catalog = "eHRM_JavaResearching")
public class RoleDepartments implements java.io.Serializable {

	private Integer roleDepartmentId;
	private Employees employees;
	private MasterDatas masterDatas;
	private Units units;

	public RoleDepartments() {
	}

	public RoleDepartments(Employees employees, MasterDatas masterDatas, Units units) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.units = units;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ROLE_DEPARTMENT_ID", unique = true, nullable = false)
	public Integer getRoleDepartmentId() {
		return this.roleDepartmentId;
	}

	public void setRoleDepartmentId(Integer roleDepartmentId) {
		this.roleDepartmentId = roleDepartmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID")
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_ID")
	public Units getUnits() {
		return this.units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

}
