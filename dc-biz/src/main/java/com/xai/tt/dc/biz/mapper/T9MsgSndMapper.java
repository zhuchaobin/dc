package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.xai.tt.dc.client.model.T9MsgSnd;
import com.xai.tt.dc.client.vo.MsgVo;
import com.xai.tt.dc.biz.core.Mapper;

public interface T9MsgSndMapper extends Mapper<T9MsgSnd> {
	Page<MsgVo> selectByPage(MsgVo query);
	int count(MsgVo query);
	MsgVo queryDetail(Integer id);
}
