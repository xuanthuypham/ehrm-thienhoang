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
 * TaWorkingSchedules generated by hbm2java
 */
@Entity
@Table(name = "TA_WORKING_SCHEDULES", catalog = "eHRM_JavaResearching")
public class TaWorkingSchedules implements java.io.Serializable {

	private Integer workingScheduleId;
	private Employees employees;
	private TaWorkingShifts taWorkingShifts;
	private Date workingScheduleDate;
	private Boolean locked;
	private Serializable remark;

	public TaWorkingSchedules() {
	}

	public TaWorkingSchedules(Employees employees, Date workingScheduleDate) {
		this.employees = employees;
		this.workingScheduleDate = workingScheduleDate;
	}

	public TaWorkingSchedules(Employees employees, TaWorkingShifts taWorkingShifts, Date workingScheduleDate,
			Boolean locked, Serializable remark) {
		this.employees = employees;
		this.taWorkingShifts = taWorkingShifts;
		this.workingScheduleDate = workingScheduleDate;
		this.locked = locked;
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "WORKING_SCHEDULE_ID", unique = true, nullable = false)
	public Integer getWorkingScheduleId() {
		return this.workingScheduleId;
	}

	public void setWorkingScheduleId(Integer workingScheduleId) {
		this.workingScheduleId = workingScheduleId;
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
	@JoinColumn(name = "WORKING_SHIFT_ID")
	public TaWorkingShifts getTaWorkingShifts() {
		return this.taWorkingShifts;
	}

	public void setTaWorkingShifts(TaWorkingShifts taWorkingShifts) {
		this.taWorkingShifts = taWorkingShifts;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "WORKING_SCHEDULE_DATE", nullable = false, length = 10)
	public Date getWorkingScheduleDate() {
		return this.workingScheduleDate;
	}

	public void setWorkingScheduleDate(Date workingScheduleDate) {
		this.workingScheduleDate = workingScheduleDate;
	}

	@Column(name = "LOCKED")
	public Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	@Column(name = "REMARK")
	public Serializable getRemark() {
		return this.remark;
	}

	public void setRemark(Serializable remark) {
		this.remark = remark;
	}

}
