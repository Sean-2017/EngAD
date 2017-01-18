/**
 * 
 */
package com.engad.ade.exception;

/**
 * @author sean.wang
 * @version
 * @date 2017-1-11下午9:03:40
 */
public class BaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID=-119548781307646593L;

	public BaseException(){
		super();
	}

	public BaseException(String message,Throwable cause){
		super(message,cause);
	}

	public BaseException(String message){
		super(message);
	}

	public BaseException(Throwable cause){
		super(cause);
	}

}
