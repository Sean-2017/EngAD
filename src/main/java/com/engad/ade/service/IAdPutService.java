package com.engad.ade.service;

import java.util.List;
import java.util.Map;

import com.engad.ade.entity.AdPut;

public interface IAdPutService {
        public List<AdPut> queryAdPut(Map<String, Object> map);
        public int insertAdPut(AdPut h);
        public Map<String, Object> getAdPut(Map<String, Object> req);
}
