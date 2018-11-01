package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.model.T1ARInf;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.inVo.TB0001InVo;

/**
 * 收货地址dc服务
 * @author zhuchaobin
 *
 */
public interface TB0001DcService {
	/**
	 * 描述：根据收货地址id修改收货地址信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	Result<Boolean> save(TB0001InVo req);

	Result<PageData<T1ARInfVo>> queryPage(TB0001InVo query, PageParam pageParam);
	

//
//	Result<PageData<PostAddressDcReq>> queryPostAddressPage(PostAddressDcReq query, PageParam pageParam);
}
