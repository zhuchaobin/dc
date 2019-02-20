package com.xai.tt.dc.client.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

/**
 * com.xai.tt
 */
@Table(name = "knowledge_file")
public class KnowledgeFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "knowledge_info_id")
    private Integer knowledgeInfoId;

    /**
     * fileName
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * TBOX设备号
     */
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 数据逻辑状态 0-无效，1-有效
     */
    private Boolean status = Boolean.TRUE;

    @Column(name = "create_time")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Column(name = "update_time")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKnowledgeInfoId() {
        return knowledgeInfoId;
    }

    public void setKnowledgeInfoId(Integer knowledgeInfoId) {
        this.knowledgeInfoId = knowledgeInfoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
