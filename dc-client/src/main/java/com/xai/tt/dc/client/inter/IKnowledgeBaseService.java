package com.xai.tt.dc.client.inter;

import com.github.pagehelper.PageInfo;
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.client.entity.KnowledgeCatalog;
import com.xai.tt.dc.client.entity.KnowledgeCatalogInfo;
import com.xai.tt.dc.client.query.KnowledgeCatalogQuery;
import com.xai.tt.dc.client.request.SaveKnowledgeCatalogInfo;
import com.xai.tt.dc.client.response.KnowledgeCatalogInfoRes;

/**
 * Created by linkun
 */
public interface IKnowledgeBaseService {


    /**
     * 1.支持分页条件查询
     *
     * @param knowledgeCatalogQuery
     * @return
     */
    Result<PageInfo<KnowledgeCatalog>> queryPage(KnowledgeCatalogQuery knowledgeCatalogQuery);


    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Result<KnowledgeCatalog> findKnowledgeCatalogById(Integer id);

    /**
     * 新增保存 (新增保存,修改保存)
     * @param knowledgeCatalog
     * @return
     */
    Result<?> saveKnowledgeCatalog(KnowledgeCatalog knowledgeCatalog);

    /**
     * 目录查询知识库
     * @param knowledgeCatalogQuery
     * @return
     */
    Result<PageInfo<KnowledgeCatalogInfo>> queryByCatalog(KnowledgeCatalogQuery knowledgeCatalogQuery);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    Result<KnowledgeCatalogInfoRes> findKnowledgeCatalogInfoById(Integer id);


    /**
     * 新增保存 (新增保存,修改保存)
     * @param knowledgeCatalogInfo
     * @return
     */
    Result<?> saveKnowledgeCatalogInfo(SaveKnowledgeCatalogInfo knowledgeCatalogInfo);


    /**
     *   根据Id删除知识库目录
     * @param id
     * @return
     */
    Result<?> delCatalogById(Integer id);

    /**
     *   根据Id删除知识库内容
     * @param id
     * @return
     */
    Result<?> delInfoById(Integer id);
}
