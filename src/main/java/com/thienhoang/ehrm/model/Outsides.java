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
 * Outsides generated by hbm2java
 */
@Entity
@Table(name = "OUTSIDES", catalog = "eHRM_JavaResearching")
public class Outsides implements java.io.Serializable {

	private Integer outsideId;
	private Employees employees;
	private Date fromDate;
	private Date toDate;
	private Date createdDate;
	private Boolean status;

	public Outsides() {
	}

	public Outsides(Employees employees) {
		this.employees = employees;
	}

	public Outsides(Employees employees, Date fromDate, Date toDate, Date createdDate, Boolean status) {
		this.employees = employees;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.createdDate = createdDate;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OUTSIDE_ID", unique = true, nullable = false)
	public Integer getOutsideId() {
		return this.outsideId;
	}

	public void setOutsideId(Integer outsideId) {
		this.outsideId = outsideId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID", nullable = false)
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FROM_DATE", length = 23)
	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TO_DATE", length = 23)
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 23)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "STATUS")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}