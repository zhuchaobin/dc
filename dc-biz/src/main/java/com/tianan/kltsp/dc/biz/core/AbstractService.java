package com.tianan.kltsp.dc.biz.core;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractService.class);

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public int save(T model) {
        return mapper.insertSelective(model);
    }

    public int save(List<T> models) {
        return mapper.insertList(models);
    }

    public int deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public void deleteByIds(String ids) {
        Stream.of(ids.split(",")).map(Integer::valueOf).forEach(this::deleteById);
    }

    @Transactional
    public void deleteByIds(List<Integer> ids) {
        ids.forEach(this::deleteById);
    }
    
    public int deleteLogicById(Integer id) {
        try {
            //T model = mapper.selectByPrimaryKey(id);
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField("id");
            field.setAccessible(true);
            field.set(model, id);//id
            field = modelClass.getDeclaredField("status");
            field.setAccessible(true);
            field.set(model, false);//status
            return mapper.updateByPrimaryKeySelective(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void deleteLogicByIds(String ids) {
    	Stream.of(ids.split(",")).map(Integer::valueOf).forEach(this::deleteLogicById);
    }

    public int update(T model) {
    	try {
	        Field field = modelClass.getDeclaredField("updateTime");
	        field.setAccessible(true);
	        field.set(model, new Date());
    	} catch(Exception e) {}
        return mapper.updateByPrimaryKeySelective(model);
    }

    public int updateByCondition(T model,Condition condition) {
        try {
            Field field = modelClass.getDeclaredField("updateTime");
            field.setAccessible(true);
            field.set(model, new Date());
        } catch(Exception e) {}
        return mapper.updateByCondition(model,condition);
    }
    
    public int updateSelective(T model) {
    	try {
	        Field field = modelClass.getDeclaredField("updateTime");
	        field.setAccessible(true);
	        field.set(model, new Date());
    	} catch(Exception e) {}
        return mapper.updateByPrimaryKeySelective(model);
    }

    public T findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }

    /**
     * 此方法慎用,要保证query对象中的非Date类型的属性名与pojo中的实体的属性名字一致
     * @param t
     * @param criteria
     * @param <K>
     */
    protected <K> void fillParam(K t,Example.Criteria criteria) {
        Class clazz = t.getClass();
        Field[] fields = t.getClass().getDeclaredFields();
        Stream.of(fields).forEach(item->{
            try {
                if ("pageNo".equals(item.getName()) || "pageSize".equals(item.getName())) return;
                Method method = clazz.getMethod("get" + item.getName().substring(0, 1).toUpperCase() + item.getName().substring(1));
                Object obj = method.invoke(t);
                if (obj == null || obj instanceof Date || obj instanceof Boolean) return;
                criteria.andLike(item.getName(), "%" + obj + "%");
            } catch (Exception e) {
                logger.error("属性没有get方法,或者属性名与实体中的实体名不一致");
            }
        });
    }
}
