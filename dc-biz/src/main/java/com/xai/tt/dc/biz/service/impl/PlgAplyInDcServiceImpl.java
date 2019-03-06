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
import com.xai.tt.dc.client.model.*;
import com.xai.tt.dc.client.query.SubmitSpgQuery;
import com.xai.tt.dc.client.query.UserInfoQuery;
import com.xai.tt.dc.client.service.PlgAplyDcService;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.inVo.OrderManagementInVo;
import com.xai.tt.dc.client.vo.inVo.PlgAplyInVo;
import com.xai.tt.dc.client.vo.outVo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
@Service("plgAplyDcService")
public class PlgAplyInDcServiceImpl implements PlgAplyDcService {
	private static final Logger logger = LoggerFactory.getLogger(PlgAplyInDcServiceImpl.class);
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
	private T18PlgAplyMapper T18PlgAplyMapper;
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
	private T13GdsDetailMapper t13GdsDetailMapper;
	@Autowired
	private T18PlgAplyMapper t18PlgAplyMapper;
	@Autowired
	private T17IvntDtlMapper t17IvntDtlMapper;
	
	
	/**
	 * 描述：保存质押信息
	 * 
	 * @author yuzhaoyang 2018-12-23
	 */
	@Override
	public Result<Boolean> save(PlgAplyInVo inVo) {
		logger.info("保存质押信息请求报文{}", JSON.toJSONString(inVo));
		logger.info("二级服务码secSrvCd：" + inVo.getSecSrvCd());
		// 保存质押信息
		T18PlgAply t18 = new T18PlgAply();
		BeanUtils.copyProperties(inVo, t18);
		t18.setPlgAplyTm(new Date());
		t18.setPlgAplyMnpltPsn(inVo.getUsername());
		t18.setPlgAplyTm(new Date());
		t18.setTms(new Date());
		t18.setPlgAplySt("01");//待审核
		String StrPost = DateUtils.noFormatDate() + sequenceUtils.getSequence("Cd_Seq", 4);
		t18.setWhrecptId("CD" + StrPost);
		t18.setPlgBillno("ZY" + StrPost);
		t18PlgAplyMapper.insert(t18);
		
		for(T13GdsDetail t13 : inVo.getT13GdsDetailList()) {
			// 保存质押货物明细
			t13.setRltvTp("02");//01:发货明细 02：质押明细 03：发货入库明细 04：出库明细
			t13.setRltvId("CD" + StrPost);
			t13.setTms(new Date());
			t13.setCrtTm(new Date());
			t13.setUsername(inVo.getUsername());
			t13GdsDetailMapper.insert(t13);
			// 质押品入库
			T17IvntDtl t17 = new T17IvntDtl();
			BeanUtils.copyProperties(inVo, t17, CommonUtils.getNullPropertyNames(inVo));
			t17.setWhrecptId(t13.getRltvId()); 
			t17.setIntrsrTp("02");// 02：存入自有货物 03：上游发货形成 
			t17.setIntrsrTnum(t13.getNum());
			t17.setInthestgTnum(t13.getNum());
			t17.setOutstgTnum(0f);
/*			t17.setArId(inVo.getArId());
			t17.setOrdrId(inVo.getOrdrId());
			t17.setSpgId(inVo.getSpgId());*/
			t17.setPlgBillno("ZY" + StrPost);
/*			t17.setBnk(inVo.getBnk());
			t17.setBnkNm(inVo.getBnkNm());
			t17.setStgco(inVo.getStgco());
			t17.setStgcoNm(inVo.getStgcoNm());*/
			t17.setGdsBlgId(inVo.getFncEntp());
			t17.setGdsBlgNm(inVo.getFncEntpNm());
			t17.setPlgAplySt("01");
			t17IvntDtlMapper.insert(t17);			
		}
		
		T11IvntInf t11IvntInf =new T11IvntInf();
		String spgId = "";
		try {
			if (null == inVo) {
				logger.error("保存质押信息请求报文不能为空");
				return Result.createFailResult("保存质押信息请求报文不能为空");
			}
			String solveType = "";
			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			// 判断处理类别  01-保存 02-提交
			if ("01".equals(inVo.getSecSrvCd())) {
				if(null != inVo.getId()) {
					T18PlgAply rltT1 = T18PlgAplyMapper.selectByPrimaryKey(inVo.getId());
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
					T18PlgAply rltT1 = T18PlgAplyMapper.selectByPrimaryKey(inVo.getId());
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
				logger.error("质押编号不能为空！");
				return Result.createFailResult("质押编号不能为空！");
			}
			BeanUtils.copyProperties(inVo, T18PlgAplyo);
			BeanUtils.copyProperties(inVo, t11IvntInf);

			// 质押新建后记录质押状态
			T18PlgAplyo.setSpgId(spgId);
			T18PlgAplyo.setCnsgn(inVo.getCnsgn());
			T18PlgAplyo.setTms(new Date());
			T18PlgAplyo.setCrtTm(new Date());
			T18PlgAplyo.setTms(new Date());

			t11IvntInf.setRltvId(spgId);
			t11IvntInf.setRltvTp(KuCunType.FA_HUO_KU_CUN.getCode());
			t11IvntInf.setSpgId(spgId);
			t11IvntInf.setCnsgn(inVo.getCnsgn());
			t11IvntInf.setTms(new Date());
			t11IvntInf.setTms(new Date());

			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			// 
			if(StringUtils.isBlank(T18PlgAplyo.getSpgSt())){
				if("05".equals(solveType) || "07".equals(solveType)|| "08".equals(solveType)) {
					T18PlgAplyo.setSpgSt("61");
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

					T18PlgAplyo.setPymtMod(t3OrderInfs.get(0).getPymtmod());
				};
			};





			if("01".equals(solveType) || "05".equals(solveType)|| "07".equals(solveType)) {
				T18PlgAplyo.setId(null);
				t11IvntInf.setId(null);

				int num = T18PlgAplyMapper.insertSelective(T18PlgAplyo);

				int num1 = t11IvntInfMapper.insertSelective(t11IvntInf);


				logger.info("更新质押信息成功，插入记录数：" + num);
			} else {
				int num = T18PlgAplyMapper.updateByPrimaryKeySelective(T18PlgAplyo);

				int num1 = t11IvntInfMapper.updateByPrimaryKeySelective(t11IvntInf);
				logger.info("更新质押信息成功：质押id" + T18PlgAplyo.getArId() + "更新条数：" + num);
			}





			// 保存质押明细信息
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
					t13GdsDetail.setRltvTp(KuCunType.FA_HUO_KU_CUN.getCode());//01:质押形成库存 02：存入自由货物形成库存
					t13GdsDetail.setModl("01");
					t13GdsDetail.setIds((long) i);
					t13GdsDetail.setModl("");
					t13GdsDetail.setPchUnitprc(0.0F);
					t13GdsDetail.setTxnPrcdif(0.0F);
					t13GdsDetail.setSaleTntvPrc(0.0F);
					t13GdsDetail.setUsername("");
					t13GdsDetail.setCrtTm(new Date());
					t13GdsDetail.setTms(new Date());
					t13GdsDetail.setMsunit("");


					t7SpgDetailMapper.insert(t7SpgDetail);

					t13GdsDetailMapper.insert(t13GdsDetail);

				}



			}



			// 保存质押附件信息
			try {
				if (StringUtils.isNotEmpty(inVo.getFileNames())) {
					T2UploadAtch t2UploadAtch = new T2UploadAtch();
					t2UploadAtch.setRltvTp("03");
					t2UploadAtch.setUsername(inVo.getUsername());
					t2UploadAtch.setRltvId(spgId);
					insertFile(t2UploadAtch, inVo.getFileNames());
				}
			else {
					logger.error("保存质押信息，质押附件为空！");
				}
			} catch (Exception e) {
				logger.error("保存质押附件信息异常 {}", e);
				return Result.createFailResult("保存质押附件信息发生异常" + e);
			}

			// 删除质押附件信息
			if (StringUtils.isNotBlank(inVo.getFilesToDelete())) {
				try {
					String[] files = inVo.getFilesToDelete().split("\\|\\|");
					for(String fileId : files) {
						logger.info("删除附件开始，附件id:" + fileId);
						t2UploadAtchMapper.deleteByPrimaryKey(Long.parseLong(fileId));
						logger.info("删除附件结束，附件id:" + fileId);
					}
				} catch (Exception e) {
					logger.error("删除质押附件信息异常 {}", e);
					return Result.createFailResult("删除质押附件信息发生异常" + e);
				}
			}

			// 如果是发起，保存流程实例id到质押信息表
			// 05:新发起发起     07：撤销件发起  08：保存件发起
			if("05".equals(solveType) || "07".equals(solveType)|| "08".equals(solveType)) {
				String processInstId = wfDcService.startProcessInstance(DataConstants.PROCESS_NAME_SPG);
				if(StringUtils.isBlank(processInstId)) {
					logger.error("发起质押，启动流程失败!");
					return Result.createFailResult("发起质押，启动流程失败!");
				} else {
					logger.error("发起质押，启动流程成功，processInstId:" + processInstId);
				}
				T18PlgAplyo.setProcessInstId(processInstId);
				Condition condition1 = new Condition(T18PlgAply.class);
				Example.Criteria criteria1 = condition1.createCriteria();
				criteria1.andCondition("Spg_ID = '" + spgId + "'");
				T18PlgAplyMapper.updateByConditionSelective(T18PlgAplyo, condition1);
				logger.info("processInstId =" + processInstId);
			}
			
			// 保存环节流水
			// 01:新发起保存   02：退回件保存  03：撤销件保存  04：保存件保存
			// 05:新发起发起   06：退回件发起  07：撤销件发起  08：保存件发起
			if("05".equals(solveType) || "06".equals(solveType)|| "07".equals(solveType)|| "08".equals(solveType)) {
				T0LnkJrnlInf t0 = new T0LnkJrnlInf();
				BeanUtils.copyProperties(T18PlgAplyo, t0);
				t0.setUsername(inVo.getUsername());
				t0.setCompanyId(inVo.getCompanyId());
				t0.setRltvId(T18PlgAplyo.getSpgId());
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
				// 更新质押状态为新状态
				try {
					T18PlgAply t1 = new T18PlgAply();

					T11IvntInf t11 = new T11IvntInf();
					// 更新质押状态

					//从工作流记录表中获取质押最新状态

					//todo
					QuerySpgInfDetailOutVo t1Vo = T18PlgAplyMapper.querySpgDetailBySpgId(spgId);
					if(t1Vo != null && t1Vo.getAplyPcstpCd() != null) {

						BeanUtils.copyProperties(t1Vo, t1);
						t1.setSpgSt(t1Vo.getAplyPcstpCd());
						t11.setIvntSt(t1Vo.getAplyPcstpCd());

						// 发送审批处理提醒信息
						// 查询长约信息
						Condition condition0 = new Condition(T1ArInf.class);
						Example.Criteria criteria0 = condition0.createCriteria();
						criteria0.andCondition("AR_ID = '" + t1.getArId() + "'");
						T1ArInf t1ar = t1ARInfMapper.selectByCondition(condition0).get(0);
						msgUtils.sendNewArTaskMsg(t1ar, null, t1, DataConstants.PROCESS_TPCD_SPG);
					} else {
						if(t1Vo != null && wfDcService.isEndProcess(t1Vo.getProcessInstId())) {
							t1.setSpgSt("99");
							t11.setIvntSt("99");
							logger.info("流程已经结束.");
						} else {
							logger.error("更新质押信息，获取质押状态失败");
							return Result.createFailResult("更新质押信息，获取质押状态失败");
						}
					}
					t1.setTms(new Date());
					t11.setTms(new Date());


					Condition condition0 = new Condition(T1ArInf.class);
					Example.Criteria criteria0 = condition0.createCriteria();
					criteria0.andCondition("Spg_ID = '" + spgId + "'");
					int rltNum = T18PlgAplyMapper.updateByConditionSelective(t1, condition0);



					Condition condition1 = new Condition(T11IvntInf.class);
					Example.Criteria criteria1 = condition1.createCriteria();
					criteria1.andCondition("Rltv_ID = '" + spgId + "'");
					int rltNum1 = t11IvntInfMapper.updateByConditionSelective(t11, condition1);


					logger.info("更新质押状态，更新记录数：" + rltNum);
				} catch (Exception e) {
					logger.error("更新质押状态异常 {}", e);
					return Result.createFailResult("更新质押状态异常:" + e);
				}
			}
		} catch (Exception e) {
			logger.error("保存质押信息异常 {}", e);
			return Result.createFailResult("保存质押信息发生异常" + e);
		}
		return Result.createSuccessResult(true);
	}


	/**
	 * 描述：删除质押
	 * 
	 * @author zhuchaobin 2018-11-21
	 */
	@Override
	public Result<Boolean> delete(String id) {
		logger.info("删除质押,请求参数:{}", id);
		try {
			T18PlgAplyMapper.deleteByPrimaryKey(Long.parseLong(id));
			logger.info("删除质押成功!");
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除质押异常 {}", e);
			return Result.createFailResult("删除质押异常" + e);
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
					logger.debug("保存质押附件信息");
					t2UploadAtchMapper.updateByPrimaryKeySelective(t2);
				} else {
					// 插入记录
					logger.debug("更新质押附件信息");
					t2UploadAtchMapper.insert(t2);
				}
			}

		} catch (Exception e) {
			logger.info("保存质押附件信息发生异常：", e);
		}

	}

	/**
	 * 描述：查询质押列表（分页）
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	@Override
	public Result<PageData<PlgAplyInVo>> queryPage(PlgAplyInVo query, PageParam pageParam) {
		logger.info("start query 质押信息 List =======> query:{},page:{}", query, pageParam);
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
			page = T18PlgAplyMapper.selectByT18PlgAplyDcQuery(query);
			count = T18PlgAplyMapper.count(query);
		} catch (Exception e) {

			logger.error("查询质押列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("queryPage success!{}",JSON.toJSON(page));
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}

	/**
	 * 描述：查询质押详情
	 * 
	 * @author yuzhaoyang 2018-12-25
	 */
	@Override
	public Result<PlgAplyInVo> queryDetail(PlgAplyInVo query ) {
		logger.info("查询质押详情,请求参数:{}", JSON.toJSONString(query));
		try {
			QuerySpgInfDetailOutVo t3 = null;
			t3 = T18PlgAplyMapper.querySpgDetail(query.getId().intValue());
			if (t3 == null) {
				logger.error("查询质押详情无数据");
				return Result.createFailResult("查询质押详情无数据");
			}
			// 查询质押附件信息
			Condition condition0 = new Condition(T2UploadAtch.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("Rltv_ID = '" + t3.getSpgId() + "'");
			criteria0.andCondition("Rltv_Tp = '03'");
			List<T2UploadAtch> t2UploadAtch01List = t2UploadAtchMapper.selectByCondition(condition0);
			t3.setT2UploadAtch01List(t2UploadAtch01List);
			logger.info("查询质押附件信息成功!");
			// 查询质押流转信息
			T0LnkJrnlInf t0 = new T0LnkJrnlInf();
			t0.setRltvId(t3.getSpgId());
			t0.setProcessType("03");
			List<QueryLnkJrnlInfOutVo> t0LnkJrnlInfList = t0LnkJrnlInfMapper.QueryLnkJrnlInfList(t0);
			if(null != t0LnkJrnlInfList) {
				t3.setList(t0LnkJrnlInfList);
				logger.info("查询质押流转详情成功!查询到数据条数：" + t0LnkJrnlInfList.size());
			}
			Condition condition1 = new Condition(T7SpgDetail.class);
			Example.Criteria criteria1 = condition1.createCriteria();
			criteria1.andCondition("Spg_ID = '" + t3.getSpgId() + "'");
			List<T7SpgDetail> t7SpgDetailList = t7SpgDetailMapper.selectByCondition(condition1);
			if(null != t7SpgDetailList) {
				t3.setT7SpgDetailList(t7SpgDetailList);
				logger.info("查询质押明细信息成功!查询到数据条数：" + t7SpgDetailList.size());
			}
			logger.info("查询质押详情成功!");
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
			logger.error("查询质押详情异常 {}", e);
			return Result.createFailResult("查询质押详情异常" + e);
		}
	}
	

}
