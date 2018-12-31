package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.biz.utils.DateUtils;
import com.xai.tt.dc.biz.utils.SequenceUtils;
import com.xai.tt.dc.biz.utils.WfeUtils;
import com.xai.tt.dc.client.model.*;
import com.xai.tt.dc.client.query.SubmitArQuery;
import com.xai.tt.dc.client.query.SubmitSpgQuery;
import com.xai.tt.dc.client.service.ArManagementDcService;
import com.xai.tt.dc.client.service.SpgManagementDcService;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.T1ARInfDetailVo;
import com.xai.tt.dc.client.vo.T6SpgInfDetailVo;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.inVo.SpgManagementInVo;
import com.xai.tt.dc.client.vo.outVo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
@Service("spgManagementDcService")
public class SpgManagementDcServiceImpl implements SpgManagementDcService {
	private static final Logger logger = LoggerFactory.getLogger(SpgManagementDcServiceImpl.class);
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

	@Autowired
	private CompanyMapper companyMapper;


	@Autowired
	private T6SpgInfMapper t6SpgInfMapper;


	@Autowired
	private T7SpgDetailMapper t7SpgDetailMapper;


	@Autowired
	private UserMapper userMapper;
	
	

	/**
	 * 描述：保存发货信息
	 * 
	 * @author yuzhaoyang 2018-12-23
	 */
	@Override
	public Result<Boolean> save(SpgManagementInVo inVo) {
		logger.info("保存发货信息请求报文{}", JSON.toJSONString(inVo));
		logger.info("二级服务码secSrvCd：" + inVo.getSecSrvCd());
		// 保存发货信息
		T6SpgInf t6SpgInfo = new T6SpgInf();
		String spgId = "";
		try {
			if (null == inVo) {
				logger.error("保存发货信息请求报文不能为空");
				return Result.createFailResult("保存发货信息请求报文不能为空");
			}
			String solveType = "";
			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			// 判断处理类别
			if ("01".equals(inVo.getSecSrvCd())) {
				if(null != inVo.getId()) {
					T6SpgInf rltT1 = t6SpgInfMapper.selectByPrimaryKey(inVo.getId());
					if((null != rltT1)){
						//撤销件	
						if("11".equals(rltT1.getSpgSt())) {
							solveType = "03";
						} else if("10".equals(rltT1.getSpgSt())){
							solveType = "04";
						} else if("01".equals(rltT1.getSpgSt())){
							solveType = "02";
						}
					} else {
						solveType = "01";
						inVo.setSpgSt("10");
					}
				} else {
					solveType = "01";
					inVo.setSpgSt("10");
				}
			} else if ("02".equals(inVo.getSecSrvCd())) {
				if(null != inVo.getId()) {
					T6SpgInf rltT1 = t6SpgInfMapper.selectByPrimaryKey(inVo.getId());
					if((null != rltT1)){
						//撤销件	
						if("11".equals(rltT1.getSpgSt())) {
							solveType = "07";
						} else if("10".equals(rltT1.getSpgSt())){
							solveType = "08";
						} else if("01".equals(rltT1.getSpgSt())){
							solveType = "06";
						}
					} else {
						solveType = "05";
					}					
				} else {
					solveType = "05";
				}
			}
			logger.info("处理类型solveType：" + solveType);
			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			if("01".equals(solveType) || "05".equals(solveType)|| "07".equals(solveType)) {
				spgId = "FH" + DateUtils.noFormatDate() + sequenceUtils.getSequence("T6_Spg_Inf_Seq", 4);
			} else {
				spgId = inVo.getSpgId();
			}			
			if(StringUtils.isBlank(spgId)) {
				logger.error("发货编号不能为空！");
				return Result.createFailResult("发货编号不能为空！");
			}
			BeanUtils.copyProperties(inVo, t6SpgInfo);
			// 发货新建后记录发货状态
			t6SpgInfo.setSpgId(spgId);
			t6SpgInfo.setCnsgn(inVo.getCnsgn());
			t6SpgInfo.setTms(new Date());

			
			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			// 
			if(StringUtils.isBlank(t6SpgInfo.getSpgSt())){
				if("05".equals(solveType) || "07".equals(solveType)|| "08".equals(solveType)) {
					t6SpgInfo.setSpgSt("01");
				}
			}
			if("01".equals(solveType) || "05".equals(solveType)|| "07".equals(solveType)) {
				t6SpgInfo.setId(null);
				int num = t6SpgInfMapper.insertSelective(t6SpgInfo);
				logger.info("更新发货信息成功，插入记录数：" + num);
			} else {
				int num = t6SpgInfMapper.updateByPrimaryKeySelective(t6SpgInfo);
				logger.info("更新发货信息成功：发货id" + t6SpgInfo.getArId() + "更新条数：" + num);
			}

			// 保存发货附件信息
			try {
				if (StringUtils.isNotEmpty(inVo.getFileNames())) {
					T2UploadAtch t2UploadAtch = new T2UploadAtch();
					t2UploadAtch.setRltvTp("01");
					t2UploadAtch.setUsername(inVo.getUsername());
					t2UploadAtch.setRltvId(spgId);
					insertFile(t2UploadAtch, inVo.getFileNames());
				}
			else {
					logger.error("保存发货信息，发货附件为空！");
				}
			} catch (Exception e) {
				logger.error("保存发货附件信息异常 {}", e);
				return Result.createFailResult("保存发货附件信息发生异常" + e);
			}

			// 删除发货附件信息
			if (StringUtils.isNotBlank(inVo.getFilesToDelete())) {
				try {
					String[] files = inVo.getFilesToDelete().split("\\|\\|");
					for(String fileId : files) {
						logger.info("删除附件开始，附件id:" + fileId);
						t2UploadAtchMapper.deleteByPrimaryKey(Long.parseLong(fileId));
						logger.info("删除附件结束，附件id:" + fileId);
					}
				} catch (Exception e) {
					logger.error("删除发货附件信息异常 {}", e);
					return Result.createFailResult("删除发货附件信息发生异常" + e);
				}
			}

			// 如果是发起，保存流程实例id到发货信息表
			// 05:新发起发起     07：撤销件发起  08：保存件发起
			if("05".equals(solveType) || "07".equals(solveType)|| "08".equals(solveType)) {
				String processInstId = wfDcService.startProcessInstance(DataConstants.PROCESS_NAME_SPG);
				if(StringUtils.isBlank(processInstId)) {
					logger.error("发起发货，启动流程失败!");
					return Result.createFailResult("发起发货，启动流程失败!");
				} else {
					logger.error("发起发货，启动流程成功，processInstId:" + processInstId);
				}
				t6SpgInfo.setProcessInstId(processInstId);
				Condition condition = new Condition(T6SpgInf.class);
				Example.Criteria criteria = condition.createCriteria();
				criteria.andCondition("Spg_ID = '" + spgId + "'");
				t6SpgInfMapper.updateByConditionSelective(t6SpgInfo, condition);
				logger.info("processInstId =" + processInstId);
			}
			
			// 保存环节流水
			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			if("05".equals(solveType) || "06".equals(solveType)|| "07".equals(solveType)|| "08".equals(solveType)) {
				T0LnkJrnlInf t0 = new T0LnkJrnlInf();
				BeanUtils.copyProperties(t6SpgInfo, t0);
				t0.setUsername(inVo.getUsername());
				t0.setCompanyId(inVo.getCompanyId());
				t0.setRltvId(t6SpgInfo.getArId());
				t0.setAplyPcstpCd("01");
				t0.setAplyPsrltCd("01");
				t0.setProcessType("01");
				t0.setId(null);
				wfeUtils.saveLnkJrnlInf(t0);
				// 拾取并完成发起任务
				wfDcService.claimAndCompleteSpgTask(spgId, inVo.getUsername(), "01", "01","","");
			}
			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			if("05".equals(solveType) || "06".equals(solveType)|| "07".equals(solveType)|| "08".equals(solveType)) {
				// 更新发货状态为新状态
				try {
					T6SpgInf t1 = new T6SpgInf();
					// 更新发货状态
					//t1.setArSt(query.getAplyPcstpCd());
					//从工作流记录表中获取发货最新状态

					//todo
					QuerySpgInfDetailOutVo t1Vo = t6SpgInfMapper.querySpgDetailBySpgId(spgId);
					if(t1Vo != null && t1Vo.getAplyPcstpCd() != null) {
						t1.setSpgSt(t1Vo.getAplyPcstpCd());
					} else {
						if(t1Vo != null && wfDcService.isEndProcess(t1Vo.getProcessInstId())) {
							t1.setSpgSt("99");
							logger.info("流程已经结束.");
						} else {
							logger.error("更新发货信息，获取发货状态失败");
							return Result.createFailResult("更新发货信息，获取发货状态失败");
						}
					}
					t1.setTms(new Date());
					Condition condition0 = new Condition(T1ArInf.class);
					Example.Criteria criteria0 = condition0.createCriteria();
					criteria0.andCondition("Spg_ID = '" + spgId + "'");
					int rltNum = t6SpgInfMapper.updateByConditionSelective(t1, condition0);
					logger.info("更新发货状态，更新记录数：" + rltNum);
				} catch (Exception e) {
					logger.error("更新发货状态异常 {}", e);
					return Result.createFailResult("更新发货状态异常:" + e);
				}
			}
		} catch (Exception e) {
			logger.error("保存发货信息异常 {}", e);
			return Result.createFailResult("保存发货信息发生异常" + e);
		}
		return Result.createSuccessResult(true);
	}

