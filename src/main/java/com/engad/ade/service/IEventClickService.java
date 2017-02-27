package com.engad.ade.service;

import java.util.List;
import java.util.Map;

import com.engad.ade.entity.EventClick;

public interface IEventClickService {
        public List<EventClick> queryEventClick(Map<String, Object> map);
        public int insertEventClick(EventClick e);
}
