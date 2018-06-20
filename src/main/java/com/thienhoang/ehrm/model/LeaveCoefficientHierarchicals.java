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
 * LeaveCoefficientHierarchicals generated by hbm2java
 */
@Entity
@Table(name = "LEAVE_COEFFICIENT_HIERARCHICALS", catalog = "eHRM_JavaResearching")
public class LeaveCoefficientHierarchicals implements java.io.Serializable {

	private Integer leaveCoefficientHierarchicalId;
	private Hierarchicals hierarchicals;
	private LeaveCoefficients leaveCoefficients;

	public LeaveCoefficientHierarchicals() {
	}

	public LeaveCoefficientHierarchicals(Hierarchicals hierarchicals, LeaveCoefficients leaveCoefficients) {
		this.hierarchicals = hierarchicals;
		this.leaveCoefficients = leaveCoefficients;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "LEAVE_COEFFICIENT_HIERARCHICAL_ID", unique = true, nullable = false)
	public Integer getLeaveCoefficientHierarchicalId() {
		return this.leaveCoefficientHierarchicalId;
	}

	public void setLeaveCoefficientHierarchicalId(Integer leaveCoefficientHierarchicalId) {
		this.leaveCoefficientHierarchicalId = leaveCoefficientHierarchicalId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HIERARCHICAL_ID", nullable = false)
	public Hierarchicals getHierarchicals() {
		return this.hierarchicals;
	}

	public void setHierarchicals(Hierarchicals hierarchicals) {
		this.hierarchicals = hierarchicals;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEAVE_COEFFICIENT_ID", nullable = false)
	public LeaveCoefficients getLeaveCoefficients() {
		return this.leaveCoefficients;
	}

	public void setLeaveCoefficients(LeaveCoefficients leaveCoefficients) {
		this.leaveCoefficients = leaveCoefficients;
	}

}