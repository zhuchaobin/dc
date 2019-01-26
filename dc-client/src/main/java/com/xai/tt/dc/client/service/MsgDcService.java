package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.MsgVo;

/**
 * 描述：站内信息服务
 * 
 * @author2019-1-24
 */
public interface MsgDcService {
	/*保存或者更新或者发送*/
	Result<Boolean> save(MsgVo query);
	/*分页查询*/
	Result<PageData<MsgVo>>  queryPage(MsgVo query, PageParam pageParam);
	/*查询明细*/
	Result<MsgVo> queryDetail(String id);
	/*按id删除*/
	Result<Boolean> delete(String id);
}
