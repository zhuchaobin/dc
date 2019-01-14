package com.xai.tt.dc.biz.service.impl;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.tianan.common.core.support.SecurityET;
import com.xai.tt.dc.biz.mapper.CompanyMapper;
import com.xai.tt.dc.biz.mapper.UserMapper;
import com.xai.tt.dc.client.model.Company;
import com.xai.tt.dc.client.model.User;
import com.xai.tt.dc.client.service.UserManagementDcService;
import com.xai.tt.dc.client.vo.UserManagementVo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@Service("userManagementDcService")
public class UserManagementDcServiceImpl implements UserManagementDcService {
	private static final Logger logger = LoggerFactory.getLogger(UserManagementDcServiceImpl.class);

	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Result<Boolean> save(UserManagementVo inVo) {
		try {
			logger.info("保存用户信息请求报文", JSON.toJSONString(inVo));
			// TODO Auto-generated method stub
			// 查询用户名是否已经注册
			Condition condition0 = new Condition(User.class);
			Example.Criteria criteria0 = condition0.createCriteria();
			criteria0.andCondition("username = '" + inVo.getUsername() + "'");
			List<User> listUser = userMapper.selectByCondition(condition0);
			if(listUser.size() > 0) {
				logger.error("用户名已存在，注册用户失败。");
				return Result.createFailResult("用户名已存在，注册用户失败。");
			}
			//公司信息保存
			Condition condition = new Condition(Company.class);
			Example.Criteria criteria = condition.createCriteria();
			criteria.andCondition("name = '" + inVo.getCompanyName() + "'");
			List<Company> list = companyMapper.selectByCondition(condition);
			Company company = new Company();
			BeanUtils.copyProperties(inVo, company);
			company.setName(inVo.getCompanyName());//不一样的名字
			// 角色类型保存
			company.setUsrTp("0" + inVo.getUserType());
			if(list.size() > 0) {
				// 更新
//				criteria.andCondition("id = '" + list.get(0).getId());
				companyMapper.updateByConditionSelective(company, condition);
				logger.info("更新公司信息成功:" + company.getName());
			} else {
				// 插入
				company.setCreateTime(new Date());
				companyMapper.insert(company);
				logger.info("新增公司信息成功:" + company.getName());
			}		
			// 获取公司id
			list = companyMapper.selectByCondition(condition);
			if(list.size() > 0) {
				//用户信息保存
				User user = new User();
				BeanUtils.copyProperties(inVo, user);
				user.setMemo(inVo.getRmrk());//不一样的名字
				user.setCtcpsn(inVo.getChineseName());//不一样的名字
				user.setAdtInd(0);//审核标志初始化为未审核
				user.setCreateTime(new Date());
				user.setVersion(1);
				user.setCtcTel(inVo.getMobile());//不一样的名字
				user.setPassword(SecurityET.encryptPassword(inVo.getPassword()));
				user.setLocked(true);
				logger.info("公司id：" + list.get(0).getId());
				user.setCompanyId(list.get(0).getId());
				userMapper.insert(user);			
				logger.info("新增用户信息成功:" + user.getUsername());
			} else {
				logger.error("查询不到公司信息，注册用户失败。");
				return Result.createFailResult("查询不到公司信息，注册用户失败。");
			}
		
			return Result.createSuccessResult(true);
		} catch(Exception e){
			logger.error("用户注册发生异常:" + e);
			return Result.createFailResult("用户注册发生异常：" + e);
		}
	}

	@Override
	public Result<PageData<UserManagementVo>> queryPage(UserManagementVo query, PageParam pageParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<UserManagementVo> queryUserDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Boolean> deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
