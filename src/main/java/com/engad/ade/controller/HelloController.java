package com.engad.ade.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.engad.ade.entity.Hello;
import com.engad.ade.service.IHelloService;

@Controller
public class HelloController {
	
	@Resource 
	private IHelloService helloService;
	
	@RequestMapping(value="/welcome")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring3 MVC 中国");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        model.addAttribute("date", dateFormat.format(new java.util.Date()));
        return "index";
    }
	
	 @RequestMapping(value="/getHello")
	 public String getHello(ModelMap model) {
		Map<String, Object> map=new HashMap<>();
		map.put("name", "青青");
		List<Hello> listHello= helloService.queryHello(map);
		model.addAttribute("listHello",listHello.get(0));
        return "hello";
    }
}
