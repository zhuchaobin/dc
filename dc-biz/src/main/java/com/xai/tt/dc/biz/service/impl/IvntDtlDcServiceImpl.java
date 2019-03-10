package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.client.model.B5PlgCntlMnyWnLn;
import com.xai.tt.dc.client.query.UserInfoQuery;
import com.xai.tt.dc.client.service.IvntDtlDcService;
import com.xai.tt.dc.client.vo.inVo.IvntDtlInVo;
import com.xai.tt.dc.client.vo.outVo.GdsBlgOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageIvntDtlOutVo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("deprecation")
@Service("ivntDtlDcService")
public class IvntDtlDcServiceImpl implements IvntDtlDcService {
	private static final Logger logger = LoggerFactory.getLogger(IvntDtlDcServiceImpl.class);
	@Autowired
	private T17IvntDtlMapper t17IvntDtlMapper;
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
