package com.xai.tt.dc.client.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name = "opinion_suggestion")
public class OpinionSuggestion {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 意见类型名称
     */
    @Column(name = "type_msg")
    private String typeMsg;

    /**
     * 意见标题
     */
    private String title;

    /**
     * 意见内容
     */
    private String content;

    /**
     * 提交意见人pin
     */
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_phone")
    private String userPhone;
    /**
     * 提交意见人
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 处理状态
     */
    @Column(name = "deal_status")
    private Byte dealStatus;

    /**
     * 处理意见
     */
    @Column(name = "deal_result")
    private String dealResult;

    /**
     * 图片地址
     */
    @Column(name = "urls")
    private String urls;

    /**
     * 意见来源
     */
    private Byte resource;

    /**
     * 逻辑有效无效
     */
    private Boolean status = Boolean.TRUE;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
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
     * 获取意见类型名称
     *
     * @return type_msg - 意见类型名称
     */
    public String getTypeMsg() {
        return typeMsg;
    }

    /**
     * 设置意见类型名称
     *
     * @param typeMsg 意见类型名称
     */
    public void setTypeMsg(String typeMsg) {
        this.typeMsg = typeMsg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取意见内容
     *
     * @return content - 意见内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置意见内容
     *
     * @param content 意见内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取提交意见人pin
     *
     * @return user_id - 提交意见人pin
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置提交意见人pin
     *
     * @param userId 提交意见人pin
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取提交意见人
     *
     * @return user_name - 提交意见人
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置提交意见人
     *
     * @param userName 提交意见人
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取处理状态
     *
     * @return deal_status - 处理状态
     */
    public Byte getDealStatus() {
        return dealStatus;
    }

    /**
     * 设置处理状态
     *
     * @param dealStatus 处理状态
     */
    public void setDealStatus(Byte dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     * 获取处理意见
     *
     * @return deal_result - 处理意见
     */
    public String getDealResult() {
        return dealResult;
    }

    /**
     * 设置处理意见
     *
     * @param dealResult 处理意见
     */
    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    /**
     * 获取意见来源
     *
     * @return resource - 意见来源
     */
    public Byte getResource() {
        return resource;
    }

    /**
     * 设置意见来源
     *
     * @param resource 意见来源
     */
    public void setResource(Byte resource) {
        this.resource = resource;
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

    @Transient
    private String resourceName;
    public String getResourceName() {
        if(this.resource == 0){
            return "APP";
        }else{
            return "PC";
        }
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

}