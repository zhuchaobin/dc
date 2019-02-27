package com.xai.tt.dc.biz.service.impl;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.UserMapper;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.client.model.User;
import com.xai.tt.dc.client.vo.outVo.QueryOrderInfDetailOutVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.biz.mapper.CompanyMapper;
import com.xai.tt.dc.client.model.Company;
import com.xai.tt.dc.client.query.CompanyQuery;
import com.xai.tt.dc.client.service.CompanyDcService;
import com.xai.tt.dc.client.vo.QueryPageInvInfVo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@SuppressWarnings("deprecation")
@Service("companyDcService")
public class CompanyDcServiceImpl implements CompanyDcService {
	private static final Logger logger = LoggerFactory.getLogger(CompanyDcServiceImpl.class);
	@Autowired
	private CompanyMapper companyMapper;




	/*保存或者更新*/
	public Result<Boolean> save(CompanyQuery query){
		return null;
		
	}
	/*分页查询*/
	public Result<PageInfo<Company>> queryPage(CompanyQuery query){
		try {
			Condition condition = new Condition(Company.class); 
			Example.Criteria criteria = condition.createCriteria(); 
			if(null != query) {
				logger.info("分页查询公司信息 =======> query:{},page:{}", query);
				if(StringUtils.isNotBlank(query.getUsrTp())) {
					criteria.andCondition("Usr_Tp = '" + query.getUsrTp() + "'");
				}
				if(StringUtils.isNotBlank(query.getName())) {
					criteria.andLike("name", query.getName());
				}
			}
			List<Company> list = companyMapper.selectByCondition(condition);
			PageInfo<Company> pageInfo = new PageInfo<Company>(list);
			logger.info("q分页查询公司信息成功!");
			return Result.createSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("分页查询公司信息异常 {}", e);
			return Result.createFailResult("查询异常");
		}	
	}
	
	/*分页查询*/
	public Result<PageInfo<Company>> queryPage_skf_fkf(QueryPageInvInfVo query){
		try {
			List<Company> list = companyMapper.queryPage_skf_fkf(query);
			PageInfo<Company> pageInfo = new PageInfo<Company>(list);
			logger.info("q分页查询公司信息成功!");
			return Result.createSuccessResult(pageInfo);
		} catch (Exception e) {
			logger.error("分页查询公司信息异常 {}", e);
			return Result.createFailResult("查询异常");
		}	
	}


	/*分页查询*/
	public Result<PageData<Company>> queryPage(CompanyQuery query, PageParam pageParam){
		logger.info("start query 订单信息 List =======> query:{},page:{}", query, pageParam);
		logger.info("userType:" + query.getUsrTp());
		logger.info("orderBy:" + query.getOrderBy());
		logger.info("getSortName:" + query.getSortName());
		logger.info("getSortOrder:" + query.getSortOrder());
		// 查询用户角色权限信息


		Page<Company> page = null;
		int count = 0;
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}
		try {
			page = companyMapper.selectByDcQuery(query);
			count = companyMapper.count(query);
		} catch (Exception e) {

			logger.error("查询订单列表异常 {}", e);
			return Result.createFailResult("查询异常");
		}
		logger.info("query success!");
		return Result.createSuccessResult(new PageData<>(count, page.getResult()));
	}



	
	/*查询明细*/
	public Result<Company> queryDetail(String id){
		return null;
		
	}
	/*按id删除*/
	public Result<Boolean> delete(String id){
		return null;
		
	}

}
