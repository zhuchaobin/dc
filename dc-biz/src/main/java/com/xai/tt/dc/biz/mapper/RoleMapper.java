package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    List<Role> querySpecialDiv(String username);
}