package com.xai.tt.dc.client.service;

import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.model.Company;
import com.xai.tt.dc.client.query.CompanyQuery;
import com.xai.tt.dc.client.vo.QueryPageInvInfVo;

/**
 * 描述：发票信息服务
 * 
 * @author2019-1-10
 */
public interface InvInfDcService {
	/*保存或者更新*/
	Result<Boolean> save(QueryPageInvInfVo query);
	/*分页查询*/
	Result<PageData<QueryPageInvInfVo>>  queryPage(QueryPageInvInfVo query, PageParam pageParam);
	/*查询明细*/
	Result<QueryPageInvInfVo> queryDetail(String id);
	/*按id删除*/
	Result<Boolean> delete(String id);
}
