package com.songxiaocai.tradedata.tool.http;/* * Description:com.songxiaocai.tradedata.http * @Date Create on 14:01 * @author <a href="mailto:yangyi@songxiaocai.com">yangyi</a> * @Version JDK 1.8 * @since version 1.0 Copyright 2019-02-25日SXC All Rights Reserved. */import lombok.extern.slf4j.Slf4j;import org.apache.http.HttpVersion;import org.apache.http.client.HttpClient;import org.apache.http.conn.ClientConnectionManager;import org.apache.http.conn.params.ConnManagerParams;import org.apache.http.conn.params.ConnPerRouteBean;import org.apache.http.conn.scheme.PlainSocketFactory;import org.apache.http.conn.scheme.Scheme;import org.apache.http.conn.scheme.SchemeRegistry;import org.apache.http.conn.ssl.SSLSocketFactory;import org.apache.http.impl.client.DefaultHttpClient;import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;import org.apache.http.params.BasicHttpParams;import org.apache.http.params.HttpConnectionParams;import org.apache.http.params.HttpParams;import org.apache.http.params.HttpProtocolParams;import org.apache.http.protocol.HTTP;import java.io.IOException;import java.security.*;import java.security.cert.CertificateException;@Slf4jpublic class CustomHttpClient {	private static HttpClient customHttpClient;	private static final int  TIME_OUT = 1000 * 60;	private CustomHttpClient()	{	}	public static HttpClient GetHttpClient()	{		return httpClientInstance();	}	private static HttpClient httpClientInstance()	{		KeyStore trustStore;		SSLSocketFactory sf = null;		try		{			trustStore = KeyStore.getInstance(KeyStore.getDefaultType());			trustStore.load(null, null);			sf = new MySSLSocketFactory(trustStore);			sf					.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);		} catch (KeyManagementException e)		{			log.error(e.getMessage(), e);		} catch (NoSuchAlgorithmException e)		{			log.error(e.getMessage(), e);		} catch (UnrecoverableKeyException e)		{			log.error(e.getMessage(), e);		} catch (IOException e)		{			log.error(e.getMessage(), e);		} catch (CertificateException e)		{			log.error(e.getMessage(), e);		} catch (KeyStoreException e)		{			log.error(e.getMessage(), e);		}		HttpParams params = new BasicHttpParams();		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);		ConnManagerParams.setTimeout(params, TIME_OUT);		ConnManagerParams.setMaxConnectionsPerRoute(params,new ConnPerRouteBean(100));		ConnManagerParams.setMaxTotalConnections(params,500);		HttpConnectionParams.setConnectionTimeout(params, TIME_OUT);		HttpConnectionParams.setSoTimeout(params, TIME_OUT);		SchemeRegistry schReg = new SchemeRegistry();		schReg.register(new Scheme("http", PlainSocketFactory				.getSocketFactory(), 80));		schReg.register(new Scheme("https", sf, 443));		ClientConnectionManager conMgr = new ThreadSafeClientConnManager(				params, schReg);		customHttpClient = new DefaultHttpClient(conMgr, params);		return customHttpClient;	}	public Object clone() throws CloneNotSupportedException	{		throw new CloneNotSupportedException();	}}