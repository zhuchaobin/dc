package com.xai.tt.dc.biz.service.impl;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.T10MsgStMapper;
import com.xai.tt.dc.biz.mapper.T9MsgSndMapper;
import com.xai.tt.dc.client.model.T10MsgSt;
import com.xai.tt.dc.client.model.T12InvInf;
import com.xai.tt.dc.client.model.T9MsgSnd;
import com.xai.tt.dc.client.service.MsgDcService;
import com.xai.tt.dc.client.vo.MsgVo;

@SuppressWarnings("deprecation")
@Service("msgDcService")
public class MsgDcServiceImpl implements MsgDcService {
	private static final Logger logger = LoggerFactory.getLogger(MsgDcServiceImpl.class);
	@Autowired
	private T10MsgStMapper t10MsgStMapper;
	@Autowired
	private T9MsgSndMapper t9MsgSndMapper;
	
	/*保存或者更新或者发送*/
	public Result<Boolean> save(MsgVo query){
		logger.info("保存或者更新发票信息  =======> query:{}", query);
		try {
			T12InvInf t12 = new T12InvInf();
			t12.setId(query.getId());
			if("01".equals(query.getSecSrvCd())) {
				t12.setIssubillPsn(query.getUsername());
				t12.setIssubillTm(new Date());
			} else if ("02".equals(query.getSecSrvCd())) {
				t12.setBilrecr(query.getUsername());
				t12.setInvTm(new Date());
			}
				
//			t12InvInfMapper.updateByPrimaryKeySelective(t12);
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("更新发票信息异常 {}", e);
			return Result.createFailResult("更新发票信息异常：" + e);
		}		
	}
	/*分页查询*/
	public Result<PageData<MsgVo>>  queryPage(MsgVo query, PageParam pageParam){
		logger.info("start query 发票信息 List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		logger.info("orderBy:" + query.getOrderBy());
		logger.info("getSortName:" + query.getSortName());
		logger.info("getSortOrder:" + query.getSortOrder());
		// 
		Page<MsgVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = t9MsgSndMapper.selectByPage(query);
			count = t9MsgSndMapper.count(query);
		} catch (Exception e) {

			logger.error("查询站内信息列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("查询站内信息列表 success!");
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}
	/*查询明细*/
	public Result<MsgVo> queryDetail(String id, String secSrvCd, String msgRevId){
		MsgVo vo = new MsgVo();
		T9MsgSnd t9 = t9MsgSndMapper.selectByPrimaryKey(Long.parseLong(id));
		if(null == t9)
			return Result.createFailResult("查询不到数据！");
		else {
			// 如果是读取操作，则设置为已读取
			if(StringUtils.isNoneBlank(secSrvCd) && "09".equals(secSrvCd) && StringUtils.isNoneBlank(msgRevId)) {
				T10MsgSt t10 = t10MsgStMapper.selectByPrimaryKey(Long.parseLong(msgRevId));
				if(null != t10) {
					t10.setMsgStcd("04");
					t10MsgStMapper.updateByPrimaryKeySelective(t10);
				}
			}
			BeanUtils.copyProperties(t9, vo);
			return Result.createSuccessResult(vo);	
		}
	}
	/*按id删除*/
	public Result<Boolean> delete(String id){
		logger.info("start delete发票信息 =======> id:{}", id);
		try {
			t9MsgSndMapper.deleteByPrimaryKey(id);
			return Result.createSuccessResult(true);
		} catch (Exception e) {
			logger.error("删除发票信息异常 {}", e);
			return Result.createFailResult("删除发票信息异常[" + e + "]");
		}		
	}

}
