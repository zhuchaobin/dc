package com.xai.tt.dc.client.request;

import java.io.Serializable;

/**
 * @author yalei.chen
 * @date 2018/6/17
 * @since JDK 1.8
 */
public class UserProtocolQuery extends PageQuery implements Serializable {


    private static final long serialVersionUID = -9109071025470550465L;

    private Integer id;

    private String name;

    private String version;

    private String appCode;

    private String appName;

    private Integer modelId;

    private String modelName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
}
