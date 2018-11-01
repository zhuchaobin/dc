package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.core.Mapper;
import com.xai.tt.dc.client.entity.T1ARInf_bak;
import com.xai.tt.dc.client.vo.T1ARInfVo;

public interface T1ARInfMapper_bak extends Mapper<T1ARInf_bak> {

	int save(T1ARInfVo req);
	Page<T1ARInfVo> selectByT1ARInfDcQuery(T1ARInfVo query);
	int count(T1ARInfVo query);

}