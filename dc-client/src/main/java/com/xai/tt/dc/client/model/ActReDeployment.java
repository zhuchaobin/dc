package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "act_re_deployment")
public class ActReDeployment {
    @Id
    @Column(name = "ID_")
    private String id;

    @Column(name = "NAME_")
    private String name;

    @Column(name = "CATEGORY_")
    private String category;

    @Column(name = "TENANT_ID_")
    private String tenantId;

    @Column(name = "DEPLOY_TIME_")
    private Date deployTime;

    @Column(name = "ENGINE_VERSION_")
    private String engineVersion;

    @Column(name = "KEY_")
    private String key;

    /**
     * @return ID_
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return NAME_
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return CATEGORY_
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return TENANT_ID_
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * @param tenantId
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * @return DEPLOY_TIME_
     */
    public Date getDeployTime() {
        return deployTime;
    }

    /**
     * @param deployTime
     */
    public void setDeployTime(Date deployTime) {
        this.deployTime = deployTime;
    }

    /**
     * @return ENGINE_VERSION_
     */
    public String getEngineVersion() {
        return engineVersion;
    }

    /**
     * @param engineVersion
     */
    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    /**
     * @return KEY_
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }
}