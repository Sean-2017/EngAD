package com.engad.ade.service;

import java.util.List;
import java.util.Map;

import com.engad.ade.entity.EventImp;

public interface IEventImpService {
        public List<EventImp> queryEventImp(Map<String, Object> map);
        public int insertEventImp(EventImp e);
        public void triggerEventImp(String target);
}
