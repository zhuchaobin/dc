package com.xai.tt.dc.client.service;

import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.model.Company;
import com.xai.tt.dc.client.query.CompanyQuery;

/**
 * 描述：公司信息服务
 * 
 * @author2018-11-30
 */
public interface CompanyDcService {
	/*保存或者更新*/
	Result<Boolean> save(CompanyQuery query);
	/*分页查询*/
	Result<PageInfo<Company>> queryPage(CompanyQuery query);
	/*查询明细*/
	Result<Company> queryDetail(String id);
	/*按id删除*/
	Result<Boolean> delete(String id);
}