	/**
	 * 描述：删除发货
	 * 
	 * @author zhuchaobin 2018-11-21
	 */
	@Override
	public Result<Boolean> deleteSpg(String id) {
		logger.info("删除发货,请求参数:{}", id);
		try {
			t6SpgInfMapper.deleteByPrimaryKey(Long.parseLong(id));
			logger.info("删除发货成功!");
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除发货异常 {}", e);
			return Result.createFailResult("删除发货异常" + e);
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
				if (lastSeparator >= 0) {
					oriFileNm = oriFileNm.substring(lastSeparator + 1);
				}
				t2.setOriFileNm(oriFileNm);
				t2.setSrFileRte(str[0]);
				t2.setCrtTm(new Date());
				t2.setTms(new Date());
				return t2;
			}).collect(Collectors.toList());
			for (T2UploadAtch t2 : t2UploadAtchs) {
				if (null != t2UploadAtchMapper.selectByPrimaryKey(t2.getId())) {
					// 更新记录
					logger.debug("保存发货附件信息");
					t2UploadAtchMapper.updateByPrimaryKeySelective(t2);
				} else {
					// 插入记录
					logger.debug("更新发货附件信息");
					t2UploadAtchMapper.insert(t2);
				}
			}

		} catch (Exception e) {
			logger.info("保存发货附件信息发生异常：", e);
		}

	}

	/**
	 * 描述：查询发货列表（分页）
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	@Override
	public Result<PageData<QuerySpgInfDetailOutVo>> queryPage(SpgManagementInVo query, PageParam pageParam) {
		logger.info("start query 发货信息 List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		logger.info("orderBy:" + query.getOrderBy());
		logger.info("getSortName:" + query.getSortName());
		logger.info("getSortOrder:" + query.getSortOrder());
		Page<QuerySpgInfDetailOutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = t6SpgInfMapper.selectByT6SpgInfDcQuery(query);
			count = t6SpgInfMapper.count(query);
		} catch (Exception e) {

			logger.error("查询发货列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("queryPage success!{}",JSON.toJSON(page));
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}

	/**
	 * 描述：查询发货流转信息列表（分页）
	 * 
	 * @author 2018-11-26
	 */
	@SuppressWarnings("null")

	@Override
	public Result<PageData<QueryLnkJrnlInfOutVo>> queryLnkJrnlInfPage(SpgManagementInVo query, PageParam pageParam) {
		logger.info("start query MaintenanceParm List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		Page<QueryLnkJrnlInfOutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			// 查询发货流转信息
			Condition condition = new Condition(T0LnkJrnlInf.class);
			Example.Criteria criteria = condition.createCriteria();
			criteria.andCondition("Rltv_ID = 'CY201811250116'");
			criteria.andCondition("PROCESS_TYPE= '01'");

		} catch (Exception e) {

			logger.error("查询发货列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("query maintenanceParm list success!");
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}

	/**
	 * 描述：查询发货详情
	 * 
	 * @author yuzhaoyang 2018-12-25
	 */
	@Override
	public Result<QuerySpgInfDetailOutVo> querySpgDetail(SpgManagementInVo query ) {
		logger.info("查询发货详情,请求参数:{}", JSON.toJSONString(query));
		try {
			QuerySpgInfDetailOutVo t3 = null;
			t3 = t6SpgInfMapper.querySpgDetail(query.getId().intValue());
			if (t3 == null) {
				logger.error("查询发货详情无数据");
				return Result.createFailResult("查询发货详情无数据");
			}
			// 查询发货附件信息
			Condition condition0 = new Condition(T2UploadAtch.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Rltv_ID = '" + t3.getSpgId() + "'");
			criteria0.andCondition("Rltv_Tp = '02'");
			List<T2UploadAtch> t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			t3.setT2UploadAtch01List(t2UploadAtch01List);
			logger.info("查询发货附件信息成功!");
			// 查询发货流转信息
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			t0.setRltvId(t3.getSpgId());
			t0.setProcessType("02");
			List<QueryLnkJrnlInfOutVo> t0LnkJrnlInfList = t0LnkJrnlInfMapper.QueryLnkJrnlInfList(t0);
			if(null != t0LnkJrnlInfList) {
				t3.setList(t0LnkJrnlInfList);
				logger.info("查询发货流转详情成功!查询到数据条数：" + t0LnkJrnlInfList.size());
			}
			Condition condition1 = new Condition(T7SpgDetail.class);
			Example.Criteria criteria1 = condition1.createCriteria();
			criteria1.andCondition("Spg_ID = '" + t3.getSpgId() + "'");
			List<T7SpgDetail> t7SpgDetailList = t7SpgDetailMapper.selectByCondition(condition1);
			if(null != t7SpgDetailList) {
				t3.setT7SpgDetailList(t7SpgDetailList);
				logger.info("查询发货明细信息成功!查询到数据条数：" + t7SpgDetailList.size());
			}
			logger.info("查询发货详情成功!");
			// 查询用户角色参数权限信息
			List<String> userRoleParmsList = userMapper.QueryUserRoleParms(query.getUsername());
			String userRoleParms = "";
			for(String ele:userRoleParmsList) {
				userRoleParms = userRoleParms + "|" + ele;
			}
			if(StringUtils.isNotBlank(userRoleParms)) {
				String[] str = userRoleParms.split("\\|");
				List<String> list = new ArrayList<String>();
				for(String elem: str) {
					list.add(elem);
				}
				t3.setRoleParmsList(list);
			} else {
				logger.error("查询用户角色参数权限信息，结果为空");
			}
			return Result.createSuccessResult(t3);
		} catch (Exception e) {
			logger.error("查询发货详情异常 {}", e);
			return Result.createFailResult("查询发货详情异常" + e);
		}
	}
	
	/**
	 * 描述：撤销发货
	 * 
	 * @author yuzhaoyang 2018-12-13
	 */
	@Override
	public Result<Boolean> unDoSpg(SpgManagementInVo inVo) {
		logger.info("撤销发货请求报文", JSON.toJSONString(inVo));
/*		T6_Spg_Inf t1 = t1ARInfMapper.selectByPrimaryKey(inVo.getId());
		if (t1 == null) {
			logger.error("查询发货详情无数据");
			return Result.createFailResult("查询发货详情无数据");
		}
		try {
			// 休眠流程实例
			wfDcService.suspendProcessInstanceById(t1.getProcessInstId());
		} catch (Exception e) {
			logger.error("撤销发货休眠流程实例异常 {}", e);
			return Result.createFailResult("撤销发货休眠流程实例异常:" + e);
		}
		
		try {
			// 保存环节流水
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			BeanUtils.copyProperties(t1, t0);
			t0.setUsername(inVo.getUsername());
			t0.setCompanyId(inVo.getCompanyId());
			t0.setRltvId(t1.getArId());
			t0.setProcessType("01");
			t0.setAplyPcstpCd("11");
			t0.setAplyPsrltCd("04");
			t0.setId(null);
			wfeUtils.saveLnkJrnlInf(t0);
		} catch (Exception e) {
			logger.error("撤销发货保存环节流水异常 {}", e);
			return Result.createFailResult("撤销发货保存环节流水异常:" + e);
		}

		try {
			// 更新发货状态
			t1.setArSt("11");
			t1.setTms(new Date());
			Condition condition0 = new Condition(T6_Spg_Inf.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Spg_ID = '" + t1.gets() + "'");
			int rltNum = t1ARInfMapper.updateByConditionSelective(t1, condition0);
			logger.info("更新发货状态，更新记录数：" + rltNum);
		} catch (Exception e) {
			logger.error("更新发货状态异常 {}", e);
			return Result.createFailResult("更新发货状态异常:" + e);
		}
		return Result.createSuccessResult(true);*/
		return null;
	}

	/**
	 * 描述：发货提交
	 * 
	 * @author zhuchaobin 2018-11-21
	 */
	@Override
	public Result<Boolean> submitSpg(SubmitSpgQuery query) {
		String fucNm = "发货提交";
		logger.info(fucNm + ",请求参数:{}", JSON.toJSONString(query));

		try {
			// 判断当前用户是否有权限处理该件
			// todo()
			// 判断任务当前所处的环节是否正确
			// todo()
			// 拾取并完成任务
			wfDcService.claimAndCompleteSpgTask(query.getSpgId(), query.getUsername(), query.getAplyPcstpCd(),
					query.getAplyPsrltCd(),query.getPymtmod(), query.getSelRdmgdsMod());
			logger.debug("拾取并完成任务成功！");
		} catch (Exception e) {
			logger.error("发货提交异常 {}", e);
			return Result.createFailResult("流程已被撤销，无法提交:" + e);
		}

		// 保存附件信息
		try {
			if (StringUtils.isNotEmpty(query.getFileNames())) {
				T2UploadAtch t2UploadAtch = new T2UploadAtch();
				t2UploadAtch.setRltvTp(query.getAplyPcstpCd());
				t2UploadAtch.setUsername(query.getUsername());
				t2UploadAtch.setRltvId(query.getSpgId());
				insertFile(t2UploadAtch, query.getFileNames());
			} else {
				logger.debug("保存发货提交信息，附件为空！");
			}
		} catch (Exception e) {
			logger.error("提交发货，保存附件信息异常 {}", e);
			return Result.createFailResult("提交发货，保存附件信息异常" + e);
		}

		try {
			// 保存环节流水
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			BeanUtils.copyProperties(query, t0);
			t0.setRltvId(query.getSpgId());
			t0.setProcessType("03");
			wfeUtils.saveLnkJrnlInf(t0);
		} catch (Exception e) {
			logger.error("发货提交保存环节流水异常 {}", e);
			return Result.createFailResult("发货提交保存环节流水异常:" + e);
		}

		try {
			T1ArInf t1 = new T1ArInf();
			// 更新发货状态
			//t1.setArSt(query.getAplyPcstpCd());
			//从工作流记录表中获取发货最新状态
			T1ARInfDetailVo t1Vo = t1ARInfMapper.queryArDetailByArId(query.getSpgId());
			if(t1Vo != null && t1Vo.getAplyPcstpCd() != null) {
				t1.setArSt(t1Vo.getAplyPcstpCd());
			} else {
				logger.error("更新发货信息，获取发货状态失败");
				return Result.createFailResult("更新发货信息，获取发货状态失败");
			}
			t1.setTms(new Date());
			Condition condition0 = new Condition(T6SpgInf.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Spg_ID = '" + query.getSpgId() + "'");
			int rltNum = t1ARInfMapper.updateByConditionSelective(t1, condition0);
			logger.info("更新发货状态，更新记录数：" + rltNum);
		} catch (Exception e) {
			logger.error("更新发货状态异常 {}", e);
			return Result.createFailResult("更新发货状态异常:" + e);
		}
		return Result.createSuccessResult(true);
	}

	/**
	 * 描述：查询发货详情
	 * 
	 */
	@Override
	public Result<QuerySpgSubmmitDetailOutVo> getSpgSubmmitDetail(String id, String arId, String aplyPcstpCd) {
		logger.info("查询发货提交详情,请求参数:arId={} aplyPcstpCd={}", arId, aplyPcstpCd);
		QuerySpgSubmmitDetailOutVo outVo = new QuerySpgSubmmitDetailOutVo();
		try {
			T0LnkJrnlInf t0 = null;
			t0 = t0LnkJrnlInfMapper.selectByPrimaryKey(Long.parseLong(id));
			if (t0 == null) {
				logger.error("查询发货提交详情无数据");
				return Result.createFailResult("查询发货提交详情无数据");
			} else {
				BeanUtils.copyProperties(t0, outVo);
			}
			// 查询公司名称
			if (null != outVo.getCompanyId()) {
				Company company = new Company();
				company = companyMapper.selectByPrimaryKey(outVo.getCompanyId());
				outVo.setName(company.getName());
			}

			// 查询发货提交附件信息
			Condition condition0 = new Condition(T2UploadAtch.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Rltv_ID = '" + arId + "'");
			criteria0.andCondition("Rltv_Tp = '" + aplyPcstpCd + "'");
			List<T2UploadAtch> t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			outVo.setT2UploadAtch01List(t2UploadAtch01List);
			logger.info("查询发货提交附件信息成功!");
			return Result.createSuccessResult(outVo);
		} catch (Exception e) {
			logger.error("查询发货提交详情异常 {}", e);
			return Result.createFailResult("查询发货提交详情异常" + e);
		}
	}

}
