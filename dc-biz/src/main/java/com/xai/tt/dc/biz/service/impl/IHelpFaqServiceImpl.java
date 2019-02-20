package com.xai.tt.dc.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.biz.core.AbstractService;
import com.xai.tt.dc.client.entity.HelpFaq;
import com.xai.tt.dc.client.inter.IHelpFaqService;
import com.xai.tt.dc.client.query.HelpFaqQuery;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 
 */
@Service("iHelpFaqServiceImpl")
public class IHelpFaqServiceImpl extends AbstractService<HelpFaq> implements IHelpFaqService {

    private static final Logger logger = LoggerFactory.getLogger(IHelpFaqServiceImpl.class);


    @Override
    public Result<PageInfo<HelpFaq>> queryPage(HelpFaqQuery helpFaqQuery) {
        try {
            Condition condition = new Condition(HelpFaq.class);
            condition.orderBy("sort");
            List<HelpFaq> result;
            PageHelper.startPage(helpFaqQuery.getPageNo(), helpFaqQuery.getPageSize());
            if (StringUtils.isNotEmpty(helpFaqQuery.getQuestion())) {
                condition.createCriteria().andLike("question", "%" + helpFaqQuery.getQuestion() + "%");
            }
            if (StringUtils.isNotEmpty(helpFaqQuery.getAnswer())) {
                condition.or().andLike("answer", helpFaqQuery.getAnswer());
            }
            result = findByCondition(condition);
            PageInfo pageInfo = new PageInfo<>(result);
            return Result.createSuccessResult(pageInfo);
        }catch (Exception e) {
            logger.error("查找FAQ异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<HelpFaq> findHelpFaqById(Integer id) {
        if(id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            HelpFaq helpFaq = this.findById(id);
            return Result.createSuccessResult(helpFaq);
        } catch(Exception e) {
            logger.error("查找FAQ异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<?> saveHelpFaq(HelpFaq helpFaq) {
        try {
            if (helpFaq.getId() != null) {
                this.update(helpFaq);
            } else {
                this.save(helpFaq);
            }
            return Result.createSuccessResult();
        } catch (Exception e) {
            logger.error("FAQ保存失败", e);
            return Result.createFailResult("系统异常");
        }
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
            logger.error("查找FAQ异常", e);
            return Result.createFailResult("系统异常");
        }
    }
}
