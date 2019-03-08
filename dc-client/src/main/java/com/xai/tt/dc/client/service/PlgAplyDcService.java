package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.inVo.PlgAplyInVo;

/**
 * dc服务
 * @author
 *
 */
public interface PlgAplyDcService {
	// 质押申请
	Result<Boolean> save(PlgAplyInVo inVo);
	// 质押列表查询
	Result<PageData<PlgAplyInVo>> queryPage(PlgAplyInVo inVo, PageParam pageParam);
	// 质押详情查询
	Result<PlgAplyInVo> queryDetail(PlgAplyInVo inVo);
	// 质押删除
	Result<Boolean> delete(String id);
	// 质押审核
	Result<Boolean> adt(PlgAplyInVo inVo);
}
