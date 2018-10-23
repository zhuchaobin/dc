package com.tianan.kltsp.dc.biz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.tianan.kltsp.dc.client.entity.Factory;
import com.tianan.kltsp.dc.client.query.FactoryQuery;
import com.tianan.kltsp.dc.client.vo.CityVo;
import com.tianan.kltsp.dc.client.vo.FactoryVo;
import com.tianan.kltsp.dc.client.vo.ProvinceVo;
@Mapper
public interface FactoryMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(Factory factory);

    FactoryVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(FactoryVo factory);
    
    Page<FactoryVo> selectByFactoryQuery(FactoryQuery factoryQuery);
    
    int count(FactoryQuery factoryQuery);
    
    int updateByPrimaryKeySelective(Factory factory);
    
    List<ProvinceVo> selectAllProvince();
    
    List<CityVo> selectCityList(String provinceCode);
    
    int insertFactoryBatch(String data);
}