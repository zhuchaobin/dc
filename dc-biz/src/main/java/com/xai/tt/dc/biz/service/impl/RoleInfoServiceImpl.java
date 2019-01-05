package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.biz.mapper.ActRuTaskMapper;
import com.xai.tt.dc.biz.mapper.RoleMapper;
import com.xai.tt.dc.client.inter.RoleInfoService;
import com.xai.tt.dc.client.model.Role;
import com.xai.tt.dc.client.query.WfeQuery;
import com.xai.tt.dc.client.service.WfDcService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//

@SuppressWarnings("deprecation")
@Service("roleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {
	private static final Logger logger = LoggerFactory.getLogger(RoleInfoServiceImpl.class);

	@Autowired
	private RoleMapper roleMapper;


	@Override
	public Result<String> querySpecialDiv(String userName) {



		logger.info("start querySpecialDiv userName======> {}", userName);

		if (userName == null||"".equals(userName)) {

			return Result.createFailResult("用户名为空。");

		};

		List<Role> roleList=null;
		try {
			roleList = roleMapper.querySpecialDiv(userName);
		} catch (Exception e) {

			logger.error(" querySpecialDiv发生异常{}", e);
			return Result.createFailResult("querySpecialDiv发生异常");
		}

		StringBuffer sbf1 =new StringBuffer();
		StringBuffer sbf2 =new StringBuffer();

		logger.info("roleList======> {}", JSON.toJSONString(roleList));

		if (roleList != null&&roleList.size()>0) {

			for (int i = 0; i < roleList.size(); i++) {

				Role role = roleList.get(i);
				String aplyPsrlt = role.getAplyPsrlt();
				if (aplyPsrlt == null||"".equals(aplyPsrlt)) {
				continue;
				};

				String[] split = aplyPsrlt.split("\\|");

				if (split.length > 0) {

					for (int j = 0; j < split.length; j++) {

						String s = split[j];

						if (s.startsWith("order")) {

							sbf1.append(s.replaceAll("order:", ""));

						} else if (s.startsWith("spg")) {

							sbf2.append(s.replaceAll("spg:", ""));
						}

					}



				}


			}



		}



		Result<String> result = Result.createSuccessResult(sbf1.toString() + sbf2.toString());

		logger.info("end querySpecialDiv result======> {}", JSON.toJSONString(result));
		return result;

	}
}
