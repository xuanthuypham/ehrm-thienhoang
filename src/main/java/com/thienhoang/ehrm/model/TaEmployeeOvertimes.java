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
 * TaEmployeeOvertimes generated by hbm2java
 */
@Entity
@Table(name = "TA_EMPLOYEE_OVERTIMES", catalog = "eHRM_JavaResearching")
public class TaEmployeeOvertimes implements java.io.Serializable {

	private Integer employeeOvertimeId;
	private MasterDatas masterDatas;
	private TaEmployeeTimesheets taEmployeeTimesheets;
	private TaOvertimeSetting taOvertimeSetting;
	private Double scheduledHours;
	private Double actualHours;
	private Double approvedHours;
	private Boolean approved;
	private Serializable remark;
	private Double actualMinutes;

	public TaEmployeeOvertimes() {
	}

	public TaEmployeeOvertimes(MasterDatas masterDatas, TaEmployeeTimesheets taEmployeeTimesheets) {
		this.masterDatas = masterDatas;
		this.taEmployeeTimesheets = taEmployeeTimesheets;
	}

	public TaEmployeeOvertimes(MasterDatas masterDatas, TaEmployeeTimesheets taEmployeeTimesheets,
			TaOvertimeSetting taOvertimeSetting, Double scheduledHours, Double actualHours, Double approvedHours,
			Boolean approved, Serializable remark, Double actualMinutes) {
		this.masterDatas = masterDatas;
		this.taEmployeeTimesheets = taEmployeeTimesheets;
		this.taOvertimeSetting = taOvertimeSetting;
		this.scheduledHours = scheduledHours;
		this.actualHours = actualHours;
		this.approvedHours = approvedHours;
		this.approved = approved;
		this.remark = remark;
		this.actualMinutes = actualMinutes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EMPLOYEE_OVERTIME_ID", unique = true, nullable = false)
	public Integer getEmployeeOvertimeId() {
		return this.employeeOvertimeId;
	}

	public void setEmployeeOvertimeId(Integer employeeOvertimeId) {
		this.employeeOvertimeId = employeeOvertimeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_OVERTIME_STATUS_ID", nullable = false)
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_TIMESHEET_ID", nullable = false)
	public TaEmployeeTimesheets getTaEmployeeTimesheets() {
		return this.taEmployeeTimesheets;
	}

	public void setTaEmployeeTimesheets(TaEmployeeTimesheets taEmployeeTimesheets) {
		this.taEmployeeTimesheets = taEmployeeTimesheets;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OT_INCOME_ID")
	public TaOvertimeSetting getTaOvertimeSetting() {
		return this.taOvertimeSetting;
	}

	public void setTaOvertimeSetting(TaOvertimeSetting taOvertimeSetting) {
		this.taOvertimeSetting = taOvertimeSetting;
	}

	@Column(name = "SCHEDULED_HOURS", precision = 53, scale = 0)
	public Double getScheduledHours() {
		return this.scheduledHours;
	}

	public void setScheduledHours(Double scheduledHours) {
		this.scheduledHours = scheduledHours;
	}

	@Column(name = "ACTUAL_HOURS", precision = 53, scale = 0)
	public Double getActualHours() {
		return this.actualHours;
	}

	public void setActualHours(Double actualHours) {
		this.actualHours = actualHours;
	}

	@Column(name = "APPROVED_HOURS", precision = 53, scale = 0)
	public Double getApprovedHours() {
		return this.approvedHours;
	}

	public void setApprovedHours(Double approvedHours) {
		this.approvedHours = approvedHours;
	}

	@Column(name = "APPROVED")
	public Boolean getApproved() {
		return this.approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	@Column(name = "REMARK")
	public Serializable getRemark() {
		return this.remark;
	}

	public void setRemark(Serializable remark) {
		this.remark = remark;
	}

	@Column(name = "ACTUAL_MINUTES", precision = 53, scale = 0)
	public Double getActualMinutes() {
		return this.actualMinutes;
	}

	public void setActualMinutes(Double actualMinutes) {
		this.actualMinutes = actualMinutes;
	}

}
