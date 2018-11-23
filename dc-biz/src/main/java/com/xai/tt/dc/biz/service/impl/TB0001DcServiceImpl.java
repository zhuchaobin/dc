package com.xai.tt.dc.biz.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.ActRuTaskMapper;
import com.xai.tt.dc.biz.mapper.T1ARInfMapper;
import com.xai.tt.dc.biz.mapper.T2ARAtchMapper;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.biz.utils.DateUtils;
import com.xai.tt.dc.biz.utils.SequenceUtils;
import com.xai.tt.dc.biz.utils.WfeUtils;
import com.xai.tt.dc.client.model.T0LnkJrnlInf;
import com.xai.tt.dc.client.model.T1ARInf;
import com.xai.tt.dc.client.model.T2ARAtch;
import com.xai.tt.dc.client.query.SubmitArQuery;
import com.xai.tt.dc.client.query.WfeQuery;
import com.xai.tt.dc.client.service.TB0001DcService;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.inVo.TB0001InVo;
import com.xai.tt.dc.client.vo.inVo.TB0001SubInVo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@SuppressWarnings("deprecation")
@Service("tB0001DcService")
public class TB0001DcServiceImpl implements TB0001DcService {
	private static final Logger logger = LoggerFactory.getLogger(TB0001DcServiceImpl.class);
	@Autowired
	private T1ARInfMapper t1ARInfMapper;

	@Autowired
	private T2ARAtchMapper t2ARAtchMapper;

	@Autowired
	private SequenceUtils sequenceUtils;
	
	@Autowired
	private WfeUtils wfeUtils;

	@Autowired
	private WfDcService wfDcService;
	
	/**
	 * 描述：保存长约信息
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	@Override
	public Result<Boolean> save(TB0001InVo inVo) {
		logger.info("保存长约信息请求报文",  JSON.toJSONString(inVo));
		// 保存长约信息
		T1ARInf t1ARInf = new T1ARInf();
		String arId = "";
		try {
			if (null == inVo) {
				logger.error("保存长约信息请求报文不能为空");
				return Result.createFailResult("保存长约信息请求报文不能为空");
			}
			BeanUtils.copyProperties(inVo, t1ARInf);
			// 长约新建后记录长约状态
			t1ARInf.setArSt("01");
			t1ARInf.setCrtPsn("刘");
			t1ARInf.setTms(new Date());
			t1ARInf.setCrtTm(new Date());
			arId = "CY" + DateUtils.noFormatDate() + sequenceUtils.getSequence("T1_AR_Inf_Seq", 4);
			t1ARInf.setArId(arId);
			t1ARInfMapper.insertSelective(t1ARInf);
			// 保存长约附件信息
			try {
				if (null != inVo.getList()) {
					for (TB0001SubInVo subInvo : inVo.getList()) {
						if (null != subInvo) {
							T2ARAtch t2ARAtch = new T2ARAtch();
							BeanUtils.copyProperties(subInvo, t2ARAtch);
							t2ARAtch.setArId(t1ARInf.getArId());
							t2ARAtchMapper.insertSelective(t2ARAtch);
						}
					}
				} else {
					logger.error("保存长约信息，长约附件为空！");
				}
			} catch (Exception e) {
				logger.error("保存长约附件信息异常 {}", e);
				return Result.createFailResult("保存长约附件信息发生异常" + e);
			}
			// 保存流程实例id到长约信息表
			String processInstId = wfDcService.startProcessInstance(DataConstants.PROCESS_NAME_AR);
			t1ARInf.setProcessInstId(processInstId);
			Condition condition = new Condition(T1ARInf.class);
			Example.Criteria criteria = condition.createCriteria();
			criteria.andCondition("AR_ID = '" + arId + "'");
			t1ARInfMapper.updateByConditionSelective(t1ARInf, condition);
			logger.info("processInstId =" + processInstId);
			// 保存环节流水
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			BeanUtils.copyProperties(t1ARInf, t0);
			t0.setOprEcd(inVo.getUsername());
			t0.setAplyPcsInsid(inVo.getCompanyId());
			wfeUtils.saveLnkJrnlInf(t0, "01", "01");
			// 拾取并完成发起任务
			wfDcService.claimAndCompleteTask(arId, inVo.getUsername(), "01", "01");
		} catch (Exception e) {
			logger.error("保存长约信息异常 {}", e);
			return Result.createFailResult("保存长约信息发生异常" + e);
		}
		return Result.createSuccessResult(true);
	}
	/**
	 * 描述：查询长约列表（分页）
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	@Override
	public Result<PageData<T1ARInfVo>> queryPage(TB0001InVo query, PageParam pageParam) {
		logger.info("start query MaintenanceParm List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		Page<T1ARInfVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = t1ARInfMapper.selectByT1ARInfDcQuery(query);
			count = t1ARInfMapper.count(query);
		} catch (Exception e) {

			logger.error("查询长约列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("query maintenanceParm list success!");
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}
	/**
	 * 描述：查询长约详情
	 * 
	 * @author zhuchaobin 2018-11-21
	 */
	@Override
	public Result<T1ARInfVo> queryArDetail(String id) {
		logger.info("查询长约详情,请求参数:{}", id);
		T1ARInfVo t1ARInfVo = new T1ARInfVo();
		try {
			T1ARInf t1ARInf = null;
/*			Condition condition = new Condition(T1ARInf.class);
			Example.Criteria criteria = condition.createCriteria();
			criteria.andCondition("AR_ID = '" + id + "'");
			t1ARInf = t1ARInfMapper.selectByCondition(condition).get(0);*/
			t1ARInf = t1ARInfMapper.selectByPrimaryKey( Long.parseLong(id));
			BeanUtils.copyProperties(t1ARInf, t1ARInfVo);
			if (t1ARInfVo == null) {
				logger.error("查询长约详情无数据");
				return Result.createFailResult("查询长约详情无数据");
			}
			logger.info("查询长约详情成功!");
			return Result.createSuccessResult(t1ARInfVo);
		} catch (Exception e) {
			logger.error("查询长约详情异常 {}", e);
			return Result.createFailResult("查询长约详情异常");
		}
	}
	
	/**
	 * 描述：长约提交
	 * 
	 * @author zhuchaobin 2018-11-21
	 */
	@Override
	public Result<Boolean> submitAr(SubmitArQuery query) {
		String fucNm = "长约提交";
		logger.info(fucNm + ",请求参数:{}", JSON.toJSONString(query));
		
		T1ARInfVo t1ARInfVo = new T1ARInfVo();
		try {
			// 保存环节流水
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			BeanUtils.copyProperties(query, t0);
			t0.setOprEcd(query.getUsername());
			t0.setAplyPcsInsid(query.getCompanyId());
			wfeUtils.saveLnkJrnlInf(t0, "01", "01");
			// 拾取并完成发起任务
			wfDcService.claimAndCompleteTask(query.getArId(), query.getUsername(), query.getAplyPcstpCd(), query.getAplyPsrltCd());
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("长约提交异常 {}", e);
			return Result.createFailResult("长约提交异常");
		}
	}
	
}
