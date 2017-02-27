package com.engad.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {

	public static String URL_RES_PREFIX;
	private static Properties p=null;
	
	static{
		if(p==null){
			p = new Properties();
			load();
		}
	}
	
	public static void load(){
		InputStream inputStream = null;
		try{
			inputStream=Constants.class.getResourceAsStream("/config.properties");
			if(p==null){
				p = new Properties();
			}
			p.load(inputStream);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(inputStream!=null){
				try{
					inputStream.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
		URL_RES_PREFIX = p.getProperty("url.res.prefix","http://10.10.1.173:8080/ade/");
	}
}
