package com.songxiaocai.tradedata.infrastructure.repository.mapper;/* * Description:com.songxiaocai.tradedata.infrastructure.repository.mapper * @Date Create on 17:10 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-14日SXC All Rights Reserved. */import com.songxiaocai.tradedata.infrastructure.repository.entity.SxcStorehouse;import java.util.HashMap;import java.util.List;public interface SxcStorehouseMapper {	List<SxcStorehouse> getById(Integer id) ;	int modifyCutffTime(HashMap<String, Object> hs) ;}