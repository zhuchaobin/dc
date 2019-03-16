package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;
import com.xai.tt.dc.client.vo.inVo.PlgDrcPrcInVo;
import com.xai.tt.dc.client.vo.outVo.PlgDrcPrcOutVo;
import com.xai.tt.dc.client.model.B4PlgDrcPrc;

/**
 * 
 * <pre>
 * 质押指导价
 * </pre>
 * <small> 2019-03-16 01:56:08 | xai-auto</small>
 */
public interface B4PlgDrcPrcMapper extends Mapper<B4PlgDrcPrc> {
    int save(PlgDrcPrcInVo inVo);
    Page<PlgDrcPrcOutVo> queryPage(PlgDrcPrcInVo inVo);
    int count(PlgDrcPrcInVo query);
    PlgDrcPrcOutVo getDetailById(Integer id);
    PlgDrcPrcOutVo getDetailByCondition(PlgDrcPrcInVo inVo);
}
