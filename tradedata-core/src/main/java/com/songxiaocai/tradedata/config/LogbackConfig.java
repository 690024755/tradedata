//package com.songxiaocai.tradedata.config;/////*// * Description:com.songxiaocai.tradedata.test// * @Date Create on 16:43// * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a>// * @Version JDK 1.8// * @since version 1.0 Copyright 2019-02-27日SXC All Rights Reserved.// *///////import ch.qos.logback.classic.LoggerContext;//import ch.qos.logback.classic.joran.JoranConfigurator;//import lombok.NoArgsConstructor;//import lombok.extern.slf4j.Slf4j;//import org.slf4j.LoggerFactory;////import javax.annotation.PostConstruct;//import java.net.URL;////@NoArgsConstructor//@Slf4j////@Component////public class LogbackConfig {//	public final static String Default_logback_file= "logback.xml";////////	private  URL url=null;//	public static LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();//	public static JoranConfigurator configurator = new JoranConfigurator();//	LogbackConfig(URL url) {//		this.url=url;//	}////public void loadLogback(){//	configurator.setContext(lc);//	lc.reset();//	try {//		if(url==null){//			URL ll=this.getClass().getResource("/"+Default_logback_file);//		setUrl(ll);//			configurator.doConfigure(ll);//		}//		configurator.doConfigure(url);//	} catch (Exception e) {//		log.error("logback配合文件加载失败",e);//	}////}////	@PostConstruct//	public void init(){//		loadLogback();////	}////	public URL getUrl() {//		return url;//	}////	public void setUrl(URL url) {//		this.url = url;//	}////}