package com.xai.tt.dc.client.query;

import com.xai.tt.dc.client.request.PageQuery;

/**
 * Created by linkun
 */
public class KnowledgeCatalogQuery extends PageQuery {

    /**
     * 知识库目录名称
     */
    private String catalogName;

    /**
     * 关键字
     */
    private String keyWorlds;

    /**
     * 目录Id
     */
    private Integer catelogId;

    public Integer getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Integer catelogId) {
        this.catelogId = catelogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getKeyWorlds() {
        return keyWorlds;
    }

    public void setKeyWorlds(String keyWorlds) {
        this.keyWorlds = keyWorlds;
    }
}
