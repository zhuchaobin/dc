package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.query.SubmitArQuery;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.inVo.TB0001InVo;

/**
 * 收货地址dc服务
 * @author zhuchaobin
 *
 */
public interface TB0001DcService {
	/**
	 * 描述：保存长约信息
	 * 
	 * @author zhuchaobin 2018-10-26
	 */
	Result<Boolean> save(TB0001InVo req);

	Result<PageData<T1ARInfVo>> queryPage(TB0001InVo query, PageParam pageParam);

	Result<T1ARInfVo> queryArDetail(String arId);
	
	Result<Boolean> submitAr(SubmitArQuery query);
//
//	Result<PageData<PostAddressDcReq>> queryPostAddressPage(PostAddressDcReq query, PageParam pageParam);
}
