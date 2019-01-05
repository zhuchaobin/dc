package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "role")
public class Role {
    @Id
    private Integer id;

    private String code;

    private String name;

    private String memo;

    private Boolean locked;

    private Boolean system;

    private Boolean assignable;

    private Integer version;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 角色不可见参数列表
     */
    private String parms;

    /**
     * 审批结论个性化字段初始化
     */
    @Column(name = "Aply_PsRlt")
    private String aplyPsrlt;

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
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return name
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
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * @return system
     */
    public Boolean getSystem() {
        return system;
    }

    /**
     * @param system
     */
    public void setSystem(Boolean system) {
        this.system = system;
    }

    /**
     * @return assignable
     */
    public Boolean getAssignable() {
        return assignable;
    }

    /**
     * @param assignable
     */
    public void setAssignable(Boolean assignable) {
        this.assignable = assignable;
    }

    /**
     * @return version
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

    /**
     * 获取角色不可见参数列表
     *
     * @return parms - 角色不可见参数列表
     */
    public String getParms() {
        return parms;
    }

    /**
     * 设置角色不可见参数列表
     *
     * @param parms 角色不可见参数列表
     */
    public void setParms(String parms) {
        this.parms = parms;
    }

    /**
     * 获取审批结论个性化字段初始化
     *
     * @return Aply_PsRlt - 审批结论个性化字段初始化
     */
    public String getAplyPsrlt() {
        return aplyPsrlt;
    }

    /**
     * 设置审批结论个性化字段初始化
     *
     * @param aplyPsrlt 审批结论个性化字段初始化
     */
    public void setAplyPsrlt(String aplyPsrlt) {
        this.aplyPsrlt = aplyPsrlt;
    }
}