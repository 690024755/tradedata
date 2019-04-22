package com.songxiaocai.tradedata.infrastructure.repository.impl;/* * Description:com.songxiaocai.tradedata.infrastructure.repository.impl * @Date Create on 10:57 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-04-22日SXC All Rights Reserved. */import com.songxiaocai.tradedata.application.repository.SxcOrderRepository;import com.songxiaocai.tradedata.infrastructure.repository.entity.SxcOrder;import com.songxiaocai.tradedata.infrastructure.repository.mapper.SxcOrderMapper;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Repository;import org.springframework.util.CollectionUtils;import java.util.HashMap;import java.util.List;@Repositorypublic class SxcOrderRepositoryImpl implements SxcOrderRepository {	@Autowired	SxcOrderMapper sxcOrderMapper;	@Override	public List<SxcOrder> getByBuyerId(Integer buyerId) {		List<SxcOrder> lists=sxcOrderMapper.getByBuyerId(buyerId);		return lists;	}	/**	 * 单条修改用户主订单记录为失效	 * @param state	 * @param buyerId	 * @return	 */	@Override	public Boolean modifyState(Integer buyerId,Integer state) {		HashMap<String,Object> map=new HashMap();		map.put("state",state);		map.put("buyerId",buyerId);		int num =sxcOrderMapper.modifyStatee(map);		if(num<0){			return false;		}		return true;	}}