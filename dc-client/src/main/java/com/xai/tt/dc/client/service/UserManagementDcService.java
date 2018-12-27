package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.UserManagementVo;

/**
 * 用户信息dc服务
 * @author zhuchaobin
 *
 */
public interface UserManagementDcService {
	/**
	 * 描述：保存用户信息
	 * 
	 * @author zhuchaobin 2018-12-27
	 */
	Result<Boolean> save(UserManagementVo req);

	Result<PageData<UserManagementVo>> queryPage(UserManagementVo query, PageParam pageParam);

	Result<UserManagementVo> queryUserDetail(String id);

	Result<Boolean> deleteUser(String id);
}
