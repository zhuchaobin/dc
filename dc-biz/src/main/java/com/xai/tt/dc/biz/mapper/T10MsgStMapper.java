package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.T10MsgSt;
import com.xai.tt.dc.client.vo.QueryPageInvInfVo;
import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;

public interface T10MsgStMapper extends Mapper<T10MsgSt> {
	Page<QueryPageInvInfVo> selectByPage(QueryPageInvInfVo query);
	int count(QueryPageInvInfVo query);
	QueryPageInvInfVo queryDetail(Integer id);
}