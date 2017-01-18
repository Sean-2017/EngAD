package com.engad.ade.test.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONFunction;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
/*相关jar包：

commons-beanutils.jar
commons-collections-3.1.jar
commons-io-1.4.jar
commons-lang.jar
commons-logging.jar
dubbo-2.4.9.1.jar
httpclient-4.3.6.jar
httpcore-4.3.3.jar
javaee.jar
javassist-3.16.1-GA.jar
log4j-1.2.15.jar
slf4j-api-1.7.2.jar
slf4j-log4j12-1.7.2.jar*/

/** 
 *  专用工具类 
 *  
 */  
public class Utils {  
      
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);  
      
    /** 
     * @param obj 
     * @return 返回JSON字符串 
     */  
    public static <T> String convertToString4Obj(T obj){  
          
        try {  
            return JSONUtils.valueToString(obj);
            //JSON.json(obj);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "{\"resultCode\":-500,\"msg\":\"不能把Obj变为JSON字符串.\"}";  
    }  
  
    /** 
     * @param clazz 
     * @param req 
     * @return 
     * @throws Exception 
     *  
     * 根据请求的request 的 body 返回 clazz的list形式 
     */  
    public static <T> List<T> convertToListObject(Class<T> clazz,  
            HttpServletRequest req) throws Exception{  
        return convertToListObject(clazz, toString(req));  
    }  
  
    /** 
     * @param clazz 
     * @param jsonStr 
     * @return 
     *  
     * 根据字符串返回clazz的list形式 
     */  
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public static <T> List<T> convertToListObject(Class<T> clazz, String jsonStr)  
            throws Exception{  
        List<T> retVal = new ArrayList<T>();  
        if(StringUtils.isBlank(jsonStr)){  
            return retVal;  
        }  
        try {  
            Object obj = JSONFunction.parse(jsonStr);//JSON.parse(jsonStr);  
            if (obj instanceof JSONArray) {  
                List<Map> list = JSONArray.toList(JSONArray.fromObject(jsonStr), List.class);  
                if(clazz == Map.class){  
                    return (List<T>) list;  
                }  
                for (Map<String, Object> map : list) {  
                    T t = clazz.newInstance();  
                    BeanUtils.copyProperties(t, map);  
                    retVal.add(t);  
                }  
            } else if (obj instanceof JSONObject) {  
                /*Map map = JSONArray.(JSONArray.fromObject(jsonStr), Map.class);  
                if(clazz == Map.class){  
                    retVal.add((T) map);  
                    return retVal;  
                }  
                T t = clazz.newInstance();  
                BeanUtils.copyProperties(t, map);  
                retVal.add(t);  */
            }  
        /*} catch (ParseException e) {  
            logger.info("parse JSON error.......",e);  
            throw e;  */
        } catch (InstantiationException e) {  
            logger.info("instance clazz[{}] error.......",clazz,e);  
            throw e;  
        } catch (IllegalAccessException e) {  
            logger.info("IllegalAccessException........",e);  
            throw e;  
        } catch (InvocationTargetException e) {  
            logger.info("InvocationTargetException........",e);  
            throw e;  
        }  
        return retVal;  
    }  
  
    /** 
     * @param req 
     * @return 
     * @throws IOException 
     *  
     * 返回req的body字符串 
     */  
    public static String toString(HttpServletRequest req) throws IOException {  
        ByteArrayOutputStream writer = new ByteArrayOutputStream();  
        InputStream ins = null;  
        String retVal = null;  
        try {  
            ins = req.getInputStream();  
            if (ins != null) {  
                IOUtils.copy(ins, writer);  
                retVal = new String(writer.toByteArray(),"utf-8");  
            }  
        } finally {  
            IOUtils.closeQuietly(ins);  
            IOUtils.closeQuietly(writer);  
        }  
        logger.info("request body is [{}]",retVal);  
        return retVal;  
    }  
  
    /** 
     * @param req 
     * @return 
     * @throws IOException  
     *  
     */  
    @SuppressWarnings("rawtypes")  
    public static Map convertToMap(HttpServletRequest req) throws Exception {  
        String jsonStr = toString(req);  
        if(StringUtils.isNotBlank(jsonStr)){  
            return null;//JSON.parse(jsonStr, Map.class);  
        }  
        return null;  
    }  
  
}  