package com.xai.tt.dc.biz.service.impl;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
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
import com.xai.tt.dc.biz.mapper.T0LnkJrnlInfMapper;
import com.xai.tt.dc.biz.mapper.T1ArInfMapper;
import com.xai.tt.dc.biz.mapper.T2UploadAtchMapper;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.biz.utils.DateUtils;
import com.xai.tt.dc.biz.utils.SequenceUtils;
import com.xai.tt.dc.biz.utils.WfeUtils;
import com.xai.tt.dc.client.model.T0LnkJrnlInf;
import com.xai.tt.dc.client.model.T1ArInf;
import com.xai.tt.dc.client.model.T2UploadAtch;
import com.xai.tt.dc.client.query.SubmitArQuery;
import com.xai.tt.dc.client.service.ArManagementDcService;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.T1ARInfDetailVo;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@SuppressWarnings("deprecation")
@Service("arManagementDcService")
public class ArManagementDcServiceImpl implements ArManagementDcService {
	private static final Logger logger = LoggerFactory.getLogger(ArManagementDcServiceImpl.class);
	@Autowired
	private T1ArInfMapper t1ARInfMapper;
	
	@Autowired
	private T0LnkJrnlInfMapper t0LnkJrnlInfMapper;

	@Autowired
	private T2UploadAtchMapper t2UploadAtchMapper;

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
	public Result<Boolean> save(ArManagementInVo inVo) {
		logger.info("保存长约信息请求报文", JSON.toJSONString(inVo));
		// 保存长约信息
		T1ArInf t1ArInf = new T1ArInf();
		String arId = "";
		try {
			if (null == inVo) {
				logger.error("保存长约信息请求报文不能为空");
				return Result.createFailResult("保存长约信息请求报文不能为空");
			}
			BeanUtils.copyProperties(inVo, t1ArInf);
			// 长约新建后记录长约状态
			t1ArInf.setArSt("01");
			t1ArInf.setCrtPsn("刘");
			t1ArInf.setTms(new Date());
			t1ArInf.setCrtTm(new Date());
			t1ArInf.setSplchainCo(123);
			arId = "CY" + DateUtils.noFormatDate() + sequenceUtils.getSequence("T1_AR_Inf_Seq", 4);
			t1ArInf.setArId(arId);
			t1ARInfMapper.insertSelective(t1ArInf);
			// 保存长约附件信息
			try {
	            if (StringUtils.isNotEmpty(inVo.getFileNames())) {
	                T2UploadAtch t2UploadAtch = new T2UploadAtch();
	                t2UploadAtch.setRltvTp("01");
	                t2UploadAtch.setUsername(inVo.getUsername());
	                t2UploadAtch.setRltvId(t1ArInf.getArId());
	                insertFile(t2UploadAtch, inVo.getFileNames());
	            }
				/*if (null != inVo.getList()) {
					for (TB0001SubInVo subInvo : inVo.getList()) {
						if (null != subInvo) {
							T2UploadAtch t2UploadAtch = new T2UploadAtch();
							BeanUtils.copyProperties(subInvo, t2UploadAtch);
							t2UploadAtch.setRltvId(t1ArInf.getArId());
							t2UploadAtchMapper.insertSelective(t2UploadAtch);
						}
					}
				}*/ else {
					logger.error("保存长约信息，长约附件为空！");
				}
			} catch (Exception e) {
				logger.error("保存长约附件信息异常 {}", e);
				return Result.createFailResult("保存长约附件信息发生异常" + e);
			}
			// 保存流程实例id到长约信息表
			String processInstId = wfDcService.startProcessInstance(DataConstants.PROCESS_NAME_AR);
			t1ArInf.setProcessInstId(processInstId);
			Condition condition = new Condition(T1ArInf.class);
			Example.Criteria criteria = condition.createCriteria();
			criteria.andCondition("AR_ID = '" + arId + "'");
			t1ARInfMapper.updateByConditionSelective(t1ArInf, condition);
			logger.info("processInstId =" + processInstId);
			// 保存环节流水
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			BeanUtils.copyProperties(t1ArInf, t0);
			t0.setUsername(inVo.getUsername());
			t0.setCompanyId(inVo.getCompanyId());
			t0.setRltvId(t1ArInf.getArId());
			t0.setAplyPcstpCd("01");
			t0.setAplyPsrltCd("01");
			t0.setProcessType("01");
			wfeUtils.saveLnkJrnlInf(t0);
			// 拾取并完成发起任务
			wfDcService.claimAndCompleteTask(arId, inVo.getUsername(), "01", "01");
		} catch (Exception e) {
			logger.error("保存长约信息异常 {}", e);
			return Result.createFailResult("保存长约信息发生异常" + e);
		}
		return Result.createSuccessResult(true);
	}
	
	/**
	 * 描述：删除长约
	 * 
	 * @author zhuchaobin 2018-11-21
	 */
	@Override
	public Result<Boolean> deleteAr(String id) {
		logger.info("删除长约,请求参数:{}", id);
		try {
			t1ARInfMapper.deleteByPrimaryKey(Long.parseLong(id));	
			logger.info("删除长约成功!");
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除长约异常 {}", e);
			return Result.createFailResult("删除长约异常" + e);
		}
	}
	
