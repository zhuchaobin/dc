package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.T17IvntDtl;
import com.xai.tt.dc.client.vo.inVo.IvntDtlInVo;
import com.xai.tt.dc.client.vo.inVo.OutStgTnumSubInVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageIvntDtlOutVo;

import java.util.List;

import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;
 
public interface T17IvntDtlMapper extends Mapper<T17IvntDtl> {
	Page<QueryPageIvntDtlOutVo> selectByPage(IvntDtlInVo query);
	int count(IvntDtlInVo query);
	QueryPageIvntDtlOutVo queryDetail(String id);
	List<String> queryGdsBlgList();
	void updateT17(OutStgTnumSubInVo t17);
	List<QueryPageIvntDtlOutVo> selectByList(IvntDtlInVo query);
}