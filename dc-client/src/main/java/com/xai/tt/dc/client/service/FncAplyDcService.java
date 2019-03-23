package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.inVo.FncAplyInVo;
import com.xai.tt.dc.client.vo.outVo.FncAplyOutVo;

/**
 * <pre>
 * 融资申请dc 服务接口类
 * </pre>
 * <small> 2019-03-20 23:41:27 | zhuchaobin</small>
 */
 
public interface FncAplyDcService {
	/**
	 * 描述：保存融资申请
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	Result<String> save(FncAplyInVo inVo);
	/**
	 * 描述：查询融资申请列表（分页）
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	Result<PageData<FncAplyOutVo>> queryPage(FncAplyInVo inVo, PageParam pageParam);
	/**
	 * 描述：查询融资申请详情（主键）
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	Result<FncAplyOutVo> getDetailById(Integer id);	
	/**
	 * 描述：查询融资申请详情（按条件）
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	Result<FncAplyOutVo> getDetailByCondition(FncAplyInVo inVo);
	/**
	 * 描述：按id删除融资申请
	 * 
	 * @<small> 2019-03-20 23:41:27 | zhuchaobin</small>
	 */
	Result<String> batchDelete(String ids);
}