package com.xai.tt.dc.client.service;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.vo.inVo.KcManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryKcDetailOutVo;

/**
 * 品类信息dc服务
 * @author yuzhaoyang
 *
 */
public interface PdService {


    public Result<Boolean> savePrc() ;
}
