package com.engad.ade.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.engad.ade.entity.AdPut;
import com.engad.ade.entity.EventClick;
import com.engad.ade.service.IAdPutService;
import com.engad.ade.service.IEventClickService;
import com.engad.ade.service.IEventImpService;

@Controller
public class AdeController extends BaseController {
	//private static Logger log = Logger.getLogger(HelloController.class);
	private static Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Resource
	private IAdPutService adPutService;
	
	@Resource
	private IEventClickService eClickService;
	
	@Resource
	private IEventImpService eImpService;
	
	@RequestMapping(value="/click")
    public String printClick(@RequestParam(value ="req") String req,@RequestParam(value ="target") String target,ModelMap model) {
        //model.addAttribute("message", "Spring3 MVC 中国");
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        //model.addAttribute("date", dateFormat.format(new java.util.Date()));
		//log.info(ad);
		log.info(target);
		Map<String, Object> map=new HashMap<>();
		map.put("reqId", req);
		AdPut adPut = adPutService.queryAdPut(map).get(0);
		
		EventClick ec = new EventClick();
		ec.setAdId(adPut.getAdId());
		ec.setAppId(adPut.getAppId());
		ec.setCreativeId(adPut.getCreativeId());
		ec.setGmtOccur(new Date());
		ec.setIncomeAmount(0.11D);
		//ec.setIncomeId(incomeId);
		ec.setIsPayment(true);
		ec.setPaymentAmount(0.22D);
		ec.setPutId(adPut.getId());
		ec.setSeatId(adPut.getSeatId());
		ec.setIsIncome(true);
		ec.setIsPayment(true);
		
		eClickService.insertEventClick(ec);
		
		return "redirect:"+target;//"forward:"+target;
    }
	
	@RequestMapping(value="/ad")
    public String getAd(@RequestParam(value ="seat") Long seat,ModelMap model) {
        //model.addAttribute("message", "Spring3 MVC 中国");
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        //model.addAttribute("date", dateFormat.format(new java.util.Date()));
		//log.info(ad);
		//log.info(target);
		Map<String, Object> ad_req = new HashMap<>();
		ad_req.put("seat_id", seat);
		ad_req.put("app_id", 1L);
		//ad_req.put("req_id", seat + "T" + System.currentTimeMillis());
		
		Map<String, Object> ad_resp = adPutService.getAdPut(ad_req);
		model.addAttribute("ads", ad_resp);
		
		eImpService.triggerEventImp((String)ad_resp.get("click_url"));
		
		return "ad";
    }
	
	@RequestMapping(value="/stat")
    public String getStat(ModelMap model) {
		Map<String, Object> q = new HashMap<>();
		Map<String, Object> mStat = new HashMap<>();
		
		q.put("adId", 1L);
		int ad_imp_num = eImpService.queryEventImp(q).size();
		mStat.put("imp_num_ad1", ad_imp_num);
		int ad_clk_num = eClickService.queryEventClick(q).size();
		mStat.put("clk_num_ad1", ad_clk_num);
		if (ad_imp_num > 0) {
			//double d = Math.round((ad_clk_num/ad_imp_num)*100);
			mStat.put("ctr_ad1", Math.round(ad_clk_num * 100D/ad_imp_num));//String.format("%.2f", (ad_clk_num*100)/ad_imp_num*0.01D));//Math.round(ad_clk_num/ad_imp_num * 100)* 0.01d);
		}
		
		q.put("adId", 2L);
		ad_imp_num = eImpService.queryEventImp(q).size();
		mStat.put("imp_num_ad2", ad_imp_num);
		ad_clk_num = eClickService.queryEventClick(q).size();
		mStat.put("clk_num_ad2", ad_clk_num);
		if (ad_imp_num > 0) {
			//double d = ad_clk_num/ad_imp_num;
			mStat.put("ctr_ad2", Math.round(ad_clk_num * 100D/ad_imp_num));//Math.round(ad_clk_num/ad_imp_num * 100)* 0.01d);
		}
		
		q.put("adId", null);
		q.put("seatId", 1L);
		int seat_imp_num = eImpService.queryEventImp(q).size();
		mStat.put("imp_num_seat1", seat_imp_num);
		int seat_clk_num = eClickService.queryEventClick(q).size();
		mStat.put("clk_num_seat1", seat_clk_num);
		
		q.put("seatId", 2L);
		seat_imp_num = eImpService.queryEventImp(q).size();
		mStat.put("imp_num_seat2", seat_imp_num);
		seat_clk_num = eClickService.queryEventClick(q).size();
		mStat.put("clk_num_seat2", seat_clk_num);
		
		model.addAttribute("mStat", mStat);
		
		return "stat";
	}
}
