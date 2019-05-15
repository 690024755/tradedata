package com.songxiaocai.tradedata.filter;/* * Description:com.songxiaocai.tradedata.filter * @Date Create on 16:17 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-21日SXC All Rights Reserved. */import com.songxiaocai.tradedata.tool.jedis.JedisTemplate;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Component;import javax.servlet.*;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import java.io.IOException;@Slf4jpublic class HeaderFilter implements Filter {	Integer SESSION_MAX_AGE = 60 * 60 * 24 * 30;	@Autowired	JedisTemplate jedisTemplate;	@Override	public void init(FilterConfig filterConfig) throws ServletException {	}	@Override	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {		HttpServletRequest request = (HttpServletRequest)servletRequest;		HttpServletResponse response = (HttpServletResponse) servletResponse;		response.setHeader("Access-Control-Allow-Origin","*");		filterChain.doFilter(request, response);	}	@Override	public void destroy() {	}}