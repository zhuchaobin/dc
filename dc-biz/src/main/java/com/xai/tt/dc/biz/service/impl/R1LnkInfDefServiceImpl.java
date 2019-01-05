package com.xai.tt.dc.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.biz.mapper.R1LnkInfDefMapper;
import com.xai.tt.dc.biz.mapper.RoleMapper;
import com.xai.tt.dc.client.inter.R1LnkInfDefService;

import com.xai.tt.dc.client.model.R1LnkInfDef;
import com.xai.tt.dc.client.model.Role;
import com.xai.tt.dc.client.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

//

@SuppressWarnings("deprecation")
@Service("r1LnkInfDefService")
public class R1LnkInfDefServiceImpl implements R1LnkInfDefService {
	private static final Logger logger = LoggerFactory.getLogger(R1LnkInfDefServiceImpl.class);




	@Autowired
	private R1LnkInfDefMapper r1LnkInfDefMapper;


	@Override
	public  Result<String> querySpecialDiv(String aplyPcstpCd){



		logger.info("start querySpecialDiv aplyPcstpCd======> {}", aplyPcstpCd);

		if (aplyPcstpCd == null||"".equals(aplyPcstpCd)) {

			return Result.createFailResult("aplyPcstpCd为空。");

		};

		List<R1LnkInfDef> r1LnkInfDefs =null;
		try {

			Condition condition = new Condition(R1LnkInfDef.class);
			Example.Criteria criteria = condition.createCriteria();
			criteria.andCondition("Aply_PcStp_Cd = '" + aplyPcstpCd + "'");

			r1LnkInfDefs = r1LnkInfDefMapper.selectByCondition(condition);


		} catch (Exception e) {

			logger.error(" querySpecialDiv发生异常{}", e);
			return Result.createFailResult("querySpecialDiv发生异常");
		}


		logger.info("r1LnkInfDefs======> {}", JSON.toJSONString(r1LnkInfDefs));

		if (r1LnkInfDefs != null&&r1LnkInfDefs.size()>0) {

			 return  Result.createSuccessResult(r1LnkInfDefs.get(0).getAplyPsrlt());

		}else{

			return  Result.createSuccessResult("");
		}


	}
}
