package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.query.SubmitArQuery;
import com.xai.tt.dc.client.vo.T1ARInfDetailVo;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryArSubmmitDetailOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryLnkJrnlInfOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageArOutVo;

/**
 * 发货信息dc服务
 * @author yuzhaoyang
 *
 */
public interface SpgManagementDcService {

	Result<Boolean> save(ArManagementInVo req);

	Result<PageData<QueryPageArOutVo>> queryPage(ArManagementInVo query, PageParam pageParam);

	Result<T1ARInfDetailVo> querySpgDetail(String arId);
	
	Result<Boolean> submitSpg(SubmitArQuery query);

	Result<PageData<QueryLnkJrnlInfOutVo>> queryLnkJrnlInfPage(ArManagementInVo query, PageParam pageParam);

	Result<Boolean> deleteSpg(String id);

	Result<QueryArSubmmitDetailOutVo> getSpgSubmmitDetail(String id, String arId, String aplyPcstpCd);

	Result<Boolean> unDoSpg(ArManagementInVo inVo);
}
