package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.Company;
import com.xai.tt.dc.client.model.T18PlgAply;
import com.xai.tt.dc.client.vo.inVo.PlgAplyInVo;
import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;

public interface T18PlgAplyMapper extends Mapper<T18PlgAply> {
	Page<PlgAplyInVo> selectByPage(PlgAplyInVo query);
	int count(PlgAplyInVo query);
}