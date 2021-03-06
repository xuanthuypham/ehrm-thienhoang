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
 * ProjectDefaults generated by hbm2java
 */
@Entity
@Table(name = "PROJECT_DEFAULTS", catalog = "eHRM_JavaResearching")
public class ProjectDefaults implements java.io.Serializable {

	private Integer projectDefaultId;
	private Employees employees;
	private Projects projects;

	public ProjectDefaults() {
	}

	public ProjectDefaults(Employees employees, Projects projects) {
		this.employees = employees;
		this.projects = projects;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PROJECT_DEFAULT_ID", unique = true, nullable = false)
	public Integer getProjectDefaultId() {
		return this.projectDefaultId;
	}

	public void setProjectDefaultId(Integer projectDefaultId) {
		this.projectDefaultId = projectDefaultId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID", nullable = false)
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID", nullable = false)
	public Projects getProjects() {
		return this.projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

}
