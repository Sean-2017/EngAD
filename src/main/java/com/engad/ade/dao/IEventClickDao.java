package com.engad.ade.dao;

import java.util.List;
import java.util.Map;

import com.engad.ade.entity.EventClick;

public interface IEventClickDao {
	 public List<EventClick> queryEventClick(Map<String, Object> map);
	 public int insertEventClick(EventClick e);
}
