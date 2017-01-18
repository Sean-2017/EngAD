/**
 * 
 */
package com.engad.ade.exception;

/**
 * @author sean.wang
 * @version
 * @date 2017-1-11下午9:04:13
 */
public class InvokeException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID=6850088618561031567L;

	public InvokeException(){
		super();
	}

	public InvokeException(String message,Throwable cause){
		super(message,cause);
	}

	public InvokeException(String message){
		super(message);
	}

	public InvokeException(Throwable cause){
		super(cause);
	}

}
