package com.xai.tt.dc.client.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "knowledge_catalog_info")
public class KnowledgeCatalogInfo {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 目录Id
     */
    @Column(name = "catelog_id")
    private Integer catelogId;

    @Column(name = "catelog_name")
    private String catelogName;

    /**
     * 摘要
     */
    private String abstracts;

    /**
     * 知识库内容
     */
    private String content;

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
     * 获取目录Id
     *
     * @return catelog_id - 目录Id
     */
    public Integer getCatelogId() {
        return catelogId;
    }

    /**
     * 设置目录Id
     *
     * @param catelogId 目录Id
     */
    public void setCatelogId(Integer catelogId) {
        this.catelogId = catelogId;
    }

    /**
     * 获取知识库内容
     *
     * @return content - 知识库内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置知识库内容
     *
     * @param content 知识库内容
     */
    public void setContent(String content) {
        this.content = content;
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

    public String getCatelogName() {
        return catelogName;
    }

    public void setCatelogName(String catelogName) {
        this.catelogName = catelogName;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }
}