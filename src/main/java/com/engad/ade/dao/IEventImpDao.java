package com.engad.ade.dao;

import java.util.List;
import java.util.Map;

import com.engad.ade.entity.EventImp;

public interface IEventImpDao {
	 public List<EventImp> queryEventImp(Map<String, Object> map);
	 public int insertEventImp(EventImp e);
}
