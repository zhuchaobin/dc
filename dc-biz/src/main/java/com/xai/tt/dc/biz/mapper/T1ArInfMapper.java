package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.xai.tt.dc.client.model.T1ArInf;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageArOutVo;
import com.xai.tt.dc.biz.core.Mapper;
public interface T1ArInfMapper extends Mapper<T1ArInf> {
	int save(ArManagementInVo req);
	Page<QueryPageArOutVo> selectByT1ARInfDcQuery(ArManagementInVo query);
	int count(ArManagementInVo query);
}