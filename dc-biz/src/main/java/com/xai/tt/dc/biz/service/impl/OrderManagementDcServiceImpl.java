package com.xai.tt.dc.biz.service.impl;

import java.util.ArrayList;
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
import com.esotericsoftware.minlog.Log;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.CompanyMapper;
import com.xai.tt.dc.biz.mapper.T0LnkJrnlInfMapper;
import com.xai.tt.dc.biz.mapper.T12InvInfMapper;
import com.xai.tt.dc.biz.mapper.T1ArInfMapper;
import com.xai.tt.dc.biz.mapper.T3OrderInfMapper;
import com.xai.tt.dc.biz.mapper.T8OrderDetailMapper;
import com.xai.tt.dc.biz.mapper.UserMapper;
import com.xai.tt.dc.biz.mapper.T2UploadAtchMapper;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.biz.utils.DateUtils;
import com.xai.tt.dc.biz.utils.MsgUtils;
import com.xai.tt.dc.biz.utils.SequenceUtils;
import com.xai.tt.dc.biz.utils.WfeUtils;
import com.xai.tt.dc.client.inter.R1LnkInfDefService;
import com.xai.tt.dc.client.model.Company;
import com.xai.tt.dc.client.model.T0LnkJrnlInf;
import com.xai.tt.dc.client.model.T12InvInf;
import com.xai.tt.dc.client.model.T1ArInf;
import com.xai.tt.dc.client.model.T3OrderInf;
import com.xai.tt.dc.client.model.T8OrderDetail;
import com.xai.tt.dc.client.model.User;
import com.xai.tt.dc.client.model.T2UploadAtch;
import com.xai.tt.dc.client.query.SubmitOrderQuery;
import com.xai.tt.dc.client.service.OrderManagementDcService;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.inVo.OrderManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryArSubmmitDetailOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryLnkJrnlInfOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryOrderInfDetailOutVo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@SuppressWarnings("deprecation")
@Service("orderManagementDcService")
public class OrderManagementDcServiceImpl implements OrderManagementDcService {
	private static final Logger logger = LoggerFactory.getLogger(OrderManagementDcServiceImpl.class);
	@Autowired
	private T3OrderInfMapper t3OrderInfMapper;

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
	private UserMapper userMapper;

	@Autowired
	private T8OrderDetailMapper t8OrderDetailMapper;
	
	@Autowired
	private R1LnkInfDefService r1LnkInfDefService;
	
	@Autowired
	private T12InvInfMapper t12InvInfMapper;
	
	@Autowired
	private T1ArInfMapper t1ARInfMapper;
	
	@Autowired
	private MsgUtils msgUtils;
	
