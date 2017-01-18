package com.engad.ade.service;

import java.util.List;
import java.util.Map;

import com.engad.ade.entity.Hello;
public interface IHelloService {
        public List<Hello> queryHello(Map<String, Object> map);
        public int insertHello(Hello h);
}
