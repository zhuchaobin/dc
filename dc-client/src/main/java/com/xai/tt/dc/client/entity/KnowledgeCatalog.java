package com.xai.tt.dc.client.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "knowledge_catalog")
public class KnowledgeCatalog {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 知识库目录名称
     */
    @Column(name = "catalog_name")
    private String catalogName;

    /**
     * 关键字
     */
    @Column(name = "key_worlds")
    private String keyWorlds;

    /**
     * 摘要
     */
    private String abstracts;

    /**
     * 知识库目录名称
     */
    @Column(name = "knowledge_name")
    private String knowledgeName;

    /**
     * 逻辑有效无效
     */
    private Boolean status = Boolean.TRUE;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取知识库目录名称
     *
     * @return catalog_name - 知识库目录名称
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * 设置知识库目录名称
     *
     * @param catalogName 知识库目录名称
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    /**
     * 获取关键字
     *
     * @return key_worlds - 关键字
     */
    public String getKeyWorlds() {
        return keyWorlds;
    }

    /**
     * 设置关键字
     *
     * @param keyWorlds 关键字
     */
    public void setKeyWorlds(String keyWorlds) {
        this.keyWorlds = keyWorlds;
    }

    /**
     * 获取摘要
     *
     * @return abstract - 摘要
     */
    public String getAbstracts() {
        return abstracts;
    }

    /**
     * 设置摘要
     *
     * @param abstracts 摘要
     */
    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    /**
     * 获取知识库目录名称
     *
     * @return knowledge_name - 知识库目录名称
     */
    public String getKnowledgeName() {
        return knowledgeName;
    }

    /**
     * 设置知识库目录名称
     *
     * @param knowledgeName 知识库目录名称
     */
    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    /**
     * 获取逻辑有效无效
     *
     * @return status - 逻辑有效无效
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置逻辑有效无效
     *
     * @param status 逻辑有效无效
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}