/**
 * 
 */
package com.engad.ade.pojo;


/**
 * @author sean.wang
 * @version
 * @date 2016-1-14上午10:31:34
 */
public class Json{
	
	private String pid;
	private String clientId;
	private String status;
	private String error;
	private Object ret;
	
	
	public String getPid(){
		return pid;
	}
	public void setPid(String pid){
		this.pid=pid;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getError(){
		return error;
	}
	public void setError(String error){
		this.error=error;
	}
	public Object getRet(){
		return ret;
	}
	public void setRet(Object ret){
		this.ret=ret;
	}
	public String getClientId(){
		return clientId;
	}
	public void setClientId(String clientId){
		this.clientId=clientId;
	}
	@Override
	public  String toString(){
		return "Json [pid="+pid+", clientId="+clientId+", status="+status+", error="+error+", ret="+ret+"]";
	}
	
}
