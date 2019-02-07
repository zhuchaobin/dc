package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.xai.tt.dc.client.model.T11IvntInf;
import com.xai.tt.dc.biz.core.Mapper;
import com.xai.tt.dc.client.vo.inVo.KcManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryKcDetailOutVo;
import com.xai.tt.dc.client.vo.outVo.QuerySpgInfDetailOutVo;

public interface T11IvntInfMapper extends Mapper<T11IvntInf> {
    Page<QueryKcDetailOutVo> selectByT11IvntInfDcQuery(KcManagementInVo query);

    int count(KcManagementInVo query);


    QueryKcDetailOutVo selectT11IvntInfById(KcManagementInVo query);

}