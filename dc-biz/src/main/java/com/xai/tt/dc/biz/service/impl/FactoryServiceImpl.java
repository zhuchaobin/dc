package com.xai.tt.dc.biz.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.xai.tt.dc.biz.mapper.FactoryMapper;
import com.xai.tt.dc.client.entity.Factory;
import com.xai.tt.dc.client.query.FactoryQuery;
import com.xai.tt.dc.client.service.FactoryService;
import com.xai.tt.dc.client.vo.CityVo;
import com.xai.tt.dc.client.vo.FactoryVo;
import com.xai.tt.dc.client.vo.ProvinceVo;
@Service
public class FactoryServiceImpl implements FactoryService {
	
     private static final Logger logger = LoggerFactory.getLogger(FactoryServiceImpl.class);
	
	@Autowired
	private FactoryMapper factoryMapper;

	@Override
	public Result<PageData<FactoryVo>> queryFactoryList(FactoryQuery factoryQuery, PageParam pageParam) {
		logger.info("start query factory List =======> query:{},page:{}",factoryQuery,pageParam);
		Page<FactoryVo> page = null;
		
		if (pageParam != null) {
			PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		}try{
		    page = factoryMapper.selectByFactoryQuery(factoryQuery);
		}catch(Exception e){
			logger.error("查询异常!",e);
		    return Result.createFailResult("查询异常");
		}
		return Result.createSuccessResult(new PageData<>(page.getTotal(), page.getResult()));
	}

	@Override
	public Result<FactoryVo> queryFactoryById(Integer id) {
		logger.info("start query factory by id =======> id:{}",id);
		FactoryVo factory = null;
		try{
			factory = factoryMapper.selectByPrimaryKey(id);
		}catch(Exception e){
			e.printStackTrace();
			return Result.createFailResult("查询异常"); 
		}
		return Result.createSuccessResult(factory);
	}

	@Override
	public Result<Boolean> updateFactory(Factory factory) {
		logger.info("start update factory =======> factory:{}",factory);
		try{
		FactoryVo factoryDb = factoryMapper.selectByPrimaryKey(factory.getId());
		  if(factoryDb == null){
			  return Result.createFailResult("该数据不存在无法进行更新操作");
		  }
		factoryDb.setName(factory.getName());
		factoryDb.setCode(factory.getCode());
		factoryDb.setManagerName(factory.getManagerName());
		factoryDb.setEmail(factory.getEmail());
		factoryDb.setProvince(factory.getProvince());
		factoryDb.setCity(factory.getCity());
		factoryDb.setAddress(factory.getAddress());
		factoryDb.setMobile(factory.getMobile());
		factoryDb.setLocked(factory.getLocked());
		factoryMapper.updateByPrimaryKey(factoryDb); 
		}catch(Exception e){
			e.printStackTrace();
			return Result.createFailResult("更新异常"); 
		}
		return Result.createSuccessResult(true);
	}

	@Override
	public Result<Boolean> deleteFactoryById(Integer id) {
		logger.info("start delete factory by id =======> id :{}",id);
		try{
			factoryMapper.deleteByPrimaryKey(id);
		}catch(Exception e){
			e.printStackTrace();
			return Result.createFailResult("删除异常");
		}
		return Result.createSuccessResult(true);
	}

	@Override
	public Result<Boolean> addFactory(Factory factory) {
		logger.info("start insert factory =======> factory:{}",factory);
		try{
			factoryMapper.insert(factory);
		}catch(Exception e){
			e.printStackTrace();
			return Result.createFailResult("插入异常");
		}
		return Result.createSuccessResult(true);
	}

	@Override
	public Result<Boolean> updateFactorySelective(Factory factory) {
		logger.info("start update factory ======> factory:{}",factory);
		try{
			factoryMapper.updateByPrimaryKeySelective(factory);
		}catch(Exception e){
			e.printStackTrace();
			return Result.createFailResult("更新异常");
		}
		return Result.createSuccessResult(true);
	}

	@Override
	public Result<List<ProvinceVo>> queryAllProvince() {
		logger.info("start query all Province ======>");
		List<ProvinceVo> list = null;
		try{
			list = factoryMapper.selectAllProvince();
		}catch(Exception e){
			e.printStackTrace();
			return Result.createFailResult("查询异常");
		}
		return Result.createSuccessResult(list);
	}

	@Override
	public Result<List<CityVo>> queryCityList(String provinceCode) {
		logger.info("start query City List ======>");
		List<CityVo> list = null;
		try{
			list = factoryMapper.selectCityList(provinceCode);
		}catch(Exception e){
			e.printStackTrace();
			return Result.createFailResult("查询异常");
		}
		return Result.createSuccessResult(list);
	}

	@Override
	public Result<Factory> importFactoryCheck(Factory factory) {
		FactoryQuery query = new FactoryQuery();
        query.setCode(factory.getCode());
        boolean checkStatus = true;
        try{
        	int count = factoryMapper.count(query);
            if(count > 0){
            	factory.setCode("编号已存在，");
    		    checkStatus = false;
    	    }else{
    		
    	    }
        }catch(Exception e){
    	    e.printStackTrace();
    	    factory.setCode("编号校验异常，");
    	    checkStatus = false;
        }

        if(checkStatus){
			return Result.createSuccessResult(factory);
		}else {
			return Result.createFailResult(1,null,factory);
		}
	}

	@Override
	public Result<Boolean> importFactoryBatch(String data) {
		factoryMapper.insertFactoryBatch(data);
		return Result.createSuccessResult(true);
	}
	
}
