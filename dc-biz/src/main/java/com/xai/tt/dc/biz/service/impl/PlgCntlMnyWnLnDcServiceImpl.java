package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.client.service.PlgCntlMnyWnLnDcService;
import com.xai.tt.dc.client.vo.PlgCntlMnyWnLnVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("deprecation")
@Service("plgCntlMnyWnLnDcService")
public class PlgCntlMnyWnLnDcServiceImpl implements PlgCntlMnyWnLnDcService {
	private static final Logger logger = LoggerFactory.getLogger(PlgCntlMnyWnLnDcServiceImpl.class);
	@Autowired
	private B5PlgCntlMnyWnLnMapper b5PlgCntlMnyWnLnMapper;
	/**
	 * 描述：删除质押控货预警
	 * 
	 * @author
	 */
	@Override
	public Result<Boolean> delete(String id) {
		logger.info("删除质押控货预警,请求参数:{}", id);
		try {
			b5PlgCntlMnyWnLnMapper.deleteByPrimaryKey(Long.parseLong(id));
			logger.info("删除质押控货预警成功!");
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除质押控货预警异常 {}", e);
			return Result.createFailResult("删除质押控货预警异常" + e);
		}
	}


	/**
	 * 描述：查询质押控货预警列表（分页）
	 * 
	 * @author
	 */
	@Override
	public Result<PageData<PlgCntlMnyWnLnVo>> queryPage(PlgCntlMnyWnLnVo query, PageParam pageParam) {
		logger.info("start query 质押控货预警信息 List =======> query:{},page:{}", query, pageParam);

		Page<PlgCntlMnyWnLnVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		} 
		try {
			page = b5PlgCntlMnyWnLnMapper.selectByPage(query);
			count = b5PlgCntlMnyWnLnMapper.count(query);
		} catch (Exception e) {
			logger.error("查询质押控货预警列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("queryPage success!{}", JSON.toJSON(page));
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}

	/**
	 * 描述：查询质押控货预警详情
	 * 
	 * @author
	 */
	@Override
	public Result<PlgCntlMnyWnLnVo> queryDetail(PlgCntlMnyWnLnVo query) {
		logger.info("查询质押控货预警详情,请求参数:{}", JSON.toJSONString(query));
		try {
			PlgCntlMnyWnLnVo PlgCntlMnyWnLnVo = b5PlgCntlMnyWnLnMapper.queryDetail(query);
			if (PlgCntlMnyWnLnVo == null) {
				logger.error("查询质押控货预警详情无数据");
				return Result.createFailResult("查询质押控货预警详情无数据");
			} else {
				// 查询质押控货预警明细
				Result<PlgCntlMnyWnLnVo> rlt = new Result<PlgCntlMnyWnLnVo>();
				rlt.setData(PlgCntlMnyWnLnVo);
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询质押控货预警详情异常 {}", e);
			return Result.createFailResult("查询质押控货预警详情异常" + e);
		}
	}	
}
