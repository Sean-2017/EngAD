package com.engad.ade.dao;

import java.util.List;
import java.util.Map;

import com.engad.ade.entity.AdPut;

public interface IAdPutDao {
	 public List<AdPut> queryAdPut(Map<String, Object> map);
	 public int insertAdPut(AdPut h);
}
