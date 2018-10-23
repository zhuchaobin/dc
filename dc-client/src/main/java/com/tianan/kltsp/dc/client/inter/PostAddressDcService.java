package com.tianan.kltsp.dc.client.inter;

import java.util.List;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.tianan.kltsp.dc.client.entity.PostAddress;
import com.tianan.kltsp.dc.client.request.PostAddressDcReq;
import com.tianan.kltsp.dc.client.response.PostAddressRes;
import com.tianan.kltsp.dc.client.vo.PostAddressVo;

/**
 * 收货地址dc服务
 * @author zhuchaobin
 *
 */
public interface PostAddressDcService {
	/**
	 * 描述：根据收货地址id修改收货地址信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	Result<Boolean> save(PostAddressDcReq req);
	
	/**
	 * 描述：根据收货地址id删除收货地址信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	Result<?> delete(PostAddress medel);
	
	/**
	 * 描述：根据车主用户id查询收货地址列表信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	Result<List<PostAddressVo>> list(Integer carOwnerId);
	
	/**
	 * 描述：根据收货地址id查询收货地址信息
	 * 
	 * @author zhucb 2018-06-30
	 */
	Result<PostAddress> query(Integer id);
	
	/**
	 * 描述：新增根据收货地址
	 * 
	 * @author zhucb 2018-06-30
	 */
	Result<Boolean> add(PostAddress medel);
	
	/**
	 * 描述：设置车主默认收货地址
	 * 
	 * @author zhucb 2018-06-30
	 */
	Result<Boolean> setPreferredPostAddres(PostAddress model);
	/**
	 * 描述：根据条件查询收货地址列表信息
	 * 
	 * @author zhucb 2018-07-21
	 */
	Result<PageData<PostAddressVo>> queryPage(PostAddressDcReq query, PageParam pageParam);
//
//	Result<PageData<PostAddressDcReq>> queryPostAddressPage(PostAddressDcReq query, PageParam pageParam);
}
