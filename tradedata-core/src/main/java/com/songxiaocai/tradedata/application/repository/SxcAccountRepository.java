package com.songxiaocai.tradedata.application.repository;/* * Description:com.songxiaocai.tradedata.application.repository * @Date Create on 11:41 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-21日SXC All Rights Reserved. */import com.songxiaocai.tradedata.client.result.SxcAccountInfoDTO;public interface SxcAccountRepository {	public SxcAccountInfoDTO getByUserId(Integer userId);	/**	 * 修改账户余额	 * @param userId	 * @param balance	 * @return	 */	public Boolean modifyBalance(Integer userId,Long balance);}