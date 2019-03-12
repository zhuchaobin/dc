package com.xai.tt.dc.client.service;

import java.util.List;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.query.UserInfoQuery;
import com.xai.tt.dc.client.vo.inVo.IvntDtlInVo;
import com.xai.tt.dc.client.vo.inVo.OutStgTnumInVo;
import com.xai.tt.dc.client.vo.outVo.GdsBlgOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageIvntDtlOutVo;

/**
 * dc服务
 * @author
 *
 */
public interface IvntDtlDcService {
	// 库存列表查询
	Result<PageData<QueryPageIvntDtlOutVo>> queryPage(IvntDtlInVo inVo, PageParam pageParam);
	// 库存详情查询
	Result<QueryPageIvntDtlOutVo> queryDetail(IvntDtlInVo inVo);
	// 库存删除
	Result<Boolean> delete(String id); 
	// 查询货物归属列表
	Result<List<GdsBlgOutVo>> queryGdsBlgList(UserInfoQuery userInfo); 
	// 出库
	Result<?> outStgTnum(OutStgTnumInVo inVo); 
}
