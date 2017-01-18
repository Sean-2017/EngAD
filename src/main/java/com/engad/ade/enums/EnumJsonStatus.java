/**
 * 
 */
package com.engad.ade.enums;

import com.engad.ade.exception.ValidateException;
import com.engad.ade.protocol.IVerifyEnumCode;

/**
 * @author sesn.wsng
 * @version
 * @date 2017-1-11上午9:34:18
 */
public enum EnumJsonStatus implements IVerifyEnumCode {
	OK((int)1, "成功"),
	NO((int)0, "失败");
	
	
	private String desc;
	private int value;
	
	private EnumJsonStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	public static EnumJsonStatus getEnum(int type) {
		EnumJsonStatus[] status = EnumJsonStatus.values();
		for(int i = 0; i < status.length; i++) {
			if(status[i].getValue() == type) {
				return status[i];
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.mumfans.taijiao.p1.protocol.IVerifyEnumCode#verifyCodeBeAllowed(java.lang.Object)
	 */
	@Override
	public <T> boolean verifyCodeBeAllowed(T code) throws ValidateException{
		try{
			boolean ok = false;
			if(null==code || code.toString().trim().length()==0){
				throw new ValidateException("枚举不能为空[enum="+this.getClass().getName()+",code="+code+"]");
			}
			int input = Integer.valueOf(code.toString());
			for(EnumJsonStatus e:EnumJsonStatus.values()){
				if(e.getValue()==input){
					ok =  true;
					break;
				}
			}
			if(!ok){
				throw new ValidateException("枚举不存在[enum="+this.getClass().getName()+",code="+code+"]");
			}
			return ok;
		}catch(NumberFormatException e){
			throw new ValidateException("不是数字，不能取得枚举类型[enum="+this.getClass().getName()+",code="+code+"]",e);
		}catch(RuntimeException e){
			throw new ValidateException(e);
		}catch(ValidateException e){
			throw e;
		}catch(Throwable e){
			throw new ValidateException("校验枚举异常[enum="+this.getClass().getName()+",code="+code+"]",e);
		}
	}
}
