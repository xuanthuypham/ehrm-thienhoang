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
 * PerformanceAssessmentHistories generated by hbm2java
 */
@Entity
@Table(name = "PERFORMANCE_ASSESSMENT_HISTORIES", catalog = "eHRM_JavaResearching")
public class PerformanceAssessmentHistories implements java.io.Serializable {

	private Integer performanceAssessmentHistoryId;
	private AssessmentCriterias assessmentCriterias;
	private PerformanceAssessments performanceAssessments;
	private Integer staffScore;
	private Serializable staffExplanations;
	private Integer supervisorScore;
	private Serializable supervisorExplanations;
	private Integer dhScore;
	private Serializable dhComments;

	public PerformanceAssessmentHistories() {
	}

	public PerformanceAssessmentHistories(AssessmentCriterias assessmentCriterias,
			PerformanceAssessments performanceAssessments) {
		this.assessmentCriterias = assessmentCriterias;
		this.performanceAssessments = performanceAssessments;
	}

	public PerformanceAssessmentHistories(AssessmentCriterias assessmentCriterias,
			PerformanceAssessments performanceAssessments, Integer staffScore, Serializable staffExplanations,
			Integer supervisorScore, Serializable supervisorExplanations, Integer dhScore, Serializable dhComments) {
		this.assessmentCriterias = assessmentCriterias;
		this.performanceAssessments = performanceAssessments;
		this.staffScore = staffScore;
		this.staffExplanations = staffExplanations;
		this.supervisorScore = supervisorScore;
		this.supervisorExplanations = supervisorExplanations;
		this.dhScore = dhScore;
		this.dhComments = dhComments;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PERFORMANCE_ASSESSMENT_HISTORY_ID", unique = true, nullable = false)
	public Integer getPerformanceAssessmentHistoryId() {
		return this.performanceAssessmentHistoryId;
	}

	public void setPerformanceAssessmentHistoryId(Integer performanceAssessmentHistoryId) {
		this.performanceAssessmentHistoryId = performanceAssessmentHistoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSESSMENT_CRITERIA_ID", nullable = false)
	public AssessmentCriterias getAssessmentCriterias() {
		return this.assessmentCriterias;
	}

	public void setAssessmentCriterias(AssessmentCriterias assessmentCriterias) {
		this.assessmentCriterias = assessmentCriterias;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERFORMANCE_ASSESSMENT_ID", nullable = false)
	public PerformanceAssessments getPerformanceAssessments() {
		return this.performanceAssessments;
	}

	public void setPerformanceAssessments(PerformanceAssessments performanceAssessments) {
		this.performanceAssessments = performanceAssessments;
	}

	@Column(name = "STAFF_SCORE")
	public Integer getStaffScore() {
		return this.staffScore;
	}

	public void setStaffScore(Integer staffScore) {
		this.staffScore = staffScore;
	}

	@Column(name = "STAFF_EXPLANATIONS")
	public Serializable getStaffExplanations() {
		return this.staffExplanations;
	}

	public void setStaffExplanations(Serializable staffExplanations) {
		this.staffExplanations = staffExplanations;
	}

	@Column(name = "SUPERVISOR_SCORE")
	public Integer getSupervisorScore() {
		return this.supervisorScore;
	}

	public void setSupervisorScore(Integer supervisorScore) {
		this.supervisorScore = supervisorScore;
	}

	@Column(name = "SUPERVISOR_EXPLANATIONS")
	public Serializable getSupervisorExplanations() {
		return this.supervisorExplanations;
	}

	public void setSupervisorExplanations(Serializable supervisorExplanations) {
		this.supervisorExplanations = supervisorExplanations;
	}

	@Column(name = "DH_SCORE")
	public Integer getDhScore() {
		return this.dhScore;
	}

	public void setDhScore(Integer dhScore) {
		this.dhScore = dhScore;
	}

	@Column(name = "DH_COMMENTS")
	public Serializable getDhComments() {
		return this.dhComments;
	}

	public void setDhComments(Serializable dhComments) {
		this.dhComments = dhComments;
	}

}
