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
 * OutBreakTypes generated by hbm2java
 */
@Entity
@Table(name = "OUT_BREAK_TYPES", catalog = "eHRM_JavaResearching")
public class OutBreakTypes implements java.io.Serializable {

	private Integer outBreakTypeId;
	private RoleApprovalLevel roleApprovalLevel;
	private Serializable typeName;
	private String approvedOrder;
	private Set<OutBreakRequests> outBreakRequestses = new HashSet<OutBreakRequests>(0);

	public OutBreakTypes() {
	}

	public OutBreakTypes(RoleApprovalLevel roleApprovalLevel, Serializable typeName, String approvedOrder,
			Set<OutBreakRequests> outBreakRequestses) {
		this.roleApprovalLevel = roleApprovalLevel;
		this.typeName = typeName;
		this.approvedOrder = approvedOrder;
		this.outBreakRequestses = outBreakRequestses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OUT_BREAK_TYPE_ID", unique = true, nullable = false)
	public Integer getOutBreakTypeId() {
		return this.outBreakTypeId;
	}

	public void setOutBreakTypeId(Integer outBreakTypeId) {
		this.outBreakTypeId = outBreakTypeId;
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

	@Column(name = "APPROVED_ORDER", length = 50)
	public String getApprovedOrder() {
		return this.approvedOrder;
	}

	public void setApprovedOrder(String approvedOrder) {
		this.approvedOrder = approvedOrder;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outBreakTypes")
	public Set<OutBreakRequests> getOutBreakRequestses() {
		return this.outBreakRequestses;
	}

	public void setOutBreakRequestses(Set<OutBreakRequests> outBreakRequestses) {
		this.outBreakRequestses = outBreakRequestses;
	}

}
