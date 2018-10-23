package com.tianan.kltsp.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.tianan.kltsp.dc.biz.core.Mapper;
import com.tianan.kltsp.dc.client.entity.T1ARInf;
import com.tianan.kltsp.dc.client.vo.T1ARInfVo;

public interface T1ARInfMapper extends Mapper<T1ARInf> {

	int save(T1ARInfVo req);
	Page<T1ARInfVo> selectByT1ARInfDcQuery(T1ARInfVo query);
	int count(T1ARInfVo query);

}