package com.songxiaocai.tradedata.infrastructure.repository.impl;/* * Description:com.songxiaocai.tradedata.infrastructure.repository.impl * @Date Create on 17:14 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-14日SXC All Rights Reserved. */import com.alibaba.fastjson.JSON;import com.songxiaocai.tradedata.application.repository.SxcUserRepository;import com.songxiaocai.tradedata.client.result.SxcUserInfoVO;import com.songxiaocai.tradedata.infrastructure.repository.entity.SxcUser;import com.songxiaocai.tradedata.infrastructure.repository.mapper.SxcUserMapper;import com.songxiaocai.tradedata.service.params.SxcUserInfoDTO;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Repository;import org.springframework.util.CollectionUtils;import java.util.HashMap;import java.util.List;@Slf4j@Repositorypublic class SxcUserRepositoryImpl implements SxcUserRepository {	@Autowired	private SxcUserMapper sxcUserMapper;	@Override	public SxcUserInfoDTO getByMobilePhone(HashMap<String, Object> hs) {		log.info("参数="+ JSON.toJSONString(hs));		SxcUserInfoDTO sxcUserInfoDTO=new SxcUserInfoDTO();		List<SxcUser> sxcuser=sxcUserMapper.getByMobilePhone(hs);		if(CollectionUtils.isEmpty(sxcuser)){			return null;		}		sxcuser.forEach(ss->{			sxcUserInfoDTO.setMobilePhone(ss.getMobilePhone());			sxcUserInfoDTO.setUserId(ss.getUserId());			sxcUserInfoDTO.setUserName(ss.getUserName());			sxcUserInfoDTO.setCityCode(ss.getCityCode());		});		return sxcUserInfoDTO;	}	@Override	public Boolean updatePassword(List<SxcUser> list) {		Integer i=sxcUserMapper.updatePassword(list);		if(i>0){			return true;		}		return false;	}}