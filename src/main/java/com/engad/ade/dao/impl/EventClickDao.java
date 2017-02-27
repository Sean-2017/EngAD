package com.engad.ade.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.engad.ade.dao.IEventClickDao;
import com.engad.ade.entity.EventClick;

@Repository
public class EventClickDao extends BaseMyBatisDao<EventClick, Integer> implements IEventClickDao {

	@Override
	public List<EventClick> queryEventClick(Map<String, Object> map) {
		return query("EventClickMapper."+"queryEventClick", map);
	}

	@Override
	public int insertEventClick(EventClick e) {
		return insert("EventClickMapper."+"insertEventClick", e);
	}
}
