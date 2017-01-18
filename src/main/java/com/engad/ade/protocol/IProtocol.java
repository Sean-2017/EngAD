/**
 * 
 */
package com.engad.ade.protocol;

import net.sf.json.JSONObject;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.engad.ade.exception.ValidateException;

/**
 * @author sean.wang
 * @version
 * @date 2017-1-11下午11:30:57
 */
public interface IProtocol {
	
	public void setJsonBody(JSONObject jsonObject) throws Exception;
	
	public void validate() throws ValidateException;
	
    public <T> T invoke() throws Exception;

	public void setMultipartRequest(MultipartHttpServletRequest multipartRequest);

	public boolean validateClientId(boolean exceptionIfNull) throws ValidateException;
}
