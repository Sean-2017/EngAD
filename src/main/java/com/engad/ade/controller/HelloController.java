package com.engad.ade.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.engad.ade.entity.Hello;
import com.engad.ade.enums.EnumJsonError;
import com.engad.ade.enums.EnumJsonStatus;
import com.engad.ade.exception.BringBackException;
import com.engad.ade.exception.InvokeException;
import com.engad.ade.exception.ValidateException;
import com.engad.ade.pojo.Json;
import com.engad.ade.protocol.IProtocol;
import com.engad.ade.service.IHelloService;
import com.engad.framework.utils.SpringContextUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

@Controller
public class HelloController extends BaseController {
	//private static Logger log = Logger.getLogger(HelloController.class);
	private static Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Resource 
	private IHelloService helloService;
	
	@RequestMapping(value="/welcome")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring3 MVC 中国");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        model.addAttribute("date", dateFormat.format(new java.util.Date()));
        return "index";
    }
	
	 @RequestMapping(value="/getHello/{name}")
	 public String getHello(@PathVariable("name") String name, ModelMap model) {
		Map<String, Object> map=new HashMap<>();
		map.put("name", name);
		List<Hello> listHello= helloService.queryHello(map);
		model.addAttribute("listHello",listHello.get(0));
        return "hello";
	}
	 
	@SuppressWarnings("all")
	//@RequestMapping(value = "/p1")
	@RequestMapping(value="/postWx", method = RequestMethod.POST)
	public @ResponseBody Json postWx(HttpServletRequest request, ModelMap model) throws ValidateException {
		String msg = Thread.currentThread().getId() + "|"+ request.getRemoteAddr() + "|协议处理|";
		String pid = "";
		String clientId = "";
		log.info(INFO + msg+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		MsgReceive mr = new MsgReceive(request);
		pid = mr.get(MsgReceive.PARAM_NAME_PID);
		clientId = mr.get(MsgReceive.PARAM_NAME_CLIENTID);

		String pidclientid = "[pid=" + pid + ",clientid=" + clientId	+ "]|";
		msg = msg + pidclientid;
		log.info(INFO + msg + "开始");
		log.info(INFO + msg + mr.getJsonBody());

		if (pid == null || pid.trim().length() == 0) {
			throw new ValidateException("pid为空");
		}
		if (!"p1001".equals(pid)) {
			if (clientId == null || clientId.trim().length() == 0) {
				//hrow new ValidateException("clientId为空");
				clientId="28";		
			}
		}
		if ("p1107".equals(pid)) {
			//同步处理
			synchronized (this) {
				return invokeController(msg, pid, clientId, mr);
			}
		}else{
			return invokeController(msg, pid, clientId, mr);
		}
    }
	 
	 
	@SuppressWarnings("all")
	private Json invokeController(String msg, String pid, String clientId,
		MsgReceive mr) {
		Json json = null;
		try {
			IProtocol pro = (IProtocol) SpringContextUtil.getBean(pid);
			if (pro == null) {
				throw new InvokeException("无此协议实现[pid=" + pid + "]");
			}
	
			pro.setJsonBody(mr.getJO());
	
			if (!"p1001".equals(pid)) {
				//pro.validateClientId(true);
				log.info(INFO + msg + "校验|clientId通过");
			}
	
			pro.validate();
			log.info(INFO + msg + "校验|通过");
			Object ret = pro.invoke();
			log.info(INFO + msg + "执行|通过");
			json = new Json();
			json.setClientId(clientId);
			json.setPid(pid);
			json.setStatus(EnumJsonStatus.OK.getValue() + "");
			json.setRet(ret);
		}catch (ValidateException e) {
			json = new Json();
			json.setClientId(clientId);
			json.setPid(pid);
			json.setError(EnumJsonError.VALIDATE_EXCEPTION.getDesc() + ":"
					+ (e == null ? "" : e.getMessage()));
			json.setStatus(EnumJsonStatus.NO.getValue() + "");
			log.info(INFO + msg + "异常", e);
		} catch (InvokeException e) {
			json = new Json();
			json.setClientId(clientId);
			json.setPid(pid);
			json.setError(EnumJsonError.INVOKE_EXCEPTION.getDesc() + ":"
					+ (e == null ? "" : e.getMessage()));
			json.setStatus(EnumJsonStatus.NO.getValue() + "");
			log.info(INFO + msg + "异常", e);
		} catch (BringBackException e) {
			json = new Json();
			json.setClientId(clientId);
			json.setPid(pid);
			json.setError(e == null ? EnumJsonError.UNKNOW_EXCEPION
					.getDesc() : e.getMessage());
			json.setStatus(EnumJsonStatus.NO.getValue() + "");
			log.info(INFO + msg + "异常", e);
		} catch (Throwable e) {
			json = new Json();
			json.setClientId(clientId);
			json.setPid(pid);
			json.setError(EnumJsonError.UNKNOW_EXCEPION.getDesc() + ":"
					+ (e == null ? "" : e.getMessage()));
			json.setStatus(EnumJsonStatus.NO.getValue() + "");
			log.info(INFO + msg + "异常", e);
		} finally {
		//	log.info(INFO + msg + "输出|" + json);
			log.info(INFO + msg + "完成");
			return json;		
		}
	}
	
	
	
	//注入
    //@Resource
    //private Hello hello;
    
	 /**
     * 创建异常信息请求
     * @param requestBody 请求消息内容
     * @param request 请求消息头
     * @return jsonObject
     */
    @RequestMapping(
            value="/postHello",
            method = RequestMethod.POST
    )
    public @ResponseBody Hello postHello(@RequestBody String requestBody, HttpServletRequest request) {
        JSONObject jsonObject = JSONObject.fromObject(requestBody);
        //hello.setName(jsonObject.getString("Name"));
        //hello.setContent(jsonObject.getString("Content"));
        Hello s = (Hello)JSONObject.toBean(JSONObject.fromObject(jsonObject.getString("Hello")), Hello.class);;

        
        helloService.insertHello(s);
        Map<String, Object> map=new HashMap<>();
        map.put("name", jsonObject.getString("Name"));
		List<Hello> listHello= helloService.queryHello(map);
		//model.addAttribute("listHello",listHello.get(0));
        //返回请求结果
        JSONObject result= new JSONObject();
        result.put("listHello", listHello.get(0));
        JSONArray respObject = new JSONArray();
        respObject.add(result);
        //result.put("success", "true");
        
        Json json = new Json();
		json.setClientId("1");
		json.setPid("20000");
		json.setStatus(EnumJsonStatus.OK.getValue() + "");
		json.setRet(listHello);
		
        return listHello.get(0);//result.toString();
        //return new ModelAndView("hello", json);//ResponseUtilsHelper.jsonSuccess(result.toString())
    }
    
    @RequestMapping(
            value="/receivePost",
            method = RequestMethod.POST
    )
    public @ResponseBody String receivePost(HttpServletRequest request) throws IOException, UnsupportedEncodingException {
        
        // 读取请求内容
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){
            sb.append(line);
        }

        // 将资料解码
        String reqBody = sb.toString();
        return URLDecoder.decode(reqBody, HTTP.UTF_8);
    }
    
    
    @ResponseBody  
    @RequestMapping(value="/order",method=RequestMethod.POST)  
    public boolean order(HttpServletRequest request,@RequestBody List<Hello> orders) throws Exception {  
        try {  
            //this.orderService.saveOrderList(orders,admPost);  
            //log.log("订单管理","1","导入",new Date(),"导入订单成功,订单信息--> " + GsonUtil.toString(orders, new TypeToken<List<Order>>() {}.getType()));  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            //log.log("订单管理",admPost.getId(),"导入",new Date(),"导入订单失败,订单信息--> " + GsonUtil.toString(orders, new TypeToken<List<Order>>() {}.getType()));  
            return false;  
        }  
    }  
}
