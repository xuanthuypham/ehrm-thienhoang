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
 * TaMealTimeSetting generated by hbm2java
 */
@Entity
@Table(name = "TA_MEAL_TIME_SETTING", catalog = "eHRM_JavaResearching")
public class TaMealTimeSetting implements java.io.Serializable {

	private Integer mealTimeId;
	private TaWorkingShifts taWorkingShifts;
	private Serializable mealTimeCode;
	private Serializable mealTimeName;
	private Date mealTimeStart;
	private Date mealTimeEnd;
	private Date mealTimeNextStart;
	private Date mealTimeNextEnd;
	private Serializable remark;

	public TaMealTimeSetting() {
	}

	public TaMealTimeSetting(TaWorkingShifts taWorkingShifts, Serializable mealTimeName, Date mealTimeStart,
			Date mealTimeEnd) {
		this.taWorkingShifts = taWorkingShifts;
		this.mealTimeName = mealTimeName;
		this.mealTimeStart = mealTimeStart;
		this.mealTimeEnd = mealTimeEnd;
	}

	public TaMealTimeSetting(TaWorkingShifts taWorkingShifts, Serializable mealTimeCode, Serializable mealTimeName,
			Date mealTimeStart, Date mealTimeEnd, Date mealTimeNextStart, Date mealTimeNextEnd, Serializable remark) {
		this.taWorkingShifts = taWorkingShifts;
		this.mealTimeCode = mealTimeCode;
		this.mealTimeName = mealTimeName;
		this.mealTimeStart = mealTimeStart;
		this.mealTimeEnd = mealTimeEnd;
		this.mealTimeNextStart = mealTimeNextStart;
		this.mealTimeNextEnd = mealTimeNextEnd;
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MEAL_TIME_ID", unique = true, nullable = false)
	public Integer getMealTimeId() {
		return this.mealTimeId;
	}

	public void setMealTimeId(Integer mealTimeId) {
		this.mealTimeId = mealTimeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WORKING_SHIFT_ID", nullable = false)
	public TaWorkingShifts getTaWorkingShifts() {
		return this.taWorkingShifts;
	}

	public void setTaWorkingShifts(TaWorkingShifts taWorkingShifts) {
		this.taWorkingShifts = taWorkingShifts;
	}

	@Column(name = "MEAL_TIME_CODE")
	public Serializable getMealTimeCode() {
		return this.mealTimeCode;
	}

	public void setMealTimeCode(Serializable mealTimeCode) {
		this.mealTimeCode = mealTimeCode;
	}

	@Column(name = "MEAL_TIME_NAME", nullable = false)
	public Serializable getMealTimeName() {
		return this.mealTimeName;
	}

	public void setMealTimeName(Serializable mealTimeName) {
		this.mealTimeName = mealTimeName;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "MEAL_TIME_START", nullable = false, length = 16)
	public Date getMealTimeStart() {
		return this.mealTimeStart;
	}

	public void setMealTimeStart(Date mealTimeStart) {
		this.mealTimeStart = mealTimeStart;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "MEAL_TIME_END", nullable = false, length = 16)
	public Date getMealTimeEnd() {
		return this.mealTimeEnd;
	}

	public void setMealTimeEnd(Date mealTimeEnd) {
		this.mealTimeEnd = mealTimeEnd;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "MEAL_TIME_NEXT_START", length = 16)
	public Date getMealTimeNextStart() {
		return this.mealTimeNextStart;
	}

	public void setMealTimeNextStart(Date mealTimeNextStart) {
		this.mealTimeNextStart = mealTimeNextStart;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "MEAL_TIME_NEXT_END", length = 16)
	public Date getMealTimeNextEnd() {
		return this.mealTimeNextEnd;
	}

	public void setMealTimeNextEnd(Date mealTimeNextEnd) {
		this.mealTimeNextEnd = mealTimeNextEnd;
	}

	@Column(name = "REMARK")
	public Serializable getRemark() {
		return this.remark;
	}

	public void setRemark(Serializable remark) {
		this.remark = remark;
	}

}
