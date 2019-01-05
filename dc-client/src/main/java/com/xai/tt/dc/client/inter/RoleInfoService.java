package com.xai.tt.dc.client.inter;

import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.client.entity.UserInfo;
import com.xai.tt.dc.client.model.Role;

import java.util.List;

public interface RoleInfoService {


    /**
     * 查询个性化字段
     * @param userName
     * @return
     */
    Result<String> querySpecialDiv(String userName);

}
