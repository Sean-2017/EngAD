package com.engad.ade.test.postjson;

import java.io.IOException;

import com.engad.ade.entity.Hello;

import net.sf.json.JSONObject;


/** 
 *  专用Http请求工具类 （HttpClient、Json对象）
 *  
 */  
public class PostTest {
	
	
	public static void main(String[] args) throws IOException {  
		JSONObject param = new JSONObject();
		param.put("Name","sean");
		Hello hr = new Hello();
		hr.setContent("My name is Sean");
		hr.setName("Sean");
		param.put("Hello",hr);
	    
	    JSONObject result= HttpRequestUtils.httpPost("http://127.0.0.1:8080/engad-ade/postHello", param, false);
	    //JSONObject a = result.discard("listHello");
	    Hello h = (Hello)JSONObject.toBean(result, Hello.class);//.get("listHello");
	    System.out.println(h.getContent());
    } 
}