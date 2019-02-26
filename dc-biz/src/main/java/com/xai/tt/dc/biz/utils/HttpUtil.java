package com.xai.tt.dc.biz.utils;

import com.alibaba.fastjson.JSON;
import com.xai.tt.dc.biz.mapper.B1VrtyPdNmMapper;
import com.xai.tt.dc.biz.mapper.B3PdNmDrcPrcMapper;
import com.xai.tt.dc.biz.mapper.UserMapper;
import com.xai.tt.dc.client.model.B1VrtyPdNm;
import com.xai.tt.dc.client.model.B3PdNmDrcPrc;
import com.xai.tt.dc.client.model.T1ArInf;

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
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
@SuppressWarnings("deprecation")
@Service("httpUtil")
public final class HttpUtil {
 
	private static HttpClient httpClient = new HttpClient();
	
	@Autowired
	private  B1VrtyPdNmMapper b1VrtyPdNmMapper;
	@Autowired
	private  B3PdNmDrcPrcMapper b3PdNmDrcPrcMapper;
	
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
 
	public void setPrc(String gbName, String quotationTime, float avgPrice) {
		Condition condition = new Condition(B1VrtyPdNm.class);
		Example.Criteria criteria = condition.createCriteria();
		criteria.andCondition("name = '" + gbName + "'");
		criteria.andCondition("folder = '0'");
		List<B1VrtyPdNm> list = b1VrtyPdNmMapper.selectByCondition(condition);
		if(list != null && list.size() > 0) {
			for(B1VrtyPdNm b1 : list) {
				Condition condition1 = new Condition(B3PdNmDrcPrc.class);
				Example.Criteria criteria1 = condition1.createCriteria();
				criteria1.andCondition("Pd_ID = '" + b1.getId() + "'");
				criteria1.andCondition("Acq_Dt = '" + quotationTime + "'");
				List<B3PdNmDrcPrc> list1 = b3PdNmDrcPrcMapper.selectByCondition(condition1);
				if(null != list1 && list1.size() > 0) {
					for(B3PdNmDrcPrc b3 : list1) {
						b3.setSrcDsc(avgPrice + "");
						b3.setTms(new Date());
						b3.setUsername("99999999");
						b3PdNmDrcPrcMapper.updateByPrimaryKey(b3);
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		String url = "http://www.enanchu.com/quotation/1/ajaxQuoteRecordsToday.action";
		Map<String, String> map = new HashMap<String, String>();
		map.put("tabId", "1");
//		map.put("code", "vms2.0");
		String msg = post(url, map);

		String jsonString = JSON.toJSONString(msg);
		jsonString = jsonString.replace("\\", "");
		jsonString = jsonString.substring(1, jsonString.length()-1);

		System.out.println("jsonString=" + jsonString);
		try {
            JSONObject jsonObject = new JSONObject(jsonString);
         // 返回json的数组
            JSONArray jsonArray = jsonObject.getJSONArray("records");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                System.out.println(jsonObject2.getString("gbName"));
                String gbName = jsonObject2.getString("gbName");
                
                //日期
                String quotationTimeFormatString = jsonObject2.getString("quotationTimeFormatString");
                quotationTimeFormatString= quotationTimeFormatString.replace("-", "");
                System.out.println(quotationTimeFormatString);
                

                //均价
                String lowPrice = jsonObject2.getString("lowPrice");
                String highPrice = jsonObject2.getString("highPrice");
                float avgPrice = 0;
                if(StringUtils.isNotBlank(lowPrice)) {
                	avgPrice = (Integer.parseInt(lowPrice) + Integer.parseInt(highPrice))/2;
                	System.out.println(avgPrice);
                } 
                
                setPrc(gbName, quotationTimeFormatString, avgPrice);
                //牌号                
                String quotationType = jsonObject2.getString("quotationType");
                System.out.println(quotationType);
                //涨跌
                String priceRate = jsonObject2.getString("priceRate");
                System.out.println(priceRate);

                              
            }
	} catch (Exception e) {
        // TODO: handle exception
		System.out.println(e);
    }
}
}
