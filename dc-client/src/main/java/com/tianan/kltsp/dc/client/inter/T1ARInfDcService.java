package com.tianan.kltsp.dc.client.inter;

import java.util.List;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.tianan.kltsp.dc.client.entity.PostAddress;
import com.tianan.kltsp.dc.client.entity.T1ARInf;
import com.tianan.kltsp.dc.client.request.PostAddressDcReq;
import com.tianan.kltsp.dc.client.response.PostAddressRes;
import com.tianan.kltsp.dc.client.vo.PostAddressVo;
import com.tianan.kltsp.dc.client.vo.T1ARInfVo;

/**
 * 收货地址dc服务
 * @author zhuchaobin
 *
 */
public interface T1ARInfDcService {
	/**
	 * 描述：根据收货地址id修改收货地址信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	Result<Boolean> save(T1ARInf req);

	Result<PageData<T1ARInfVo>> queryPage(T1ARInfVo query, PageParam pageParam);
	

//
//	Result<PageData<PostAddressDcReq>> queryPostAddressPage(PostAddressDcReq query, PageParam pageParam);
}
