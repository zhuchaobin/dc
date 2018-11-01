package com.xai.tt.dc.biz.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.biz.core.AbstractService;
import com.xai.tt.dc.biz.mapper.UserProtocolMapper;
import com.xai.tt.dc.client.entity.UserProtocol;
import com.xai.tt.dc.client.inter.UserProtocolService;
import com.xai.tt.dc.client.request.UserProtocolQuery;
import com.xai.tt.dc.client.vo.UserProtocolVo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yalei.chen
 * @date 2018/6/17
 * @since JDK 1.8
 */
@Service("userProtocolService")
public class UserProtocolServiceImpl extends AbstractService<UserProtocol> implements UserProtocolService

{

    private static final Logger logger = LoggerFactory.getLogger(UserProtocolServiceImpl.class);

    @Autowired
    private UserProtocolMapper userProtocolMapper;

    @Override
    public Result<PageInfo<UserProtocolVo>> queryPage(UserProtocolQuery query) {
        if(query == null) {
            logger.error("查询参数不能为空");
            return Result.createFailResult("查询参数不能为空");
        }
        try {
            logger.info("分页查询信息请求参数：{}", JSON.toJSONString(query));
            PageHelper.startPage(query.getPageNo(), query.getPageSize(), true);


            Condition condition = new Condition(UserProtocol.class);
            Example.Criteria criteria = condition.createCriteria();

            if(query.getId() != null){
                criteria.andEqualTo("id",query.getId());
            }
            if(StringUtils.isNoneBlank(query.getName())){
                criteria.andLike("name","%"+query.getName()+"%");
            }
            if(StringUtils.isNoneBlank(query.getVersion())){
                criteria.andLike("version","%"+query.getVersion()+"%");
            }
            if(StringUtils.isNoneBlank(query.getAppCode())){
                criteria.andLike("appCode","%"+query.getAppCode()+"%");
            }
            if(StringUtils.isNoneBlank(query.getModelName())){
                criteria.andLike("modelName","%"+query.getModelName()+"%");
            }

            criteria.andEqualTo("status",1);

            List<UserProtocol> userProtocols = userProtocolMapper.selectByCondition(condition);

            List<UserProtocolVo> tAppCodeVos = new ArrayList<>();

            for (UserProtocol tAppCode  : userProtocols){
                UserProtocolVo target = new UserProtocolVo();
                BeanUtils.copyProperties(tAppCode, target);
                tAppCodeVos.add(target);
            }

            Page page = (Page) userProtocols;
            Page entities = (Page) page.clone();
            entities.clear();
            entities.addAll(tAppCodeVos);

            PageInfo<UserProtocolVo> pageInfo = new PageInfo<UserProtocolVo>(entities);
            return Result.createSuccessResult(pageInfo);
        } catch(Exception e) {
            logger.error("分页查询信息异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<Integer> addUserProtocol(UserProtocol model) {
        if (model == null) {
            logger.error("新增信息不能为空");
            return Result.createFailResult("新增信息不能为空");
        }


        if (StringUtils.isBlank(model.getAppName())) {
            logger.error("App名称信息不能为空");
            return Result.createFailResult("App名称信息不能为空");
        }

        if (StringUtils.isBlank(model.getName())) {
            logger.error("协议名称信息不能为空");
            return Result.createFailResult("协议名称信息不能为空");
        }

        if (StringUtils.isBlank(model.getVersion())) {
            logger.error("协议版本信息不能为空");
            return Result.createFailResult("协议版本信息不能为空");
        }

        if (StringUtils.isBlank(model.getContent())) {
            logger.error("协议内容信息不能为空");
            return Result.createFailResult("协议内容信息不能为空");
        }

        Condition condition = new Condition(UserProtocol.class);
        Example.Criteria criteria = condition.createCriteria();

        criteria.andEqualTo("appCode", model.getAppCode());
        criteria.andEqualTo("status", 1);

        List<UserProtocol> userProtocols = this.findByCondition(condition);


        if (null != userProtocols && userProtocols.size() > 0) {
            logger.error("已存在该信息");
            return Result.createFailResult("已存在该信息");
        }

        try {
            model.setStatus(true);
            Date now = new Date();
            model.setCreateTime(now);
            model.setUpdateTime(now);
            int count = this.save(model);
            return Result.createSuccessResult(count);
        } catch(DuplicateKeyException e){
            logger.error("appCode重复", e);
            return Result.createFailResult("appCode重复");
        } catch(Exception e) {
            logger.error("保存信息异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<Integer> delById(Integer id) {
        if(id == null) {
            logger.error("主键信息不能为空");
            return Result.createFailResult("新增信息不能为空");
        }
        try {
            int i = this.deleteById(id);
            return Result.createSuccessResult(i);
        }catch (Exception e){
            logger.error("删除信息异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<Integer> updateUserProtocol(UserProtocol model) {
        if(model == null) {
            logger.error("更新信息不能为空");
            return Result.createFailResult("更新信息不能为空");
        }

        if(model.getId() == null){
            logger.error("主键信息不能为空");
            return Result.createFailResult("主键信息不能为空");
        }

        try {

            UserProtocol userProtocol = this.findById(model.getId());

            if(StringUtils.isNoneBlank(model.getAppCode()) || model.getModelId() != null){
                String appCode = userProtocol.getAppCode();

                if(StringUtils.isNoneBlank(model.getAppCode())){
                    appCode = model.getAppCode();
                }

                Condition condition = new Condition(UserProtocol.class);
                Example.Criteria criteria = condition.createCriteria();

                criteria.andEqualTo("appCode",appCode);
                criteria.andEqualTo("status",1);

                List<UserProtocol> userProtocols = this.findByCondition(condition);

                if(null != userProtocols && userProtocols.size() > 0 && !userProtocols.get(0).getId().equals(model.getId())){
                    logger.error("已存在该信息");
                    return Result.createFailResult("已存在该信息");
                }
            }
            int i = this.updateSelective(model);

            return Result.createSuccessResult(i);
        } catch(DuplicateKeyException e){
            logger.error("appCode重复", e);
            return Result.createFailResult("appCode重复");
        } catch (Exception e){
            logger.error("更新信息异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<UserProtocolVo> findUserProtocolById(Integer id) {
        if(id == null) {
            logger.error("主键信息不能为空");
            return Result.createFailResult("新增信息不能为空");
        }

        try {
            UserProtocol tAppCode = this.findById(id);

            UserProtocolVo target = new UserProtocolVo();
            BeanUtils.copyProperties(tAppCode, target);
            return Result.createSuccessResult(target);
        }catch (Exception e){
            logger.error("查询信息异常", e);
            return Result.createFailResult("查询信息异常");
        }
    }

    @Override
    public Result<UserProtocolVo> findUserProtocol(String appCode, Integer modelId) {

        Condition condition = new Condition(UserProtocol.class);
        Example.Criteria criteria = condition.createCriteria();

        criteria.andEqualTo("appCode",appCode);
        criteria.andEqualTo("status",1);

        List<UserProtocol> userProtocols = this.findByCondition(condition);

        if(null != userProtocols && userProtocols.size() > 0 ){
            UserProtocol userProtocol = userProtocols.get(0);
            UserProtocolVo target = new UserProtocolVo();
            BeanUtils.copyProperties(userProtocol, target);
            return Result.createSuccessResult(target);
        }

        return Result.createSuccessResult();
    }
}
