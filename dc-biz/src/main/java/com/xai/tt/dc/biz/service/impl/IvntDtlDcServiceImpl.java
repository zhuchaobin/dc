package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.biz.utils.CommonUtils;
import com.xai.tt.dc.client.model.B4PlgDrcPrc;
import com.xai.tt.dc.client.model.PlgCntlMnyWnLn;
import com.xai.tt.dc.client.model.T17IvntDtl;
import com.xai.tt.dc.client.model.T8OrderDetail;
import com.xai.tt.dc.client.query.UserInfoQuery;
import com.xai.tt.dc.client.service.IvntDtlDcService;
import com.xai.tt.dc.client.vo.PlgCntlMnyWnLnVo;
import com.xai.tt.dc.client.vo.inVo.IvntDtlInVo;
import com.xai.tt.dc.client.vo.inVo.OutStgTnumInVo;
import com.xai.tt.dc.client.vo.inVo.OutStgTnumSubInVo;
import com.xai.tt.dc.client.vo.outVo.GdsBlgOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageIvntDtlOutVo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("deprecation")
@Service("ivntDtlDcService")
public class IvntDtlDcServiceImpl implements IvntDtlDcService {
	private static final Logger logger = LoggerFactory.getLogger(IvntDtlDcServiceImpl.class);
	@Autowired
	private T17IvntDtlMapper t17IvntDtlMapper;
	@Autowired
	private B5PlgCntlMnyWnLnMapper b5PlgCntlMnyWnLnMapper;
	@Autowired
	private B4PlgDrcPrcMapper b4PlgDrcPrcMapper;
	
