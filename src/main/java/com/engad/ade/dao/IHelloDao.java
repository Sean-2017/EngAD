package com.engad.ade.dao;

import java.util.List;
import java.util.Map;

import com.engad.ade.entity.Hello;

public interface IHelloDao {
	 public List<Hello> queryHello(Map<String, Object> map);
	 public int insertHello(Hello h);
}
