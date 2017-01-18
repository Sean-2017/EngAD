/**
 * 
 */
package com.engad.ade.exception;

/**
 * @author sean.wang
 * @version
 * @date 2017-1-11下午9:04:13
 */
public class BringBackException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID=6850088618561031567L;

	public BringBackException(){
		super();
	}

	public BringBackException(String message,Throwable cause){
		super(message,cause);
	}

	public BringBackException(String message){
		super(message);
	}

	public BringBackException(Throwable cause){
		super(cause);
	}

}
