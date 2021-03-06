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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TripTypes generated by hbm2java
 */
@Entity
@Table(name = "TRIP_TYPES", catalog = "eHRM_JavaResearching")
public class TripTypes implements java.io.Serializable {

	private Integer tripTypeId;
	private ApprovalLevels approvalLevels;
	private RoleApprovalLevel roleApprovalLevel;
	private Serializable typeName;
	private Integer continuous;
	private Integer compensation;
	private String approvedOrder;
	private Set<TripRequests> tripRequestses = new HashSet<TripRequests>(0);

	public TripTypes() {
	}

	public TripTypes(ApprovalLevels approvalLevels, RoleApprovalLevel roleApprovalLevel, Serializable typeName,
			Integer continuous, Integer compensation, String approvedOrder, Set<TripRequests> tripRequestses) {
		this.approvalLevels = approvalLevels;
		this.roleApprovalLevel = roleApprovalLevel;
		this.typeName = typeName;
		this.continuous = continuous;
		this.compensation = compensation;
		this.approvedOrder = approvedOrder;
		this.tripRequestses = tripRequestses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TRIP_TYPE_ID", unique = true, nullable = false)
	public Integer getTripTypeId() {
		return this.tripTypeId;
	}

	public void setTripTypeId(Integer tripTypeId) {
		this.tripTypeId = tripTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPROVAL_LEVEL_ID")
	public ApprovalLevels getApprovalLevels() {
		return this.approvalLevels;
	}

	public void setApprovalLevels(ApprovalLevels approvalLevels) {
		this.approvalLevels = approvalLevels;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_APPROVAL_LEVEL_ID")
	public RoleApprovalLevel getRoleApprovalLevel() {
		return this.roleApprovalLevel;
	}

	public void setRoleApprovalLevel(RoleApprovalLevel roleApprovalLevel) {
		this.roleApprovalLevel = roleApprovalLevel;
	}

	@Column(name = "TYPE_NAME")
	public Serializable getTypeName() {
		return this.typeName;
	}

	public void setTypeName(Serializable typeName) {
		this.typeName = typeName;
	}

	@Column(name = "CONTINUOUS")
	public Integer getContinuous() {
		return this.continuous;
	}

	public void setContinuous(Integer continuous) {
		this.continuous = continuous;
	}

	@Column(name = "COMPENSATION")
	public Integer getCompensation() {
		return this.compensation;
	}

	public void setCompensation(Integer compensation) {
		this.compensation = compensation;
	}

	@Column(name = "APPROVED_ORDER", length = 50)
	public String getApprovedOrder() {
		return this.approvedOrder;
	}

	public void setApprovedOrder(String approvedOrder) {
		this.approvedOrder = approvedOrder;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tripTypes")
	public Set<TripRequests> getTripRequestses() {
		return this.tripRequestses;
	}

	public void setTripRequestses(Set<TripRequests> tripRequestses) {
		this.tripRequestses = tripRequestses;
	}

}
