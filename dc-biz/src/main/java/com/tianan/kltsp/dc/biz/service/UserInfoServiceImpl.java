package com.tianan.kltsp.dc.biz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.tianan.common.api.mybatis.PageParam;
import com.tianan.kltsp.dc.biz.core.AbstractService;
import com.tianan.kltsp.dc.client.entity.UserInfo;
import com.tianan.kltsp.dc.client.inter.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);


    @Override
    public Result<?> doSave(UserInfo userInfo) {
        try {
            if (userInfo.getId() != null) {
                this.update(userInfo);
            } else {
                this.save(userInfo);
            }
            return Result.createSuccessResult();
        } catch (Exception e) {
            logger.error("UserInfo保存失败", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<?> delDataById(Integer id) {
        if (id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            this.deleteById(id);
            return Result.createSuccessResult();
        } catch (Exception e) {
            logger.error("删除UserInfo异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<PageInfo<UserInfo>> queryPage(UserInfo userInfo, PageParam pageParam) {
        try {
            Condition condition = new Condition(UserInfo.class);
            condition.orderBy("sort");
            List<UserInfo> result;
            PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
            fillParam(userInfo,condition.createCriteria());
            result = findByCondition(condition);
            PageInfo pageInfo = new PageInfo<>(result);
            return Result.createSuccessResult(pageInfo);
        }catch (Exception e) {
            logger.error("查找FAQ异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<UserInfo> findOne(Integer id) {
        if(id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            UserInfo userInfo = this.findById(id);
            return Result.createSuccessResult(userInfo);
        } catch(Exception e) {
            logger.error("查找AppPackage异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<UserInfo> findByOwnerId(String ownerId) {
        try {
            UserInfo userInfo = this.findBy("carOwnerId", ownerId);
            return Result.createSuccessResult(userInfo);
        } catch (Exception e) {
            logger.error("查找AppPackage异常", e);
            return Result.createFailResult("系统异常");
        }

    }
}
