package com.songxiaocai.tradedata.service;/* * Description:com.songxiaocai.tradedata.service * @Date Create on 18:18 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-25日SXC All Rights Reserved. */import com.alibaba.fastjson.JSON;import com.alibaba.fastjson.JSONObject;import com.songxiaocai.tradedata.application.repository.SxcUserRepository;import com.songxiaocai.tradedata.service.params.SxcUserInfoDTO;import com.songxiaocai.tradedata.tool.date.DateTool;import com.songxiaocai.tradedata.tool.http.HttpRequestSimple;import com.songxiaocai.tradedata.tool.jedis.JedisTemplate;import com.songxiaocai.tradedata.tool.map.MapUtil;import com.sxc.common.domain.result.Result;import com.sxc.midgard.activitydubbo.constant.enums.CouponRangeTypeEnum;import com.sxc.midgard.activitydubbo.params.coupon.CouponDTO;import com.sxc.midgard.activitydubbo.params.coupon.GiveOutDTO;import com.sxc.midgard.activitydubbo.params.coupon.OrderInfoDTO;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Component;import java.util.*;@Component@Slf4jpublic class CouponsService {	@Autowired	private HttpRequestSimple httpclent;	@Autowired	private JedisTemplate jedisTemplate;	@Autowired	private SxcUserRepository sxcUserRepository;	/*	给用户发放代金券	 */	public Result<String> sendCoupons(String mobile,Integer couponType){		Result<String> re=new Result<>();		Map<String,Object> hashmap=new HashMap<>();		String response=null;		SxcUserInfoDTO sxcUserInfoDTO=sxcUserRepository.getByMobilePhone(mobile);		Integer userId=sxcUserInfoDTO.getUserId();		CouponDTO couponDTO=new CouponDTO();		try{			if(couponType.equals(CouponRangeTypeEnum.ALL.getId())){				couponDTO.setCatIdArray("[152]");				//商品分组类				couponDTO.setGoodsGroupIds("[1]");			}else if(couponType.equals(CouponRangeTypeEnum.CAT.getId())){				couponDTO.setCatIdArray("[152]");				couponDTO.setGoodsGroupIds("[]");			} else if(couponType.equals(CouponRangeTypeEnum.GOODS_GROUP.getId())){				//商品分组类				couponDTO.setGoodsGroupIds("[1]");				couponDTO.setCatIdArray("[]");			}else {				re.setSuccess(false);				re.setErrorMessage("输入的代金券类型不正确");				return re;			}			//代金券有效时间			couponDTO.setBeginTimeStr(DateTool.getCurrentTime());			//代金券有效时间			couponDTO.setEndTimeStr(DateTool.getCurrentDayEndTime());			//折扣力度：10%（可抵扣最高金额=订单金额*（1-抵扣力度））			couponDTO.setDurationTime(10);			//代金券面额			couponDTO.setFee(10000L);            //归属品类			couponDTO.setAttachCat(152);			//可用品类			//代金券类型			couponDTO.setUseType(0);			//代金券发放原因			couponDTO.setDescription("测试");			//小b用户的userid			couponDTO.setUserId(userId);			GiveOutDTO giveOutDTO=new GiveOutDTO();			giveOutDTO.setCouponDTO(couponDTO);			List<OrderInfoDTO> orderInfos=new ArrayList<>();			giveOutDTO.setOrderInfos(orderInfos);			hashmap.put("giveOutDTO",JSON.toJSONString(giveOutDTO));			hashmap.put("appKey","18701298");			hashmap.put("clientSysName","pcweb");			hashmap.put("clientSysVersion","1.0.0");			hashmap.put("clientVersion","1.0.0");			hashmap.put("deviceUUID","af9947469f3ec84f5308c223ad706a0a");			StringBuffer redis_key=new StringBuffer("18888888888").append("-").append("18701298").append("-").append("erp_login");			String cookie=String.valueOf(jedisTemplate.get(redis_key.toString()));			log.info("代金券发放请求报文:" + MapUtil.mapToString(hashmap));			String url="https://gateway.songxiaocai.net/gw/api/songxiaocai.activity.coupon.giveout";			response = httpclent.postSendHttpApi(url,cookie,MapUtil.mapToString(hashmap));			log.info("代金券发放返回报文:" + response);			//TODO			Object resultResponse=JSONObject.parse(response);			if(false){				System.out.println("解析对象类型");			}		}catch (Exception e){			log.error("代金券发放返回报文: {}", MapUtil.mapToString(hashmap), e);			re.setSuccess(false);			re.setErrorMessage("发放代金券失败");			return re;		}		re.setData(response);		re.setSuccess(true);        return re;	}}