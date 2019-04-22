package com.songxiaocai.tradedata.web.controller.web;/* * Description:com.songxiaocai.tradedata.web.controller.web * @Date Create on 11:18 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-21日SXC All Rights Reserved. */import com.songxiaocai.tradedata.service.BalanceService;import com.sxc.common.domain.result.Result;import lombok.extern.slf4j.Slf4j;import org.apache.commons.lang3.StringUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.ResponseBody;@Slf4j@Controller@RequestMapping("/api/tradedata/web")public class BalanceController {	@Autowired	private BalanceService balanceService;	/**	 * 修改账户余额	 * @param mobile,amount	 */	@RequestMapping(value = "/modify/balance",method = RequestMethod.POST)	@ResponseBody	public Result<?> modifyBalance(String mobile,String amount) {		Result result=new Result();		if(StringUtils.isAllBlank(mobile,amount))		{			result.setSuccess(false);			result.setErrorMessage("请求参数为空！");			log.info("mobile: {},amount :{}", mobile,amount);			return result;		}		try{			Result<String> re= balanceService.modifyBalance(mobile,Long.valueOf(amount));			if (re!=null && re.isSuccess()){				result.setSuccessInfo("余额修改成功");				result.setSuccess(true);}			else {				result.setSuccess(false);				result.setErrorMessage(re.getErrorMessage());			}			return result;		}catch (Exception e){			log.error("余额修改异常", e);			result.setErrorMessage("余额修改异常");			result.setSuccess(false);			result.setE(e);		}		return result;	}}