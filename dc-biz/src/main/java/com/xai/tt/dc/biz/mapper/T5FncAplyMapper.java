package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;
import com.xai.tt.dc.client.vo.inVo.FncAplyInVo;
import com.xai.tt.dc.client.vo.outVo.FncAplyOutVo;
import com.xai.tt.dc.client.model.T5FncAply;

/**
 * 
 * <pre>
 * 融资申请
 * </pre>
 * <small> 2019-03-20 23:41:27 | zhuchaobin</small>
 */
public interface T5FncAplyMapper extends Mapper<T5FncAply> {
    int save(FncAplyInVo inVo);
    Page<FncAplyOutVo> queryPage(FncAplyInVo inVo);
    int count(FncAplyInVo query);
    FncAplyOutVo getDetailById(Integer id);
    FncAplyOutVo getDetailByCondition(FncAplyInVo inVo);
}
