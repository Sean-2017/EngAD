package com.engad.ade.entity;

import java.io.Serializable;
import java.util.Date;

public class EventImp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long putId;
	private Long adId;
	private Long creativeId;
	private Long appId;
	private Long seatId;
	private Boolean isPayment;
	private Long paymentId;
	private Integer adImpNum;
	private Boolean isIncome;
	private Long incomeId;
	private Integer seatImpNum;
	private Date gmtOccur;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPutId() {
		return putId;
	}
	public void setPutId(Long putId) {
		this.putId = putId;
	}
	public Long getAdId() {
		return adId;
	}
	public void setAdId(Long adId) {
		this.adId = adId;
	}
	public Long getCreativeId() {
		return creativeId;
	}
	public void setCreativeId(Long creativeId) {
		this.creativeId = creativeId;
	}
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	public Boolean getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(Boolean isPayment) {
		this.isPayment = isPayment;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getAdImpNum() {
		return adImpNum;
	}
	public void setAdImpNum(Integer adImpNum) {
		this.adImpNum = adImpNum;
	}
	public Boolean getIsIncome() {
		return isIncome;
	}
	public void setIsIncome(Boolean isIncome) {
		this.isIncome = isIncome;
	}
	public Long getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}
	public Integer getSeatImpNum() {
		return seatImpNum;
	}
	public void setSeatImpNum(Integer seatImpNum) {
		this.seatImpNum = seatImpNum;
	}
	public Date getGmtOccur() {
		return gmtOccur;
	}
	public void setGmtOccur(Date gmtOccur) {
		this.gmtOccur = gmtOccur;
	}
}
