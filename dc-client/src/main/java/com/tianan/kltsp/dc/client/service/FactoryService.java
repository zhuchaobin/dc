package com.tianan.kltsp.dc.client.service;

import java.util.List;

import com.tianan.common.api.bean.PageData;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.tianan.kltsp.dc.client.entity.Factory;
import com.tianan.kltsp.dc.client.query.FactoryQuery;
import com.tianan.kltsp.dc.client.vo.CityVo;
import com.tianan.kltsp.dc.client.vo.FactoryVo;
import com.tianan.kltsp.dc.client.vo.ProvinceVo;

public interface FactoryService {
	
    public Result<PageData<FactoryVo>> queryFactoryList(FactoryQuery factoryQuery,PageParam pageParam);
	
	public Result<FactoryVo> queryFactoryById(Integer id);
	
	public Result<Boolean> updateFactory(Factory factory);
	
	public Result<Boolean> deleteFactoryById(Integer id);
	
	public Result<Boolean> addFactory(Factory factory);
	
	public Result<Boolean> updateFactorySelective(Factory factory);
	
	public Result<List<ProvinceVo>> queryAllProvince();
	
	public Result<List<CityVo>> queryCityList(String provinceCode);
	
	/**
     * 检查导入的经销商信息并返回检查结果
     * @param importDriver
     * @return
     */
    Result<Factory> importFactoryCheck(Factory factory);

    /**
     * 批量插入经销商信息
     * @param data
     * @return
     */
    Result<Boolean> importFactoryBatch(String data);
}
