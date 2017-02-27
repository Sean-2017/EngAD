package com.engad.ade.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.engad.ade.dao.IAdPutDao;
import com.engad.ade.entity.AdPut;

@Repository
public class AdPutDao extends BaseMyBatisDao<AdPut, Integer> implements IAdPutDao {

	@Override
	public List<AdPut> queryAdPut(Map<String, Object> map) {
		return query("AdPutMapper."+"queryAdPut", map);
	}

	@Override
	public int insertAdPut(AdPut h) {
		return insert("AdPutMapper."+"insertAdPut", h);
	}
}
