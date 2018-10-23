package com.tianan.kltsp.dc.biz.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.tianan.kltsp.dc.biz.core.Mapper;
import com.tianan.kltsp.dc.client.entity.PostAddress;
import com.tianan.kltsp.dc.client.request.PostAddressDcReq;
import com.tianan.kltsp.dc.client.vo.PostAddressVo;

public interface PostAddressMapper extends Mapper<PostAddress> {	
	List<PostAddressVo> list(Integer carOwnerId);
	int save(PostAddressDcReq req);
	int expOtherPreferred(PostAddressDcReq req);
	Page<PostAddressVo> pageQuery(PostAddressDcReq query);
	int count(PostAddressDcReq query);	
}