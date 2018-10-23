package com.tianan.kltsp.dc.biz.core;

import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;

import tk.mybatis.mapper.entity.Condition;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
	
    /**
     * 持久化
     * @param model
     */
    int save(T model);

    /**
     * 批量持久化
     * @param models
     */
    int save(List<T> models);

    /**
     * 通过主键刪除
     * @param id
     */
    int deleteById(Integer id);

    /**
     * 批量刪除 eg：ids -> “1,2,3,4”
     * @param ids
     */
    void deleteByIds(String ids);
    
    /**
     * 通过主键刪除
     * @param id
     */
    int deleteLogicById(Integer id);

    /**
     * 批量刪除 eg：ids -> “1,2,3,4”
     * @param ids
     */
    void deleteLogicByIds(String ids);

    /**
     * 更新
     * @param model
     */
    int update(T model);
    
    /**
     * 更新
     * @param model
     */
    int updateSelective(T model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    T findById(Integer id);

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个ID查找//eg：ids -> “1,2,3,4”
     * @param ids
     * @return
     */
    List<T> findByIds(String ids);

    /**
     * 根据条件查找
     * @param condition
     * @return
     */
    List<T> findByCondition(Condition condition);

    /**
     * //获取所有
     * @return
     */
    List<T> findAll();
}
