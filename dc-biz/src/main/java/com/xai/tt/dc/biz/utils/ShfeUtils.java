package com.xai.tt.dc.biz.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esotericsoftware.minlog.Log;

/**
 * Created by qqg on 2018/1/3.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 读取Excel
 * 
 * @author zengwendong
 */
public class ShfeUtils {
	private Logger logger = LoggerFactory.getLogger(ShfeUtils.class);

	    private static String openFile(String filePath) {
	        int HttpResult; // 服务器返回的状态
	        String ee = new String();
	        try
	        {
	            URL url =new URL(filePath); // 创建URL
	            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
	            urlconn.connect();
	            HttpURLConnection httpconn =(HttpURLConnection)urlconn;
	            HttpResult = httpconn.getResponseCode();
	            if(HttpResult != HttpURLConnection.HTTP_OK) {
	                System.out.print("无法连接到");
	            } else {
	                int filesize = urlconn.getContentLength(); // 取数据长度
	                InputStreamReader isReader = new InputStreamReader(urlconn.getInputStream(),"UTF-8");
	                BufferedReader reader = new BufferedReader(isReader);
	                StringBuffer buffer = new StringBuffer();
	                String line; // 用来保存每行读取的内容
	                line = reader.readLine(); // 读取第一行
	                while (line != null) { // 如果 line 为空说明读完了
	                    buffer.append(line); // 将读到的内容添加到 buffer 中
	                    buffer.append(" "); // 添加换行符
	                    line = reader.readLine(); // 读取下一行
	                }
	                System.out.print(buffer.toString());
	                ee = buffer.toString();
	            }
	        }
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	        return  ee;
	    }

/*	--------------------- 
	作者：CrazZy651314 
	来源：CSDN 
	原文：https://blog.csdn.net/qinqigang/article/details/78966005 
	版权声明：本文为博主原创文章，转载请附上博文链接！*/
	public static void main(String[] args) {
		try {
			System.out.print(openFile("http://www.shfe.com.cn/data/dailydata/kx/kx20190129.dat"));
			String jsonString = openFile("http://www.shfe.com.cn/data/dailydata/kx/kx20190129.dat");
			System.out.println("jsonString=" + jsonString);
			try {
	            JSONObject jsonObject = new JSONObject(jsonString);
	         // 返回json的数组
	            JSONArray jsonArray = jsonObject.getJSONArray("o_curinstrument");
	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
	                System.out.println(jsonObject2.getString("OPENPRICE"));
/*	                Person person = new Person();
	                person.setId(jsonObject2.getInt("id"));
	                person.setName(jsonObject2.getString("name"));
	                person.setAddress(jsonObject2.getString("address"));
	                list.add(person);*/
	            }
	            
	            JSONObject personObject = jsonObject.getJSONObject("o_curinstrument");
	            System.out.println("personObject=" + personObject);
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
			// generate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
