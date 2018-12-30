package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.User;

import java.util.List;

import com.xai.tt.dc.biz.core.Mapper;

public interface UserMapper extends Mapper<User> {
	List<String> QueryUserRoleParms(String username);
}