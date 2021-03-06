package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
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
 * TripReimbursementAmount generated by hbm2java
 */
@Entity
@Table(name = "TRIP_REIMBURSEMENT_AMOUNT", catalog = "eHRM_JavaResearching")
public class TripReimbursementAmount implements java.io.Serializable {

	private Integer id;
	private TripRequests tripRequests;
	private BigDecimal taxFree;
	private BigDecimal taxable;
	private BigDecimal total;
	private BigDecimal food;
	private BigDecimal transport;
	private BigDecimal project;
	private BigDecimal laundry;
	private BigDecimal hotel;

	public TripReimbursementAmount() {
	}

	public TripReimbursementAmount(TripRequests tripRequests, BigDecimal taxFree, BigDecimal taxable, BigDecimal total,
			BigDecimal food, BigDecimal transport, BigDecimal project, BigDecimal laundry, BigDecimal hotel) {
		this.tripRequests = tripRequests;
		this.taxFree = taxFree;
		this.taxable = taxable;
		this.total = total;
		this.food = food;
		this.transport = transport;
		this.project = project;
		this.laundry = laundry;
		this.hotel = hotel;
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
	@JoinColumn(name = "TRIP_REQUEST_ID")
	public TripRequests getTripRequests() {
		return this.tripRequests;
	}

	public void setTripRequests(TripRequests tripRequests) {
		this.tripRequests = tripRequests;
	}

	@Column(name = "TAX_FREE", precision = 18)
	public BigDecimal getTaxFree() {
		return this.taxFree;
	}

	public void setTaxFree(BigDecimal taxFree) {
		this.taxFree = taxFree;
	}

	@Column(name = "TAXABLE", precision = 18)
	public BigDecimal getTaxable() {
		return this.taxable;
	}

	public void setTaxable(BigDecimal taxable) {
		this.taxable = taxable;
	}

	@Column(name = "TOTAL", precision = 18)
	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Column(name = "FOOD", precision = 18)
	public BigDecimal getFood() {
		return this.food;
	}

	public void setFood(BigDecimal food) {
		this.food = food;
	}

	@Column(name = "TRANSPORT", precision = 18)
	public BigDecimal getTransport() {
		return this.transport;
	}

	public void setTransport(BigDecimal transport) {
		this.transport = transport;
	}

	@Column(name = "PROJECT", precision = 18)
	public BigDecimal getProject() {
		return this.project;
	}

	public void setProject(BigDecimal project) {
		this.project = project;
	}

	@Column(name = "LAUNDRY", precision = 18)
	public BigDecimal getLaundry() {
		return this.laundry;
	}

	public void setLaundry(BigDecimal laundry) {
		this.laundry = laundry;
	}

	@Column(name = "HOTEL", precision = 18)
	public BigDecimal getHotel() {
		return this.hotel;
	}

	public void setHotel(BigDecimal hotel) {
		this.hotel = hotel;
	}

}
