package com.engad.ade.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.engad.ade.dao.IEventClickDao;
import com.engad.ade.entity.EventClick;
import com.engad.ade.service.IEventClickService;

@Service
public class EventClickService implements IEventClickService{
	@Resource
	private IEventClickDao eClickDao;
	
	@Override
	public List<EventClick> queryEventClick(Map<String, Object> map) {
		return eClickDao.queryEventClick(map);
	}

	@Override
	public int insertEventClick(EventClick e) {
		return eClickDao.insertEventClick(e);
	}
}
