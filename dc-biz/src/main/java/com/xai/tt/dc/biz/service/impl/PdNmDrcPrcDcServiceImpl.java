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
import com.xai.tt.dc.client.service.PdNmDrcPrcDcService;
import com.xai.tt.dc.client.vo.inVo.PdNmDrcPrcInVo;
import com.xai.tt.dc.client.vo.outVo.PdNmDrcPrcOutVo;
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
 * 品名指导价dc 服务实现类
 * </pre>
 * <small> 2019-03-21 15:23:49 | zhuchaobin</small>
 */
 
 @SuppressWarnings("deprecation")
@Service("pdNmDrcPrcDcService")
public class PdNmDrcPrcDcServiceImpl implements PdNmDrcPrcDcService {
	private static final Logger logger = LoggerFactory.getLogger(PdNmDrcPrcDcServiceImpl.class);
	@Autowired
	private B3PdNmDrcPrcMapper b3PdNmDrcPrcMapper;

	/**
	 * 描述：保存品名指导价
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	@Override
	public Result<String> save(PdNmDrcPrcInVo inVo) {
		logger.info("save品名指导价请求报文{inVo}", JSON.toJSONString(inVo));
		logger.info("二级服务码secSrvCd：" + inVo.getSecSrvCd());
		try {
			if(null == inVo.getId()){
				// 新建品名指导价
				B3PdNmDrcPrc b3PdNmDrcPrc = new B3PdNmDrcPrc();
				BeanUtils.copyProperties(inVo, b3PdNmDrcPrc);
				b3PdNmDrcPrc.setTms(new Date());
				Integer count = b3PdNmDrcPrcMapper.insert(b3PdNmDrcPrc);
				logger.info("insert 品名指导价 成功，条数：" + count);
			} else {
				// 更新品名指导价
				B3PdNmDrcPrc b3PdNmDrcPrc = new B3PdNmDrcPrc();
				BeanUtils.copyProperties(inVo, b3PdNmDrcPrc);
				b3PdNmDrcPrc.setTms(new Date());
				Integer count = b3PdNmDrcPrcMapper.updateByPrimaryKeySelective(b3PdNmDrcPrc);
				logger.info("update 品名指导价 成功，条数：" + count);			
			}
			return Result.createSuccessResult("保存品名指导价成功！");
		} catch (Exception e) {
			logger.error("保存品名指导价异常 {}", e);
			return Result.createFailResult("保存品名指导价异常：" + e);
		}
	}

	/**
	 * 描述：查询品名指导价列表（分页）
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	@Override
	public Result<PageData<PdNmDrcPrcOutVo>> queryPage(PdNmDrcPrcInVo inVo, PageParam pageParam) {
		logger.info("start queryPage 品名指导价 =======> inVo:{}, pageParam:{}", JSON.toJSONString(inVo), pageParam);
		logger.info("userType:" + inVo.getUserType());
		logger.info("orderBy:" + inVo.getOrderBy());
		logger.info("getSortName:" + inVo.getSortName());
		logger.info("getSortOrder:" + inVo.getSortOrder());

		Page<PdNmDrcPrcOutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = b3PdNmDrcPrcMapper.queryPage(inVo);
			count = b3PdNmDrcPrcMapper.count(inVo);
			logger.info("分页查询品名指导价成功:{}", JSON.toJSON(page));
			return Result.createSuccessResult(new PageData<>(count, page.getResult()));
		} catch (Exception e) {
			logger.error("分页查询品名指导价异常 {}", e);
			return Result.createFailResult("查询品名指导价异常:" + e);
		}
	}

	/**
	 * 描述：查询品名指导价详情（主键）
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	@Override
	public Result<PdNmDrcPrcOutVo> getDetailById(Integer id){
		logger.info("按主键查询品名指导价详情,请求参数:{}", id);
		try {
			PdNmDrcPrcOutVo outVo = b3PdNmDrcPrcMapper.getDetailById(id);
			if (null == outVo) {
				logger.error("查询品名指导价详情无数据");
				return Result.createFailResult("查询查询品名指导价详情无数据");
			} else {
				Result<PdNmDrcPrcOutVo> rlt = new Result<PdNmDrcPrcOutVo>();
				rlt.setData(outVo);
				logger.info("查询品名指导价详情成功:{}", JSON.toJSONString(rlt));
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询品名指导价详情异常 {}", e);
			return Result.createFailResult("查询品名指导价详情异常" + e);
		}
	}
	
	/**
	 * 描述：查询品名指导价详情（按条件）
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	@Override
	public Result<PdNmDrcPrcOutVo> getDetailByCondition(PdNmDrcPrcInVo inVo){
		logger.info("按主键查询品名指导价详情,请求参数:{}", JSON.toJSONString(inVo));
		try {
			PdNmDrcPrcOutVo outVo = b3PdNmDrcPrcMapper.getDetailByCondition(inVo);
			if (null == outVo) {
				logger.error("查询品名指导价详情无数据");
				return Result.createFailResult("查询查询品名指导价详情无数据");
			} else {
				Result<PdNmDrcPrcOutVo> rlt = new Result<PdNmDrcPrcOutVo>();
				rlt.setData(outVo);
				logger.info("查询品名指导价详情成功:{}", JSON.toJSONString(rlt));
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询品名指导价详情异常 {}", e);
			return Result.createFailResult("查询品名指导价详情异常" + e);
		}
	}
	
	/**
	 * 描述：按id删除品名指导价
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	@Override
	public Result<String> batchDelete(String ids) {
		logger.info("batchDelete 品名指导价,请求参数:{}", ids);
		try {
			b3PdNmDrcPrcMapper.deleteByIds(ids);
			logger.info("按id删除品名指导价成功!");
			return Result.createSuccessResult("按id删除品名指导价成功！");
		} catch (Exception e) {
			logger.error("按id删除品名指导价异常 {}", e);
			return Result.createFailResult("按id删除品名指导价异常：" + e);
		}
	}	
}