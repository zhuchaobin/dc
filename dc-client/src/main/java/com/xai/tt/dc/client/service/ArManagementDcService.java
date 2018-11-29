package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.model.T0LnkJrnlInf;
import com.xai.tt.dc.client.query.SubmitArQuery;
import com.xai.tt.dc.client.vo.T1ARInfDetailVo;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;

/**
 * 收货地址dc服务
 * @author zhuchaobin
 *
 */
public interface ArManagementDcService {
	/**
	 * 描述：保存长约信息
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	Result<Boolean> save(ArManagementInVo req);

	Result<PageData<T1ARInfVo>> queryPage(ArManagementInVo query, PageParam pageParam);

	Result<T1ARInfDetailVo> queryArDetail(String arId);
	
	Result<Boolean> submitAr(SubmitArQuery query);
//
//	Result<PageData<PostAddressDcReq>> queryPostAddressPage(PostAddressDcReq query, PageParam pageParam);

	Result<PageData<T0LnkJrnlInf>> queryLnkJrnlInfPage(ArManagementInVo query, PageParam pageParam);

	Result<Boolean> deleteAr(String id);
}