	// 出库
	@Override
	public Result<?> outStgTnum(OutStgTnumInVo inVo){
		logger.info("出库操作,请求参数:{}", JSON.toJSONString(inVo));
		
		//校验剩余货值是否允许
		//校验每一项商品在库总量是否<=出库总量
		//校验是否为同一个企业的商品
		//校验是否为同一个长约的商品
		//校验出库操作人的身份类型是否为平台或者仓储
		if((1 != inVo.getUserType()) && (8 != inVo.getUserType())) {
			logger.error("出库失败：当前用户没有出库权限！");
			return Result.createFailResult("出库失败：当前用户没有出库权限！");
		}
		// 当前总出库货值
		float totalOutValue = 0;
		float lwstCntlMnyLn = 0;
		float plgWnLn = 0;
		// 该客户该长约下在库在质押货物总金额
		float relIvntTotalAmount = 0l;
		if(inVo != null && inVo.getOutStgTnumSubInVoList() != null && inVo.getOutStgTnumSubInVoList().size() > 0) {
			// 再次校验是否可以出库
			String idList = "";
			Map<Long, OutStgTnumSubInVo> outStgTnumSubInVoMap = new HashMap<Long, OutStgTnumSubInVo>();
			for(OutStgTnumSubInVo subInVo : inVo.getOutStgTnumSubInVoList()) {
				idList += (StringUtils.isBlank(idList) ? subInVo.getId() : (","+subInVo.getId()));
				outStgTnumSubInVoMap.put(subInVo.getId(), subInVo);				
			}
			IvntDtlInVo ivntDtlInVo = new IvntDtlInVo();
			ivntDtlInVo.setIdList(idList);
			ivntDtlInVo.setSecSrvCd("09");
			ivntDtlInVo.setUserType(inVo.getUserType());
	//		List<QueryPageIvntDtlOutVo> queryPageIvntDtlOutVoList = t17IvntDtlMapper.selectByList(ivntDtlInVo);
			List<T17IvntDtl> queryPageIvntDtlOutVoList = t17IvntDtlMapper.selectByIds(idList);
			logger.info("queryPageIvntDtlOutVoList.size()=" + queryPageIvntDtlOutVoList.size() );
			// 判定是否为同一长约下货物
			String arIdPre = "";
			// 判定是否为同一客户名下货物
			Long gdsBlgIdPre = 0l;
			if(null != queryPageIvntDtlOutVoList && queryPageIvntDtlOutVoList.size() > 0) {
				logger.info("outStgTnumSubInVoMap.size()=" + outStgTnumSubInVoMap.size());
				logger.info("queryPageIvntDtlOutVoList.size()=" + queryPageIvntDtlOutVoList.size());
				if(outStgTnumSubInVoMap.size() == queryPageIvntDtlOutVoList.size()) {
					for(int i = 0; i < queryPageIvntDtlOutVoList.size(); i++ ) {
						T17IvntDtl queryPageIvntDtlOutVo = queryPageIvntDtlOutVoList.get(i);
						// 逐一校验各货物在库数量是否满足出库数量，并计算商品价值总额
						OutStgTnumSubInVo outStgTnumSubInVo = outStgTnumSubInVoMap.get(queryPageIvntDtlOutVo.getId());
						if(i ==0) {
							arIdPre = outStgTnumSubInVo.getArId();
							gdsBlgIdPre = outStgTnumSubInVo.getGdsBlgId();
						} else {
							if(!arIdPre.equals(outStgTnumSubInVo.getArId()) ) {
								logger.error("出库出错：选择出库货物非同一长约下的货物，不能一起出库！");
								return Result.createFailResult("出库出错：选择出库货物非同一长约下的货物，不能一起出库！");
							}
							if(gdsBlgIdPre != outStgTnumSubInVo.getGdsBlgId()) {
								logger.error("出库出错：选择出库货物非同一企业名下的货物，不能一起出库！");
								return Result.createFailResult("出库出错：选择出库货物非同一企业名下的货物，不能一起出库！");
							}
						}
						if(null != outStgTnumSubInVo) {
							if(queryPageIvntDtlOutVo.getInthestgTnum() < outStgTnumSubInVo.getCurrOutstgTnum()) {
								logger.error("出库出错：货物"+ outStgTnumSubInVo.getPdNm()+"在库数量小于待出库的数量！");
								return Result.createFailResult("出库出错：货物"+ outStgTnumSubInVo.getPdNm()+"在库数量小于待出库的数量！");
							} else {
								// 实时查询质押指导价
								Condition condition = new Condition(B4PlgDrcPrc.class);
								Example.Criteria criteria = condition.createCriteria();
								criteria.andCondition("Ar_ID = '" + arIdPre + "'");
								criteria.andCondition("Pd_ID = '" + queryPageIvntDtlOutVo.getPdId() + "'");
								List<B4PlgDrcPrc> b4List = b4PlgDrcPrcMapper.selectByCondition(condition);
								if(null != b4List && b4List.size() > 0)
									totalOutValue += (outStgTnumSubInVo.getCurrOutstgTnum() * b4List.get(0).getPlgDrcPrc());
								else {
									logger.error("出库出错：获取商品"+queryPageIvntDtlOutVo.getPdNm()+"质押指导价失败！");
									return Result.createFailResult("出库出错：获取商品"+queryPageIvntDtlOutVo.getPdNm()+"质押指导价失败！");
								}
							}
						} else {
							logger.error("出库出错：获取在库货物信息失败！");
							return Result.createFailResult("出库出错：获取在库货物信息失败！");
						}
					}
					//判断 控货值是否在可出货范围内
					// 获取最低控货值
					PlgCntlMnyWnLnVo query = new PlgCntlMnyWnLnVo();
					query.setArId(arIdPre);
					PlgCntlMnyWnLnVo plgCntlMnyWnLnVo = b5PlgCntlMnyWnLnMapper.queryDetail(query);
					if(plgCntlMnyWnLnVo == null) {
						logger.error("出库出错：获取最低控货值失败！");
						return Result.createFailResult("出库出错：获取最低控货值失败！");
					} else {
						lwstCntlMnyLn = plgCntlMnyWnLnVo.getLwstCntlMnyLn();
						plgWnLn = plgCntlMnyWnLnVo.getPlgWnln();
					}
					// 获取该企业所有在库质押品总货值					
					IvntDtlInVo ivntDtlInVo2 = new IvntDtlInVo();
					ivntDtlInVo2.setArId(arIdPre);
					ivntDtlInVo2.setGdsBlgId(gdsBlgIdPre);
					ivntDtlInVo2.setUserType(inVo.getUserType());
					ivntDtlInVo2.setSecSrvCd("10");
					List<QueryPageIvntDtlOutVo> queryPageIvntDtlOutVoList2 = t17IvntDtlMapper.selectByList(ivntDtlInVo2);
					if(null != queryPageIvntDtlOutVoList2  && queryPageIvntDtlOutVoList2.size() > 0) {
						for(QueryPageIvntDtlOutVo vo : queryPageIvntDtlOutVoList2) {
							relIvntTotalAmount += (vo.getInthestgTnum() * vo.getPlgDrcPrc());
						}
						if(relIvntTotalAmount - totalOutValue < lwstCntlMnyLn) {
							logger.error("出库失败：出库后在库质押货物总额"+(relIvntTotalAmount - totalOutValue)+"低于最低控货线" + lwstCntlMnyLn);
							return Result.createFailResult("出库失败：出库后在库质押货物总额"+(relIvntTotalAmount - totalOutValue)+"低于最低控货线" + lwstCntlMnyLn);
						}
					}
					
				} else {
					logger.error("出库出错：待出库商品列表条数与在库商品列表条数不一致！");
					return Result.createFailResult("出库出错：待出库商品列表条数与在库商品列表条数不一致！");
				}
			} else {
				logger.error("出库出错：待出库商品在库存信息中查不到！");
				return Result.createFailResult("出库出错：待出库商品在库存信息中查不到！");
			}
			
			// 做真正的出库，扣减货物数量
			for(OutStgTnumSubInVo subInVo : inVo.getOutStgTnumSubInVoList()) {
/*				T17IvntDtl t17 = new T17IvntDtl();
				t17.setInthestgTnum(subInVo.getInthestgTnum() - subInVo.getCurrOutstgTnum());
				t17.setOutstgTnum(subInVo.getOutstgTnum() + subInVo.getCurrOutstgTnum());
				t17.setTms(new Date());
				t17.setId(subInVo.getId());*/
				t17IvntDtlMapper.updateT17(subInVo);
			}
		}
		
		if(relIvntTotalAmount - totalOutValue < plgWnLn) {
			logger.info("出库成功：出库后在库质押货物总额"+(relIvntTotalAmount - totalOutValue)+"低于预警线线" + plgWnLn);
			return Result.createSuccessResult("出库成功：出库后在库质押货物总额"+(relIvntTotalAmount - totalOutValue)+"低于预警线线" + plgWnLn);
		} else
		return Result.createSuccessResult("出库成功");
	}
		
