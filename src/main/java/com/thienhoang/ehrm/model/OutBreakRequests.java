package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OutBreakRequests generated by hbm2java
 */
@Entity
@Table(name = "OUT_BREAK_REQUESTS", catalog = "eHRM_JavaResearching")
public class OutBreakRequests implements java.io.Serializable {

	private Integer outBreakRequestId;
	private Employees employees;
	private MasterDatas masterDatas;
	private OutBreakTypes outBreakTypes;
	private Date requestDate;
	private Serializable requestContent;
	private int countApprove;
	private Double requestValue;
	private Set<OutBreakOvertime> outBreakOvertimes = new HashSet<OutBreakOvertime>(0);
	private Set<OutBreakRequestHistories> outBreakRequestHistorieses = new HashSet<OutBreakRequestHistories>(0);

	public OutBreakRequests() {
	}

	public OutBreakRequests(Date requestDate, Serializable requestContent, int countApprove) {
		this.requestDate = requestDate;
		this.requestContent = requestContent;
		this.countApprove = countApprove;
	}

	public OutBreakRequests(Employees employees, MasterDatas masterDatas, OutBreakTypes outBreakTypes, Date requestDate,
			Serializable requestContent, int countApprove, Double requestValue, Set<OutBreakOvertime> outBreakOvertimes,
			Set<OutBreakRequestHistories> outBreakRequestHistorieses) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.outBreakTypes = outBreakTypes;
		this.requestDate = requestDate;
		this.requestContent = requestContent;
		this.countApprove = countApprove;
		this.requestValue = requestValue;
		this.outBreakOvertimes = outBreakOvertimes;
		this.outBreakRequestHistorieses = outBreakRequestHistorieses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OUT_BREAK_REQUEST_ID", unique = true, nullable = false)
	public Integer getOutBreakRequestId() {
		return this.outBreakRequestId;
	}

	public void setOutBreakRequestId(Integer outBreakRequestId) {
		this.outBreakRequestId = outBreakRequestId;
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
	@JoinColumn(name = "OUT_BREAK_REQUEST_STATUS_ID")
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OUT_BREAK_TYPE_ID")
	public OutBreakTypes getOutBreakTypes() {
		return this.outBreakTypes;
	}

	public void setOutBreakTypes(OutBreakTypes outBreakTypes) {
		this.outBreakTypes = outBreakTypes;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REQUEST_DATE", nullable = false, length = 10)
	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Column(name = "REQUEST_CONTENT", nullable = false)
	public Serializable getRequestContent() {
		return this.requestContent;
	}

	public void setRequestContent(Serializable requestContent) {
		this.requestContent = requestContent;
	}

	@Column(name = "COUNT_APPROVE", nullable = false)
	public int getCountApprove() {
		return this.countApprove;
	}

	public void setCountApprove(int countApprove) {
		this.countApprove = countApprove;
	}

	@Column(name = "REQUEST_VALUE", precision = 53, scale = 0)
	public Double getRequestValue() {
		return this.requestValue;
	}

	public void setRequestValue(Double requestValue) {
		this.requestValue = requestValue;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outBreakRequests")
	public Set<OutBreakOvertime> getOutBreakOvertimes() {
		return this.outBreakOvertimes;
	}

	public void setOutBreakOvertimes(Set<OutBreakOvertime> outBreakOvertimes) {
		this.outBreakOvertimes = outBreakOvertimes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outBreakRequests")
	public Set<OutBreakRequestHistories> getOutBreakRequestHistorieses() {
		return this.outBreakRequestHistorieses;
	}

	public void setOutBreakRequestHistorieses(Set<OutBreakRequestHistories> outBreakRequestHistorieses) {
		this.outBreakRequestHistorieses = outBreakRequestHistorieses;
	}

}
