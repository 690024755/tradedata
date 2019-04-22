package com.songxiaocai.tradedata.web.controller.web;/* * Description:com.songxiaocai.tradedata.web.controller.web * @Date Create on 17:48 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-04-02日SXC All Rights Reserved. */import com.alibaba.fastjson.JSON;import com.songxiaocai.tradedata.service.GatewayService;import com.sxc.common.domain.result.Result;import lombok.extern.slf4j.Slf4j;import org.apache.commons.lang3.StringUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.ResponseBody;import java.util.ArrayList;import java.util.HashMap;import java.util.List;@Slf4j@Controller@RequestMapping("/api/tradedata/web")public class GatewayController {	@Autowired	private GatewayService gatewayService;	@RequestMapping(value = "/apiNameDeploy",method = RequestMethod.POST)	@ResponseBody	public Result<?> apiNameDeploy(String apiNames) {		Result result=new Result();		Integer num=0;		if(StringUtils.isAllBlank(apiNames))		{			result.setSuccess(false);			result.setErrorMessage("请求参数为空！");			log.info("apiNames: {}", apiNames);			return result;		}		try{			String[] apiNameArray = apiNames.split("\n");			HashMap<String,String> deployResult=new HashMap<String,String>();			for (String apiName : apiNameArray) {				Result<String> re=gatewayService.modifyApiDefine(apiName);				if(!re.isSuccess()){					deployResult.put("apiName="+apiName,re.getErrorMessage());					num++;				}			}			if( deployResult.size()>0){				result.setErrorMessage("稳定测试环境网关部署失败条数="+num+",ErrorMessage="+ JSON.toJSONString(deployResult));				result.setSuccess(false);				result.setData(deployResult);				return result;			}			result.setSuccessInfo("稳定测试环境网关部署成功");			result.setSuccess(true);		}catch (Exception e){			log.error("稳定测试环境网关部署异常", e);			result.setSuccessInfo("稳定测试环境网关部署异常");			result.setSuccess(false);			result.setE(e);			return result;		}		return result;	}	@RequestMapping(value = "/apiNameDeployTest",method = RequestMethod.POST)	@ResponseBody	public Result<?> apiNameDeployTest(String apiNames) {		Result result=new Result();		if(StringUtils.isAllBlank(apiNames))		{			result.setSuccess(false);			result.setErrorMessage("请求参数为空！");			log.info("apiNames: {}", apiNames);			return result;		}		try{			String[] apiNameArray = apiNames.split("\n");			for (String apiName : apiNameArray) {			}			result.setSuccessInfo("稳定测试环境网关部署开发当中");			result.setSuccess(true);		}catch (Exception e){			log.error("稳定测试环境网关部署异常", e);			result.setSuccessInfo("稳定测试环境网关部署异常");			result.setSuccess(false);		}		return result;	}}