package com.songxiaocai.tradedata.web.controller.web;/* * Description:com.songxiaocai.tradedata.web.controller.web * @Date Create on 17:41 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-26日SXC All Rights Reserved. */import com.songxiaocai.tradedata.service.CouponsService;import com.sxc.common.domain.result.Result;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.ResponseBody;@Slf4j@Controller@RequestMapping("/api/tradedata/web")public class CouponsController {	@Autowired	private CouponsService couponsService;	@RequestMapping(value = "/sendCoupons",method = RequestMethod.GET)	@ResponseBody	public Result<?> sendCoupons(String mobile,Integer couponType ) {		//发放代金券 ，1品类，2商品组，3全商品组		Result<String> re=couponsService.sendCoupons(mobile,couponType);		Result result=new Result();		if(!re.isSuccess()){			result.setData(false);			result.setErrorMessage(re.getErrorMessage());			result.setSuccess(false);			return result;		}		result.setData(re.getData());		result.setSuccess(true);		result.setSuccessInfo("代金券发放成功");		return result;	}}