package com.engad.ade.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.engad.ade.dao.IHelloDao;
import com.engad.ade.entity.Hello;
import com.engad.ade.service.IHelloService;
@Service
public class HelloService implements IHelloService{
	@Resource
	private IHelloDao helloDao;
	@Override
	public List<Hello> queryHello(Map<String, Object> map) {
		return helloDao.queryHello(map);
	}

}
