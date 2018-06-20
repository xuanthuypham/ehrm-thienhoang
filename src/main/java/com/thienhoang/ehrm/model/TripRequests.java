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
 * TripRequests generated by hbm2java
 */
@Entity
@Table(name = "TRIP_REQUESTS", catalog = "eHRM_JavaResearching")
public class TripRequests implements java.io.Serializable {

	private Integer tripRequestId;
	private Employees employees;
	private MasterDatas masterDatas;
	private TripRequests tripRequests;
	private TripTypes tripTypes;
	private Date startDate;
	private Date endDate;
	private double noOfWorkingDays;
	private double noOfCalendarDays;
	private Date requestDate;
	private Serializable requestContent;
	private int countApprove;
	private int locationId;
	private Integer projectId;
	private Integer isDeclareReimbuesement;
	private Date approvalDateReimbursement;
	private Integer flagColor;
	private Set<TripLocations> tripLocationses = new HashSet<TripLocations>(0);
	private Set<TripRequests> tripRequestses = new HashSet<TripRequests>(0);
	private Set<TripReimbursementAmount> tripReimbursementAmounts = new HashSet<TripReimbursementAmount>(0);
	private Set<TripRequestHistories> tripRequestHistorieses = new HashSet<TripRequestHistories>(0);

	public TripRequests() {
	}

	public TripRequests(Employees employees, MasterDatas masterDatas, TripTypes tripTypes, Date startDate, Date endDate,
			double noOfWorkingDays, double noOfCalendarDays, Date requestDate, Serializable requestContent,
			int countApprove, int locationId) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.tripTypes = tripTypes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.noOfWorkingDays = noOfWorkingDays;
		this.noOfCalendarDays = noOfCalendarDays;
		this.requestDate = requestDate;
		this.requestContent = requestContent;
		this.countApprove = countApprove;
		this.locationId = locationId;
	}

	public TripRequests(Employees employees, MasterDatas masterDatas, TripRequests tripRequests, TripTypes tripTypes,
			Date startDate, Date endDate, double noOfWorkingDays, double noOfCalendarDays, Date requestDate,
			Serializable requestContent, int countApprove, int locationId, Integer projectId,
			Integer isDeclareReimbuesement, Date approvalDateReimbursement, Integer flagColor,
			Set<TripLocations> tripLocationses, Set<TripRequests> tripRequestses,
			Set<TripReimbursementAmount> tripReimbursementAmounts, Set<TripRequestHistories> tripRequestHistorieses) {
		this.employees = employees;
		this.masterDatas = masterDatas;
		this.tripRequests = tripRequests;
		this.tripTypes = tripTypes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.noOfWorkingDays = noOfWorkingDays;
		this.noOfCalendarDays = noOfCalendarDays;
		this.requestDate = requestDate;
		this.requestContent = requestContent;
		this.countApprove = countApprove;
		this.locationId = locationId;
		this.projectId = projectId;
		this.isDeclareReimbuesement = isDeclareReimbuesement;
		this.approvalDateReimbursement = approvalDateReimbursement;
		this.flagColor = flagColor;
		this.tripLocationses = tripLocationses;
		this.tripRequestses = tripRequestses;
		this.tripReimbursementAmounts = tripReimbursementAmounts;
		this.tripRequestHistorieses = tripRequestHistorieses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TRIP_REQUEST_ID", unique = true, nullable = false)
	public Integer getTripRequestId() {
		return this.tripRequestId;
	}

	public void setTripRequestId(Integer tripRequestId) {
		this.tripRequestId = tripRequestId;
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
	@JoinColumn(name = "TRIP_REQUEST_STATUS_ID", nullable = false)
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRIP_REQUESTSREPLACEID")
	public TripRequests getTripRequests() {
		return this.tripRequests;
	}

	public void setTripRequests(TripRequests tripRequests) {
		this.tripRequests = tripRequests;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRIP_TYPE_ID", nullable = false)
	public TripTypes getTripTypes() {
		return this.tripTypes;
	}

	public void setTripTypes(TripTypes tripTypes) {
		this.tripTypes = tripTypes;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", nullable = false, length = 23)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", nullable = false, length = 23)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "NO_OF_WORKING_DAYS", nullable = false, precision = 53, scale = 0)
	public double getNoOfWorkingDays() {
		return this.noOfWorkingDays;
	}

	public void setNoOfWorkingDays(double noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}

	@Column(name = "NO_OF_CALENDAR_DAYS", nullable = false, precision = 53, scale = 0)
	public double getNoOfCalendarDays() {
		return this.noOfCalendarDays;
	}

	public void setNoOfCalendarDays(double noOfCalendarDays) {
		this.noOfCalendarDays = noOfCalendarDays;
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

	@Column(name = "LOCATION_ID", nullable = false)
	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Column(name = "PROJECT_ID")
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "IS_DECLARE_REIMBUESEMENT")
	public Integer getIsDeclareReimbuesement() {
		return this.isDeclareReimbuesement;
	}

	public void setIsDeclareReimbuesement(Integer isDeclareReimbuesement) {
		this.isDeclareReimbuesement = isDeclareReimbuesement;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APPROVAL_DATE_REIMBURSEMENT", length = 23)
	public Date getApprovalDateReimbursement() {
		return this.approvalDateReimbursement;
	}

	public void setApprovalDateReimbursement(Date approvalDateReimbursement) {
		this.approvalDateReimbursement = approvalDateReimbursement;
	}

	@Column(name = "FLAG_COLOR")
	public Integer getFlagColor() {
		return this.flagColor;
	}

	public void setFlagColor(Integer flagColor) {
		this.flagColor = flagColor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tripRequests")
	public Set<TripLocations> getTripLocationses() {
		return this.tripLocationses;
	}

	public void setTripLocationses(Set<TripLocations> tripLocationses) {
		this.tripLocationses = tripLocationses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tripRequests")
	public Set<TripRequests> getTripRequestses() {
		return this.tripRequestses;
	}

	public void setTripRequestses(Set<TripRequests> tripRequestses) {
		this.tripRequestses = tripRequestses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tripRequests")
	public Set<TripReimbursementAmount> getTripReimbursementAmounts() {
		return this.tripReimbursementAmounts;
	}

	public void setTripReimbursementAmounts(Set<TripReimbursementAmount> tripReimbursementAmounts) {
		this.tripReimbursementAmounts = tripReimbursementAmounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tripRequests")
	public Set<TripRequestHistories> getTripRequestHistorieses() {
		return this.tripRequestHistorieses;
	}

	public void setTripRequestHistorieses(Set<TripRequestHistories> tripRequestHistorieses) {
		this.tripRequestHistorieses = tripRequestHistorieses;
	}

}