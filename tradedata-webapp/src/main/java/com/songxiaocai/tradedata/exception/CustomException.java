package com.songxiaocai.tradedata.exception;/* * Description:com.songxiaocai.tradedata.exception * @Date Create on 16:35 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-21日SXC All Rights Reserved. */import lombok.AllArgsConstructor;import lombok.Data;import lombok.ToString;@Data@AllArgsConstructor@ToStringpublic class CustomException extends RuntimeException{	private String errorCode;	private String msg;	private Throwable throwable;/*	@Override	public String toString() {		StringBuilder sb= new StringBuilder();		sb.append("【errorCod】:").append(this.errorCode).append("【msg】:").append(this.msg)				.append("【inner Caluse】:").append(null == throwable?"Inner Business Caluse":throwable.toString());		return sb.toString();	}*/}