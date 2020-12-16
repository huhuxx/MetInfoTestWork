package com.Interface.controller;

import java.io.IOException;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.cookie.Cookie;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.cookie.StandardCookieSpec;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import net.sf.json.JSONObject;
/**
 * 
 * @author sunyingjiao
 *
 */

public class HttpDriver {
	
	public static JSONObject doGet(String url,CookieStore cookies) throws IOException, ParseException {
		
		RequestConfig config=RequestConfig.custom().
				setCookieSpec(StandardCookieSpec.STRICT).build();
		CloseableHttpClient client=HttpClients.custom().
				setDefaultRequestConfig(config)
				.setDefaultCookieStore(cookies).build();
		
		HttpGet get = new HttpGet(url);

		CloseableHttpResponse response = client.execute(get);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
//		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

//		List<Cookie> listCookies=cookies.getCookies();
//		for (Cookie cookie : listCookies) {
//			System.out.println(cookie.getName()+":"+cookie.getValue());
//		}
		
		return result;
	}

	public static JSONObject doGet(String url) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet get = new HttpGet(url);

		CloseableHttpResponse response = client.execute(get);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		
		return result;

	}
	
	public static JSONObject doGet(String url,String para) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet get = new HttpGet(url+para);

		CloseableHttpResponse response = client.execute(get);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		return result;

	}

	public static JSONObject doPost(String url, JSONObject body) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();
		
		
		HttpPost post=new HttpPost(url);
		HttpEntity requestEntity=new StringEntity(body.toString());
		post.setHeader("Content-Type","application/json;charset=utf-8");
		post.setEntity(requestEntity);

		CloseableHttpResponse response = client.execute(post);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		return result;

	}

	public static JSONObject doPost(String url, String formbody) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();
		
		
		HttpPost post=new HttpPost(url);
		HttpEntity requestEntity=new StringEntity(formbody);
//		post.setHeader("Content-Type","application/json;charset=utf-8");
		post.setEntity(requestEntity);

		CloseableHttpResponse response = client.execute(post);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		return result;

	}
	public static JSONObject doPut(String url, String formbody) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPut put=new HttpPut(url);
		HttpEntity requestEntity=new StringEntity(formbody);
		put.setHeader("Content-Type","application/json;charset=utf-8");
		put.setEntity(requestEntity);

		CloseableHttpResponse response = client.execute(put);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		return result;

	}
	public static JSONObject doPut(String url, JSONObject body) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPut put=new HttpPut(url);
		HttpEntity requestEntity=new StringEntity(body.toString());
		put.setHeader("Content-Type","application/json;charset=utf-8");
		put.setEntity(requestEntity);

		CloseableHttpResponse response = client.execute(put);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		return result;

	}
	
	public static JSONObject doDelete(String url) throws IOException, ParseException {
		CloseableHttpClient client = HttpClients.createDefault();

		HttpDelete delete = new HttpDelete(url);

		CloseableHttpResponse response = client.execute(delete);

		HttpEntity entity = response.getEntity();
		String strResult = EntityUtils.toString(entity);
		System.out.println(strResult);

		EntityUtils.consume(entity);
		response.close();
		client.close();

		JSONObject result = JSONObject.fromObject(strResult);

		
		return result;

	}
}
