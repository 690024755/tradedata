package com.songxiaocai.tradedata.client.result;/* * Description:com.songxiaocai.tradedata.client.result * @Date Create on 17:19 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-14日SXC All Rights Reserved. */import lombok.Data;import java.io.Serializable;import java.util.Date;@Datapublic class SxcAccountInfoDTO {	private Integer id;	private Integer userId;	private Integer accountId;	/**	 * 余额	 */	private Long balance;	private Date createTime;	/**	 * 0:删除 1:可用	 */	private Integer state;	/**	 * 红包账户余额	 */	private Long subsidyBalance;	/**	 * 现金账户余额	 */	private Long cashBalance;	/**	 * 充值送本金余额	 */	private Long baseCashBalance;}