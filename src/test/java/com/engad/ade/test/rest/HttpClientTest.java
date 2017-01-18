package com.engad.ade.test.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import net.sf.json.JSONFunction;

/** 
 *  发送HttpClient 
 *  
 */  
public class HttpClientTest {  
  
    public static void main(String[] args) throws IOException {  
        delete();  
    }  
  
    public static void query() throws IOException {  
  
        CloseableHttpClient client = HttpClientBuilder.create().build();  
  
        HttpPost post = new HttpPost(  
                "http://localhost:7001/pa18shoplife/lifegame/ItemareaBag/query.do3");  
  
        Map<String, Object> map = new HashMap<String, Object>();  
        List<String> list = new ArrayList<String>();  
        list.add("41");  
        list.add("42");  
        map.put("ids", list);  
        map.put("pageNumber", "1");  
        map.put("pageSize", "5000");  
        String str = Utils.convertToString4Obj(map);  
        System.out.println(str);  
  
        respCallback(client, post, str);  
    }  
  
    public static void saveorupdate() throws IOException,  
            UnsupportedEncodingException, ClientProtocolException {  
        CloseableHttpClient client = HttpClientBuilder.create().build();  
  
        HttpPost post = new HttpPost(  
                "http://localhost:7001/pa18shoplife/lifegame/ItemareaBag/saveorupdate.do3");  
  
        List<LifeGameItemareaBagDTO> list = new ArrayList<LifeGameItemareaBagDTO>();  
  
        LifeGameItemareaBagDTO dto = new LifeGameItemareaBagDTO();  
        dto.setId(41);  
        dto.setRoleId(3);  
        dto.setGridbag("11111");  
        dto.setGridnum(3);  
        list.add(dto);  
  
        dto = new LifeGameItemareaBagDTO();  
        dto.setId(42);  
        dto.setRoleId(4);  
        dto.setGridbag("222222");  
        dto.setGridnum(3);  
        list.add(dto);  
        String jsonStr = "";//JSON.json(list);  
        System.out.println(jsonStr);  
        respCallback(client, post, jsonStr);  
    }  
  
    public static void delete() throws IOException,  
            UnsupportedEncodingException, ClientProtocolException {  
        CloseableHttpClient client = HttpClientBuilder.create().build();  
  
        HttpPost post = new HttpPost(  
                "http://localhost:7001/pa18shoplife/lifegame/ItemareaBag/delete.do3");  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
  
        Map<String, Object> map1 = new HashMap<String, Object>();  
        map1.put("id", "41");  
  
        Map<String, Object> map2 = new HashMap<String, Object>();  
        map2.put("id", "42");  
  
        list.add(map1);  
        list.add(map2);  
  
        String str = Utils.convertToString4Obj(list);  
        System.out.println(str);  
        respCallback(client, post, str);  
    }  
  
    private static void respCallback(CloseableHttpClient client, HttpPost post,  
            String str) throws IOException {  
        post.setEntity(new StringEntity(str, "utf-8"));  
  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        InputStream ins = null;  
        try {  
            CloseableHttpResponse resp = client.execute(post);  
            if (resp.getStatusLine().getStatusCode() == 200) {  
                ins = resp.getEntity().getContent();  
                IOUtils.copy(ins, bos);  
                System.out.println(new String(bos.toByteArray(), "UTF-8"));  
            } else {  
                System.out.println("error..............");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            IOUtils.closeQuietly(ins);  
            IOUtils.closeQuietly(bos);  
            client.close();  
        }  
    }  
  
}  
