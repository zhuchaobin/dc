package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.query.SubmitOrderQuery;
import com.xai.tt.dc.client.vo.inVo.OrderManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryArSubmmitDetailOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryOrderInfDetailOutVo;

/**
 * 订单信息dc服务
 * @author zhuchaobin
 *
 */
public interface OrderManagementDcService {
	/**
	 * 描述：保存订单信息
	 * 
	 * @author zhuchaobin 2018-12-18
	 */
	Result<Boolean> save(OrderManagementInVo req);

	Result<PageData<QueryOrderInfDetailOutVo>> queryPage(OrderManagementInVo query, PageParam pageParam);

//	Result<QueryOrderInfDetailOutVo> queryArDetail(String arId);
	
	Result<Boolean> submitOrder(SubmitOrderQuery query);

	Result<Boolean> deleteOrder(String id);
	
	/**
	 * 描述：查询订单详情
	 * 
	 * @author zhuchaobin 2018-12-18
	 */
	Result<QueryArSubmmitDetailOutVo> getOrderSubmmitDetail(String id, String arId, String aplyPcstpCd);

	Result<Boolean> unDoOrder(OrderManagementInVo inVo);

	Result<QueryOrderInfDetailOutVo> queryArDetail(OrderManagementInVo query);
}
