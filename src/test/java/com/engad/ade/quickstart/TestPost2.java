package com.engad.ade.quickstart;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;

/** 
 *  专用Http请求工具类 （Json对象）
 *  
 */  
public class TestPost2 {

   /**87FF2A5697A1E21C77FB02206743A68C
    * @param args
    * @throws UnsupportedEncodingException 
    */
   public static void main(String[] args) throws UnsupportedEncodingException {
       // http://101.200.172.162:8089/taijiao/p1    http://localhost:8080/springmvc/app  http://127.0.0.1:8080/taijiao-1.3.0/p1
	   //36.6312220000,114.5458080000
      // String URL = Constants.URL_RES_POSTMUMFANSWEB;
	   String URL = "http://127.0.0.1:8080/engad-ade/p1";
       System.out.println(URL);
       String Json = findXmlInfo();
       String clientId="278";
       String pid ="p2000";
       String userName ="15313776700";


       //String ctype ="1";
       List<String> lista = new ArrayList<String>();
       lista.add("1");
       lista.add("2");
       lista.add("3");
       lista.add("4");
       JSONArray array1 = JSONArray.fromObject(lista);
       Map<String,Object> params =  new HashMap<String,Object>();
       params.put("clientId", clientId);
       params.put("pid", pid);
       params.put("userName", userName);
       params.put("userId", "760");
       params.put("duration", "200");
       params.put("sounds", "http://b.hiphotos.baidu.com/zhidao/pic/item/5fdf8db1cb134954b84130be544e9258d0094a89.jpg");

       JSONArray array = JSONArray.fromObject(params);
       Json = array.toString().substring(1, array.toString().lastIndexOf("]"));

       String postResult = doHttpPost(Json,URL); 
       System.out.println("postResult:"+postResult);      
       JSONObject jsonObj = JSONObject.fromObject(postResult);

   }
   
   private static String findXmlInfo() {
       // TODO Auto-generated method stub
       return null;
   }

   public static String doHttpPost(String xmlInfo,String URL){         
        System.out.println("发起的数据:"+xmlInfo);       
       byte[] xmlData = xmlInfo.getBytes();            
        InputStream instr  = null;         
       // final String BOUNDARY = "----------HV2ymHFg03ehbqgZCaKO6jyH";  
         try{                          
                URL url = new URL(URL);                
                URLConnection urlCon = url.openConnection();               
                urlCon.setDoOutput(true);              
                urlCon.setDoInput(true);               
                urlCon.setUseCaches(false);                            
                urlCon.setRequestProperty("Content-Type", "text/xml");       
              // urlCon.setRequestProperty("Content-Type",  
              //          "multipart/form-data; boundary=" + BOUNDARY);  
                urlCon.setRequestProperty("Content-length",String.valueOf(xmlData.length)); 
                System.out.println(String.valueOf(xmlData.length));
                DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());            
                printout.write(xmlData);               
                printout.flush();              
                printout.close();              
                instr = urlCon.getInputStream();   
                byte[] bis = IOUtils.toByteArray(instr);
                String ResponseString = new String(bis, "UTF-8");  
               if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
                    System.out.println("返回空");
                   }
              System.out.println("返回数据为:" + ResponseString);
             return ResponseString;    
            
         }catch(Exception e){              
                e.printStackTrace();
               return "0";
         }             
         finally {             
                try {             
                       instr.close();  
                        
                }catch (Exception ex) {      
                       return "0";
                    }                  
                }                  
         } 
}