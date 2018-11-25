package com.xai.tt.dc.biz.utils;

import java.util.Date;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xai.tt.dc.biz.mapper.ActRuTaskMapper;
import com.xai.tt.dc.biz.mapper.T0LnkJrnlInfMapper;
import com.xai.tt.dc.biz.mapper.TSequenceMapper;
import com.xai.tt.dc.client.model.T0LnkJrnlInf;
import com.xai.tt.dc.client.model.TSequence;
import com.xai.tt.dc.client.query.WfeQuery;
import com.xai.tt.dc.client.vo.inVo.TB0001InVo;

/**
 * 工作流相关功能
 * zhuchaobin
 * 2018-11-20 
 */
@SuppressWarnings("deprecation")
@Service("wfeUtils")
public class WfeUtils {
	private static final Logger logger = LoggerFactory.getLogger(WfeUtils.class);
	@Autowired
	private T0LnkJrnlInfMapper t0LnkJrnlInfMapper;
	@Autowired
	private ActRuTaskMapper actRuTaskMapper;
	/*
	 * 保存环节流水信息
	 * 2018-11-20
	 */
	public void saveLnkJrnlInf(T0LnkJrnlInf t0) {
		logger.info("保存环节流水信息开始");
		try {
			t0.setInlzTm(new Date());
			t0.setLnkSttm(new Date());
			t0.setLnkEdtm(new Date());
			t0LnkJrnlInfMapper.insertSelective(t0);
			logger.info("保存环节流水信息成功");
		} catch (Exception e) {
			logger.error("保存环节流水信息成功" + e);
		}		
	}
		
	public static void main(String[] args) {

	}
}
