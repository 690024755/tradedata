package com.songxiaocai.tradedata.application.repository;/* * Description:com.songxiaocai.tradedata.application.repository * @Date Create on 18:16 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-14日SXC All Rights Reserved. */import com.songxiaocai.tradedata.infrastructure.repository.entity.SxcStorehouse;import java.util.List;public interface SxcStorehouseRepository {	 List<SxcStorehouse> getById(Integer id);	int modifyCutffTime(String cutoffTime,Integer id);}