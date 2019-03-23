package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.inVo.PdNmDrcPrcInVo;
import com.xai.tt.dc.client.vo.outVo.PdNmDrcPrcOutVo;

/**
 * <pre>
 * 品名指导价dc 服务接口类
 * </pre>
 * <small> 2019-03-21 15:23:49 | zhuchaobin</small>
 */
 
public interface PdNmDrcPrcDcService {
	/**
	 * 描述：保存品名指导价
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	Result<String> save(PdNmDrcPrcInVo inVo);
	/**
	 * 描述：查询品名指导价列表（分页）
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	Result<PageData<PdNmDrcPrcOutVo>> queryPage(PdNmDrcPrcInVo inVo, PageParam pageParam);
	/**
	 * 描述：查询品名指导价详情（主键）
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	Result<PdNmDrcPrcOutVo> getDetailById(Integer id);	
	/**
	 * 描述：查询品名指导价详情（按条件）
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	Result<PdNmDrcPrcOutVo> getDetailByCondition(PdNmDrcPrcInVo inVo);
	/**
	 * 描述：按id删除品名指导价
	 * 
	 * @<small> 2019-03-21 15:23:49 | zhuchaobin</small>
	 */
	Result<String> batchDelete(String ids);
}