package com.xai.tt.dc.client.inter;

import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.client.entity.UserProtocol;
import com.xai.tt.dc.client.request.UserProtocolQuery;
import com.xai.tt.dc.client.vo.UserProtocolVo;

/**
 * @author yalei.chen
 * @date 2018/6/17
 * @since JDK 1.8
 */
public interface UserProtocolService {

    /**
     * 1.支持分页条件查询
     * @param query	查询对象
     * @return
     */
    Result<PageInfo<UserProtocolVo>> queryPage(UserProtocolQuery query);

    /**
     * 添加appCode
     * @param model
     * @return
     */
    Result<Integer> addUserProtocol(UserProtocol model);

    /**
     * 按主键删除
     * @param id
     * @return
     */
    Result<Integer> delById(Integer id);

    /**
     * 更新
     * @param model
     * @return
     */
    Result<Integer> updateUserProtocol(UserProtocol model);

    /**
     * 根据主键查找
     * @param id
     * @return
     */
    Result<UserProtocolVo> findUserProtocolById(Integer id);

    /**
     * C端查询用户协议
     * @param appCode
     * @param modelId
     * @return
     */
    Result<UserProtocolVo> findUserProtocol(String appCode,Integer modelId);

}
