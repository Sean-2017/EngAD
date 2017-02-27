package com.engad.ade.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.engad.ade.dao.IEventImpDao;
import com.engad.ade.entity.EventImp;

@Repository
public class EventImpDao extends BaseMyBatisDao<EventImp, Integer> implements IEventImpDao {

	@Override
	public List<EventImp> queryEventImp(Map<String, Object> map) {
		return query("EventImpMapper."+"queryEventImp", map);
	}

	@Override
	public int insertEventImp(EventImp e) {
		return insert("EventImpMapper."+"insertEventImp", e);
	}
}
