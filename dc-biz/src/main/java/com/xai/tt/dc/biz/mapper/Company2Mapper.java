package com.xai.tt.dc.biz.mapper;

import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;
import com.xai.tt.dc.client.vo.inVo.Company2InVo;
import com.xai.tt.dc.client.vo.outVo.Company2OutVo;
import com.xai.tt.dc.client.model.Company;

/**
 * 
 * <pre>
 * 企业信息2
 * </pre>
 * <small> 2019-03-23 23:10:26 | zhuchaobin</small>
 */
public interface Company2Mapper extends Mapper<Company> {
    int save(Company2InVo inVo);
    Page<Company2OutVo> queryPage(Company2InVo inVo);
    int count(Company2InVo query);
    Company2OutVo getDetailById(Integer id);
    Company2OutVo getDetailByCondition(Company2InVo inVo);
}
