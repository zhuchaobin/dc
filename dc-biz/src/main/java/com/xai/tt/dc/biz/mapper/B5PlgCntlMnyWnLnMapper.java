package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.B5PlgCntlMnyWnLn;
import com.xai.tt.dc.client.vo.PlgCntlMnyWnLnVo;
import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;
public interface B5PlgCntlMnyWnLnMapper extends Mapper<B5PlgCntlMnyWnLn> {
	Page<PlgCntlMnyWnLnVo> selectByPage(PlgCntlMnyWnLnVo query);
	int count(PlgCntlMnyWnLnVo query);
	PlgCntlMnyWnLnVo queryDetail(PlgCntlMnyWnLnVo query);
}