	// 保存附件信息
    private void insertFile(T2UploadAtch t2UploadAtch, String fileNames) {
        try {
            List<T2UploadAtch> t2UploadAtchs = Arrays.asList(fileNames.split(",")).stream().map(item -> {
            	T2UploadAtch t2 = new T2UploadAtch();
            	BeanUtils.copyProperties(t2UploadAtch, t2);
                String[] str = item.split("\\|\\|");
                // 取原始文件名
                String oriFileNm = str[1];
                int lastSeparator = oriFileNm.lastIndexOf("\\");
                if(lastSeparator >= 0) {
                	oriFileNm = oriFileNm.substring(lastSeparator + 1);
                }
                t2.setOriFileNm(oriFileNm);
                t2.setSrFileRte(str[0]);
                t2.setCrtTm(new Date());
                t2.setTms(new Date());
                return t2;
            }).collect(Collectors.toList());
            t2UploadAtchMapper.insertList(t2UploadAtchs);
        } catch (Exception e) {
            logger.info("保存附件信息发生异常：",e);
        }


    }

	/**
	 * 描述：查询长约列表（分页）
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	@Override
	public Result<PageData<T1ARInfVo>> queryPage(ArManagementInVo query, PageParam pageParam) {
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
	 * 描述：查询长约列表（分页）
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	@SuppressWarnings("null")
	@Override
	public Result<PageData<T0LnkJrnlInf>> queryLnkJrnlInfPage(ArManagementInVo query, PageParam pageParam) {
		logger.info("start query MaintenanceParm List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		Page<T0LnkJrnlInf> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			// 查询长约流转信息
			Condition condition = new Condition(T0LnkJrnlInf.class); 
			Example.Criteria criteria = condition.createCriteria(); 
			criteria.andCondition("Rltv_ID = 'CY201811250116'");
			criteria.andCondition("PROCESS_TYPE= '01'");
			List<T0LnkJrnlInf> t0LnkJrnlInfList= t0LnkJrnlInfMapper.selectByCondition(condition);
			/*			page.addAll(t0LnkJrnlInfList);*/
			page = (Page<T0LnkJrnlInf>) t0LnkJrnlInfList;
			count = t0LnkJrnlInfList.size();
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
	public Result<T1ARInfDetailVo> queryArDetail(String id) {
		logger.info("查询长约详情,请求参数:{}", id);
		T1ARInfDetailVo t1ARInfDetailVo = new T1ARInfDetailVo();
		try {
			T1ArInf t1ARInf = null;
			/*
			 * Condition condition = new Condition(T1ARInf.class); Example.Criteria criteria
			 * = condition.createCriteria(); criteria.andCondition("AR_ID = '" + id + "'");
			 * t1ARInf = t1ARInfMapper.selectByCondition(condition).get(0);
			 */
			t1ARInf = t1ARInfMapper.selectByPrimaryKey(Long.parseLong(id));
			BeanUtils.copyProperties(t1ARInf, t1ARInfDetailVo);
			if (t1ARInfDetailVo == null) {
				logger.error("查询长约详情无数据");
				return Result.createFailResult("查询长约详情无数据");
			}
			// 查询长约附件信息
			Condition condition0 = new Condition(T2UploadAtch.class); 
			Example.Criteria criteria0 = condition0.createCriteria(); 
			criteria0.andCondition("Rltv_ID = '" + t1ARInfDetailVo.getArId() + "'");
			criteria0.andCondition("Rltv_Tp = '01'");
			List<T2UploadAtch> t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			t1ARInfDetailVo.setT2UploadAtch01List(t2UploadAtch01List);
			logger.info("查询长约附件信息成功!");
			// 查询长约流转信息
			Condition condition = new Condition(T0LnkJrnlInf.class); 
			Example.Criteria criteria = condition.createCriteria(); 
			criteria.andCondition("Rltv_ID = '" + t1ARInfDetailVo.getArId() + "'");
			criteria.andCondition("PROCESS_TYPE= '01'");
			List<T0LnkJrnlInf> t0LnkJrnlInfList= t0LnkJrnlInfMapper.selectByCondition(condition);
			t1ARInfDetailVo.setList(t0LnkJrnlInfList);
			logger.info("查询长约流转详情成功!");
			logger.info("查询长约详情成功!");
			return Result.createSuccessResult(t1ARInfDetailVo);
		} catch (Exception e) {
			logger.error("查询长约详情异常 {}", e);
			return Result.createFailResult("查询长约详情异常" + e);
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
			//判断当前用户是否有权限处理该件
			// todo()
			// 判断任务当前所处的环节是否正确
			// todo()			
			// 拾取并完成任务
			wfDcService.claimAndCompleteTask(query.getArId(), query.getUsername(), query.getAplyPcstpCd(),
					query.getAplyPsrltCd());
			logger.debug("拾取并完成任务成功！");
		} catch (Exception e) {
			logger.error("长约提交异常 {}", e);
			return Result.createFailResult("拾取并完成任务异常:" + e);
		}
		try {
			// 保存环节流水
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			BeanUtils.copyProperties(query, t0);
			t0.setRltvId(query.getArId());
			t0.setProcessType("01");
			wfeUtils.saveLnkJrnlInf(t0);
		} catch (Exception e) {
			logger.error("长约提交保存环节流水异常 {}", e);
			return Result.createFailResult("长约提交保存环节流水异常:" + e);
		}
		return Result.createSuccessResult(true);
	}

}
