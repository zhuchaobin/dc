package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.xai.tt.dc.client.model.T12InvInf;
import com.xai.tt.dc.client.vo.QueryPageInvInfVo;
import com.xai.tt.dc.client.vo.T1ARInfDetailVo;
import com.xai.tt.dc.biz.core.Mapper;

@SuppressWarnings("unused")
public interface T12InvInfMapper extends Mapper<T12InvInf> {
	Page<QueryPageInvInfVo> selectByPage(QueryPageInvInfVo query);
	int count(QueryPageInvInfVo query);
	QueryPageInvInfVo queryDetail(Integer id);
}