	/**
	 * 描述：保存订单信息
	 * 
	 * @author zhuchaobin 2018-12-17 二级服务码secSrvCd 01:保存 02:发起
	 */
	@Override
	public Result<Boolean> save(OrderManagementInVo inVo) {
		logger.info("保存订单信息请求报文{}", JSON.toJSONString(inVo));
		logger.info("二级服务码secSrvCd：" + inVo.getSecSrvCd());
		// 保存订单信息
		T3OrderInf t3OrderInf = new T3OrderInf();
		String orderId = "";
		try {
			if (null == inVo) {
				logger.error("保存订单信息请求报文不能为空");
				return Result.createFailResult("保存订单信息请求报文不能为空");
			}
			String solveType = "";
			// 01:新发起保存 02：退回件保存 03：撤销件保存 04：保存件保存
			// 05:新发起发起 06：退回件发起 07：撤销件发起 08：保存件发起
			// 判断处理类别
			if ("01".equals(inVo.getSecSrvCd())) {
				if (null != inVo.getId()) {
					T3OrderInf rltT3 = t3OrderInfMapper.selectByPrimaryKey(inVo.getId());
					if ((null != rltT3)) {
						// 撤销件
						if ("11".equals(rltT3.getOrdrSt())) {
							solveType = "03";
						} else if ("10".equals(rltT3.getOrdrSt())) {
							solveType = "04";
						} else if ("01".equals(rltT3.getOrdrSt())) {
							solveType = "02";
						}
					} else {
						solveType = "01";
						inVo.setOrdrSt("10");
					}
				} else {
					solveType = "01";
					inVo.setOrdrSt("10");
				}
			} else if ("02".equals(inVo.getSecSrvCd())) {
				if (null != inVo.getId()) {
					T3OrderInf rltT3 = t3OrderInfMapper.selectByPrimaryKey(inVo.getId());
					if ((null != rltT3)) {
						// 撤销件
						if ("11".equals(rltT3.getOrdrSt())) {
							solveType = "07";
						} else if ("10".equals(rltT3.getOrdrSt())) {
							solveType = "08";
						} else if ("01".equals(rltT3.getOrdrSt())) {
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
			// 01:新发起保存 02：退回件保存 03：撤销件保存 04：保存件保存
			// 05:新发起发起 06：退回件发起 07：撤销件发起 08：保存件发起
			if ("01".equals(solveType) || "05".equals(solveType) || "07".equals(solveType)) {
				orderId = "DD" + DateUtils.noFormatDate() + sequenceUtils.getSequence("T3_Order_Inf_Seq", 4);
			} else {
				orderId = inVo.getOrdrId();
			}
			if (StringUtils.isBlank(orderId)) {
				logger.error("订单编号不能为空！");
				return Result.createFailResult("订单编号不能为空！");
			}
			BeanUtils.copyProperties(inVo, t3OrderInf);
			// 订单新建后记录订单状态
			t3OrderInf.setOrdrId(orderId);
			t3OrderInf.setTms(new Date());
			t3OrderInf.setCrtTm(new Date());

			// 01:新发起保存 02：退回件保存 03：撤销件保存 04：保存件保存
			// 05:新发起发起 06：退回件发起 07：撤销件发起 08：保存件发起
			//
			if (StringUtils.isBlank(t3OrderInf.getOrdrSt())) {
				if ("05".equals(solveType) || "07".equals(solveType) || "08".equals(solveType)) {
					t3OrderInf.setOrdrSt("01");
				}
			}
			if ("01".equals(solveType) || "05".equals(solveType) || "07".equals(solveType)) {
				t3OrderInf.setId(null);
				int num = t3OrderInfMapper.insertSelective(t3OrderInf);
				logger.info("更新订单信息成功，插入记录数：" + num);
			} else {
				int num = t3OrderInfMapper.updateByPrimaryKeySelective(t3OrderInf);
				logger.info("更新订单信息成功：订单id" + t3OrderInf.getArId() + "更新条数：" + num);
			}

			// 保存订单明细信息
			// 先删除已经存在的
			Condition condition = new Condition(T8OrderDetail.class);
			Example.Criteria criteria = condition.createCriteria();
			criteria.andCondition("Ordr_ID = '" + orderId + "'");
			t8OrderDetailMapper.deleteByCondition(condition);

			List<T8OrderDetail> t8OrderDetailList = inVo.getT8OrderDetailList();
			T8OrderDetail t8 = new T8OrderDetail();
			for (T8OrderDetail elem : t8OrderDetailList) {
				BeanUtils.copyProperties(elem, t8);
				t8.setOrdrId(orderId);
				t8.setCrtTm(new Date());
				t8.setUsername(inVo.getUsername());
				t8OrderDetailMapper.insert(t8);
			}

			// 保存订单附件信息
			try {
				if (StringUtils.isNotEmpty(inVo.getFileNames())) {
					T2UploadAtch t2UploadAtch = new T2UploadAtch();
					t2UploadAtch.setRltvTp("02");
					t2UploadAtch.setUsername(inVo.getUsername());
					t2UploadAtch.setRltvId(orderId);
					insertFile(t2UploadAtch, inVo.getFileNames());
				} else {
					logger.error("保存订单信息，订单附件为空！");
				}
			} catch (Exception e) {
				logger.error("保存订单附件信息异常 {}", e);
				return Result.createFailResult("保存订单附件信息发生异常" + e);
			}

			// 删除订单附件信息
			if (StringUtils.isNotBlank(inVo.getFilesToDelete())) {
				try {
					String[] files = inVo.getFilesToDelete().split("\\|\\|");
					for (String fileId : files) {
						logger.info("删除附件开始，附件id:" + fileId);
						t2UploadAtchMapper.deleteByPrimaryKey(Long.parseLong(fileId));
						logger.info("删除附件结束，附件id:" + fileId);
					}
				} catch (Exception e) {
					logger.error("删除订单附件信息异常 {}", e);
					return Result.createFailResult("删除订单附件信息发生异常" + e);
				}
			}

			// 如果是发起，保存流程实例id到订单信息表
			// 05:新发起发起 07：撤销件发起 08：保存件发起
			if ("05".equals(solveType) || "07".equals(solveType) || "08".equals(solveType)) {
				String processInstId = wfDcService.startProcessInstance(DataConstants.PROCESS_NAME_ORDER);
				if (StringUtils.isBlank(processInstId)) {
					logger.error("发起订单，启动流程失败!");
					return Result.createFailResult("发起订单，启动流程失败!");
				} else {
					logger.error("发起订单，启动流程成功，processInstId:" + processInstId);
				}
				t3OrderInf.setProcessInstId(processInstId);
				Condition condition2 = new Condition(T3OrderInf.class);
				Example.Criteria criteria2 = condition.createCriteria();
				criteria.andCondition("Ordr_ID = '" + orderId + "'");
				t3OrderInfMapper.updateByConditionSelective(t3OrderInf, condition);
				logger.info("processInstId =" + processInstId);
			}

			// 01:新发起保存 02：退回件保存 03：撤销件保存 04：保存件保存
			// 05:新发起发起 06：退回件发起 07：撤销件发起 08：保存件发起
			if ("05".equals(solveType) || "06".equals(solveType) || "07".equals(solveType) || "08".equals(solveType)) {
				// 拾取并完成发起任务
				wfDcService.claimAndCompleteOrderTask(orderId, inVo.getUsername(), "01", "01", inVo.getPymtmod());
				// 保存环节流水
				T0LnkJrnlInf t0 = new T0LnkJrnlInf();
				BeanUtils.copyProperties(t3OrderInf, t0);
				t0.setUsername(inVo.getUsername());
				t0.setCompanyId(inVo.getCompanyId());
				t0.setRltvId(t3OrderInf.getOrdrId());
				t0.setAplyPcstpCd("01");
				t0.setAplyPsrltCd("01");
				t0.setProcessType("02");
				t0.setId(null);
				wfeUtils.saveLnkJrnlInf(t0);
			}
			// 01:新发起保存 02：退回件保存 03：撤销件保存 04：保存件保存
			// 05:新发起发起 06：退回件发起 07：撤销件发起 08：保存件发起
			if ("05".equals(solveType) || "06".equals(solveType) || "07".equals(solveType) || "08".equals(solveType)) {
				// 更新订单状态为新状态
				try {
					T3OrderInf t3 = new T3OrderInf();
					// 更新订单状态
					// t1.setOrdrSt(query.getAplyPcstpCd());
					// 从工作流记录表中获取订单最新状态
					QueryOrderInfDetailOutVo t1Vo = t3OrderInfMapper.queryOrderDetailByOrderId(orderId);
					if (t1Vo != null && t1Vo.getAplyPcstpCd() != null) {
						BeanUtils.copyProperties(t1Vo, t3);
						t3.setOrdrSt(t1Vo.getAplyPcstpCd());

						// 发送审批处理提醒信息
						// 查询长约信息
						Condition condition0 = new Condition(T1ArInf.class);
						Example.Criteria criteria0 = condition0.createCriteria();
						criteria0.andCondition("AR_ID = '" + t3.getArId() + "'");
						T1ArInf t1 = t1ARInfMapper.selectByCondition(condition0).get(0);
						msgUtils.sendNewArTaskMsg(t1, t3, null, DataConstants.PROCESS_TPCD_ORDER);
					} else {
						if (t1Vo != null && wfDcService.isEndProcess(t1Vo.getProcessInstId())) {
							t3.setOrdrSt("99");
							logger.info("流程已经结束.");
						} else {
							logger.error("更新订单信息，获取订单状态失败");
							return Result.createFailResult("更新订单信息，获取订单状态失败");
						}
					}
					t3.setTms(new Date());
					Condition condition0 = new Condition(T3OrderInf.class);
					Example.Criteria criteria0 = condition0.createCriteria();
					criteria0.andCondition("Ordr_ID = '" + orderId + "'");
					int rltNum = t3OrderInfMapper.updateByConditionSelective(t3, condition0);
					logger.info("更新订单状态，更新记录数：" + rltNum);
				} catch (Exception e) {
					logger.error("更新订单状态异常 {}", e);
					return Result.createFailResult("更新订单状态异常:" + e);
				}
			}
		} catch (Exception e) {
			logger.error("保存订单信息异常 {}", e);
			return Result.createFailResult("保存订单信息发生异常" + e);
		}
		return Result.createSuccessResult(true);
	}

	/**
	 * 描述：删除订单
	 * 
	 * @author zhuchaobin 2018-12-18
	 */
	@Override
	public Result<Boolean> deleteOrder(String id) {
		logger.info("删除订单,请求参数:{}", id);
		try {
			t3OrderInfMapper.deleteByPrimaryKey(Long.parseLong(id));
			logger.info("删除订单成功!");
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除订单异常 {}", e);
			return Result.createFailResult("删除订单异常" + e);
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
					logger.debug("保存订单附件信息");
					t2UploadAtchMapper.updateByPrimaryKeySelective(t2);
				} else {
					// 插入记录
					logger.debug("更新订单附件信息");
					t2UploadAtchMapper.insert(t2);
				}
			}
			// t2UploadAtchMapper.insertList(t2UploadAtchs);
		} catch (Exception e) {
			logger.info("保存附件信息发生异常：", e);
		}

	}

	/**
	 * 描述：查询订单列表（分页）
	 * 
	 * @author zhuchaobin 2018-12-18
	 */
	@Override
	public Result<PageData<QueryOrderInfDetailOutVo>> queryPage(OrderManagementInVo query, PageParam pageParam) {
		logger.info("start query 订单信息 List =======> query:{},page:{}", query, pageParam);
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
		
		Page<QueryOrderInfDetailOutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = t3OrderInfMapper.selectByT3OrderInfDcQuery(query);
			count = t3OrderInfMapper.count(query);
		} catch (Exception e) {

			logger.error("查询订单列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("query success!");
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}

	/**
	 * 描述：查询订单详情
	 * 
	 * @author zhuchaobin 2018-12-18
	 */
	@Override
	public Result<QueryOrderInfDetailOutVo> queryArDetail(OrderManagementInVo query) {
		logger.info("查询订单详情,请求参数:{}", JSON.toJSONString(query));
		try {
			QueryOrderInfDetailOutVo t3 = null;
			t3 = t3OrderInfMapper.queryOrderDetail(query.getId().intValue());
			if (t3 == null) {
				logger.error("查询订单详情无数据");
				return Result.createFailResult("查询订单详情无数据");
			}
			// 查询订单附件信息
			Condition condition0 = new Condition(T2UploadAtch.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Rltv_ID = '" + t3.getOrdrId() + "'");
			criteria0.andCondition("Rltv_Tp = '02'");
			List<T2UploadAtch> t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			t3.setT2UploadAtch01List(t2UploadAtch01List);
			logger.info("查询订单附件信息成功!");
			// 查询订单流转信息
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			t0.setRltvId(t3.getOrdrId());
			t0.setProcessType("02");
			List<QueryLnkJrnlInfOutVo> t0LnkJrnlInfList = t0LnkJrnlInfMapper.QueryLnkJrnlInfList(t0);
			if (null != t0LnkJrnlInfList) {
				t3.setList(t0LnkJrnlInfList);
				logger.info("查询订单流转详情成功!查询到数据条数：" + t0LnkJrnlInfList.size());
			}
			Condition condition1 = new Condition(T8OrderDetail.class);
			Example.Criteria criteria1 = condition1.createCriteria();
			criteria1.andCondition("Ordr_ID = '" + t3.getOrdrId() + "'");
			List<T8OrderDetail> t8OrderDetailList = t8OrderDetailMapper.selectByCondition(condition1);
			if (null != t8OrderDetailList) {
				t3.setT8OrderDetailList(t8OrderDetailList);
				logger.info("查询订单明细信息成功!查询到数据条数：" + t8OrderDetailList.size());
			}
			logger.info("查询订单详情成功!");
			// 查询用户角色参数权限信息
			List<String> userRoleParmsList = userMapper.QueryUserRoleParms(query.getUsername());
			String userRoleParms = "";
			for (String ele : userRoleParmsList) {
				userRoleParms = userRoleParms + "|" + ele;
			}
			if (StringUtils.isNotBlank(userRoleParms)) {
				String[] str = userRoleParms.split("\\|");
				List<String> list = new ArrayList<String>();
				for (String elem : str) {
					list.add(elem);
				}
				t3.setRoleParmsList(list);
			} else {
				logger.error("查询用户角色参数权限信息，结果为空");
			}
			// 如果是订单提交的查询
			if("1".equals(query.getFlag())) {
				//查询个性化审批界面
				Log.info("query.getAplyPcstpCd():" + query.getAplyPcstpCd());
				Result<String> result = r1LnkInfDefService.querySpecialDiv(query.getAplyPcstpCd());
				t3.setAplyPsrlt(result.getData());
			}
						
			return Result.createSuccessResult(t3);
		} catch (Exception e) {
			logger.error("查询订单详情异常 {}", e);
			return Result.createFailResult("查询订单详情异常" + e);
		}
	}

	/**
	 * 描述：撤销订单
	 * 
	 * @author zhuchaobin 2018-12-18
	 */
	@Override
	public Result<Boolean> unDoOrder(OrderManagementInVo inVo) {
		logger.info("撤销订单请求报文", JSON.toJSONString(inVo));
		T3OrderInf t1 = t3OrderInfMapper.selectByPrimaryKey(inVo.getId());
		if (t1 == null) {
			logger.error("查询订单详情无数据");
			return Result.createFailResult("查询订单详情无数据");
		}
		try {
			// 休眠流程实例
			wfDcService.suspendProcessInstanceById(t1.getProcessInstId());
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
			t0.setRltvId(t1.getArId());
			t0.setProcessType("02");
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
			t1.setOrdrSt("11");
			t1.setTms(new Date());
			Condition condition0 = new Condition(T3OrderInf.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Ordr_ID = '" + t1.getOrdrId() + "'");
			int rltNum = t3OrderInfMapper.updateByConditionSelective(t1, condition0);
			logger.info("更新订单状态，更新记录数：" + rltNum);
		} catch (Exception e) {
			logger.error("更新订单状态异常 {}", e);
			return Result.createFailResult("更新订单状态异常:" + e);
		}
		return Result.createSuccessResult(true);
	}

	/**
	 * 描述：订单提交
	 * 
	 * @author zhuchaobin 2018-12-18
	 */
	@Override
	public Result<Boolean> submitOrder(SubmitOrderQuery query) {
		String fucNm = "订单提交";
		logger.info(fucNm + ",请求参数:{}", JSON.toJSONString(query));

		try {
			// 判断当前用户是否有权限处理该件
			// todo()
			// 判断任务当前所处的环节是否正确
			// todo()
			// 查询付款方式
			Condition condition0 = new Condition(T3OrderInf.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Ordr_ID = '" + query.getOrdrId() + "'");
			T3OrderInf t3 = t3OrderInfMapper.selectByCondition(condition0).get(0);

			// 拾取并完成任务
			wfDcService.claimAndCompleteOrderTask(query.getOrdrId(), query.getUsername(), query.getAplyPcstpCd(),
					query.getAplyPsrltCd(), t3.getPymtmod());
			logger.debug("拾取并完成任务成功！");
			
			// 保证金支付、融资发放、货款支付、货款支付四个环节需要生成发票信息,去掉后面两个货款支付的环节，业务说不用记了
			if("33".equals(query.getAplyPcstpCd()) || "34".equals(query.getAplyPcstpCd())
					/*|| "35".equals(query.getAplyPcstpCd()) || "36".equals(query.getAplyPcstpCd())*/) {
				T12InvInf t12 = new T12InvInf();
//				t12.setPyr(query.getCompanyId());
				// 查询长约信息，获取收款方id
				Condition condition = new Condition(T1ArInf.class);
				Example.Criteria criteria = condition.createCriteria();
				criteria.andCondition("AR_ID = '" + query.getArId() + "'");
				T1ArInf t1 = t1ARInfMapper.selectByCondition(condition).get(0);
				if(null != t1) {
					if("33".equals(query.getAplyPcstpCd())){
						t12.setRcvprt(t1.getBnk());
						t12.setPyr(t1.getFncEntp());
					} else if("34".equals(query.getAplyPcstpCd())){
						t12.setRcvprt(t1.getFncEntp());
						t12.setPyr(t1.getBnk());
					} else if("35".equals(query.getAplyPcstpCd())){
						t12.setRcvprt(t1.getSplchainCo());
						t12.setPyr(t1.getFncEntp());
					}  else if("36".equals(query.getAplyPcstpCd())){
						t12.setRcvprt(t1.getUstrmSplr());
						t12.setPyr(t1.getSplchainCo());
					}  
				}
				// 查询付款方公司信息，获取发票抬头
				Company company = companyMapper.selectByPrimaryKey(query.getCompanyId());
				if(null != company) {
					String prpslInvHd = "";
					prpslInvHd += ("公司名称：\t\t" + company.getName());
					prpslInvHd += ("\r\n纳税人识别号：\t" + company.getTaxpyrIdNo());
					prpslInvHd += ("\r\n开户行：\t\t\t" + company.getDepbnk());
					prpslInvHd += ("\r\n银行账户号：\t\t" + company.getBnkAccNo());
					prpslInvHd += ("\r\n负责人：\t\t\t" + company.getBnkAccNo());
					prpslInvHd += ("\r\n注册地址：\t\t" + company.getRgtads());
					t12.setPrpslInvHd(prpslInvHd);
				} else {
					logger.error("查询付款方公司信息失败!");
				}
				t12.setAmt(query.getAmt());
				t12.setPyTm(new Date());
				t12.setPyRsn(DataConstants.APLY_PCSTPCD_2_CHS.get(query.getAplyPcstpCd()));
				t12.setAprvPsn(query.getUsername());
				t12.setAprvTm(new Date());
				t12.setRmrk(query.getRmrk());
				t12.setCtcTel(query.getMobile());
				t12.setRltvId(query.getOrdrId());
				t12.setRltvTp(query.getAplyPcstpCd());
				t12InvInfMapper.insert(t12);
				logger.debug("生成发票信息成功！");
			}
		} catch (Exception e) {
			logger.error("订单提交异常 {}", e);
			return Result.createFailResult("流程已被撤销，无法提交:" + e);
		}

		// 保存附件信息
		try {
			if (StringUtils.isNotEmpty(query.getFileNames())) {
				T2UploadAtch t2UploadAtch = new T2UploadAtch();
				t2UploadAtch.setRltvTp(query.getAplyPcstpCd());
				t2UploadAtch.setUsername(query.getUsername());
				t2UploadAtch.setRltvId(query.getOrdrId());
				insertFile(t2UploadAtch, query.getFileNames());
			} else {
				logger.debug("保存订单提交信息，附件为空！");
			}
		} catch (Exception e) {
			logger.error("提交订单，保存附件信息异常 {}", e);
			return Result.createFailResult("提交订单，保存附件信息异常" + e);
		}

		try {
			// 保存环节流水
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			BeanUtils.copyProperties(query, t0);
			t0.setRltvId(query.getOrdrId());
			t0.setProcessType("02");
			wfeUtils.saveLnkJrnlInf(t0);
		} catch (Exception e) {
			logger.error("订单提交保存环节流水异常 {}", e);
			return Result.createFailResult("订单提交保存环节流水异常:" + e);
		}

		try {
			T3OrderInf t1 = new T3OrderInf();
			// 更新订单状态
			// t1.setOrdrSt(query.getAplyPcstpCd());
			// 从工作流记录表中获取订单最新状态
			QueryOrderInfDetailOutVo t1Vo = t3OrderInfMapper.queryOrderDetailByOrderId(query.getOrdrId());
			if (t1Vo != null && StringUtils.isNotBlank(t1Vo.getAplyPcstpCd())) {				
				BeanUtils.copyProperties(t1Vo, t1);
				t1.setOrdrSt(t1Vo.getAplyPcstpCd());

				// 发送审批处理提醒信息
				// 查询长约信息
				Condition condition0 = new Condition(T1ArInf.class);
				Example.Criteria criteria0 = condition0.createCriteria();
				criteria0.andCondition("AR_ID = '" + t1.getArId() + "'");
				T1ArInf t1ar = t1ARInfMapper.selectByCondition(condition0).get(0);
				msgUtils.sendNewArTaskMsg(t1ar, t1, null, DataConstants.PROCESS_TPCD_ORDER);
			} else {
				// 判断流程是否结束
				if(t1Vo != null && wfDcService.isEndProcess(t1Vo.getProcessInstId())) {
					logger.error("流程已结束，设置状态为99");
					t1.setOrdrSt("99");
				} else {
					logger.error("更新订单信息，获取订单状态失败");
					return Result.createFailResult("更新订单信息，获取订单状态失败");
				}
			}
			t1.setTms(new Date());
			Condition condition0 = new Condition(T3OrderInf.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Ordr_ID = '" + query.getOrdrId() + "'");
			int rltNum = t3OrderInfMapper.updateByConditionSelective(t1, condition0);
			logger.info("更新订单状态，更新记录数：" + rltNum);
		} catch (Exception e) {
			logger.error("更新订单状态异常 {}", e);
			return Result.createFailResult("更新订单状态异常:" + e);
		}
		return Result.createSuccessResult(true);
	}

	/**
	 * 描述：查询订单提交详情 2018-12-18
	 */
	@Override
	public Result<QueryArSubmmitDetailOutVo> getOrderSubmmitDetail(String id, String orderId, String aplyPcstpCd) {
		logger.info("查询订单提交详情,请求参数:orderId={} aplyPcstpCd={}", orderId, aplyPcstpCd);
		QueryArSubmmitDetailOutVo outVo = new QueryArSubmmitDetailOutVo();
		try {
			T0LnkJrnlInf t0 = null;
			t0 = t0LnkJrnlInfMapper.selectByPrimaryKey(Long.parseLong(id));
			if (t0 == null) {
				logger.error("查询订单提交详情无数据");
				return Result.createFailResult("查询订单提交详情无数据");
			} else
				BeanUtils.copyProperties(t0, outVo);
			// 查询公司名称
			if (null != outVo.getCompanyId()) {
				Company company = new Company();
				company = companyMapper.selectByPrimaryKey(t0.getCompanyId());
				if(null != company)
					outVo.setName(company.getName());
			}

			// 查询订单提交附件信息
			Condition condition0 = new Condition(T2UploadAtch.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Rltv_ID = '" + orderId + "'");
			criteria0.andCondition("Rltv_Tp = '" + aplyPcstpCd + "'");
			List<T2UploadAtch> t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			if(null != t2UploadAtch01List && t2UploadAtch01List.size() > 0) {
				outVo.setT2UploadAtch01List(t2UploadAtch01List);
				logger.info("查询订单提交附件信息,返回条数为：" + t2UploadAtch01List.size());
			} else {
				logger.info("查询订单提交附件信息,返回结果为空");
			}
			logger.info("查询订单提交附件信息成功!");
			return Result.createSuccessResult(outVo);
		} catch (Exception e) {
			logger.error("查询订单提交详情异常 {}", e);
			return Result.createFailResult("查询订单提交详情异常" + e);
		}
	}
}
