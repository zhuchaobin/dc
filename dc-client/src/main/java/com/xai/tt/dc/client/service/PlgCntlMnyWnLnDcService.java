package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.PlgCntlMnyWnLnVo;

/**
 * dc服务
 * @author
 *
 */
public interface PlgCntlMnyWnLnDcService {
	// 控货预警线列表查询
	Result<PageData<PlgCntlMnyWnLnVo>> queryPage(PlgCntlMnyWnLnVo inVo, PageParam pageParam);
	// 控货预警线详情查询
	Result<PlgCntlMnyWnLnVo> queryDetail(PlgCntlMnyWnLnVo inVo);
	// 控货预警线删除
	Result<Boolean> delete(String id); 

}
