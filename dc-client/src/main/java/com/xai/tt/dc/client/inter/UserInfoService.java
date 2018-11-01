package com.xai.tt.dc.client.inter;

import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.entity.UserInfo;

public interface UserInfoService {


    /**
     * 身份信息保存
     * @param userInfo
     * @return
     */
    Result<?> doSave(UserInfo userInfo);

    /**
     * 删除信息
     * @param id
     * @return
     */
    Result<?> delDataById(Integer id);

    /**
     * 分页查询
     *
     * @param userInfo
     * @param pageParam
     * @return
     */
    Result<PageInfo<UserInfo>> queryPage(UserInfo userInfo, PageParam pageParam);

    /**
     * 个人信息查询
     * @param id
     * @return
     */
    Result<UserInfo> findOne(Integer id);

    /**
     * 格局ownerId查询
     * @param ownerId
     * @return
     */
    Result<UserInfo> findByOwnerId(String ownerId);

}
