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
 * TripLocationProjects generated by hbm2java
 */
@Entity
@Table(name = "TRIP_LOCATION_PROJECTS", catalog = "eHRM_JavaResearching")
public class TripLocationProjects implements java.io.Serializable {

	private Integer id;
	private Projects projects;
	private TripLocations tripLocations;
	private Integer projectPercent;

	public TripLocationProjects() {
	}

	public TripLocationProjects(Projects projects, TripLocations tripLocations, Integer projectPercent) {
		this.projects = projects;
		this.tripLocations = tripLocations;
		this.projectPercent = projectPercent;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public Projects getProjects() {
		return this.projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRIP_LOCATION_ID")
	public TripLocations getTripLocations() {
		return this.tripLocations;
	}

	public void setTripLocations(TripLocations tripLocations) {
		this.tripLocations = tripLocations;
	}

	@Column(name = "PROJECT_PERCENT")
	public Integer getProjectPercent() {
		return this.projectPercent;
	}

	public void setProjectPercent(Integer projectPercent) {
		this.projectPercent = projectPercent;
	}

}