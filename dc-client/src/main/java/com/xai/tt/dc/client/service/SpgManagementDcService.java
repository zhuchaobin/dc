package com.xai.tt.dc.client.service;

import java.util.List;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.query.SubmitArQuery;
import com.xai.tt.dc.client.query.SubmitSpgQuery;
import com.xai.tt.dc.client.query.UserInfoQuery;
import com.xai.tt.dc.client.vo.T1ARInfDetailVo;
import com.xai.tt.dc.client.vo.T6SpgInfDetailVo;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.inVo.SpgManagementInVo;
import com.xai.tt.dc.client.vo.outVo.*;

/**
 * 发货信息dc服务
 * @author yuzhaoyang
 *
 */
public interface SpgManagementDcService {

	Result<Boolean> save(SpgManagementInVo req);

	Result<PageData<QuerySpgInfDetailOutVo>> queryPage(SpgManagementInVo query, PageParam pageParam);

	Result<QuerySpgInfDetailOutVo> querySpgDetail(SpgManagementInVo arId);
	
	Result<Boolean> submitSpg(SubmitSpgQuery query);

	Result<PageData<QueryLnkJrnlInfOutVo>> queryLnkJrnlInfPage(SpgManagementInVo query, PageParam pageParam);

	Result<Boolean> deleteSpg(String id);

	Result<QuerySpgSubmmitDetailOutVo> getSpgSubmmitDetail(String id, String arId, String aplyPcstpCd);

	Result<Boolean> unDoSpg(SpgManagementInVo inVo);

	Result<List<Integer>> getAdtTaskNum(UserInfoQuery query);
}
