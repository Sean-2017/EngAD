package com.engad.ade.test.rest;

/** 
 * 物品区域 --> 背包 
 *  
 */  
public class LifeGameItemareaBagDTO {  
  
    private long id;  
    private long roleId;  
    private String gridbag;  
    private int gridnum;  
  
    public long getId() {  
        return id;  
    }  
  
    public void setId(long id) {  
        this.id = id;  
    }  
  
    public long getRoleId() {  
        return roleId;  
    }  
  
    public void setRoleId(long roleId) {  
        this.roleId = roleId;  
    }  
  
    public String getGridbag() {  
        return gridbag;  
    }  
  
    public void setGridbag(String gridbag) {  
        this.gridbag = gridbag;  
    }  
  
    public int getGridnum() {  
        return gridnum;  
    }  
  
    public void setGridnum(int gridnum) {  
        this.gridnum = gridnum;  
    }  
  
}  