package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.xai.tt.dc.client.model.T6SpgInf;
import com.xai.tt.dc.biz.core.Mapper;
import com.xai.tt.dc.client.vo.T1ARInfDetailVo;
import com.xai.tt.dc.client.vo.T6SpgInfDetailVo;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.inVo.SpgManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageArOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryPageSpgOutVo;
import com.xai.tt.dc.client.vo.outVo.QuerySpgInfDetailOutVo;

public interface T6SpgInfMapper extends Mapper<T6SpgInf> {

    int save(SpgManagementInVo req);
    Page<QueryPageSpgOutVo> selectByT6SpgInfDcQuery(SpgManagementInVo query);
    int count(SpgManagementInVo query);
    QuerySpgInfDetailOutVo querySpgDetail(Integer id);
    QuerySpgInfDetailOutVo querySpgDetailBySpgId(String arId);
}