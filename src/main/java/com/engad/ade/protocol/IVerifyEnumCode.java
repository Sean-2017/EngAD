/**
 * 
 */
package com.engad.ade.protocol;

import com.engad.ade.exception.ValidateException;

/**
 * 校验enum中的code
 * @author sean.wang
 * @version
 * @date 2017-1-11下午5:12:02
 */
public interface IVerifyEnumCode{
	
	/**
	 * 校验在enum中次code是否允许
	 * @author jinsong
	 * @param code
	 * @throws Exception
	 */
	public <T> boolean verifyCodeBeAllowed (T code) throws ValidateException;

}
