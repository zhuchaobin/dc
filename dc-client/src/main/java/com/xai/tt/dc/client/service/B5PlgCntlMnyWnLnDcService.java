package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.B5PlgCntlMnyWnLnVo;

/**
 * dc服务
 * @author
 *
 */
public interface B5PlgCntlMnyWnLnDcService {
	// 最低控货预警线保存
	Result<Boolean> save(B5PlgCntlMnyWnLnVo inVo);
	// 最低控货预警线列表查询
	Result<PageData<B5PlgCntlMnyWnLnVo>> queryPage(B5PlgCntlMnyWnLnVo inVo, PageParam pageParam);
	// 最低控货预警线详情查询
	Result<B5PlgCntlMnyWnLnVo> queryDetail(B5PlgCntlMnyWnLnVo inVo);
	// 最低控货预警线删除
	Result<Boolean> delete(String id);
}
