package com.xai.tt.dc.biz.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.xai.tt.dc.biz.core.Mapper;
import com.xai.tt.dc.client.entity.PostAddress;
import com.xai.tt.dc.client.request.PostAddressDcReq;
import com.xai.tt.dc.client.vo.PostAddressVo;

public interface PostAddressMapper extends Mapper<PostAddress> {	
	List<PostAddressVo> list(Integer carOwnerId);
	int save(PostAddressDcReq req);
	int expOtherPreferred(PostAddressDcReq req);
	Page<PostAddressVo> pageQuery(PostAddressDcReq query);
	int count(PostAddressDcReq query);	
}