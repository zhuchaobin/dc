package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.inVo.PlgAplyInVo;

/**
 * dc服务
 * @author
 *
 */
public interface PlgAplyDcService {

	Result<Boolean> save(PlgAplyInVo inVo);

	Result<PageData<PlgAplyInVo>> queryPage(PlgAplyInVo inVo, PageParam pageParam);

	Result<PlgAplyInVo> queryDetail(PlgAplyInVo inVo);
	
	Result<Boolean> delete(String id);
}
