package com.xai.tt.dc.biz.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.xai.tt.dc.client.response.AncmNewsInfoRes;
import  com.xai.tt.dc.client.response.FileInfo;
import com.xai.tt.dc.client.response.KnowledgeCatalogInfoRes;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.biz.mapper.KnowledgeCatalogInfoMapper;
import com.xai.tt.dc.biz.mapper.KnowledgeCatalogMapper;
import com.xai.tt.dc.biz.mapper.KnowledgeFileMapper;
import com.xai.tt.dc.biz.mapper.T14AncmNewsMapper;
import com.xai.tt.dc.biz.mapper.T15AncmNewsFileMapper;
import  com.xai.tt.dc.client.entity.KnowledgeCatalog;
import  com.xai.tt.dc.client.entity.KnowledgeCatalogInfo;
import  com.xai.tt.dc.client.entity.KnowledgeFile;
import com.xai.tt.dc.client.inter.IAncmNewsBaseService;
import  com.xai.tt.dc.client.inter.IKnowledgeBaseService;
import com.xai.tt.dc.client.model.T14AncmNews;
import com.xai.tt.dc.client.model.T15AncmNewsFile;
import com.xai.tt.dc.client.query.KeyWordsQuery;
import  com.xai.tt.dc.client.query.KnowledgeCatalogQuery;
import com.xai.tt.dc.client.request.SaveAncmNewInfo;
import  com.xai.tt.dc.client.request.SaveKnowledgeCatalogInfo;

/**
 * 
 */
@Service("iAncmNewsBaseServiceImpl")
public class IAncmNewsBaseServiceImpl implements IAncmNewsBaseService {

    private static final Logger logger = LoggerFactory.getLogger(IAncmNewsBaseServiceImpl.class);
    @Resource
    private T14AncmNewsMapper t14AncmNewsMapper;

    @Resource
    private T15AncmNewsFileMapper t15AncmNewsFileMapper;

    @Override
    public Result<PageInfo<T14AncmNews>> queryPage(KeyWordsQuery keyWordsQuery) {
        try {
            Condition condition = new Condition(T14AncmNews.class);
            condition.orderBy("order").asc();
            Example.Criteria criteria = condition.createCriteria();

            if (StringUtils.isNotEmpty(keyWordsQuery.getKeyWorlds())) {
                criteria.andLike("abstracts", "%" + keyWordsQuery.getKeyWorlds() + "%");
                condition.or().andLike("username", "%" + keyWordsQuery.getKeyWorlds() + "%");
                condition.or().andLike("content", "%" + keyWordsQuery.getKeyWorlds() + "%");
            }

            PageHelper.startPage(keyWordsQuery.getPageNo(), keyWordsQuery.getPageSize());
            List<T14AncmNews> result = t14AncmNewsMapper.selectByCondition(condition);
            PageInfo pageInfo = new PageInfo<>(result);
            return Result.createSuccessResult(pageInfo);
        } catch (Exception e) {
            logger.error("查找公告新闻异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<AncmNewsInfoRes> findAncmNewsById(Integer id) {
       
        if(id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
        	T14AncmNews t14 = t14AncmNewsMapper.selectByPrimaryKey(id);
            AncmNewsInfoRes ancmNewsInfoRes = new AncmNewsInfoRes();
            BeanUtils.copyProperties(t14, ancmNewsInfoRes);
         
            Condition condition = new Condition(T15AncmNewsFile.class);
            condition.createCriteria().andEqualTo("ancmNewsId", id);
            List<T15AncmNewsFile> t15AncmNewsFiles = t15AncmNewsFileMapper.selectByCondition(condition);
            if (CollectionUtils.isNotEmpty(t15AncmNewsFiles)) {
                List<FileInfo> fileInfos = t15AncmNewsFiles.stream().map(item -> {
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.setFileUrl(item.getFileUrl());
                    fileInfo.setFileName(item.getFileName());
                    return fileInfo;
                }).collect(Collectors.toList());
                ancmNewsInfoRes.setFileInfos(fileInfos);
            }
            return Result.createSuccessResult(ancmNewsInfoRes);
        } catch(Exception e) {
            logger.error("查找公告新闻异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Transactional
    @Override
    public Result<?> saveAncmNewInfo(SaveAncmNewInfo saveAncmNewInfo) {
    	T14AncmNews t14 = new T14AncmNews();
    	// 不指定默认排在最后 
    	if(null == saveAncmNewInfo.getOrder())
    		saveAncmNewInfo.setOrder(9999);
    	BeanUtils.copyProperties(saveAncmNewInfo, t14);
    
        if (saveAncmNewInfo.getId() != null) {
        	t14.setUpdateTime(new Date());
            t14AncmNewsMapper.updateByPrimaryKey(t14);
            if (StringUtils.isNotEmpty(saveAncmNewInfo.getFileNames())) {
                Condition condition = new Condition(KnowledgeFile.class);
                condition.createCriteria().andEqualTo("id", t14.getId());
                t15AncmNewsFileMapper.deleteByCondition(condition);
                insertFile(saveAncmNewInfo);
            }
        } else {
        	t14.setUpdateTime(new Date());
        	t14.setCreateTime(new Date());
            t14AncmNewsMapper.insert(t14);
            if (StringUtils.isNotEmpty(saveAncmNewInfo.getFileNames())) {
                insertFile(saveAncmNewInfo);
            }
        }
        return Result.createSuccessResult();
    }

    private void insertFile(SaveAncmNewInfo saveAncmNewInfo) {
        try {
            List<T15AncmNewsFile> t15AncmNewsFiles = Arrays.asList(saveAncmNewInfo.getFileNames().split(",")).stream().map(item -> {
            	T15AncmNewsFile t15AncmNewsFile = new T15AncmNewsFile();
                String[] str = item.split("\\|\\|");
                t15AncmNewsFile.setFileName(str[1]);
                t15AncmNewsFile.setFileUrl(str[0]);
                t15AncmNewsFile.setAncmNewsId(saveAncmNewInfo.getId());
                return t15AncmNewsFile;
            }).collect(Collectors.toList());
            t15AncmNewsFileMapper.insertList(t15AncmNewsFiles);
        } catch (Exception e) {
            logger.info("异常为",e);
        }


    }


    @Override
    public Result<?> delInfoById(Integer id) {
        if (id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            t14AncmNewsMapper.deleteByPrimaryKey(id);
            return Result.createSuccessResult();
        } catch (Exception e) {
            logger.error("查找公告新闻内容异常", e);
            return Result.createFailResult("系统异常");
        }
    }
}
