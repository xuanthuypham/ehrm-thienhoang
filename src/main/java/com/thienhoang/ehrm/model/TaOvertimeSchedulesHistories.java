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
 * TaOvertimeSchedulesHistories generated by hbm2java
 */
@Entity
@Table(name = "TA_OVERTIME_SCHEDULES_HISTORIES", catalog = "eHRM_JavaResearching")
public class TaOvertimeSchedulesHistories implements java.io.Serializable {

	private Integer overtimeScheduleHistoryId;
	private Employees employees;
	private MasterDatas masterDatas;
	private TaOvertimeSchedules taOvertimeSchedules;
	private Date modifiedDate;
	private Serializable comment;

	public TaOvertimeSchedulesHistories() {
	}

	public TaOvertimeSchedulesHistories(Employees employees, MasterDatas masterDatas,
			TaOvertimeSchedules taOvertimeSchedules, Date modifiedDate) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.taOvertimeSchedules = taOvertimeSchedules;
		this.modifiedDate = modifiedDate;
	}

	public TaOvertimeSchedulesHistories(Employees employees, MasterDatas masterDatas,
			TaOvertimeSchedules taOvertimeSchedules, Date modifiedDate, Serializable comment) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.taOvertimeSchedules = taOvertimeSchedules;
		this.modifiedDate = modifiedDate;
		this.comment = comment;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OVERTIME_SCHEDULE_HISTORY_ID", unique = true, nullable = false)
	public Integer getOvertimeScheduleHistoryId() {
		return this.overtimeScheduleHistoryId;
	}

	public void setOvertimeScheduleHistoryId(Integer overtimeScheduleHistoryId) {
		this.overtimeScheduleHistoryId = overtimeScheduleHistoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPROVER_ID", nullable = false)
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TA_OVERTIME_SCHEDULES_STATUS_ID", nullable = false)
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OVERTIME_SCHEDULE_ID", nullable = false)
	public TaOvertimeSchedules getTaOvertimeSchedules() {
		return this.taOvertimeSchedules;
	}

	public void setTaOvertimeSchedules(TaOvertimeSchedules taOvertimeSchedules) {
		this.taOvertimeSchedules = taOvertimeSchedules;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_DATE", nullable = false, length = 10)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "COMMENT")
	public Serializable getComment() {
		return this.comment;
	}

	public void setComment(Serializable comment) {
		this.comment = comment;
	}

}
