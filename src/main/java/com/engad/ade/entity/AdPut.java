package com.engad.ade.entity;

import java.io.Serializable;
import java.util.Date;

public class AdPut implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String reqId;
	private Integer callMode;
	private Long appId;
	private Long seatId;
	private Long adId;
	private Long creativeId;
	private String reqContent;
	private Integer putStatus;
	private Integer adFrom;
	private Double price;
	private Integer pricingMode;
	private String respTransferUrl;
	private Integer respStatus;
	private String respCode;
	private String respContent;
	private Date gmtReq;
	private Date gmtResp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public Integer getCallMode() {
		return callMode;
	}
	public void setCallMode(Integer callMode) {
		this.callMode = callMode;
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
	public String getReqContent() {
		return reqContent;
	}
	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}
	public Integer getPutStatus() {
		return putStatus;
	}
	public void setPutStatus(Integer putStatus) {
		this.putStatus = putStatus;
	}
	public Integer getAdFrom() {
		return adFrom;
	}
	public void setAdFrom(Integer adFrom) {
		this.adFrom = adFrom;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getPricingMode() {
		return pricingMode;
	}
	public void setPricingMode(Integer pricingMe) {
		this.pricingMode = pricingMe;
	}
	public String getRespTransferUrl() {
		return respTransferUrl;
	}
	public void setRespTransferUrl(String respTransferUrl) {
		this.respTransferUrl = respTransferUrl;
	}
	public Integer getRespStatus() {
		return respStatus;
	}
	public void setRespStatus(Integer respStatus) {
		this.respStatus = respStatus;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespContent() {
		return respContent;
	}
	public void setRespContent(String respContent) {
		this.respContent = respContent;
	}
	public Date getGmtReq() {
		return gmtReq;
	}
	public void setGmtReq(Date gmtReq) {
		this.gmtReq = gmtReq;
	}
	public Date getGmtResp() {
		return gmtResp;
	}
	public void setGmtResp(Date gmtResp) {
		this.gmtResp = gmtResp;
	}
	
}
