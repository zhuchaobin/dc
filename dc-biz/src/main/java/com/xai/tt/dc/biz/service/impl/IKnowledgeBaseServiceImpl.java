package com.xai.tt.dc.biz.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import  com.xai.tt.dc.client.response.FileInfo;
import  com.xai.tt.dc.client.response.KnowledgeCatalogInfoRes;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import  com.xai.tt.dc.client.entity.KnowledgeCatalog;
import  com.xai.tt.dc.client.entity.KnowledgeCatalogInfo;
import  com.xai.tt.dc.client.entity.KnowledgeFile;
import  com.xai.tt.dc.client.inter.IKnowledgeBaseService;
import  com.xai.tt.dc.client.query.KnowledgeCatalogQuery;
import  com.xai.tt.dc.client.request.SaveKnowledgeCatalogInfo;

/**
 * 
 */
@Service("iKnowledgeBaseServiceImpl")
public class IKnowledgeBaseServiceImpl implements IKnowledgeBaseService {

    private static final Logger logger = LoggerFactory.getLogger(IKnowledgeBaseServiceImpl.class);


    @Resource
    private KnowledgeCatalogMapper knowledgeCatalogMapper;

    @Resource
    private KnowledgeCatalogInfoMapper knowledgeCatalogInfoMapper;

    @Resource
    private KnowledgeFileMapper knowledgeFileMapper;


    @Override
    public Result<PageInfo<KnowledgeCatalog>> queryPage(KnowledgeCatalogQuery knowledgeCatalogQuery) {
        try {
            Condition condition = new Condition(KnowledgeCatalog.class);
            condition.orderBy("id").desc();
            if (StringUtils.isNotEmpty(knowledgeCatalogQuery.getCatalogName())) {
                condition.createCriteria().andLike("catalogName", "%"+knowledgeCatalogQuery.getCatalogName()+"%");
            }
            if (StringUtils.isNotEmpty(knowledgeCatalogQuery.getKeyWorlds())) {
                condition.or().andLike("keyWorlds", knowledgeCatalogQuery.getKeyWorlds());
            }
            PageHelper.startPage(knowledgeCatalogQuery.getPageNo(), knowledgeCatalogQuery.getPageSize());
            List<KnowledgeCatalog> result = knowledgeCatalogMapper.selectByCondition(condition);
            PageInfo pageInfo = new PageInfo<>(result);
            return Result.createSuccessResult(pageInfo);
        } catch (Exception e) {
            logger.error("查找知识库异常", e);
            return Result.createFailResult("系统异常");
        }

    }