	/**
	 * 描述：删除库存信息
	 * 
	 * @author
	 */
	@Override
	public Result<Boolean> delete(String id) {
		logger.info("删除库存信息,请求参数:{}", id);
		try {
			t17IvntDtlMapper.deleteByPrimaryKey(Long.parseLong(id));
			logger.info("删除库存信息成功!");
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除库存信息异常 {}", e);
			return Result.createFailResult("删除库存信息异常" + e);
		}
	}


	/**
	 * 描述：查询库存信息列表（分页）
	 * 
	 * @author
	 */
	@Override
	public Result<PageData<QueryPageIvntDtlOutVo>> queryPage(IvntDtlInVo query, PageParam pageParam) {
		logger.info("start query 库存信息信息 List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		logger.info("orderBy:" + query.getOrderBy());
		logger.info("getSortName:" + query.getSortName());
		logger.info("getSortOrder:" + query.getSortOrder());

		Page<QueryPageIvntDtlOutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		} 
		try {
			page = t17IvntDtlMapper.selectByPage(query);
			count = t17IvntDtlMapper.count(query);
		} catch (Exception e) {
			logger.error("查询库存信息列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("queryPage success!{}", JSON.toJSON(page));
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}

	/**
	 * 描述：查询库存信息详情
	 * 
	 * @author
	 */
	@Override
	public Result<QueryPageIvntDtlOutVo> queryDetail(IvntDtlInVo query) {
		logger.info("查询库存信息详情,请求参数:{}", JSON.toJSONString(query));
		try {
			QueryPageIvntDtlOutVo queryPageIvntDtlOutVo = t17IvntDtlMapper.queryDetail(query.getId() + "");
			if (queryPageIvntDtlOutVo == null) {
				logger.error("查询库存信息详情无数据");
				return Result.createFailResult("查询库存信息详情无数据");
			} else {
				// 查询库存信息明细
				Result<QueryPageIvntDtlOutVo> rlt = new Result<QueryPageIvntDtlOutVo>();
				rlt.setData(queryPageIvntDtlOutVo);
				return rlt;
			}
		} catch (Exception e) {
			logger.error("查询库存信息详情异常 {}", e);
			return Result.createFailResult("查询库存信息详情异常" + e);
		}
	}
	// 查询货物归属列表
	@Override
	public Result<List<GdsBlgOutVo>> queryGdsBlgList(UserInfoQuery userInfo){
		List<GdsBlgOutVo> gdsBlgOutVoList = new ArrayList<GdsBlgOutVo>();
		try {
			List<String > gdsBlgList = t17IvntDtlMapper.queryGdsBlgList();
			if(null != gdsBlgList && gdsBlgList.size() > 0) {
				for(String gdsBlg : gdsBlgList) {
					String[] arr = gdsBlg.split("#");
					if(null != arr && arr.length ==2) {
						GdsBlgOutVo gdsBlgOutVo = new GdsBlgOutVo();
						gdsBlgOutVo.setGdsBlgId(Long.parseLong(arr[0]));
						gdsBlgOutVo.setGdsBlgNm(arr[1]);
						logger.info("货物归属id|公司名:" + gdsBlgOutVo.getGdsBlgId() + "|" + gdsBlgOutVo.getGdsBlgNm());
						// 计算质押物总质押货值
						IvntDtlInVo query = new IvntDtlInVo();
						query.setGdsBlgId(gdsBlgOutVo.getGdsBlgId());
						query.setUserType(userInfo.getUserType());//给平台权限，默认可以查所有货物
						Page<QueryPageIvntDtlOutVo> page = t17IvntDtlMapper.selectByPage(query);
						float plgPdValue = 0f;
						// 合作银行
						String bnkNm = "";
						// 合作仓储
						String stgNm = "";
						// 相关长约
						String arId = ""; 
						if(null != page && page.size() > 0) {
							for(QueryPageIvntDtlOutVo ivntDtl : page) {
								// 自动质押或者质押审核通过， 且在库有余量，且有质押指导价
								if(("02".equals(ivntDtl.getPlgAplySt()) || "04".equals(ivntDtl.getPlgAplySt())) 
										&& null != ivntDtl.getInthestgTnum() 
										&& ivntDtl.getPlgDrcPrc() != 0l) {
									plgPdValue += (ivntDtl.getInthestgTnum()  * ivntDtl.getPlgDrcPrc());
								}
								if(StringUtils.isNoneBlank(ivntDtl.getBnkNm())){
									if(!bnkNm.contains(ivntDtl.getBnkNm())) {
										if(StringUtils.isBlank(bnkNm))
											bnkNm = ivntDtl.getBnkNm();
										else
											bnkNm += ("," + ivntDtl.getBnkNm());
									}
									gdsBlgOutVo.setBnkNm(bnkNm);	
								}
								if(StringUtils.isNoneBlank(ivntDtl.getStgcoNm())){
									if(!stgNm.contains(ivntDtl.getStgcoNm())) {
										if(StringUtils.isBlank(stgNm))
											stgNm = ivntDtl.getStgcoNm();
										else
											stgNm += ("," + ivntDtl.getStgcoNm());
									}
									gdsBlgOutVo.setStgNm(stgNm);	
								}
								if(StringUtils.isNoneBlank(ivntDtl.getArId())){
									if(!arId.contains(ivntDtl.getArId())) {
										if(StringUtils.isBlank(arId))
											arId = ivntDtl.getArId();
										else
											arId += ("," + ivntDtl.getArId());
									}
									gdsBlgOutVo.setArId(arId);		
								}
							}
						}
						gdsBlgOutVo.setPlgPdValue(plgPdValue);
						logger.info("循环内货物归属信息：" + JSON.toJSONString(gdsBlgOutVo));	
						gdsBlgOutVoList.add(gdsBlgOutVo);										
					}
				}
				logger.info("货物归属信息返回结果：" + JSON.toJSONString(gdsBlgOutVoList));
			}
			
		} catch (Exception e) {
			logger.error("查询货物归属列表发生异常：" + e);
			return Result.createFailResult("查询货物归属列表发生异常：" + e);
		}
		Result<List<GdsBlgOutVo>> rlt = new Result<List<GdsBlgOutVo>> ();
		rlt.setData(gdsBlgOutVoList);
		logger.error("查询货物归属列表发生成功：" + gdsBlgOutVoList);
		return rlt;
	}
	
	
}
