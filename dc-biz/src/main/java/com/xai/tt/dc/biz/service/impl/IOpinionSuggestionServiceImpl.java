package com.xai.tt.dc.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.biz.core.AbstractService;
import com.xai.tt.dc.client.entity.OpinionSuggestion;
import com.xai.tt.dc.client.inter.IOpinionSuggestionService;
import com.xai.tt.dc.client.query.OpinionSuggestionQuery;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
@Service("iOpinionSuggestionServiceImpl")
public class IOpinionSuggestionServiceImpl  extends AbstractService<OpinionSuggestion> implements IOpinionSuggestionService{

    private static final Logger logger = LoggerFactory.getLogger(IOpinionSuggestionServiceImpl.class);


    @Override
    public Result<PageInfo<OpinionSuggestion>> queryPage(OpinionSuggestionQuery opinionSuggestionQuery) {
        Condition condition = new Condition(OpinionSuggestion.class);
        condition.orderBy("createTime").desc();
        if (StringUtils.isNotEmpty(opinionSuggestionQuery.getUserPhone())) {
            condition.createCriteria().andLike("userPhone", "%" + opinionSuggestionQuery.getUserPhone() + "%");
        }
        PageHelper.startPage(opinionSuggestionQuery.getPageNo(), opinionSuggestionQuery.getPageSize());
        List<OpinionSuggestion> result = findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(result);
        return Result.createSuccessResult(pageInfo);
    }



    @Override
    public Result<OpinionSuggestion> findOpinionSuggestionById(Integer id) {
        if(id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            OpinionSuggestion carInfo = this.findById(id);
            return Result.createSuccessResult(carInfo);
        } catch(Exception e) {
            logger.error("查找车辆基本信息异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<?> saveOpinionSuggestion(OpinionSuggestion opinionSuggestion) {
        try {
            if (opinionSuggestion.getId() != null) {
                this.update(opinionSuggestion);
            } else {
                this.save(opinionSuggestion);
            }
            return Result.createSuccessResult();
        } catch (Exception e) {
            logger.error("保存意见建议失败", e);
            return Result.createFailResult("系统异常");
        }
    }


    private void fillCondition(Example.Criteria criteria, OpinionSuggestionQuery opinionSuggestionQuery) {
        PageHelper.startPage(opinionSuggestionQuery.getPageNo(), opinionSuggestionQuery.getPageSize());
        if (opinionSuggestionQuery.getBeginCreateTime() != null) {
            criteria.andGreaterThanOrEqualTo("createTime", opinionSuggestionQuery.getBeginCreateTime());
        }
        if (opinionSuggestionQuery.getEndCreateTime() != null) {
            criteria.andLessThanOrEqualTo("createTime", opinionSuggestionQuery.getEndCreateTime());
        }

        fillParam(opinionSuggestionQuery,criteria);
    }

    @Override
    public Result<?> delById(Integer id) {
        if (id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            this.deleteById(id);
            return Result.createSuccessResult();
        } catch (Exception e) {
            logger.error("删除意见建议异常", e);
            return Result.createFailResult("系统异常");
        }
    }
}
