package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;
import com.xai.tt.dc.client.vo.inVo.PdNmDrcPrcInVo;
import com.xai.tt.dc.client.vo.outVo.PdNmDrcPrcOutVo;
import com.xai.tt.dc.client.model.B3PdNmDrcPrc;

/**
 * 
 * <pre>
 * 品名指导价
 * </pre>
 * <small> 2019-03-21 15:23:49 | zhuchaobin</small>
 */
public interface B3PdNmDrcPrcMapper extends Mapper<B3PdNmDrcPrc> {
    int save(PdNmDrcPrcInVo inVo);
    Page<PdNmDrcPrcOutVo> queryPage(PdNmDrcPrcInVo inVo);
    int count(PdNmDrcPrcInVo query);
    PdNmDrcPrcOutVo getDetailById(Integer id);
    PdNmDrcPrcOutVo getDetailByCondition(PdNmDrcPrcInVo inVo);
}
