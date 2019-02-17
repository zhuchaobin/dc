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


	@Autowired
	private T13GdsDetailMapper t13GdsDetailMapper;


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


		List<QueryKcDetailOutVo> result=new ArrayList<>();
		if (page!=null){
			List<QueryKcDetailOutVo> tmpList = page.getResult();

			for (int i = 0; i < tmpList.size(); i++) {

				QueryKcDetailOutVo queryKcDetailOutVo = tmpList.get(i);
				int ivnSt = Integer.parseInt(queryKcDetailOutVo.getIvntSt());
				if (ivnSt ==61||ivnSt==62){

					queryKcDetailOutVo.setRltvId("YD"+queryKcDetailOutVo.getRltvId());

				}else 	if (ivnSt ==77){

					queryKcDetailOutVo.setRltvId("CK"+queryKcDetailOutVo.getRltvId());

				}else{
					queryKcDetailOutVo.setRltvId("ZK"+queryKcDetailOutVo.getRltvId());

				}


				result.add(queryKcDetailOutVo);


			}
		}


		return Result.createSuccessResult(new PageData<>(count, result));

	}

	@Override
	public Result<QueryKcDetailOutVo> queryDetail(KcManagementInVo query) {
		logger.info("查询发货详情,请求参数:{}", JSON.toJSONString(query));
		try {
			QueryKcDetailOutVo t3 = null;
			t3 = t11IvntInfMapper.selectT11IvntInfById(query.getId().intValue());
			if (t3 == null) {
				logger.error("查询发货详情无数据");
				return Result.createFailResult("查询发货详情无数据");
			}


			Condition condition1 = new Condition(T13GdsDetail.class);
			Example.Criteria criteria1 = condition1.createCriteria();
			criteria1.andCondition("Rltv_ID = '" + t3.getRltvId() + "'");
			List<T13GdsDetail> t13GdsDetailList = t13GdsDetailMapper.selectByCondition(condition1);
			if(null != t13GdsDetailList) {
				t3.setT13GdsDetailList(t13GdsDetailList);
				logger.info("查询发货明细信息成功!查询到数据条数：" + t13GdsDetailList.size());
			}
			logger.info("查询发货详情成功!");


			// 查询用户角色参数权限信息
			List<String> userRoleParmsList = userMapper.QueryUserRoleParms(query.getUsername());
			String userRoleParms = "";
			for(String ele:userRoleParmsList) {
				userRoleParms = userRoleParms + "|" + ele;
			}
			if(StringUtils.isNotBlank(userRoleParms)) {
				String[] str = userRoleParms.split("\\|");
				List<String> list = new ArrayList<String>();
				for(String elem: str) {
					list.add(elem);
				}
				t3.setRoleParmsList(list);


			} else {
				logger.error("查询用户角色参数权限信息，结果为空");
			}


			logger.info("querySpgDetail res {}", JSON.toJSONString(t3));

			return Result.createSuccessResult(t3);
		} catch (Exception e) {
			logger.error("查询发货详情异常 {}", e);
			return Result.createFailResult("查询发货详情异常" + e);
		}
	}
}
