package com.thienhoang.ehrm.model;
// Generated Apr 22, 2018 7:20:49 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ExchangeRates generated by hbm2java
 */
@Entity
@Table(name = "EXCHANGE_RATES", catalog = "eHRM_JavaResearching")
public class ExchangeRates implements java.io.Serializable {

	private Integer exchangeRateId;
	private MasterDatas masterDatasByCurrencyExchangeCategoryId;
	private MasterDatas masterDatasByCurrencyId;
	private MasterDatas masterDatasByExchangedCurrencyId;
	private BigDecimal rate;
	private int year;
	private int month;
	private Date updatedDate;

	public ExchangeRates() {
	}

	public ExchangeRates(MasterDatas masterDatasByCurrencyExchangeCategoryId, MasterDatas masterDatasByCurrencyId,
			MasterDatas masterDatasByExchangedCurrencyId, BigDecimal rate, int year, int month, Date updatedDate) {
		this.masterDatasByCurrencyExchangeCategoryId = masterDatasByCurrencyExchangeCategoryId;
		this.masterDatasByCurrencyId = masterDatasByCurrencyId;
		this.masterDatasByExchangedCurrencyId = masterDatasByExchangedCurrencyId;
		this.rate = rate;
		this.year = year;
		this.month = month;
		this.updatedDate = updatedDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EXCHANGE_RATE_ID", unique = true, nullable = false)
	public Integer getExchangeRateId() {
		return this.exchangeRateId;
	}

	public void setExchangeRateId(Integer exchangeRateId) {
		this.exchangeRateId = exchangeRateId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURRENCY_EXCHANGE_CATEGORY_ID", nullable = false)
	public MasterDatas getMasterDatasByCurrencyExchangeCategoryId() {
		return this.masterDatasByCurrencyExchangeCategoryId;
	}

	public void setMasterDatasByCurrencyExchangeCategoryId(MasterDatas masterDatasByCurrencyExchangeCategoryId) {
		this.masterDatasByCurrencyExchangeCategoryId = masterDatasByCurrencyExchangeCategoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURRENCY_ID", nullable = false)
	public MasterDatas getMasterDatasByCurrencyId() {
		return this.masterDatasByCurrencyId;
	}

	public void setMasterDatasByCurrencyId(MasterDatas masterDatasByCurrencyId) {
		this.masterDatasByCurrencyId = masterDatasByCurrencyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXCHANGED_CURRENCY_ID", nullable = false)
	public MasterDatas getMasterDatasByExchangedCurrencyId() {
		return this.masterDatasByExchangedCurrencyId;
	}

	public void setMasterDatasByExchangedCurrencyId(MasterDatas masterDatasByExchangedCurrencyId) {
		this.masterDatasByExchangedCurrencyId = masterDatasByExchangedCurrencyId;
	}

	@Column(name = "RATE", nullable = false, precision = 20, scale = 10)
	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Column(name = "YEAR", nullable = false)
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "MONTH", nullable = false)
	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", nullable = false, length = 23)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
