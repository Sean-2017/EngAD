package com.engad.ade.controller;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.mina.core.buffer.IoBuffer;

import net.sf.json.JSONObject;



public class MsgReceive {
	
	public static final String PARAM_NAME_PID="pid";
	public static final String PARAM_NAME_CLIENTID="clientId";
	
	private String req_addr ="";
	private String req_body = "";
	private JSONObject jo;
	
	public MsgReceive(HttpServletRequest request){
		this.doReceive(request);
		jo = JSONObject.fromObject(req_body);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key){
		return (T)jo.get(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getPid(){
		return (T)jo.get(PARAM_NAME_PID);
	}
	@SuppressWarnings("unchecked")
	public <T> T getClientId(){
		return (T)jo.get(PARAM_NAME_CLIENTID);
	}
	
	public String getJsonBody(){
		return this.req_body;
	}
	
	private void doReceive(HttpServletRequest request){
		req_addr = request.getRemoteAddr();
		
		// 取输入字节
		ServletInputStream is;
		try{
			is=request.getInputStream();
		}catch(IOException e1){
			throw new RuntimeException("不能获取输入流");
		}
		IoBuffer buffer = IoBuffer.allocate(0);
		boolean finished = false;
		while (!finished) {
			int bytesRead = 0;// 已经读取的
			int bytesToRead = 512;// 总共要读取的
			byte[] input = new byte[bytesToRead];
			while (bytesRead < bytesToRead) {
				int result=0;
				try {
					result = is.read(input, bytesRead, bytesToRead - bytesRead);
				} catch (IOException e) {
					throw new RuntimeException("不能读取请求体");
				}
				if (result == -1) {
					finished = true;
					break;
				}
				bytesRead += result;
			}
			IoBuffer newBuffer = IoBuffer.allocate(buffer.capacity() + bytesToRead);
			newBuffer.put(buffer);
			newBuffer.put(input, 0, bytesRead);
			buffer = newBuffer;
			buffer.flip();
		}

        //无数据
        if(buffer.limit()==0){
		    throw new RuntimeException("无请求体");
        }
        try {
        	req_body = buffer.getString(Charset.forName("utf-8").newDecoder());
		} catch (CharacterCodingException e) {
			throw new RuntimeException("请求体不是utf-8编码");

		}
	}
	
	public String getAddr(){
		return req_addr;
	}
	
	public String getMsg(){
		return req_body;
	}
	
	public JSONObject getJO(){
		return jo;
	}
}
