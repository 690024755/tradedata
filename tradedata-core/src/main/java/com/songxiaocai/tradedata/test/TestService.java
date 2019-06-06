package com.songxiaocai.tradedata.test;/* * Description:com.songxiaocai.tradedata.test * @Date Create on 14:04 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-15日SXC All Rights Reserved. */import com.alibaba.fastjson.JSON;import com.songxiaocai.tradedata.application.repository.SxcUserRepository;import com.songxiaocai.tradedata.service.GoodsPriceService;import com.songxiaocai.tradedata.service.params.SxcUserInfoDTO;import com.songxiaocai.tradedata.tool.jedis.JedisTemplate;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.test.context.ContextConfiguration;import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;import org.testng.annotations.Test;import java.util.*;@Slf4j@ContextConfiguration(locations = {"/META-INF/spring/tradedata-context.xml"})public class TestService extends AbstractTestNGSpringContextTests {	@Autowired	private SxcUserRepository sxcUserRepository;	@Autowired	private GoodsPriceService goodsPriceService;	@Autowired	JedisTemplate jedisTemplate;	@Test	public void test1() {		jedisTemplate.set("test", "test");		HashMap<String, Object> hs = new HashMap<String, Object>();		hs.put("mobilePhone", "13093863511");		hs.put("userType", 1);		SxcUserInfoDTO Result = sxcUserRepository.getByMobilePhone(hs);	}	@Test	public void test2() {		String ItemId="9478,10039";		Integer pickhouseId=89;		System.out.println(JSON.toJSONString(goodsPriceService.modifyFreightFee(ItemId,pickhouseId)));		String[] ItemIds=ItemId.split(",");		for(String ItemIdtmp:ItemIds){			goodsPriceService.modifyBasePrice(Integer.valueOf(ItemIdtmp),200L);			goodsPriceService.modifyRaisePrice(Integer.valueOf(ItemIdtmp),100L);		}	}}