package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.T0LnkJrnlInf;
import com.xai.tt.dc.client.vo.outVo.QueryLnkJrnlInfOutVo;

import java.util.List;

import com.xai.tt.dc.biz.core.Mapper;

public interface T0LnkJrnlInfMapper extends Mapper<T0LnkJrnlInf> {
	List<QueryLnkJrnlInfOutVo> QueryLnkJrnlInfList(T0LnkJrnlInf query);
}