package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.T1ArInf;
import com.xai.tt.dc.client.vo.T1ARInfVo;
import com.xai.tt.dc.client.vo.inVo.TB0001InVo;
import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;

public interface T1ARInfMapper_v1 extends Mapper<T1ArInf> {
	int save(TB0001InVo req);
	Page<T1ARInfVo> selectByT1ARInfDcQuery(TB0001InVo query);
	int count(TB0001InVo query);
}