package com.engad.ade.pojo;

import java.sql.Timestamp;

/**
 * Device entity. @author MyEclipse Persistence Tools
 */

public class Device extends BasePOJO implements java.io.Serializable{

	private static final long serialVersionUID=883072674540130664L;
	private Long id;
	private Long userId;
	private Integer isDeleteFlag;
	private Integer app;
	private String appVersion;
	private String system;
	private String systemVersion;
	private Timestamp createDateTime;
	private Timestamp updateDateTime;

	// Constructors

	/** default constructor */
	public Device(){
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id=id;
	}

	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public Integer getIsDeleteFlag(){
		return isDeleteFlag;
	}

	public void setIsDeleteFlag(Integer isDeleteFlag){
		this.isDeleteFlag=isDeleteFlag;
	}

	public Integer getApp(){
		return app;
	}

	public void setApp(Integer app){
		this.app=app;
	}

	public String getAppVersion(){
		return appVersion;
	}

	public void setAppVersion(String appVersion){
		this.appVersion=appVersion;
	}

	public String getSystem(){
		return system;
	}

	public void setSystem(String system){
		this.system=system;
	}

	public String getSystemVersion(){
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion){
		this.systemVersion=systemVersion;
	}

	public Timestamp getCreateDateTime(){
		return createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime){
		this.createDateTime=createDateTime;
	}

	public Timestamp getUpdateDateTime(){
		return updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime){
		this.updateDateTime=updateDateTime;
	}

	@Override
	public String toString(){
		return "Device [id="+id+", userId="+userId+", isDeleteFlag="+isDeleteFlag+", app="+app+", appVersion="
				+appVersion+", system="+system+", systemVersion="+systemVersion+", createDateTime="+createDateTime
				+", updateDateTime="+updateDateTime+"]";
	}
}