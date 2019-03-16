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
import com.xai.tt.dc.client.service.PlgDrcPrcDcService;
import com.xai.tt.dc.client.vo.inVo.PlgDrcPrcInVo;
import com.xai.tt.dc.client.vo.outVo.PlgDrcPrcOutVo;
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
 * 质押指导价dc 服务实现类
 * </pre>
 * <small> 2019-03-16 01:56:08 | xai-auto</small>
 */
 
 @SuppressWarnings("deprecation")
@Service("plgDrcPrcDcService")
public class PlgDrcPrcDcServiceImpl implements PlgDrcPrcDcService {
	private static final Logger logger = LoggerFactory.getLogger(PlgDrcPrcDcServiceImpl.class);
	@Autowired
	private B4PlgDrcPrcMapper b4PlgDrcPrcMapper;

	/**
	 * 描述：保存质押指导价
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	@Override
	public Result<String> save(PlgDrcPrcInVo inVo) {
		logger.info("save质押指导价请求报文{inVo}", JSON.toJSONString(inVo));
		logger.info("二级服务码secSrvCd：" + inVo.getSecSrvCd());
		try {
			if(null == inVo.getId()){
				// 新建质押指导价
				B4PlgDrcPrc b4PlgDrcPrc = new B4PlgDrcPrc();
				BeanUtils.copyProperties(inVo, b4PlgDrcPrc);
				b4PlgDrcPrc.setTms(new Date());
				Integer count = b4PlgDrcPrcMapper.insert(b4PlgDrcPrc);
				logger.info("insert 质押指导价 成功，条数：" + count);
			} else {
				// 更新质押指导价
				B4PlgDrcPrc b4PlgDrcPrc = new B4PlgDrcPrc();
				BeanUtils.copyProperties(inVo, b4PlgDrcPrc);
				b4PlgDrcPrc.setTms(new Date());
				Integer count = b4PlgDrcPrcMapper.updateByPrimaryKeySelective(b4PlgDrcPrc);
				logger.info("update 质押指导价 成功，条数：" + count);			
			}
			return Result.createSuccessResult("保存质押指导价成功！");
		} catch (Exception e) {
			logger.error("保存质押指导价异常 {}", e);
			return Result.createFailResult("保存质押指导价异常：" + e);
		}
	}

	/**
	 * 描述：查询质押指导价列表（分页）
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	@Override
	public Result<PageData<PlgDrcPrcOutVo>> queryPage(PlgDrcPrcInVo inVo, PageParam pageParam) {
		logger.info("start queryPage 质押指导价 =======> inVo:{}, pageParam:{}", JSON.toJSONString(inVo), pageParam);
		logger.info("userType:" + inVo.getUserType());
		logger.info("orderBy:" + inVo.getOrderBy());
		logger.info("getSortName:" + inVo.getSortName());
		logger.info("getSortOrder:" + inVo.getSortOrder());

		Page<PlgDrcPrcOutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = b4PlgDrcPrcMapper.queryPage(inVo);
			count = b4PlgDrcPrcMapper.count(inVo);
			logger.info("分页查询质押指导价成功:{}", JSON.toJSON(page));
			return Result.createSuccessResult(new PageData<>(count, page.getResult()));
		} catch (Exception e) {
			logger.error("分页查询质押指导价异常 {}", e);
			return Result.createFailResult("查询质押指导价异常:" + e);
		}
	}

	/**
	 * 描述：查询质押指导价详情（主键）
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	@Override
	public Result<PlgDrcPrcOutVo> getDetailById(Integer id){
		logger.info("按主键查询质押指导价详情,请求参数:{}", id);
		try {
			PlgDrcPrcOutVo outVo = b4PlgDrcPrcMapper.getDetailById(id);
			if (null == outVo) {
				logger.error("查询质押指导价详情无数据");
				return Result.createFailResult("查询查询质押指导价详情无数据");
			} else {
				Result<PlgDrcPrcOutVo> rlt = new Result<PlgDrcPrcOutVo>();
				rlt.setData(outVo);
				logger.info("查询质押指导价详情成功:{}", JSON.toJSONString(rlt));
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询质押指导价详情异常 {}", e);
			return Result.createFailResult("查询质押指导价详情异常" + e);
		}
	}
	
	/**
	 * 描述：查询质押指导价详情（按条件）
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	@Override
	public Result<PlgDrcPrcOutVo> getDetailByCondition(PlgDrcPrcInVo inVo){
		logger.info("按主键查询质押指导价详情,请求参数:{}", JSON.toJSONString(inVo));
		try {
			PlgDrcPrcOutVo outVo = b4PlgDrcPrcMapper.getDetailByCondition(inVo);
			if (null == outVo) {
				logger.error("查询质押指导价详情无数据");
				return Result.createFailResult("查询查询质押指导价详情无数据");
			} else {
				Result<PlgDrcPrcOutVo> rlt = new Result<PlgDrcPrcOutVo>();
				rlt.setData(outVo);
				logger.info("查询质押指导价详情成功:{}", JSON.toJSONString(rlt));
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询质押指导价详情异常 {}", e);
			return Result.createFailResult("查询质押指导价详情异常" + e);
		}
	}
	
	/**
	 * 描述：按id删除质押指导价
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	@Override
	public Result<String> batchDelete(String ids) {
		logger.info("batchDelete 质押指导价,请求参数:{}", ids);
		try {
			b4PlgDrcPrcMapper.deleteByIds(ids);
			logger.info("按id删除质押指导价成功!");
			return Result.createSuccessResult("按id删除质押指导价成功！");
		} catch (Exception e) {
			logger.error("按id删除质押指导价异常 {}", e);
			return Result.createFailResult("按id删除质押指导价异常：" + e);
		}
	}	
}