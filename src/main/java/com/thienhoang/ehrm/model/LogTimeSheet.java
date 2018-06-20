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
 * LogTimeSheet generated by hbm2java
 */
@Entity
@Table(name = "LOG_TIME_SHEET", catalog = "eHRM_JavaResearching")
public class LogTimeSheet implements java.io.Serializable {

	private Integer timeSheetLogId;
	private Employees employees;
	private TimeSheets timeSheets;
	private Date createDate;
	private Date timeSheetDate;
	private Date timeIn;
	private Date timeOut;
	private Long otHour;
	private Long lunchHour;

	public LogTimeSheet() {
	}

	public LogTimeSheet(Employees employees, TimeSheets timeSheets, Date createDate, Date timeSheetDate, Date timeIn,
			Date timeOut, Long otHour, Long lunchHour) {
		this.employees = employees;
		this.timeSheets = timeSheets;
		this.createDate = createDate;
		this.timeSheetDate = timeSheetDate;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.otHour = otHour;
		this.lunchHour = lunchHour;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TIME_SHEET_LOG_ID", unique = true, nullable = false)
	public Integer getTimeSheetLogId() {
		return this.timeSheetLogId;
	}

	public void setTimeSheetLogId(Integer timeSheetLogId) {
		this.timeSheetLogId = timeSheetLogId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATE_BY")
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIME_SHEET_ID")
	public TimeSheets getTimeSheets() {
		return this.timeSheets;
	}

	public void setTimeSheets(TimeSheets timeSheets) {
		this.timeSheets = timeSheets;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 23)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME_SHEET_DATE", length = 23)
	public Date getTimeSheetDate() {
		return this.timeSheetDate;
	}

	public void setTimeSheetDate(Date timeSheetDate) {
		this.timeSheetDate = timeSheetDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME_IN", length = 23)
	public Date getTimeIn() {
		return this.timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME_OUT", length = 23)
	public Date getTimeOut() {
		return this.timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	@Column(name = "OT_HOUR", precision = 18, scale = 0)
	public Long getOtHour() {
		return this.otHour;
	}

	public void setOtHour(Long otHour) {
		this.otHour = otHour;
	}

	@Column(name = "LUNCH_HOUR", precision = 18, scale = 0)
	public Long getLunchHour() {
		return this.lunchHour;
	}

	public void setLunchHour(Long lunchHour) {
		this.lunchHour = lunchHour;
	}

}
