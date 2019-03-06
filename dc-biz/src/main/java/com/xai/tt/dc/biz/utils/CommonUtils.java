package com.xai.tt.dc.biz.utils;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

/**
 * 通用工具类
 * zhuchaobin
 * 2019-3-6 
 */
@SuppressWarnings("deprecation")
@Service("commonUtils")
public class CommonUtils {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	// 获取空属性
	public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames =  new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue ==  null) emptyNames.add(pd.getName());
        }
        String[] result =  new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
	
	public static void main(String[] args) {

	}
}
