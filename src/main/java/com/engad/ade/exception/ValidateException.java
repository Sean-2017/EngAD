/**
 * 
 */
package com.engad.ade.exception;

/**
 * @author sean.wang
 * @version
 * @date 2017-1-11下午9:04:13
 */
public class ValidateException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID=6850088618561031567L;

	public ValidateException(){
		super();
	}

	public ValidateException(String message,Throwable cause){
		super(message,cause);
	}

	public ValidateException(String message){
		super(message);
	}

	public ValidateException(Throwable cause){
		super(cause);
	}

}
