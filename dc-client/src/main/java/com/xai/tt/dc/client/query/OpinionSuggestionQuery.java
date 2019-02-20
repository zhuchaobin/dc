package com.xai.tt.dc.client.query;

import com.alibaba.fastjson.annotation.JSONField;
import com.xai.tt.dc.client.request.PageQuery;

import java.util.Date;

/**
 * Created by linkun on 2017/10/19.
 */
public class OpinionSuggestionQuery extends PageQuery {

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 意见类型名称
     */
    private String typeMsg;

    /**
     * 意见内容
     */
    private String content;

    /**
     * 提交意见人pin
     */
    private String userId;

    /**
     * 提交意见人
     */
    private String userName;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 处理状态
     */
    private Byte dealStatus;

    /**
     * 处理意见
     */
    private String dealResult;

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
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date beginCreateTime;


    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endCreateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeMsg() {
        return typeMsg;
    }

    public void setTypeMsg(String typeMsg) {
        this.typeMsg = typeMsg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Byte dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public Byte getResource() {
        return resource;
    }

    public void setResource(Byte resource) {
        this.resource = resource;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getBeginCreateTime() {
        return beginCreateTime;
    }

    public void setBeginCreateTime(Date beginCreateTime) {
        this.beginCreateTime = beginCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
