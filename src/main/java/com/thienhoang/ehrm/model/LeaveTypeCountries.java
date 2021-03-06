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
 * LeaveTypeCountries generated by hbm2java
 */
@Entity
@Table(name = "LEAVE_TYPE_COUNTRIES", catalog = "eHRM_JavaResearching")
public class LeaveTypeCountries implements java.io.Serializable {

	private Integer leaveTypeCountryId;
	private LeaveTypesetting leaveTypesetting;
	private MasterDatas masterDatas;

	public LeaveTypeCountries() {
	}

	public LeaveTypeCountries(LeaveTypesetting leaveTypesetting, MasterDatas masterDatas) {
		this.leaveTypesetting = leaveTypesetting;
		this.masterDatas = masterDatas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "LEAVE_TYPE_COUNTRY_ID", unique = true, nullable = false)
	public Integer getLeaveTypeCountryId() {
		return this.leaveTypeCountryId;
	}

	public void setLeaveTypeCountryId(Integer leaveTypeCountryId) {
		this.leaveTypeCountryId = leaveTypeCountryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEAVE_TYPE_ID", nullable = false)
	public LeaveTypesetting getLeaveTypesetting() {
		return this.leaveTypesetting;
	}

	public void setLeaveTypesetting(LeaveTypesetting leaveTypesetting) {
		this.leaveTypesetting = leaveTypesetting;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

}
