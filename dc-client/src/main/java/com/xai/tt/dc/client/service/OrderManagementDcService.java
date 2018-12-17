package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.model.T0LnkJrnlInf;
import com.xai.tt.dc.client.query.SubmitArQuery;
import com.xai.tt.dc.client.vo.T1ARInfDetailVo;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.inVo.OrderManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryArSubmmitDetailOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageArOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryLnkJrnlInfOutVo;

/**
 * 订单信息dc服务
 * @author zhuchaobin
 *
 */
public interface OrderManagementDcService {
	/**
	 * 描述：保存订单信息
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	Result<Boolean> save(OrderManagementInVo req);

/*	Result<PageData<QueryPageOrderOutVo>> queryPage(OrderManagementInVo query, PageParam pageParam);

	Result<T1ARInfDetailVo> queryArDetail(String arId);
	
	Result<Boolean> submitAr(SubmitArQuery query);

	Result<PageData<QueryLnkJrnlInfOutVo>> queryLnkJrnlInfPage(OrderManagementInVo query, PageParam pageParam);

	Result<Boolean> deleteAr(String id);
	
	*//**
	 * 描述：查询订单详情
	 * 
	 * @author zhuchaobin 2018-11-21
	 *//*
	Result<QueryArSubmmitDetailOutVo> getArSubmmitDetail(String id, String arId, String aplyPcstpCd);

	Result<Boolean> unDoAr(OrderManagementInVo inVo);*/
}
