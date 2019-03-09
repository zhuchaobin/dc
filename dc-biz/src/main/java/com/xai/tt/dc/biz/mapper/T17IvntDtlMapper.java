package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.T17IvntDtl;
import com.xai.tt.dc.client.vo.inVo.IvntDtlInVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageIvntDtlOutVo;
import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;
 
public interface T17IvntDtlMapper extends Mapper<T17IvntDtl> {
	Page<QueryPageIvntDtlOutVo> selectByPage(IvntDtlInVo query);
	int count(IvntDtlInVo query);
	QueryPageIvntDtlOutVo queryDetail(String id);
}