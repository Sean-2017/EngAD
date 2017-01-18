/**
 * 
 */
package com.engad.ade.pojo;

/**
 * @author sean.wang
 * @version
 * @date 2017-1-11下午8:56:16
 */
public class BasePageVO{
	
	private Integer pageSize;
	private Integer currentPage;
	public Integer getPageSize(){
		return pageSize;
	}
	public void setPageSize(Integer pageSize){
		this.pageSize=pageSize;
	}
	public Integer getCurrentPage(){
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage){
		this.currentPage=currentPage;
	}
	@Override
	public String toString(){
		return "BasePageVO [pageSize="+pageSize+", currentPage="+currentPage+"]";
	}
	
	public Integer getOffset(){
		if(currentPage==null || pageSize==null){
			return null;
		}
		Integer offset=(currentPage-1)*pageSize;
		return offset;
	}
	
	public Integer getLimit(){
		Integer limit=pageSize;
		return limit;
	}

}
