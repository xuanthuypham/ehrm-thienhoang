package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TaTimekeepers generated by hbm2java
 */
@Entity
@Table(name = "TA_TIMEKEEPERS", catalog = "eHRM_JavaResearching")
public class TaTimekeepers implements java.io.Serializable {

	private Integer timekeeperId;
	private Serializable timekeeperCode;
	private Serializable timekeeperName;
	private Boolean inOut;
	private Serializable connectivityType;
	private Serializable model;
	private Serializable ip;
	private Serializable ipPort;
	private Serializable remark;
	private Set<TaEmployeeTimesheets> taEmployeeTimesheetsesForTimekeeperInId = new HashSet<TaEmployeeTimesheets>(0);
	private Set<TaEmployeeTimesheets> taEmployeeTimesheetsesForTimekeeperOutId = new HashSet<TaEmployeeTimesheets>(0);

	public TaTimekeepers() {
	}

	public TaTimekeepers(Serializable timekeeperName) {
		this.timekeeperName = timekeeperName;
	}

	public TaTimekeepers(Serializable timekeeperCode, Serializable timekeeperName, Boolean inOut,
			Serializable connectivityType, Serializable model, Serializable ip, Serializable ipPort,
			Serializable remark, Set<TaEmployeeTimesheets> taEmployeeTimesheetsesForTimekeeperInId,
			Set<TaEmployeeTimesheets> taEmployeeTimesheetsesForTimekeeperOutId) {
		this.timekeeperCode = timekeeperCode;
		this.timekeeperName = timekeeperName;
		this.inOut = inOut;
		this.connectivityType = connectivityType;
		this.model = model;
		this.ip = ip;
		this.ipPort = ipPort;
		this.remark = remark;
		this.taEmployeeTimesheetsesForTimekeeperInId = taEmployeeTimesheetsesForTimekeeperInId;
		this.taEmployeeTimesheetsesForTimekeeperOutId = taEmployeeTimesheetsesForTimekeeperOutId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TIMEKEEPER_ID", unique = true, nullable = false)
	public Integer getTimekeeperId() {
		return this.timekeeperId;
	}

	public void setTimekeeperId(Integer timekeeperId) {
		this.timekeeperId = timekeeperId;
	}

	@Column(name = "TIMEKEEPER_CODE")
	public Serializable getTimekeeperCode() {
		return this.timekeeperCode;
	}

	public void setTimekeeperCode(Serializable timekeeperCode) {
		this.timekeeperCode = timekeeperCode;
	}

	@Column(name = "TIMEKEEPER_NAME", nullable = false)
	public Serializable getTimekeeperName() {
		return this.timekeeperName;
	}

	public void setTimekeeperName(Serializable timekeeperName) {
		this.timekeeperName = timekeeperName;
	}

	@Column(name = "IN_OUT")
	public Boolean getInOut() {
		return this.inOut;
	}

	public void setInOut(Boolean inOut) {
		this.inOut = inOut;
	}

	@Column(name = "CONNECTIVITY_TYPE")
	public Serializable getConnectivityType() {
		return this.connectivityType;
	}

	public void setConnectivityType(Serializable connectivityType) {
		this.connectivityType = connectivityType;
	}

	@Column(name = "MODEL")
	public Serializable getModel() {
		return this.model;
	}

	public void setModel(Serializable model) {
		this.model = model;
	}

	@Column(name = "IP")
	public Serializable getIp() {
		return this.ip;
	}

	public void setIp(Serializable ip) {
		this.ip = ip;
	}

	@Column(name = "IP_PORT")
	public Serializable getIpPort() {
		return this.ipPort;
	}

	public void setIpPort(Serializable ipPort) {
		this.ipPort = ipPort;
	}

	@Column(name = "REMARK")
	public Serializable getRemark() {
		return this.remark;
	}

	public void setRemark(Serializable remark) {
		this.remark = remark;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taTimekeepersByTimekeeperInId")
	public Set<TaEmployeeTimesheets> getTaEmployeeTimesheetsesForTimekeeperInId() {
		return this.taEmployeeTimesheetsesForTimekeeperInId;
	}

	public void setTaEmployeeTimesheetsesForTimekeeperInId(
			Set<TaEmployeeTimesheets> taEmployeeTimesheetsesForTimekeeperInId) {
		this.taEmployeeTimesheetsesForTimekeeperInId = taEmployeeTimesheetsesForTimekeeperInId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taTimekeepersByTimekeeperOutId")
	public Set<TaEmployeeTimesheets> getTaEmployeeTimesheetsesForTimekeeperOutId() {
		return this.taEmployeeTimesheetsesForTimekeeperOutId;
	}

	public void setTaEmployeeTimesheetsesForTimekeeperOutId(
			Set<TaEmployeeTimesheets> taEmployeeTimesheetsesForTimekeeperOutId) {
		this.taEmployeeTimesheetsesForTimekeeperOutId = taEmployeeTimesheetsesForTimekeeperOutId;
	}

}
