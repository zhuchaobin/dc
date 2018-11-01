package com.xai.tt.dc.biz.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.PostAddressMapper;
import com.xai.tt.dc.biz.mapper.T1ARInfMapper;
import com.xai.tt.dc.biz.mapper.T1ARInfMapper_bak;
import com.xai.tt.dc.client.entity.PostAddress;
import com.xai.tt.dc.client.model.T1ARInf;
import com.xai.tt.dc.client.inter.PostAddressDcService;
import com.xai.tt.dc.client.inter.T1ARInfDcService;
import com.xai.tt.dc.client.request.PostAddressDcReq;
import com.xai.tt.dc.client.vo.PostAddressVo;
import com.xai.tt.dc.client.vo.T1ARInfVo;

@SuppressWarnings("deprecation")
@Service("t1ARInfDcService")
public class T1ARInfDcServiceImpl implements T1ARInfDcService{
	private static final Logger logger = LoggerFactory.getLogger(T1ARInfDcServiceImpl.class);
	@Autowired
	private T1ARInfMapper t1ARInfMapper;
	
	/**
	 * 描述：根据长约id修改长约信息
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	@Override
	public Result<Boolean> save(T1ARInf req) {
	        logger.info("start update PostAddress ======> PostAddress:{}", req);
	        try {
	        	t1ARInfMapper.insertSelective(req);
	        } catch (Exception e) {

	            logger.error("根据长约id修改长约信息异常 {}", e);
	            return Result.createFailResult("更新异常");
	        }
	        return Result.createSuccessResult(true);
	}
	
	@Override
    public Result<PageData<T1ARInfVo>> queryPage(T1ARInfVo query, PageParam pageParam) {
		logger.info("start query MaintenanceParm List =======> query:{},page:{}", query, pageParam);
		
	       Page<T1ARInfVo> page = null;
	        int count = 0;
	        if (pageParam != null) {
	            PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
	        }
	        try {
/*	            page = t1ARInfMapper.selectByT1ARInfDcQuery(query);
	            count = t1ARInfMapper.count(query);*/
	        } catch (Exception e) {

	            logger.error("查询长约列表异常 {}", e);
	            return Result.createFailResult("查询异常");
	        }
	        logger.info("query maintenanceParm list success!");
	        return Result.createSuccessResult(new PageData<>(count, page.getResult()));
    }

	
}
