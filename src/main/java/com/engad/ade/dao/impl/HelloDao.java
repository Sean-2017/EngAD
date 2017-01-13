package com.engad.ade.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.engad.ade.dao.IHelloDao;
import com.engad.ade.entity.Hello;
@Repository
public class HelloDao extends BaseMyBatisDao<Hello, Integer> implements IHelloDao {

	@Override
	public List<Hello> queryHello(Map<String, Object> map) {
		return query("HelloMapper."+"queryHello", map);
	}

}
