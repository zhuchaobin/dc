package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.inVo.PlgDrcPrcInVo;
import com.xai.tt.dc.client.vo.outVo.PlgDrcPrcOutVo;

/**
 * <pre>
 * 质押指导价dc 服务接口类
 * </pre>
 * <small> 2019-03-16 01:56:08 | xai-auto</small>
 */
 
public interface PlgDrcPrcDcService {
	/**
	 * 描述：保存质押指导价
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	Result<String> save(PlgDrcPrcInVo inVo);
	/**
	 * 描述：查询质押指导价列表（分页）
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	Result<PageData<PlgDrcPrcOutVo>> queryPage(PlgDrcPrcInVo inVo, PageParam pageParam);
	/**
	 * 描述：查询质押指导价详情（主键）
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	Result<PlgDrcPrcOutVo> getDetailById(Integer id);	
	/**
	 * 描述：查询质押指导价详情（按条件）
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	Result<PlgDrcPrcOutVo> getDetailByCondition(PlgDrcPrcInVo inVo);
	/**
	 * 描述：按id删除质押指导价
	 * 
	 * @<small> 2019-03-16 01:56:08 | xai-auto</small>
	 */
	Result<String> batchDelete(String ids);
}