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
 * MasterDataLanguages generated by hbm2java
 */
@Entity
@Table(name = "MASTER_DATA_LANGUAGES", catalog = "eHRM_JavaResearching")
public class MasterDataLanguages implements java.io.Serializable {

	private Integer masterDataLanguageId;
	private MasterDatas masterDatas;
	private String languageCode;
	private Serializable masterDataName;
	private Serializable masterDataDescription;

	public MasterDataLanguages() {
	}

	public MasterDataLanguages(MasterDatas masterDatas, String languageCode, Serializable masterDataName) {
		this.masterDatas = masterDatas;
		this.languageCode = languageCode;
		this.masterDataName = masterDataName;
	}

	public MasterDataLanguages(MasterDatas masterDatas, String languageCode, Serializable masterDataName,
			Serializable masterDataDescription) {
		this.masterDatas = masterDatas;
		this.languageCode = languageCode;
		this.masterDataName = masterDataName;
		this.masterDataDescription = masterDataDescription;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MASTER_DATA_LANGUAGE_ID", unique = true, nullable = false)
	public Integer getMasterDataLanguageId() {
		return this.masterDataLanguageId;
	}

	public void setMasterDataLanguageId(Integer masterDataLanguageId) {
		this.masterDataLanguageId = masterDataLanguageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MASTER_DATA_ID", nullable = false)
	public MasterDatas getMasterDatas() {
		return this.masterDatas;
	}

	public void setMasterDatas(MasterDatas masterDatas) {
		this.masterDatas = masterDatas;
	}

	@Column(name = "LANGUAGE_CODE", nullable = false, length = 5)
	public String getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	@Column(name = "MASTER_DATA_NAME", nullable = false)
	public Serializable getMasterDataName() {
		return this.masterDataName;
	}

	public void setMasterDataName(Serializable masterDataName) {
		this.masterDataName = masterDataName;
	}

	@Column(name = "MASTER_DATA_DESCRIPTION")
	public Serializable getMasterDataDescription() {
		return this.masterDataDescription;
	}

	public void setMasterDataDescription(Serializable masterDataDescription) {
		this.masterDataDescription = masterDataDescription;
	}

}
