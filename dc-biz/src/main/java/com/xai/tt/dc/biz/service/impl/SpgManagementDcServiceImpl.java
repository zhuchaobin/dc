package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.enums.KuCunType;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.biz.utils.*;
import com.xai.tt.dc.client.inter.R1LnkInfDefService;
import com.xai.tt.dc.biz.utils.MsgUtils;
import com.xai.tt.dc.client.model.*;
import com.xai.tt.dc.client.query.SubmitSpgQuery;
import com.xai.tt.dc.client.query.UserInfoQuery;
import com.xai.tt.dc.client.service.PlgAplyDcService;
import com.xai.tt.dc.client.service.SpgManagementDcService;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.inVo.OrderManagementInVo;
import com.xai.tt.dc.client.vo.inVo.SpgManagementInVo;
import com.xai.tt.dc.client.vo.outVo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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


	@Autowired
	private R1LnkInfDefService r1LnkInfDefService;

	@Autowired
	private T3OrderInfMapper t3OrderInfMapper;

    @Autowired
    private MsgUtils msgUtils;

    @Autowired
    private T11IvntInfMapper t11IvntInfMapper;

	@Autowired
	private T13GdsDetailMapper t13GdsDetailMapper;

    @Autowired
    private T17IvntDtlMapper t17IvntDtlMapper;

	@Autowired
	private T16GdsOistgJrnlMapper t16GdsOistgJrnlMapper;
	
	@Autowired
	private PlgAplyDcService plgAplyDcService;
	
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
		T11IvntInf t11IvntInf =new T11IvntInf();
		String spgId = "";
		try {
			if (null == inVo) {
				logger.error("保存发货信息请求报文不能为空");
				return Result.createFailResult("保存发货信息请求报文不能为空");
			}
			String solveType = "";
			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			// 判断处理类别  01-保存 02-提交
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
						inVo.setSpgSt("10");//保存
					}
				} else {
					solveType = "01";
					inVo.setSpgSt("10");//保存
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
						}else if("61".equals(rltT1.getSpgSt())){
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
			BeanUtils.copyProperties(inVo, t11IvntInf);

			// 发货新建后记录发货状态
			t6SpgInfo.setSpgId(spgId);
			t6SpgInfo.setCnsgn(inVo.getCnsgn());
			t6SpgInfo.setTms(new Date());
			t6SpgInfo.setCrtTm(new Date());
			t6SpgInfo.setTms(new Date());

			t11IvntInf.setRltvId(spgId);
			t11IvntInf.setRltvTp(KuCunType.FA_HUO_KU_CUN.getCode());
			t11IvntInf.setSpgId(spgId);
			t11IvntInf.setCnsgn(inVo.getCnsgn());
			t11IvntInf.setTms(new Date());
			t11IvntInf.setTms(new Date());

			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			// 
			if(StringUtils.isBlank(t6SpgInfo.getSpgSt())){
				if("05".equals(solveType) || "07".equals(solveType)|| "08".equals(solveType)) {
					t6SpgInfo.setSpgSt("61");
					t11IvntInf.setIvntSt("61");
				}
			}


			//查出订单中的支付方式
			if ( inVo.getOrdrId()!=null&& !"".equals(inVo.getOrdrId())) {
				Condition condition0 = new Condition(T3OrderInf.class);
				Example.Criteria criteria0 = condition0.createCriteria();
				criteria0.andCondition("Ordr_ID = '" + inVo.getOrdrId() + "'");
				List<T3OrderInf> t3OrderInfs = t3OrderInfMapper.selectByCondition(condition0);

				if ( t3OrderInfs!= null&&t3OrderInfs.size()>0) {

					t6SpgInfo.setPymtMod(t3OrderInfs.get(0).getPymtmod());
				};
			};

			if("01".equals(solveType) || "05".equals(solveType)|| "07".equals(solveType)) {
				t6SpgInfo.setId(null);
				t11IvntInf.setId(null);

				int num = t6SpgInfMapper.insertSelective(t6SpgInfo);

				int num1 = t11IvntInfMapper.insertSelective(t11IvntInf);


				logger.info("更新发货信息成功，插入记录数：" + num);
			} else {
				int num = t6SpgInfMapper.updateByPrimaryKeySelective(t6SpgInfo);

				int num1 = t11IvntInfMapper.updateByPrimaryKeySelective(t11IvntInf);
				logger.info("更新发货信息成功：发货id" + t6SpgInfo.getArId() + "更新条数：" + num);
			}

			// 保存发货明细信息
			// 先删除已经存在的
			Condition condition = new Condition(T7SpgDetail.class);
			Example.Criteria criteria = condition.createCriteria();
			criteria.andCondition("Spg_ID = '" + spgId + "'");
			t7SpgDetailMapper.deleteByCondition(condition);


			Condition condition2 = new Condition(T13GdsDetail.class);
			Example.Criteria criteria2 = condition2.createCriteria();
			criteria2.andCondition("Rltv_ID = '" + spgId + "'");
			t13GdsDetailMapper.deleteByCondition(condition2);

			List<T7SpgDetail> t7SpgDetailList = inVo.getT7SpgDetailList();
			if (t7SpgDetailList != null&&t7SpgDetailList.size()>0) {
				T7SpgDetail t7SpgDetail = new T7SpgDetail();
				T13GdsDetail t13GdsDetail= new T13GdsDetail();

				for (int i = 0; i < t7SpgDetailList.size(); i++) {

					T7SpgDetail elem=t7SpgDetailList.get(i);

					BeanUtils.copyProperties(elem, t7SpgDetail);
					t7SpgDetail.setSpgId(spgId);

					BeanUtils.copyProperties(elem, t13GdsDetail);
					t13GdsDetail.setRltvId(spgId);
					t13GdsDetail.setRltvTp("01");//01:发货形成库存 02：存入自由货物形成库存
					t13GdsDetail.setCrtTm(new Date());
					t13GdsDetail.setTms(new Date());
					t13GdsDetail.setUsername(inVo.getUsername());

//					t7SpgDetailMapper.insert(t7SpgDetail);

					t13GdsDetailMapper.insert(t13GdsDetail);

				}



			}



			// 保存发货附件信息
			try {
				if (StringUtils.isNotEmpty(inVo.getFileNames())) {
					T2UploadAtch t2UploadAtch = new T2UploadAtch();
					t2UploadAtch.setRltvTp("03");
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
				Condition condition1 = new Condition(T6SpgInf.class);
				Example.Criteria criteria1 = condition1.createCriteria();
				criteria1.andCondition("Spg_ID = '" + spgId + "'");
				t6SpgInfMapper.updateByConditionSelective(t6SpgInfo, condition1);
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
				t0.setRltvId(t6SpgInfo.getSpgId());
				t0.setAplyPcstpCd("61");//申请处理步骤
				t0.setAplyPsrltCd("01");
				t0.setProcessType("03");//流程类型
				t0.setId(null);
				wfeUtils.saveLnkJrnlInf(t0);
				// 拾取并完成发起任务
				wfDcService.claimAndCompleteSpgTask(spgId, inVo.getUsername(), "01", "01",inVo.getPymtmod(),"");
			}
			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			if("05".equals(solveType) || "06".equals(solveType)|| "07".equals(solveType)|| "08".equals(solveType)) {
				// 更新发货状态为新状态
				try {
					T6SpgInf t6 = new T6SpgInf();

					T11IvntInf t11 = new T11IvntInf();
					// 更新发货状态

					//从工作流记录表中获取发货最新状态

					//todo
					QuerySpgInfDetailOutVo t1Vo = t6SpgInfMapper.querySpgDetailBySpgId(spgId);
					if(t1Vo != null && t1Vo.getAplyPcstpCd() != null) {

						BeanUtils.copyProperties(t1Vo, t6);
						t6.setSpgSt(t1Vo.getAplyPcstpCd());
						t11.setIvntSt(t1Vo.getAplyPcstpCd());

						// 发送审批处理提醒信息
						// 查询长约信息
						Condition condition0 = new Condition(T1ArInf.class);
						Example.Criteria criteria0 = condition0.createCriteria();
						criteria0.andCondition("AR_ID = '" + t6.getArId() + "'");
						T1ArInf t1ar = t1ARInfMapper.selectByCondition(condition0).get(0);
						msgUtils.sendNewArTaskMsg(t1ar, null, t6, DataConstants.PROCESS_TPCD_SPG);
					} else {
						if(t1Vo != null && wfDcService.isEndProcess(t1Vo.getProcessInstId())) {
							t6.setSpgSt("99");
							t11.setIvntSt("99");
							logger.info("流程已经结束.");
						} else {
							logger.error("更新发货信息，获取发货状态失败");
							return Result.createFailResult("更新发货信息，获取发货状态失败");
						}
					}
					t6.setTms(new Date());
					t11.setTms(new Date());


					Condition condition0 = new Condition(T1ArInf.class);
					Example.Criteria criteria0 = condition0.createCriteria();
					criteria0.andCondition("Spg_ID = '" + spgId + "'");
					int rltNum = t6SpgInfMapper.updateByConditionSelective(t6, condition0);



					Condition condition1 = new Condition(T11IvntInf.class);
					Example.Criteria criteria1 = condition1.createCriteria();
					criteria1.andCondition("Rltv_ID = '" + spgId + "'");
					int rltNum1 = t11IvntInfMapper.updateByConditionSelective(t11, condition1);


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
	 * 描述：查询待处理任务数
	 *
	 * @author zhuchaobin 2019-1-29
	 */
	@Override
	public Result<List<Integer>> getAdtTaskNum(UserInfoQuery query) {
		logger.info("start query 长约信息 List =======> query:{}", query);
		logger.info("userType:" + query.getUserType());
		List<Integer> rltList = new ArrayList<Integer>();
		// 查询用户角色权限信息
		Condition condition = new Condition(User.class);
		Example.Criteria criteria = condition.createCriteria();
		criteria.andCondition("username = '" + query.getUsername() + "'");
		User user = userMapper.selectByCondition(condition).get(0);
		// 1 查询待处理长约任务数
		ArManagementInVo arInVo = new ArManagementInVo();
		arInVo.setSplchainCo(user.getSplchainCo());
		arInVo.setUserType(user.getUserType());
		arInVo.setCompanyId(user.getCompanyId());
		arInVo.setUsrTp(DataConstants.USER_TYPE_2_USR_TP.get(user.getUserType()));
		// 查询类型为：待审批
		arInVo.setQueryType(2);
		// 查询
		try {
			int count = t1ARInfMapper.count(arInVo);
			rltList.add(count);
		} catch (Exception e) {
			logger.error("查询待处理长约任务数异常 {}", e);
		}
		logger.info("查询待处理长约任务数成功!");
		// 2 查询待处理订单任务数
		OrderManagementInVo orderInVo = new OrderManagementInVo();
		orderInVo.setSplchainCo(user.getSplchainCo());
		orderInVo.setUserType(user.getUserType());
		orderInVo.setCompanyId(user.getCompanyId());
		orderInVo.setUsrTp(DataConstants.USER_TYPE_2_USR_TP.get(user.getUserType()));
		// 查询类型为：待审批
		orderInVo.setQueryType(2);
		// 查询
		try {
			int count = t3OrderInfMapper.count(orderInVo);
			rltList.add(count);
		} catch (Exception e) {
			logger.error("查询待处理订单任务数异常 {}", e);
		}
		logger.info("查询待处理订单任务数成功!");
		// 3 查询待处理发货任务数
		SpgManagementInVo spgInVo = new SpgManagementInVo();
		spgInVo.setSplchainCo(user.getSplchainCo());
		spgInVo.setUserType(user.getUserType());
		spgInVo.setCompanyId(user.getCompanyId());
		spgInVo.setUsrTp(DataConstants.USER_TYPE_2_USR_TP.get(user.getUserType()));
		// 查询类型为：待审批
		spgInVo.setQueryType(2);
		// 查询
		try {
			int count = t6SpgInfMapper.count(spgInVo);
			rltList.add(count);
		} catch (Exception e) {
			logger.error("查询待处理发货任务数异常 {}", e);
		}
		logger.info("查询待处理发货任务数成功!");
		logger.info("查询待处理任务数成功!");
		return Result.createSuccessResult(rltList);
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
		// 查询用户角色权限信息
		Condition condition = new Condition(User.class);
		Example.Criteria criteria = condition.createCriteria();
		criteria.andCondition("username = '" + query.getUsername() + "'");
		User user = userMapper.selectByCondition(condition).get(0);
		query.setSplchainCo(user.getSplchainCo());
		query.setUserType(user.getUserType());
		query.setCompanyId(user.getCompanyId());
		query.setUsrTp(DataConstants.USER_TYPE_2_USR_TP.get(user.getUserType()));
		
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
			criteria0.andCondition("Rltv_Tp = '03'");
			List<T2UploadAtch> t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			t3.setT2UploadAtch01List(t2UploadAtch01List);
			logger.info("查询发货附件信息成功!");
			// 查询发货流转信息
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			t0.setRltvId(t3.getSpgId());
			t0.setProcessType("03");
			List<QueryLnkJrnlInfOutVo> t0LnkJrnlInfList = t0LnkJrnlInfMapper.QueryLnkJrnlInfList(t0);
			if(null != t0LnkJrnlInfList) {
				t3.setList(t0LnkJrnlInfList);
				logger.info("查询发货流转详情成功!查询到数据条数：" + t0LnkJrnlInfList.size());
			}
			Condition condition1 = new Condition(T7SpgDetail.class);
			Example.Criteria criteria1 = condition1.createCriteria();
			criteria1.andCondition("Rltv_ID = '" + t3.getSpgId() + "'");
			criteria1.andCondition("Rltv_Tp = '01'");
			List<T13GdsDetail> t13GdsDetailList = t13GdsDetailMapper.selectByCondition(condition1);
			List<T7SpgDetail> t7List = new ArrayList<T7SpgDetail>();
			for(T13GdsDetail t13 : t13GdsDetailList) {
				T7SpgDetail t7 = new T7SpgDetail();
				BeanUtils.copyProperties(t13, t7);
				t7List.add(t7);
			}
			if(null != t7List || t7List.size() > 0) {				
				t3.setT7SpgDetailList(t7List);
				logger.info("查询发货明细信息成功!查询到数据条数：" + t7List.size());
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

			Result<String> result = r1LnkInfDefService.querySpecialDiv(query.getAplyPcstpCd());
			t3.setAplyPsrlt(result.getData());

			logger.info("querySpgDetail res {}", JSON.toJSONString(t3));

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
		logger.info("撤销订单请求报文", JSON.toJSONString(inVo));
		T6SpgInf t1 = t6SpgInfMapper.selectByPrimaryKey(inVo.getId());
		if (t1 == null) {
			logger.error("查询订单详情无数据");
			return Result.createFailResult("查询订单详情无数据");
		}
		try {

			logger.info("xxxxxxxxxxxxxxx{}", t1.getProcessInstId());

			// 休眠流程实例
			wfDcService.suspendProcessInstanceById(t1.getProcessInstId());

			logger.info("yyyyyyy{}", t1.getProcessInstId());
		} catch (Exception e) {
			logger.error("撤销订单休眠流程实例异常 {}", e);
			return Result.createFailResult("撤销订单休眠流程实例异常:" + e);
		}

		try {
			// 保存环节流水
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			BeanUtils.copyProperties(t1, t0);
			t0.setUsername(inVo.getUsername());
			t0.setCompanyId(inVo.getCompanyId());
			t0.setRltvId(t1.getSpgId());
			t0.setProcessType("03");
			t0.setAplyPcstpCd("11");
			t0.setAplyPsrltCd("04");
			t0.setId(null);
			wfeUtils.saveLnkJrnlInf(t0);
		} catch (Exception e) {
			logger.error("撤销订单保存环节流水异常 {}", e);
			return Result.createFailResult("撤销订单保存环节流水异常:" + e);
		}

		try {
			// 更新订单状态
			t1.setSpgSt("11");
			t1.setTms(new Date());
			Condition condition0 = new Condition(T6SpgInf.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Spg_ID = '" + t1.getSpgId() + "'");
			int rltNum = t6SpgInfMapper.updateByConditionSelective(t1, condition0);
			logger.info("更新订单状态，更新记录数：" + rltNum);
		} catch (Exception e) {
			logger.error("更新订单状态异常 {}", e);
			return Result.createFailResult("更新订单状态异常:" + e);
		}
		return Result.createSuccessResult(true);
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

		String aplyPcstpCd = query.getAplyPcstpCd();

		// 保存附件信息
		try {
			if (StringUtils.isNotEmpty(query.getFileNames())) {
				T2UploadAtch t2UploadAtch = new T2UploadAtch();
				t2UploadAtch.setRltvTp(aplyPcstpCd);
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
		
		// 2019-03-24转货权操作
        if("72".equals(aplyPcstpCd) && "01".equals(query.getAplyPsrltCd())){
        	// 查询长约信息中融资企业
			try {
				Condition condition = new Condition(T1ArInf.class);
				Example.Criteria criteria = condition.createCriteria();
				criteria.andCondition("AR_ID = '" + query.getArId() + "'");
				List<T1ArInf> t1List = t1ARInfMapper.selectByCondition(condition);
				if(null != t1List && t1List.size() > 0) {
					T1ArInf t1 = t1List.get(0);				
					Condition condition3 = new Condition(T17IvntDtl.class);
					Example.Criteria criteria3 = condition3.createCriteria();
					criteria3.andCondition("Spg_ID = '" + query.getSpgId() + "'");
					T17IvntDtl record = new T17IvntDtl();
					record.setGdsBlgId(t1.getFncEntp().longValue());
					t17IvntDtlMapper.updateByConditionSelective(record, condition3);				
				} else {
					logger.error("发货提交转货权异常查询不到长约信息，提交失败");
					return Result.createFailResult("发货提交转货权异常查询不到长约信息，提交失败");
				}
			} catch (Exception e) {
				logger.error("发货提交转货权异常 {}", e);
				return Result.createFailResult("发货提交转货权异常 :" + e);
			}
        }
		
		T6SpgInf t6=null;

		try {
			// 判断当前用户是否有权限处理该件
			// todo()
			// 判断任务当前所处的环节是否正确
			// todo()
			// 查询付款方式
			Condition condition0 = new Condition(T6SpgInf.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Spg_ID = '" + query.getSpgId() + "'");
			t6 = t6SpgInfMapper.selectByCondition(condition0).get(0);

 
			String selRdmgdsMod=StringUtils.isEmpty(t6.getSelRdmgdsMod())?query.getSelRdmgdsMod():t6.getSelRdmgdsMod();


			logger.info("t6.getSelRdmgdsMod():{}",t6.getSelRdmgdsMod());
			logger.info("query.getSelRdmgdsMod():{}",query.getSelRdmgdsMod());
			logger.info("selRdmgdsMod:{}",selRdmgdsMod);
			
			// 拾取并完成任务
			logger.info("发货管理拾取完成任务aplyPcstpCd=" + aplyPcstpCd);
			logger.info("发货管理拾取完成任务query.getAplyPsrltCd()=" + query.getAplyPsrltCd());
			logger.info("发货管理拾取完成任务query.getPymtMod()=" + query.getPymtMod());
			wfDcService.claimAndCompleteSpgTask(query.getSpgId(), query.getUsername(), aplyPcstpCd,
					query.getAplyPsrltCd(),query.getPymtMod(), selRdmgdsMod);
			logger.debug("拾取并完成任务成功！");
		} catch (Exception e) {
			logger.error("发货提交异常 {}", e);
			return Result.createFailResult("流程已被撤销，无法提交:" + e);
		}

		//自动质押，zhuchaobin，20190318
		if("01".equals(query.getAplyPsrltCd()) && "72".equals(aplyPcstpCd)){
			if(plgAplyDcService.autoPlg(query.getSpgId())) {
				logger.info("自动质押成功！");
				
				try {
					// 保存环节流水
					T0LnkJrnlInf t0 = new T0LnkJrnlInf();
					t0.setUsername("999999");
					t0.setCompanyId(-1);
					t0.setRltvId(query.getSpgId());
					t0.setProcessType("03");
					t0.setAplyPcstpCd("80");
					t0.setAplyPsrltCd("01");
					t0.setTms(new Date());
					wfeUtils.saveLnkJrnlInf(t0);
				} catch (Exception e) {
					logger.error("撤销订单保存环节流水异常 {}", e);
					return Result.createFailResult("撤销订单保存环节流水异常:" + e);
				}
				
			} else {
				logger.error("自动质押失败！");
			}
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
			T6SpgInf t1 = new T6SpgInf();

			T11IvntInf t11=new T11IvntInf();

			//从工作流中取出当前步骤代码


			// 更新发货状态
			QuerySpgInfDetailOutVo t6Vo = t6SpgInfMapper.querySpgDetailBySpgId(query.getSpgId());
			logger.info("tt6Vo():{}",JSON.toJSONString(t6Vo));

			if (aplyPcstpCd != null&&!"".equals(aplyPcstpCd)&&("65".equals(aplyPcstpCd)||"66".equals(aplyPcstpCd))) {

				t1.setSelRdmgdsMod(query.getSelRdmgdsMod());

			};

			if (t6Vo != null && StringUtils.isNotBlank(t6Vo.getAplyPcstpCd())) {
				BeanUtils.copyProperties(t6Vo, t1);
				t1.setSpgSt(t6Vo.getAplyPcstpCd());

				// 发送审批处理提醒信息
				// 查询长约信息
				Condition condition0 = new Condition(T1ArInf.class);
				Example.Criteria criteria0 = condition0.createCriteria();
				criteria0.andCondition("AR_ID = '" + t1.getArId() + "'");
				T1ArInf t1ar = t1ARInfMapper.selectByCondition(condition0).get(0);
				msgUtils.sendNewArTaskMsg(t1ar, null, t1, DataConstants.PROCESS_TPCD_SPG);

			} else {
				// 判断流程是否结束
				if(t6Vo != null && wfDcService.isEndProcess(t6Vo.getProcessInstId())) {
					logger.error("流程已结束，设置状态为99");
					t1.setSpgSt("99");
				} else {
					logger.error("更新发货信息，获取发货状态失败");
					return Result.createFailResult("更新发货信息，获取发货状态失败");
				}
			}

			t1.setTms(new Date());

			t11.setRltvId(query.getSpgId());
			t11.setIvntSt(t6Vo.getAplyPcstpCd());

			//
			if ("62".equals(t6Vo.getAplyPcstpCd())){
				t11.setVhclNum(query.getVhclNum());
				t11.setTprtModAndImt(query.getTprtModAndImt());
				t11.setLgstcCo(query.getLgstcCo());
				t11.setRevMnyPsn(query.getRevMnyPsn());
				t11.setRevMnyRmrk(query.getRevMnyRmrk());
				t11.setRevMnyTm(new Date());

			}	else  if ("63".equals(t6Vo.getAplyPcstpCd())){

				t11.setStgco(query.getStgco());
				t11.setIntrsrPsn(query.getIntrsrPsn());
				t11.setIntrsrTm(new Date());
				t11.setIntrsrRmrk(query.getIntrsrRmrk());

			}else  if ("63".equals(t6Vo.getAplyPcstpCd())){

				t11.setOutstgTm(new Date());
			}	else  if ("68".equals(t6Vo.getAplyPcstpCd())){
				t11.setPlgSt(Integer.parseInt(t6Vo.getAplyPcstpCd()));
			}





			Condition condition0 = new Condition(T11IvntInf.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Rltv_ID = '" + query.getSpgId() + "'");
			int rltNum = t11IvntInfMapper.updateByConditionSelective(t11, condition0);



			Condition condition1 = new Condition(T6SpgInf.class);
			Example.Criteria criteria1 = condition1.createCriteria();
			criteria1.andCondition("Spg_ID = '" + query.getSpgId() + "'");
			int rltNum1 = t6SpgInfMapper.updateByConditionSelective(t1, condition1);
			logger.info("更新发货状态，更新记录数：" + rltNum);
			logger.info("更新库存状态，更新记录数：" + rltNum);
		} catch (Exception e) {
			logger.error("更新发货状态异常 {}", e);
			return Result.createFailResult("更新发货状态异常:" + e);
		}







//		61 发货发起   待承运
//		62 接货承运   已承运，运输中
//		63 接货入库   在库
//
//		68 质押置换   质押中
//
//		77 提取货物   已出库
		if ("01".equals(t6.getPymtMod())){

			if ("62".equals(aplyPcstpCd)||"63".equals(aplyPcstpCd)){


				int rltNum = updateT11ivntInf(query,aplyPcstpCd);

			}

		}else  	if ("02".equals(t6.getPymtMod())){

			if ("62".equals(aplyPcstpCd)||"63".equals(aplyPcstpCd)||"64".equals(aplyPcstpCd)){


				int rltNum = updateT11ivntInf(query,aplyPcstpCd);

			}


		}else  	if ("03".equals(t6.getPymtMod())){

			if ("63".equals(aplyPcstpCd)){

///				saveT11ivntInf(query, t6);

			}

		}


        if ("63".equals(aplyPcstpCd)){

            String StrPost = DateUtils.noFormatDate() + sequenceUtils.getSequence("Cd_Seq", 4);


			try {
				T1ArInf t1 = null;
				Condition condition = new Condition(T1ArInf.class);
				Example.Criteria criteria = condition.createCriteria();
				criteria.andCondition("AR_ID = '" + query.getArId() + "'");
				List<T1ArInf> t1List = t1ARInfMapper.selectByCondition(condition);
				if(null != t1List && t1List.size() > 0) {
					t1 = t1List.get(0);				
				}
				if(null == t1) {
					logger.error("发货提交查询长约信息失败");
					return Result.createFailResult("发货提交查询长约信息失败");
				}
				for(T13GdsDetail t13 : query.getT13GdsDetailList()) {
					// 保存质押货物明细
					t13.setRltvTp("03");//01:发货明细 02：质押明细 03：发货入库明细 04：出库明细
					String rltvId = "CD" + StrPost;

					t13.setRltvId(rltvId);
					t13.setTms(new Date());
					t13.setCrtTm(new Date());
					t13.setUsername(query.getUsername());
					t13GdsDetailMapper.insert(t13);
					// 货物入库
					T17IvntDtl t17 = new T17IvntDtl();

					t17.setPdId(t13.getPdId()==null?0L:t13.getPdId().longValue());
					t17.setPdNm(t13.getPdNm());
					t17.setSpec(t13.getSpec());
					t17.setModl(t13.getModl());
					t17.setQlyStd(t13.getQlyStd());
					t17.setBrnd(t13.getBrnd());
					t17.setPdFctr(t13.getPdFctr());

					BeanUtils.copyProperties(query, t17, CommonUtils.getNullPropertyNames(query));


					t17.setWhrecptId(t13.getRltvId());
					t17.setIntrsrTp("03");// 02：存入自有货物 03：上游发货形成
					t17.setIntrsrTnum(t13.getNum());
					t17.setInthestgTnum(t13.getNum());
					t17.setOutstgTnum(0f);
//					t17.setArId(query.getArId());
//					t17.setOrdrId(query.getOrdrId());
//					t17.setSpgId(query.getSpgId());
					t17.setPlgBillno("ZY" + StrPost);

					t17.setGdsBlgId(t1.getSplchainCo().longValue());
					t17.setGdsBlgNm("");
					t17.setPlgAplySt("03");
					t17.setCrtTm(new Date());
					t17.setTms(new Date());

					t17.setStgco(t1.getStgco().longValue());

					t17IvntDtlMapper.insert(t17);


					T16GdsOistgJrnl t16= new T16GdsOistgJrnl();

					t16.setMnpltTrcno(rltvId);
					t16.setArId(query.getArId());
					t16.setOrdrId(query.getOrdrId());
					t16.setSpgId(query.getSpgId());
					t16.setRltvId(rltvId);
					t16.setRltvTp("03");
					t16.setTms(new Date());
					t16.setOpr(query.getUsername());
					t16.setCrtTm(new Date());
					t16.setUdtTm(new Date());
					t16.setRmrk("1");
					t16.setStgco(0L);
					t16.setStgcoNm("1");
					t16.setStrPos("1");
					t16GdsOistgJrnlMapper.insert(t16);

				}
			} catch (DuplicateKeyException e) {
				logger.info("主键冲突：e{}" , e);
			}


		}



		return Result.createSuccessResult(true);
	}
	
	
	// 自动质押 20190318, zhuchaobin
	private boolean autoSpy(String spgId) {
		return true;
	}
	

	private int updateT11ivntInf(SubmitSpgQuery query,String ivnSt) {
		String spgId = query.getSpgId();
		String kcId="KC"+spgId.substring(2);

		T11IvntInf t11 = new T11IvntInf();

		t11.setTms(new Date());
		t11.setIvntSt(ivnSt);
		Condition condition0 = new Condition(T6SpgInf.class);
		Example.Criteria criteria0 = condition0.createCriteria();
		criteria0.andCondition("Tprt_Bl_ID = '" + kcId+ "'");
		return t11IvntInfMapper.updateByConditionSelective(t11, condition0);
	}

	private void saveT11ivntInf(SubmitSpgQuery query, T6SpgInf t6) {
		String spgId = query.getSpgId();
		String ydId="YD"+spgId.substring(2);

		T11IvntInf t11 = new T11IvntInf();
		t11.setTprtBlId(ydId);
		t11.setSpgId(spgId);
		t11.setSpgPsn(t6.getSpgPsn());
		t11.setSpgCtcTel(t6.getSpgPsnCtcTel());
		t11.setSpgRmrk("");
		t11.setCnsgn(t6.getCnsgn());
		t11.setRcvgCtcTel(t6.getCnsgnCtcTel());
		t11.setPpsLnd(t6.getPpsLnd());
		t11.setPdFctr("");
		t11.setSpgTm(t6.getCrtTm());
		t11.setVhclNum(0);
		t11.setTprtModAndImt("");
		t11.setLgstcCo(0);
		t11.setRevMnyPsn("");
		t11.setRevMnyCtcTel("");
		t11.setRevMnyTm(new Date());
		t11.setRevMnyRmrk("");
		t11.setStgco(0);
		t11.setIntrsrPsn("");
		t11.setIntrsrTm(new Date());
		t11.setIntrsrRmrk("");
		t11.setOutstgTm(null);
		t11.setPlgSt(0);
		t11.setStrBit("");
		t11.setWhrecptId("");
		t11.setIvntSt("63");
		t11.setPlgWarnStcd("");
		t11.setTms(new Date());
		t11.setUsername("");
		t11.setSlfownGdsId("");
		t11.setDepPsn("");
		t11.setDepTm(new Date());
		t11.setGdsBlg(0);
		t11IvntInfMapper.insert(t11);
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

				if (company != null) {
					outVo.setName(company.getName());
				};

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
