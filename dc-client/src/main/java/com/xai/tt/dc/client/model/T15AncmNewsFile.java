package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t15_ancm_news_file")
public class T15AncmNewsFile {
    /**
     * 自增主键
     */
    @Id
    private Integer id;

    /**
     * 目录Id
     */
    @Column(name = "ancm_news_id")
    private Integer ancmNewsId;

    /**
     * 知识库内容
     */
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 逻辑有效无效
     */
    private Byte status;

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
     * @return ancm_news_id - 目录Id
     */
    public Integer getAncmNewsId() {
        return ancmNewsId;
    }

    /**
     * 设置目录Id
     *
     * @param ancmNewsId 目录Id
     */
    public void setAncmNewsId(Integer ancmNewsId) {
        this.ancmNewsId = ancmNewsId;
    }

    /**
     * 获取知识库内容
     *
     * @return file_name - 知识库内容
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置知识库内容
     *
     * @param fileName 知识库内容
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return file_url
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * @param fileUrl
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取逻辑有效无效
     *
     * @return status - 逻辑有效无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置逻辑有效无效
     *
     * @param status 逻辑有效无效
     */
    public void setStatus(Byte status) {
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