package com.xai.tt.dc.client.model;

import javax.persistence.*;

@Table(name = "act_re_procdef")
public class ActReProcdef {
    @Id
    @Column(name = "ID_")
    private String id;

    @Column(name = "REV_")
    private Integer rev;

    @Column(name = "CATEGORY_")
    private String category;

    @Column(name = "NAME_")
    private String name;

    @Column(name = "KEY_")
    private String key;

    @Column(name = "VERSION_")
    private Integer version;

    @Column(name = "DEPLOYMENT_ID_")
    private String deploymentId;

    @Column(name = "RESOURCE_NAME_")
    private String resourceName;

    @Column(name = "DGRM_RESOURCE_NAME_")
    private String dgrmResourceName;

    @Column(name = "DESCRIPTION_")
    private String description;

    @Column(name = "HAS_START_FORM_KEY_")
    private Byte hasStartFormKey;

    @Column(name = "HAS_GRAPHICAL_NOTATION_")
    private Byte hasGraphicalNotation;

    @Column(name = "SUSPENSION_STATE_")
    private Integer suspensionState;

    @Column(name = "TENANT_ID_")
    private String tenantId;

    @Column(name = "ENGINE_VERSION_")
    private String engineVersion;

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
     * @return REV_
     */
    public Integer getRev() {
        return rev;
    }

    /**
     * @param rev
     */
    public void setRev(Integer rev) {
        this.rev = rev;
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

    /**
     * @return VERSION_
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return DEPLOYMENT_ID_
     */
    public String getDeploymentId() {
        return deploymentId;
    }

    /**
     * @param deploymentId
     */
    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    /**
     * @return RESOURCE_NAME_
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @return DGRM_RESOURCE_NAME_
     */
    public String getDgrmResourceName() {
        return dgrmResourceName;
    }

    /**
     * @param dgrmResourceName
     */
    public void setDgrmResourceName(String dgrmResourceName) {
        this.dgrmResourceName = dgrmResourceName;
    }

    /**
     * @return DESCRIPTION_
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return HAS_START_FORM_KEY_
     */
    public Byte getHasStartFormKey() {
        return hasStartFormKey;
    }

    /**
     * @param hasStartFormKey
     */
    public void setHasStartFormKey(Byte hasStartFormKey) {
        this.hasStartFormKey = hasStartFormKey;
    }

    /**
     * @return HAS_GRAPHICAL_NOTATION_
     */
    public Byte getHasGraphicalNotation() {
        return hasGraphicalNotation;
    }

    /**
     * @param hasGraphicalNotation
     */
    public void setHasGraphicalNotation(Byte hasGraphicalNotation) {
        this.hasGraphicalNotation = hasGraphicalNotation;
    }

    /**
     * @return SUSPENSION_STATE_
     */
    public Integer getSuspensionState() {
        return suspensionState;
    }

    /**
     * @param suspensionState
     */
    public void setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
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
}