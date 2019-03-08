package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.Company;
import com.xai.tt.dc.client.query.CompanyQuery;
import com.xai.tt.dc.client.vo.QueryPageInvInfVo;
import com.github.pagehelper.Page;

import java.util.List;

import com.xai.tt.dc.biz.core.Mapper;

public interface CompanyMapper extends Mapper<Company> {
	
	List<Company> queryPage_skf_fkf(QueryPageInvInfVo query);


	Page<Company> selectByDcQuery(CompanyQuery query);


	int count(CompanyQuery query);


}