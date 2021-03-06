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
 * Languages generated by hbm2java
 */
@Entity
@Table(name = "LANGUAGES", catalog = "eHRM_JavaResearching")
public class Languages implements java.io.Serializable {

	private Integer languageId;
	private Serializable languageName;
	private Integer orderIndex;
	private Boolean isDefault;
	private Set<EmployeeLanguage> employeeLanguages = new HashSet<EmployeeLanguage>(0);

	public Languages() {
	}

	public Languages(Serializable languageName, Integer orderIndex, Boolean isDefault,
			Set<EmployeeLanguage> employeeLanguages) {
		this.languageName = languageName;
		this.orderIndex = orderIndex;
		this.isDefault = isDefault;
		this.employeeLanguages = employeeLanguages;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "LANGUAGE_ID", unique = true, nullable = false)
	public Integer getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	@Column(name = "LANGUAGE_NAME")
	public Serializable getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(Serializable languageName) {
		this.languageName = languageName;
	}

	@Column(name = "ORDER_INDEX")
	public Integer getOrderIndex() {
		return this.orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	@Column(name = "IS_DEFAULT")
	public Boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "languages")
	public Set<EmployeeLanguage> getEmployeeLanguages() {
		return this.employeeLanguages;
	}

	public void setEmployeeLanguages(Set<EmployeeLanguage> employeeLanguages) {
		this.employeeLanguages = employeeLanguages;
	}

}
