package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.T3OrderInf;
import com.xai.tt.dc.client.vo.inVo.OrderManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryOrderInfDetailOutVo;
import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;

public interface T3OrderInfMapper extends Mapper<T3OrderInf> {	
	int save(OrderManagementInVo req);
	Page<QueryOrderInfDetailOutVo> selectByT3OrderInfDcQuery(OrderManagementInVo query);
	int count(OrderManagementInVo query);
	QueryOrderInfDetailOutVo queryOrderDetail(Integer id);
	QueryOrderInfDetailOutVo queryOrderDetailByOrderId(String orderId);
}