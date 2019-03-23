package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.inVo.Company2InVo;
import com.xai.tt.dc.client.vo.outVo.Company2OutVo;

/**
 * <pre>
 * 企业信息2dc 服务接口类
 * </pre>
 * <small> 2019-03-23 23:10:26 | zhuchaobin</small>
 */
 
public interface Company2DcService {
	/**
	 * 描述：保存企业信息2
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	Result<String> save(Company2InVo inVo);
	/**
	 * 描述：查询企业信息2列表（分页）
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	Result<PageData<Company2OutVo>> queryPage(Company2InVo inVo, PageParam pageParam);
	/**
	 * 描述：查询企业信息2详情（主键）
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	Result<Company2OutVo> getDetailById(Integer id);	
	/**
	 * 描述：查询企业信息2详情（按条件）
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	Result<Company2OutVo> getDetailByCondition(Company2InVo inVo);
	/**
	 * 描述：按id删除企业信息2
	 * 
	 * @<small> 2019-03-23 23:10:26 | zhuchaobin</small>
	 */
	Result<String> batchDelete(String ids);
}