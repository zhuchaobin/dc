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
import com.xai.tt.dc.biz.mapper.CompanyMapper;
import com.xai.tt.dc.biz.mapper.T0LnkJrnlInfMapper;
import com.xai.tt.dc.biz.mapper.T3OrderInfMapper;
import com.xai.tt.dc.biz.mapper.T2UploadAtchMapper;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.biz.utils.DateUtils;
import com.xai.tt.dc.biz.utils.SequenceUtils;
import com.xai.tt.dc.biz.utils.WfeUtils;
import com.xai.tt.dc.client.model.Company;
import com.xai.tt.dc.client.model.T0LnkJrnlInf;
import com.xai.tt.dc.client.model.T3OrderInf;
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

	/**
	 * 描述：保存订单信息
	 * 
	 * @author zhuchaobin 2018-12-17 二级服务码secSrvCd 01:保存 02:发起
	 */
	@Override
	public Result<Boolean> save(OrderManagementInVo inVo) {
		logger.info("保存订单信息请求报文", JSON.toJSONString(inVo));
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
				orderId = inVo.getArId();
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
				Condition condition = new Condition(T3OrderInf.class);
				Example.Criteria criteria = condition.createCriteria();
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
						t3.setOrdrSt(t1Vo.getAplyPcstpCd());
					} else {
						if(t1Vo != null && wfDcService.isEndProcess(t1Vo.getProcessInstId())) {
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
		logger.info("query maintenanceParm list success!");
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}

	/**
	 * 描述：查询订单详情
	 * 
	 * @author zhuchaobin 2018-12-18
	 */
	@Override
	public Result<QueryOrderInfDetailOutVo> queryArDetail(String id) {
		logger.info("查询订单详情,请求参数:{}", id);
		try {
			QueryOrderInfDetailOutVo t3 = null;
			t3 = t3OrderInfMapper.queryOrderDetail(Integer.parseInt(id));
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
			t3.setList(t0LnkJrnlInfList);
			logger.info("查询订单流转详情成功!");
			logger.info("查询订单详情成功!");
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
			criteria0.andCondition("Order_ID = '" + t1.getOrdrId() + "'");
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
			// 拾取并完成任务
			wfDcService.claimAndCompleteOrderTask(query.getOrdrId(), query.getUsername(), query.getAplyPcstpCd(),
					query.getAplyPsrltCd(), "");
			logger.debug("拾取并完成任务成功！");
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
			if (t1Vo != null && t1Vo.getAplyPcstpCd() != null) {
				t1.setOrdrSt(t1Vo.getAplyPcstpCd());
			} else {
				logger.error("更新订单信息，获取订单状态失败");
				return Result.createFailResult("更新订单信息，获取订单状态失败");
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
	 * 描述：查询订单提交详情
	 * 2018-12-18
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
				company = companyMapper.selectByPrimaryKey(outVo.getCompanyId());
				outVo.setName(company.getName());
			}

			// 查询订单提交附件信息
			Condition condition0 = new Condition(T2UploadAtch.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Rltv_ID = '" + orderId + "'");
			criteria0.andCondition("Rltv_Tp = '" + aplyPcstpCd + "'");
			List<T2UploadAtch> t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			outVo.setT2UploadAtch01List(t2UploadAtch01List);
			logger.info("查询订单提交附件信息成功!");
			return Result.createSuccessResult(outVo);
		} catch (Exception e) {
			logger.error("查询订单提交详情异常 {}", e);
			return Result.createFailResult("查询订单提交详情异常" + e);
		}
	}
}
