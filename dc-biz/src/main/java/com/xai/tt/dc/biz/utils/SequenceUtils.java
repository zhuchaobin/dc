package com.xai.tt.dc.biz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xai.tt.dc.biz.mapper.TSequenceMapper;
import com.xai.tt.dc.client.model.TSequence;

/**
 * sequence处理工具类
 * zhuchaobin
 * 2018-10-27 
 */
@SuppressWarnings("deprecation")
@Service("sequenceUtils")
public class SequenceUtils {
	private static final Logger logger = LoggerFactory.getLogger(SequenceUtils.class);
	@Autowired
	private TSequenceMapper tSequenceMapper;
	
	public String getSequence(String name, int wideth) {
		try {
			logger.debug("获取squence，参数：name=" + name + ", wideth=" + wideth);
			TSequence ts = new TSequence();
			ts.setName(name);
			Integer currVal = tSequenceMapper.getSequence(ts);
			// 如果到了最大值，则循环从1开始
			if(currVal >= ((int) Math.pow(10, wideth))) {
				logger.debug("获取squence，当前已到最大值：" + currVal);
				try {
					TSequence tSequence = new TSequence();
					tSequence.setName(name);
					tSequence.setBeginNum(1);
					currVal = 1;
					tSequenceMapper.updateByPrimaryKeySelective(tSequence);
				} catch (Exception e) {
					logger.error("重置squence发生异常" + e);
				}
			}
			String strCurrVal = String.format("%0"+ wideth +"d", currVal); 
			logger.debug("获取[" + name + "]squence成功，返回值" + strCurrVal);
			return strCurrVal;
		} catch (Exception e) {
			logger.error("获取squence发生异常" + e);
			return "";
		}		
	}
	
	public static void main(String[] args) {

	}
}
