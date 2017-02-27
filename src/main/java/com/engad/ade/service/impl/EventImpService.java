package com.engad.ade.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.engad.ade.dao.IEventImpDao;
import com.engad.ade.entity.AdPut;
import com.engad.ade.entity.EventImp;
import com.engad.ade.service.IAdPutService;
import com.engad.ade.service.IEventImpService;

@Service
public class EventImpService implements IEventImpService{
	@Resource
	private IEventImpDao eClickDao;
	
	@Resource
	private IAdPutService adPutService;
	
	@Override
	public List<EventImp> queryEventImp(Map<String, Object> map) {
		return eClickDao.queryEventImp(map);
	}

	@Override
	public int insertEventImp(EventImp e) {
		return eClickDao.insertEventImp(e);
	}
	
	@Override
	public void triggerEventImp(String target){
		//log.info(target);
		Map<String, Object> map=new HashMap<>();
		map.put("reqId", target.substring(target.lastIndexOf("?req=")+5, target.indexOf("&target=")));
		AdPut adPut = adPutService.queryAdPut(map).get(0);
		
		EventImp ei = new EventImp();
		ei.setAdId(adPut.getAdId());
		ei.setAppId(adPut.getAppId());
		ei.setCreativeId(adPut.getCreativeId());
		ei.setGmtOccur(new Date());
		ei.setAdImpNum(1);
		//ec.setIncomeId(incomeId);
		ei.setIsPayment(true);
		ei.setSeatImpNum(1);
		ei.setPutId(adPut.getId());
		ei.setSeatId(adPut.getSeatId());
		ei.setIsIncome(true);
		ei.setIsPayment(true);
		
		insertEventImp(ei);
	}
}
