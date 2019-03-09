package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.client.service.IvntDtlDcService;
import com.xai.tt.dc.client.vo.inVo.IvntDtlInVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageIvntDtlOutVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("deprecation")
@Service("ivntDtlDcService")
public class IvntDtlDcServiceImpl implements IvntDtlDcService {
	private static final Logger logger = LoggerFactory.getLogger(IvntDtlDcServiceImpl.class);
	@Autowired
	private T17IvntDtlMapper t17IvntDtlMapper;
	/**
	 * 描述：删除库存信息
	 * 
	 * @author
	 */
	@Override
	public Result<Boolean> delete(String id) {
		logger.info("删除库存信息,请求参数:{}", id);
		try {
			t17IvntDtlMapper.deleteByPrimaryKey(Long.parseLong(id));
			logger.info("删除库存信息成功!");
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除库存信息异常 {}", e);
			return Result.createFailResult("删除库存信息异常" + e);
		}
	}


	/**
	 * 描述：查询库存信息列表（分页）
	 * 
	 * @author
	 */
	@Override
	public Result<PageData<QueryPageIvntDtlOutVo>> queryPage(IvntDtlInVo query, PageParam pageParam) {
		logger.info("start query 库存信息信息 List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		logger.info("orderBy:" + query.getOrderBy());
		logger.info("getSortName:" + query.getSortName());
		logger.info("getSortOrder:" + query.getSortOrder());

		Page<QueryPageIvntDtlOutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		} 
		try {
			page = t17IvntDtlMapper.selectByPage(query);
			count = t17IvntDtlMapper.count(query);
		} catch (Exception e) {
			logger.error("查询库存信息列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("queryPage success!{}", JSON.toJSON(page));
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}

	/**
	 * 描述：查询库存信息详情
	 * 
	 * @author
	 */
	@Override
	public Result<QueryPageIvntDtlOutVo> queryDetail(IvntDtlInVo query) {
		logger.info("查询库存信息详情,请求参数:{}", JSON.toJSONString(query));
		try {
			QueryPageIvntDtlOutVo queryPageIvntDtlOutVo = t17IvntDtlMapper.queryDetail(query.getId() + "");
			if (queryPageIvntDtlOutVo == null) {
				logger.error("查询库存信息详情无数据");
				return Result.createFailResult("查询库存信息详情无数据");
			} else {
				// 查询库存信息明细
				Result<QueryPageIvntDtlOutVo> rlt = new Result<QueryPageIvntDtlOutVo>();
				rlt.setData(queryPageIvntDtlOutVo);
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询库存信息详情异常 {}", e);
			return Result.createFailResult("查询库存信息详情异常" + e);
		}
	}
}
