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
 * ApprovalRoles generated by hbm2java
 */
@Entity
@Table(name = "APPROVAL_ROLES", catalog = "eHRM_JavaResearching")
public class ApprovalRoles implements java.io.Serializable {

	private Integer approvalId;
	private ApprovalLevels approvalLevels;
	private MasterDatas masterDatas;
	private Integer orderIndex;
	private Integer subOrder;

	public ApprovalRoles() {
	}

	public ApprovalRoles(ApprovalLevels approvalLevels, MasterDatas masterDatas, Integer orderIndex, Integer subOrder) {
		this.approvalLevels = approvalLevels;
		this.masterDatas = masterDatas;
		this.orderIndex = orderIndex;
		this.subOrder = subOrder;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "APPROVAL_ID", unique = true, nullable = false)
	public Integer getApprovalId() {
		return this.approvalId;
	}

	public void setApprovalId(Integer approvalId) {
		this.approvalId = approvalId;
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
	@JoinColumn(name = "ROLE_ID")
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

	@Column(name = "ORDER_INDEX")
	public Integer getOrderIndex() {
		return this.orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	@Column(name = "SUB_ORDER")
	public Integer getSubOrder() {
		return this.subOrder;
	}

	public void setSubOrder(Integer subOrder) {
		this.subOrder = subOrder;
	}

}
