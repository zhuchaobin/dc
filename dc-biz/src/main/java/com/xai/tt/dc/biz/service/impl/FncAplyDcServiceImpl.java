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
import com.xai.tt.dc.client.service.FncAplyDcService;
import com.xai.tt.dc.client.vo.inVo.FncAplyInVo;
import com.xai.tt.dc.client.vo.outVo.FncAplyOutVo;
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
 * 融资申请dc 服务实现类
 * </pre>
 * <small> 2019-03-20 23:41:27 | zhuchaobin</small>
 */
 
 @SuppressWarnings("deprecation")
@Service("fncAplyDcService")
public class FncAplyDcServiceImpl implements FncAplyDcService {
	private static final Logger logger = LoggerFactory.getLogger(FncAplyDcServiceImpl.class);
	@Autowired
	private T5FncAplyMapper t5FncAplyMapper;

	/**
	 * 描述：保存融资申请
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	@Override
	public Result<String> save(FncAplyInVo inVo) {
		logger.info("save融资申请请求报文{inVo}", JSON.toJSONString(inVo));
		logger.info("二级服务码secSrvCd：" + inVo.getSecSrvCd());
		try {
			if(null == inVo.getId()){
				// 新建融资申请
				T5FncAply t5FncAply = new T5FncAply();
				BeanUtils.copyProperties(inVo, t5FncAply);
				t5FncAply.setAplyTm(new Date());
				t5FncAply.setModTm(new Date());
				Integer count = t5FncAplyMapper.insert(t5FncAply);
				logger.info("insert 融资申请 成功，条数：" + count);
			} else {
				// 更新融资申请
				T5FncAply t5FncAply = new T5FncAply();
				BeanUtils.copyProperties(inVo, t5FncAply);
				t5FncAply.setPcsTm(new Date());
				t5FncAply.setModTm(new Date());
				Integer count = t5FncAplyMapper.updateByPrimaryKeySelective(t5FncAply);
				logger.info("update 融资申请 成功，条数：" + count);			
			}
			return Result.createSuccessResult("保存融资申请成功！");
		} catch (Exception e) {
			logger.error("保存融资申请异常 {}", e);
			return Result.createFailResult("保存融资申请异常：" + e);
		}
	}

	/**
	 * 描述：查询融资申请列表（分页）
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	@Override
	public Result<PageData<FncAplyOutVo>> queryPage(FncAplyInVo inVo, PageParam pageParam) {
		logger.info("start queryPage 融资申请 =======> inVo:{}, pageParam:{}", JSON.toJSONString(inVo), pageParam);
		logger.info("userType:" + inVo.getUserType());
		logger.info("orderBy:" + inVo.getOrderBy());
		logger.info("getSortName:" + inVo.getSortName());
		logger.info("getSortOrder:" + inVo.getSortOrder());

		Page<FncAplyOutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = t5FncAplyMapper.queryPage(inVo);
			count = t5FncAplyMapper.count(inVo);
			logger.info("分页查询融资申请成功:{}", JSON.toJSON(page));
			return Result.createSuccessResult(new PageData<>(count, page.getResult()));
		} catch (Exception e) {
			logger.error("分页查询融资申请异常 {}", e);
			return Result.createFailResult("查询融资申请异常:" + e);
		}
	}

	/**
	 * 描述：查询融资申请详情（主键）
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	@Override
	public Result<FncAplyOutVo> getDetailById(Integer id){
		logger.info("按主键查询融资申请详情,请求参数:{}", id);
		try {
			FncAplyOutVo outVo = t5FncAplyMapper.getDetailById(id);
			if (null == outVo) {
				logger.error("查询融资申请详情无数据");
				return Result.createFailResult("查询查询融资申请详情无数据");
			} else {
				Result<FncAplyOutVo> rlt = new Result<FncAplyOutVo>();
				rlt.setData(outVo);
				logger.info("查询融资申请详情成功:{}", JSON.toJSONString(rlt));
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询融资申请详情异常 {}", e);
			return Result.createFailResult("查询融资申请详情异常" + e);
		}
	}
	
	/**
	 * 描述：查询融资申请详情（按条件）
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	@Override
	public Result<FncAplyOutVo> getDetailByCondition(FncAplyInVo inVo){
		logger.info("按主键查询融资申请详情,请求参数:{}", JSON.toJSONString(inVo));
		try {
			FncAplyOutVo outVo = t5FncAplyMapper.getDetailByCondition(inVo);
			if (null == outVo) {
				logger.error("查询融资申请详情无数据");
				return Result.createFailResult("查询查询融资申请详情无数据");
			} else {
				Result<FncAplyOutVo> rlt = new Result<FncAplyOutVo>();
				rlt.setData(outVo);
				logger.info("查询融资申请详情成功:{}", JSON.toJSONString(rlt));
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询融资申请详情异常 {}", e);
			return Result.createFailResult("查询融资申请详情异常" + e);
		}
	}
	
	/**
	 * 描述：按id删除融资申请
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	@Override
	public Result<String> batchDelete(String ids) {
		logger.info("batchDelete 融资申请,请求参数:{}", ids);
		try {
			t5FncAplyMapper.deleteByIds(ids);
			logger.info("按id删除融资申请成功!");
			return Result.createSuccessResult("按id删除融资申请成功！");
		} catch (Exception e) {
			logger.error("按id删除融资申请异常 {}", e);
			return Result.createFailResult("按id删除融资申请异常：" + e);
		}
	}	
}