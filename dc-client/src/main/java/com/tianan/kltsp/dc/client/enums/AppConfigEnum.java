package com.tianan.kltsp.dc.client.enums;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import com.alibaba.fastjson.JSON;

public class AppConfigEnum {

	private FaultNotify faultNotify = FaultNotify.No;
	
	public FaultNotify getFaultNotify() {
		return faultNotify;
	}

	public void setFaultNotify(FaultNotify faultNotify) {
		this.faultNotify = faultNotify;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		Field[] fields = AppConfigEnum.class.getDeclaredFields();
		for (int i=0; i<fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			try {
				BaseEnum baseEnum = (BaseEnum) MethodUtils.invokeMethod(this, "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
				sb.append("\"").append(fieldName).append("\"").append(":").append(baseEnum.getKey());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (i != fields.length - 1) {
				sb.append(",");
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * 将json转换为枚举对象
	 * @param content
	 * @return
	 */
	public static AppConfigEnum convertToEnum(String content) {
		AppConfigEnum app = new AppConfigEnum();
		if (StringUtils.isBlank(content)) {
			return app;
		}
		app = JSON.parseObject(content, AppConfigEnum.class);
		return app;
	}

	public static void main(String[] args) {
		AppConfigEnum app = new AppConfigEnum();
		app.setFaultNotify(FaultNotify.No);
		System.out.println(app);
		
		AppConfigEnum newApp = AppConfigEnum.convertToEnum("{\"faultNotify\":1}");
		System.out.println(newApp);
	}
	
}
