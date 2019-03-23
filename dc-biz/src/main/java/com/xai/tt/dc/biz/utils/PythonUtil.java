package com.xai.tt.dc.biz.utils;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.xai.tt.dc.biz.mapper.B1VrtyPdNmMapper;
import com.xai.tt.dc.biz.mapper.B3PdNmDrcPrcMapper;
import com.xai.tt.dc.biz.mapper.UserMapper;
import com.xai.tt.dc.client.model.B1VrtyPdNm;
import com.xai.tt.dc.client.model.B3PdNmDrcPrc;
import com.xai.tt.dc.client.model.T1ArInf;

import org.springframework.dao.DuplicateKeyException;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
/*@SuppressWarnings("deprecation")
@Service("httpUtil")*/
public final class PythonUtil {
 
	private static HttpClient httpClient = new HttpClient();
	
    public static void main(String[] args) {
        // 获取当前路径
        File directory = new File("");//设定为当前文件夹
        String dirPath = directory.getAbsolutePath();//获取绝对路径
        Process proc;
        try {
            // python解释器路径
            String pyPath = "D:\\sofeware\\python-3.7.2.post1-embed-amd64\\python.exe";
            // python脚本文件路径
     //       String pyFilePath = dirPath+ "bdindex.py";
            String pyFilePath = "D:\\TT\\src\\git-dc\\dc-biz\\src\\main\\java\\com\\xai\\tt\\dc\\biz\\utils\\bdindex.py";
            System.out.println("pyFilePath= " + pyFilePath);
            // 传给python的参数
            String argv1 = "一人之下";
            proc = Runtime.getRuntime().exec(pyPath + " "+ pyFilePath + " " +argv1);
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
	/**
	 * @Title: getDataFromURL
	 * @Description: 根据URL跨域获取输出结果，支持http
	 * @param strURL
	 *            要访问的URL地址
	 * @param param
	 *            参数
	 * @return 结果字符串
	 * @throws Exception
	 */
	public static String getDataFromURL(String strURL, Map<String, String> param) throws Exception {
		URL url = new URL(strURL);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
 
		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		final StringBuilder sb = new StringBuilder(param.size() << 4); // 4次方
		final Set<String> keys = param.keySet();
		for (final String key : keys) {
			final String value = param.get(key);
			sb.append(key); // 不能包含特殊字符
			sb.append('=');
			sb.append(value);
			sb.append('&');
		}
		// 将最后的 '&' 去掉
		sb.deleteCharAt(sb.length() - 1);
		writer.write(sb.toString());
		writer.flush();
		writer.close();
 
		InputStreamReader reder = new InputStreamReader(conn.getInputStream(), "utf-8");
		BufferedReader breader = new BufferedReader(reder);
		// BufferedWriter w = new BufferedWriter(new FileWriter("d:/1.txt"));
		String content = null;
		String result = null;
		while ((content = breader.readLine()) != null) {
			result += content;
		}
 
		return result;
	}
 
	/**
	 * @Title: postMethod
	 * @Description: 根据URL跨域获取输出结果，支持https
	 * @param url
	 *            要访问的URL地址(http://www.xxx.com?)
	 * @param urlParm
	 *            参数(id=1212&pwd=2332)
	 * @return 结果字符串
	 */
	public static String postMethod(String url, String urlParm) {
		if (null == url || "".equals(url)) {
			// url = "http://www.baidu.com";
			return null;
		}
		PostMethod post = new PostMethod(url); // new UTF8PostMethod(url);
		if (null != urlParm && !"".equals(urlParm)) {
			String[] arr = urlParm.split("&");
			NameValuePair[] data = new NameValuePair[arr.length];
			for (int i = 0; i < arr.length; i++) {
				String name = arr[i].substring(0, arr[i].lastIndexOf("="));
				String value = arr[i].substring(arr[i].lastIndexOf("=") + 1);
				data[i] = new NameValuePair(name, value);
			}
			post.setRequestBody(data);
		}
		int statusCode = 0;
		String pageContent = "";
		try {
			statusCode = httpClient.executeMethod(post);
			if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
				pageContent = post.getResponseBodyAsString();
				return pageContent;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			post.releaseConnection();
		}
		return null;
	}
 
	public static String doPost(String url, String json) throws Exception {
		PostMethod postMethod = new PostMethod(url);
		StringRequestEntity requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");
		postMethod.setRequestEntity(requestEntity);
		/* 发送请求，并获取响应对象 */
		int statusCode = httpClient.executeMethod(postMethod);
		String result = null;
		if (statusCode == HttpStatus.SC_OK) {
			result = postMethod.getResponseBodyAsString();
		} else {
			System.out.println("Method failed: " + postMethod.getStatusLine());
		}
		return result;
	}
 
	public static String post(String url, Map<String, String> params) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;
		HttpPost post = postForm(url, params);
		body = invoke(httpclient, post);
		httpclient.getConnectionManager().shutdown();
		return body;
	}
 
	private static HttpPost postForm(String url, Map<String, String> params) {
		HttpPost httpost = new HttpPost(url);
		List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			BasicNameValuePair basicNameValuePair = new BasicNameValuePair(key, params.get(key));
			nvps.add(basicNameValuePair);
		}
		try {
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return httpost;
	}
 
	private static String invoke(DefaultHttpClient httpclient, HttpUriRequest httpost) {
		HttpResponse response = sendRequest(httpclient, httpost);
		String body = paseResponse(response);
		return body;
	}
 
	private static HttpResponse sendRequest(DefaultHttpClient httpclient, HttpUriRequest httpost) {
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
 
	private static String paseResponse(HttpResponse response) {
		HttpEntity entity = response.getEntity();
		String body = null;
		try {
			body = EntityUtils.toString(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}
 

}
