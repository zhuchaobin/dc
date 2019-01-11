package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.Company;
import com.xai.tt.dc.client.vo.QueryPageInvInfVo;

import java.util.List;

import com.xai.tt.dc.biz.core.Mapper;

public interface CompanyMapper extends Mapper<Company> {
	
	List<Company> queryPage_skf_fkf(QueryPageInvInfVo query);
}