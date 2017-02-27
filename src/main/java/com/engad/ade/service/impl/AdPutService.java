package com.engad.ade.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.engad.ade.dao.IAdPutDao;
import com.engad.ade.entity.AdPut;
import com.engad.ade.service.IAdPutService;
import com.engad.framework.utils.Constants;

@Service
public class AdPutService implements IAdPutService{
	@Resource
	private IAdPutDao adPutDao;
	
	@Override
	public List<AdPut> queryAdPut(Map<String, Object> map) {
		return adPutDao.queryAdPut(map);
	}

	@Override
	public int insertAdPut(AdPut adPut) {
		return adPutDao.insertAdPut(adPut);
	}
	
	@Override
	public Map<String, Object> getAdPut(Map<String, Object> req) {
		//map
		Date gmt_req = new Date();
		//Map<String, Object> ad_put = new HashMap<>();
		AdPut adPut = new AdPut();
		
		/*String channel_id = (String)req.get("channel_id");
		String sex = (String)req.get("sex");
		String province = (String)req.get("province");
		String city = (String)req.get("city");
		String app_id = (String)req.get("appid");
		String open_id = (String)req.get("openid");
		String out_trade_no = (String)req.get("out_trade_no");
		String merchant_name = (String)req.get("merchant_name");
		String merchandise_name = (String)req.get("merchandise_name");
		String pay_type = (String)req.get("pay_type");
		String amount = (String)req.get("amount");
		String trade_time = (String)req.get("trade_time");*/
		Long seat_id = (Long)req.get("seat_id");
		String reqId = seat_id + "T" + System.currentTimeMillis();
		
		Long ad_id = 1L;
		Map<String, Object> resp = new HashMap<>();
		if (seat_id == 1){
			resp.put("desc", "恭喜获得一次抽奖机会！立即抽取-》");
			
			resp.put("image_url", "");
			
			ad_id = 1L;
		}else{
			resp.put("desc", "");
			
			//String rootPath=getClass().getResource("/").getFile().toString();
			if (Math.random()*2>1)
				resp.put("image_url", Constants.URL_RES_PREFIX + "images/123.jpg");
			else
				resp.put("image_url", Constants.URL_RES_PREFIX + "images/1234.jpg");
			
			ad_id = 2L;
		}
		String click_url = Constants.URL_RES_PREFIX + "click?req=" + reqId;
		click_url += "&target=" + "http://m.galaxyclub.cn/event/fansweek201702";
		
		resp.put("click_url", click_url);
		resp.put("success", "true");
		resp.put("msg", "50000");
		
		adPut.setCallMode(2);
		adPut.setAdId(ad_id);
		adPut.setCreativeId(1L);
		adPut.setAppId((Long)req.get("app_id"));
		adPut.setSeatId(seat_id);
		adPut.setAdFrom(1);
		
		adPut.setPrice(1.01);
		adPut.setPricingMode(1);
		
		adPut.setPutStatus(1);
		
		adPut.setRespCode("50000");
		adPut.setRespTransferUrl(click_url);
		adPut.setRespStatus(1);
		adPut.setGmtReq(gmt_req);
		adPut.setGmtResp(new Date());
		adPut.setRespContent("");
		adPut.setReqContent("");
		//private String resp_content;
		//ad_put.put("req_content", req.toString());
		adPut.setReqId(reqId);
		
		insertAdPut(adPut);
		
		return resp;
	}
}
