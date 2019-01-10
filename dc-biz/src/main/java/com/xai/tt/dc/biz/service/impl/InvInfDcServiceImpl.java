package com.xai.tt.dc.biz.service.impl;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.T12InvInfMapper;
import com.xai.tt.dc.client.model.T12InvInf;
import com.xai.tt.dc.client.service.InvInfDcService;
import com.xai.tt.dc.client.vo.QueryPageInvInfVo;

@SuppressWarnings("deprecation")
@Service("invInfDcService")
public class InvInfDcServiceImpl implements InvInfDcService {
	private static final Logger logger = LoggerFactory.getLogger(InvInfDcServiceImpl.class);
	@Autowired
	private T12InvInfMapper t12InvInfMapper;
	
	/*保存或者更新发票信息*/
	public Result<Boolean> save(QueryPageInvInfVo query){
		logger.info("保存或者更新发票信息  =======> query:{}", query);
		try {
			T12InvInf t12 = new T12InvInf();
			t12.setId(query.getId());
			t12.setIssubillPsn(query.getUsername());
			t12.setIssubillTm(new Date());
			t12InvInfMapper.updateByPrimaryKeySelective(t12);
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("更新发票信息异常 {}", e);
			return Result.createFailResult("更新发票信息异常：" + e);
		}		
	}
	/*分页查询*/
	public Result<PageData<QueryPageInvInfVo>>  queryPage(QueryPageInvInfVo query, PageParam pageParam){
		logger.info("start query 发票信息 List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		logger.info("orderBy:" + query.getOrderBy());
		logger.info("getSortName:" + query.getSortName());
		logger.info("getSortOrder:" + query.getSortOrder());
		// 查询发票信息
		Page<QueryPageInvInfVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = t12InvInfMapper.selectByPage(query);
			count = t12InvInfMapper.count(query);
		} catch (Exception e) {

			logger.error("查询发票列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("query maintenanceParm list success!");
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}
	/*查询明细*/
	public Result<QueryPageInvInfVo> queryDetail(String id){
		QueryPageInvInfVo vo = null;
		vo = t12InvInfMapper.queryDetail(Integer.parseInt(id));
		return Result.createSuccessResult(vo);
		
	}
	/*按id删除*/
	public Result<Boolean> delete(String id){
		logger.info("start delete发票信息 =======> id:{}", id);
		try {
			t12InvInfMapper.deleteByPrimaryKey(id);
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除发票信息异常 {}", e);
			return Result.createFailResult("删除发票信息异常[" + e + "]");
		}		
	}

}
