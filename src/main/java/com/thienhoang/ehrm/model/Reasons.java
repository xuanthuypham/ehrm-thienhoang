package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reasons generated by hbm2java
 */
@Entity
@Table(name = "REASONS", catalog = "eHRM_JavaResearching")
public class Reasons implements java.io.Serializable {

	private Integer reasonId;
	private String reasonName;
	private String reasonCode;
	private Date createDate;

	public Reasons() {
	}

	public Reasons(String reasonName, String reasonCode, Date createDate) {
		this.reasonName = reasonName;
		this.reasonCode = reasonCode;
		this.createDate = createDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "REASON_ID", unique = true, nullable = false)
	public Integer getReasonId() {
		return this.reasonId;
	}

	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}

	@Column(name = "REASON_NAME")
	public String getReasonName() {
		return this.reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

	@Column(name = "REASON_CODE")
	public String getReasonCode() {
		return this.reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 23)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
