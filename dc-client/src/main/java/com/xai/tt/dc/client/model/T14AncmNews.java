package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t14_ancm_news")
public class T14AncmNews {
    /**
     * 类型
     */
    private String type;
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
     * 自增主键
     */
    @Id
    private Integer id;

    /**
     * 摘要信息
     */
    private String abstracts;

    /**
     * 顺序号
     */
    @Column(name = "pos")
    private Integer order;

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
     * 操作员姓名
     */
    private String username;

    /**
     * 知识库内容
     */
    private String content;

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
     * 获取摘要信息
     *
     * @return abstracts - 摘要信息
     */
    public String getAbstracts() {
        return abstracts;
    }

    /**
     * 设置摘要信息
     *
     * @param abstracts 摘要信息
     */
    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    /**
     * 获取顺序号
     *
     * @return order - 顺序号
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 设置顺序号
     *
     * @param order 顺序号
     */
    public void setOrder(Integer order) {
        this.order = order;
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

    /**
     * 获取操作员姓名
     *
     * @return username - 操作员姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作员姓名
     *
     * @param username 操作员姓名
     */
    public void setUsername(String username) {
        this.username = username;
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
}