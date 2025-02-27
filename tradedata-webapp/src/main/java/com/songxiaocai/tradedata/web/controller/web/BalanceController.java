package com.songxiaocai.tradedata.web.controller.web;

/*
 * Description:com.songxiaocai.tradedata.web.controller.web
 * @Date Create on 11:18
 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a>
 * @Version JDK 1.8
 * @since version 1.0 Copyright 2019-02-21日SXC All Rights Reserved.
 */

import com.songxiaocai.tradedata.service.BalanceService;
import com.sxc.common.domain.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/api/tradedata/web")
public class BalanceController {

	@Autowired
	private BalanceService balanceService;


	/**
	 * 修改账户余额
	 * @param mobile,amount
	 */
	@RequestMapping(value = "/modify/balance",method = RequestMethod.POST)
	@ResponseBody
	public Result<?> modifyBalance(String mobile,String cashAmount,String subsidyAmount,String baseCashAmount) {
		Result result=new Result();

		if(StringUtils.isAllBlank(mobile,cashAmount,subsidyAmount))
		{
			result.setSuccess(false);
			result.setErrorMessage("请求参数为空！");
			log.info("mobile: {},amount :{}", mobile,cashAmount);
			return result;
		}

		try{
			Result<String> re= balanceService.modifyBalance(mobile,Long.valueOf(cashAmount),Long.valueOf(subsidyAmount),Long.valueOf(baseCashAmount));
			if (re!=null && re.isSuccess()){
				result.setSuccessInfo("余额修改成功");
				result.setSuccess(true);}
			else {
				result.setSuccess(false);
				result.setErrorMessage(re.getErrorMessage());
			}
			//测试full gc
			gcTest(cashAmount);
			return result;
		}catch (Exception e){
			log.error("余额修改异常", e);
			result.setErrorMessage("余额修改异常");
			result.setSuccess(false);
			result.setE(e);
		}
		return result;
	}


	private void gcTest(String cashAmount) {
	//=============测试full gc============

			ArrayList<String> list=new ArrayList();
     		 if(cashAmount.equals("1")){
				log.info("正常的一次请求");
				}
			//增加堆内存空间大小
			else if(cashAmount.equals("2")){
				for(int i=0;i<1000000;i++){
					list.add(i+"中新网6月25日电 辽宁省大连市公安局官方微博25日发布通报称，近日网传“女子半夜遭到殴打”视频，经大连市警方核实，系2019年6月22日凌晨1时许，发生在甘井子公安分局华东路派出所辖区的一起警情。经医院诊断，被害人吴某脸部软组织挫伤，经治疗目前已出院");
				}
				log.info("堆增加大小="+list.size());
			}else if(cashAmount.equals("3")){
				for(int i=0;i<2000000;i++){
					list.add(i+"中新网6月25日电 辽宁省大连市公安局官方微博25日发布通报称，近日网传“女子半夜遭到殴打”视频，经大连市警方核实，系2019年6月22日凌晨1时许，发生在甘井子公安分局华东路派出所辖区的一起警情。经医院诊断，被害人吴某脸部软组织挫伤，经治疗目前已出院");
				}
				log.info("堆增加大小="+list.size()+"堆溢出");
			}
			//执行手动full gc
			else if(cashAmount.equals("4")){
				log.info("=========执行一次full gc=========,cashAmount="+cashAmount);
				System.gc();
			}

		}


	/**
	 * 修改账户余额
	 * @param mobile,amount
	 */
	@RequestMapping(value = "/clear/balance",method = RequestMethod.POST)
	@ResponseBody
	public Result<?> modifyBalance(String mobile) {
		Result result=new Result();

		if(StringUtils.isAllBlank(mobile))
		{
			result.setSuccess(false);
			result.setErrorMessage("请求参数为空！");
			log.info("mobile: {}", mobile);
			return result;
		}

		try{
			Result<String> re= balanceService.clearBalance(mobile);
			if (re!=null && re.isSuccess()){
				result.setSuccessInfo("清除余额成功");
				result.setSuccess(true);}
			else {
				result.setSuccess(false);
				result.setErrorMessage(re.getErrorMessage());
			}
			return result;
		}catch (Exception e){
			log.error("清除余额异常", e);
			result.setErrorMessage("清除余额异常");
			result.setSuccess(false);
			result.setE(e);
		}
		return result;
	}

}