    @Override
    public Result<KnowledgeCatalog> findKnowledgeCatalogById(Integer id) {
        if(id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            KnowledgeCatalog helpFaq = knowledgeCatalogMapper.selectByPrimaryKey(id);
            return Result.createSuccessResult(helpFaq);
        } catch(Exception e) {
            logger.error("查找知识库异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<?> saveKnowledgeCatalog(KnowledgeCatalog knowledgeCatalog) {
        try {
            if (knowledgeCatalog.getId() != null) {
                knowledgeCatalogMapper.updateByPrimaryKey(knowledgeCatalog);
            } else {
                knowledgeCatalogMapper.insert(knowledgeCatalog);
            }
            return Result.createSuccessResult();
        } catch (Exception e) {
            logger.error("知识库保存失败", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<PageInfo<KnowledgeCatalogInfo>> queryByCatalog(KnowledgeCatalogQuery knowledgeCatalogQuery) {
        try {
            Condition condition = new Condition(KnowledgeCatalogInfo.class);
            condition.orderBy("id").desc();
            Example.Criteria criteria = condition.createCriteria();
            if (null != knowledgeCatalogQuery.getCatelogId()) {
                criteria.andEqualTo("catelogId", knowledgeCatalogQuery.getCatelogId());
            }
            if (StringUtils.isNotEmpty(knowledgeCatalogQuery.getKeyWorlds())) {
                criteria.andLike("abstracts", "%" + knowledgeCatalogQuery.getKeyWorlds() + "%");
                condition.or().andLike("catelogName", "%" + knowledgeCatalogQuery.getKeyWorlds() + "%");
                condition.or().andLike("content", "%" + knowledgeCatalogQuery.getKeyWorlds() + "%");
            }

            PageHelper.startPage(knowledgeCatalogQuery.getPageNo(), knowledgeCatalogQuery.getPageSize());
            List<KnowledgeCatalogInfo> result = knowledgeCatalogInfoMapper.selectByCondition(condition);
            PageInfo pageInfo = new PageInfo<>(result);
            return Result.createSuccessResult(pageInfo);
        } catch (Exception e) {
            logger.error("查找知识库异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<KnowledgeCatalogInfoRes> findKnowledgeCatalogInfoById(Integer id) {
        if(id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            KnowledgeCatalogInfo knowledgeCatalogInfo = knowledgeCatalogInfoMapper.selectByPrimaryKey(id);
            KnowledgeCatalogInfoRes knowledgeCatalogInfoRes = new KnowledgeCatalogInfoRes();
            knowledgeCatalogInfoRes.setStatus(knowledgeCatalogInfo.getStatus());
            knowledgeCatalogInfoRes.setId(knowledgeCatalogInfo.getId());
            knowledgeCatalogInfoRes.setCatelogName(knowledgeCatalogInfo.getCatelogName());
            knowledgeCatalogInfoRes.setCatelogId(knowledgeCatalogInfo.getCatelogId());
            knowledgeCatalogInfoRes.setContent(knowledgeCatalogInfo.getContent());
            knowledgeCatalogInfoRes.setCreateTime(knowledgeCatalogInfo.getCreateTime());
            knowledgeCatalogInfoRes.setUpdateTime(knowledgeCatalogInfo.getUpdateTime());
            knowledgeCatalogInfoRes.setAbstracts(knowledgeCatalogInfo.getAbstracts());
            Condition condition = new Condition(KnowledgeFile.class);
            condition.createCriteria().andEqualTo("knowledgeInfoId", id);
            List<KnowledgeFile> knowledgeFiles = knowledgeFileMapper.selectByCondition(condition);
            if (CollectionUtils.isNotEmpty(knowledgeFiles)) {
                List<FileInfo> fileInfos = knowledgeFiles.stream().map(item -> {
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.setFileUrl(item.getFileUrl());
                    fileInfo.setFileName(item.getFileName());
                    return fileInfo;
                }).collect(Collectors.toList());
                knowledgeCatalogInfoRes.setFileInfos(fileInfos);
            }
            return Result.createSuccessResult(knowledgeCatalogInfoRes);
        } catch(Exception e) {
            logger.error("查找知识库异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Transactional
    @Override
    public Result<?> saveKnowledgeCatalogInfo(SaveKnowledgeCatalogInfo knowledgeCatalogInfo) {
        KnowledgeCatalogInfo knowledgeCatalogInfo1 = new KnowledgeCatalogInfo();
        knowledgeCatalogInfo1.setContent(knowledgeCatalogInfo.getContent());
        knowledgeCatalogInfo1.setCatelogId(knowledgeCatalogInfo.getCatelogId());
        knowledgeCatalogInfo1.setCatelogName(knowledgeCatalogInfo.getCatelogName());
        knowledgeCatalogInfo1.setId(knowledgeCatalogInfo.getId());
        knowledgeCatalogInfo1.setStatus(knowledgeCatalogInfo.getStatus());
        if (knowledgeCatalogInfo1.getId() != null) {
            knowledgeCatalogInfoMapper.updateByPrimaryKey(knowledgeCatalogInfo);
            if (StringUtils.isNotEmpty(knowledgeCatalogInfo.getFileNames())) {
                Condition condition = new Condition(KnowledgeFile.class);
                condition.createCriteria().andEqualTo("knowledgeInfoId", knowledgeCatalogInfo1.getId());
                knowledgeFileMapper.deleteByCondition(condition);
                insertFile(knowledgeCatalogInfo);
            }
        } else {
            knowledgeCatalogInfoMapper.insert(knowledgeCatalogInfo);
            if (StringUtils.isNotEmpty(knowledgeCatalogInfo.getFileNames())) {
                insertFile(knowledgeCatalogInfo);
            }
        }

        return Result.createSuccessResult();
    }

    private void insertFile(SaveKnowledgeCatalogInfo knowledgeCatalogInfo) {
        try {
            List<KnowledgeFile> knowledgeFiles = Arrays.asList(knowledgeCatalogInfo.getFileNames().split(",")).stream().map(item -> {
                KnowledgeFile knowledgeFile = new KnowledgeFile();
                String[] str = item.split("\\|\\|");
                knowledgeFile.setFileName(str[1]);
                knowledgeFile.setFileUrl(str[0]);
                knowledgeFile.setKnowledgeInfoId(knowledgeCatalogInfo.getId());
                return knowledgeFile;
            }).collect(Collectors.toList());
            knowledgeFileMapper.insertList(knowledgeFiles);
        } catch (Exception e) {
            logger.info("异常为",e);
        }


    }

    @Override
    public Result<?> delCatalogById(Integer id) {
        if (id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            knowledgeCatalogMapper.deleteByPrimaryKey(id);
            return Result.createSuccessResult();
        } catch (Exception e) {
            logger.error("查找知识库目录异常", e);
            return Result.createFailResult("系统异常");
        }
    }

    @Override
    public Result<?> delInfoById(Integer id) {
        if (id == null) {
            logger.error("id不能为空");
            return Result.createFailResult("id不能为空");
        }
        try {
            knowledgeCatalogInfoMapper.deleteByPrimaryKey(id);
            return Result.createSuccessResult();
        } catch (Exception e) {
            logger.error("查找知识库内容异常", e);
            return Result.createFailResult("系统异常");
        }
    }
}
