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
 * UserUnitRights generated by hbm2java
 */
@Entity
@Table(name = "USER_UNIT_RIGHTS", catalog = "eHRM_JavaResearching")
public class UserUnitRights implements java.io.Serializable {

	private Integer userUnitRightId;
	private Units units;
	private Users users;

	public UserUnitRights() {
	}

	public UserUnitRights(Units units, Users users) {
		this.units = units;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "USER_UNIT_RIGHT_ID", unique = true, nullable = false)
	public Integer getUserUnitRightId() {
		return this.userUnitRightId;
	}

	public void setUserUnitRightId(Integer userUnitRightId) {
		this.userUnitRightId = userUnitRightId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_ID", nullable = false)
	public Units getUnits() {
		return this.units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}