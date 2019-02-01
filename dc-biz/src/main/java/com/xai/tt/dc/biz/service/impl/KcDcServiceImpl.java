package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.*;
import com.xai.tt.dc.biz.utils.*;
import com.xai.tt.dc.client.inter.R1LnkInfDefService;
import com.xai.tt.dc.client.model.*;
import com.xai.tt.dc.client.query.SubmitSpgQuery;
import com.xai.tt.dc.client.query.UserInfoQuery;
import com.xai.tt.dc.client.service.KcDcService;
import com.xai.tt.dc.client.service.SpgManagementDcService;
import com.xai.tt.dc.client.service.WfDcService;
import com.xai.tt.dc.client.vo.inVo.ArManagementInVo;
import com.xai.tt.dc.client.vo.inVo.KcManagementInVo;
import com.xai.tt.dc.client.vo.inVo.OrderManagementInVo;
import com.xai.tt.dc.client.vo.inVo.SpgManagementInVo;
import com.xai.tt.dc.client.vo.outVo.QueryKcDetailOutVo;
import com.xai.tt.dc.client.vo.outVo.QueryLnkJrnlInfOutVo;
import com.xai.tt.dc.client.vo.outVo.QuerySpgInfDetailOutVo;
import com.xai.tt.dc.client.vo.outVo.QuerySpgSubmmitDetailOutVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
@Service("kcDcService")
public class KcDcServiceImpl implements KcDcService {
	private static final Logger logger = LoggerFactory.getLogger(KcDcServiceImpl.class);


	@Autowired
	private UserMapper userMapper;



	@Autowired
	private T11IvntInfMapper t11IvntInfMapper;


	@Override
	public Result<PageData<QueryKcDetailOutVo>> queryPage(KcManagementInVo query, PageParam pageParam) {


		logger.info("start query 发货信息 List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUserType());
		logger.info("orderBy:" + query.getOrderBy());
		logger.info("getSortName:" + query.getSortName());
		logger.info("getSortOrder:" + query.getSortOrder());
		// 查询用户角色权限信息
		Condition condition = new Condition(User.class);
		Example.Criteria criteria = condition.createCriteria();
		criteria.andCondition("username = '" + query.getUsername() + "'");
		User user = userMapper.selectByCondition(condition).get(0);
		query.setSplchainCo(user.getSplchainCo());
		query.setUserType(user.getUserType());
		query.setCompanyId(user.getCompanyId());
		query.setUsrTp(DataConstants.USER_TYPE_2_USR_TP.get(user.getUserType()));

		Page<QueryKcDetailOutVo> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = t11IvntInfMapper.selectByT11IvntInfDcQuery(query);
			count = t11IvntInfMapper.count(query);
		} catch (Exception e) {

			logger.error("查询发货列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("queryPage success!{}",JSON.toJSON(page));
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));

	}
}
