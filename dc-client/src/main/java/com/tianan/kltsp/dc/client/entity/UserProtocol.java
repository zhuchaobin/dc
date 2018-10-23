package com.tianan.kltsp.dc.client.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user_protocol")
public class UserProtocol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 协议名称
     */
    private String name;

    /**
     * 协议版本
     */
    private String version;

    /**
     * appCode
     */
    @Column(name = "app_code")
    private String appCode;

    /**
     * app名称
     */
    @Column(name = "app_name")
    private String appName;

    /**
     * 车型名称
     */
    @Column(name = "model_name")
    private String modelName;

    /**
     * 车型ID
     */
    @Column(name = "model_id")
    private String modelId;

    /**
     * 协议内容
     */
    private String content;

    /**
     * 数据逻辑状态 0-无效，1-有效
     */
    private Boolean status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取协议名称
     *
     * @return name - 协议名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置协议名称
     *
     * @param name 协议名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取协议版本
     *
     * @return version - 协议版本
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置协议版本
     *
     * @param version 协议版本
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取appCode
     *
     * @return app_code - appCode
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * 设置appCode
     *
     * @param appCode appCode
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * 获取app名称
     *
     * @return app_name - app名称
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置app名称
     *
     * @param appName app名称
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 获取数据逻辑状态 0-无效，1-有效
     *
     * @return status - 数据逻辑状态 0-无效，1-有效
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置数据逻辑状态 0-无效，1-有效
     *
     * @param status 数据逻辑状态 0-无效，1-有效
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
}