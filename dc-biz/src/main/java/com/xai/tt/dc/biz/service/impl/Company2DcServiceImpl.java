package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.biz.utils.*;
import com.xai.tt.dc.client.model.*;
import com.xai.tt.dc.client.service.Company2DcService;
import com.xai.tt.dc.client.vo.inVo.Company2InVo;
import com.xai.tt.dc.client.vo.outVo.Company2OutVo;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * 企业信息2dc 服务实现类
 * </pre>
 * <small> 2019-03-23 23:10:26 | zhuchaobin</small>
 */
 
 @SuppressWarnings("deprecation")
@Service("company2DcService")
public class Company2DcServiceImpl implements Company2DcService {
	private static final Logger logger = LoggerFactory.getLogger(Company2DcServiceImpl.class);
	@Autowired
	private Company2Mapper company2Mapper;

	/**
	 * 描述：保存企业信息2
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	@Override
	public Result<String> save(Company2InVo inVo) {
		logger.info("save企业信息2请求报文{inVo}", JSON.toJSONString(inVo));
		logger.info("二级服务码secSrvCd：" + inVo.getSecSrvCd());
		try {
			if(null == inVo.getId()){
				// 新建企业信息2
				Company company2 = new Company();
				BeanUtils.copyProperties(inVo, company2);
				company2.setCreateTime(new Date());
				Integer count = company2Mapper.insert(company2);
				logger.info("insert 企业信息2 成功，条数：" + count);
			} else {
				// 更新企业信息2
				Company company2 = new Company();
				BeanUtils.copyProperties(inVo, company2);
				Integer count = company2Mapper.updateByPrimaryKeySelective(company2);
				logger.info("update 企业信息2 成功，条数：" + count);			
			}
			return Result.createSuccessResult("保存企业信息2成功！");
		} catch (Exception e) {
			logger.error("保存企业信息2异常 {}", e);
			return Result.createFailResult("保存企业信息2异常：" + e);
		}
	}

	/**
	 * 描述：查询企业信息2列表（分页）
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	@Override
	public Result<PageData<Company2OutVo>> queryPage(Company2InVo inVo, PageParam pageParam) {
		logger.info("start queryPage 企业信息2 =======> inVo:{}, pageParam:{}", JSON.toJSONString(inVo), pageParam);
		logger.info("userType:" + inVo.getUserType());
		logger.info("orderBy:" + inVo.getOrderBy());
		logger.info("getSortName:" + inVo.getSortName());
		logger.info("getSortOrder:" + inVo.getSortOrder());

		Page<Company2OutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = company2Mapper.queryPage(inVo);
			count = company2Mapper.count(inVo);
			logger.info("分页查询企业信息2成功:{}", JSON.toJSON(page));
			return Result.createSuccessResult(new PageData<>(count, page.getResult()));
		} catch (Exception e) {
			logger.error("分页查询企业信息2异常 {}", e);
			return Result.createFailResult("查询企业信息2异常:" + e);
		}
	}

	/**
	 * 描述：查询企业信息2详情（主键）
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	@Override
	public Result<Company2OutVo> getDetailById(Integer id){
		logger.info("按主键查询企业信息2详情,请求参数:{}", id);
		try {
			Company2OutVo outVo = company2Mapper.getDetailById(id);
			if (null == outVo) {
				logger.error("查询企业信息2详情无数据");
				return Result.createFailResult("查询查询企业信息2详情无数据");
			} else {
				Result<Company2OutVo> rlt = new Result<Company2OutVo>();
				rlt.setData(outVo);
				logger.info("查询企业信息2详情成功:{}", JSON.toJSONString(rlt));
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询企业信息2详情异常 {}", e);
			return Result.createFailResult("查询企业信息2详情异常" + e);
		}
	}
	
	/**
	 * 描述：查询企业信息2详情（按条件）
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	@Override
	public Result<Company2OutVo> getDetailByCondition(Company2InVo inVo){
		logger.info("按主键查询企业信息2详情,请求参数:{}", JSON.toJSONString(inVo));
		try {
			Company2OutVo outVo = company2Mapper.getDetailByCondition(inVo);
			if (null == outVo) {
				logger.error("查询企业信息2详情无数据");
				return Result.createFailResult("查询查询企业信息2详情无数据");
			} else {
				Result<Company2OutVo> rlt = new Result<Company2OutVo>();
				rlt.setData(outVo);
				logger.info("查询企业信息2详情成功:{}", JSON.toJSONString(rlt));
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询企业信息2详情异常 {}", e);
			return Result.createFailResult("查询企业信息2详情异常" + e);
		}
	}
	
	/**
	 * 描述：按id删除企业信息2
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	@Override
	public Result<String> batchDelete(String ids) {
		logger.info("batchDelete 企业信息2,请求参数:{}", ids);
		try {
			company2Mapper.deleteByIds(ids);
			logger.info("按id删除企业信息2成功!");
			return Result.createSuccessResult("按id删除企业信息2成功！");
		} catch (Exception e) {
			logger.error("按id删除企业信息2异常 {}", e);
			return Result.createFailResult("按id删除企业信息2异常：" + e);
		}
	}	
}