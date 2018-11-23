package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "act_ru_task")
public class ActRuTask {
    @Id
    @Column(name = "ID_")
    private String id;

    @Column(name = "REV_")
    private Integer rev;

    @Column(name = "EXECUTION_ID_")
    private String executionId;

    @Column(name = "PROC_INST_ID_")
    private String procInstId;

    @Column(name = "PROC_DEF_ID_")
    private String procDefId;

    @Column(name = "NAME_")
    private String name;

    @Column(name = "PARENT_TASK_ID_")
    private String parentTaskId;

    @Column(name = "DESCRIPTION_")
    private String description;

    @Column(name = "TASK_DEF_KEY_")
    private String taskDefKey;

    @Column(name = "OWNER_")
    private String owner;

    @Column(name = "ASSIGNEE_")
    private String assignee;

    @Column(name = "DELEGATION_")
    private String delegation;

    @Column(name = "PRIORITY_")
    private Integer priority;

    @Column(name = "CREATE_TIME_")
    private Date createTime;

    @Column(name = "DUE_DATE_")
    private Date dueDate;

    @Column(name = "CATEGORY_")
    private String category;

    @Column(name = "SUSPENSION_STATE_")
    private Integer suspensionState;

    @Column(name = "TENANT_ID_")
    private String tenantId;

    @Column(name = "FORM_KEY_")
    private String formKey;

    @Column(name = "CLAIM_TIME_")
    private Date claimTime;

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
     * @return EXECUTION_ID_
     */
    public String getExecutionId() {
        return executionId;
    }

    /**
     * @param executionId
     */
    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    /**
     * @return PROC_INST_ID_
     */
    public String getProcInstId() {
        return procInstId;
    }

    /**
     * @param procInstId
     */
    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    /**
     * @return PROC_DEF_ID_
     */
    public String getProcDefId() {
        return procDefId;
    }

    /**
     * @param procDefId
     */
    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
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
     * @return PARENT_TASK_ID_
     */
    public String getParentTaskId() {
        return parentTaskId;
    }

    /**
     * @param parentTaskId
     */
    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
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
     * @return TASK_DEF_KEY_
     */
    public String getTaskDefKey() {
        return taskDefKey;
    }

    /**
     * @param taskDefKey
     */
    public void setTaskDefKey(String taskDefKey) {
        this.taskDefKey = taskDefKey;
    }

    /**
     * @return OWNER_
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return ASSIGNEE_
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * @param assignee
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /**
     * @return DELEGATION_
     */
    public String getDelegation() {
        return delegation;
    }

    /**
     * @param delegation
     */
    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    /**
     * @return PRIORITY_
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @return CREATE_TIME_
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
     * @return DUE_DATE_
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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
     * @return FORM_KEY_
     */
    public String getFormKey() {
        return formKey;
    }

    /**
     * @param formKey
     */
    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    /**
     * @return CLAIM_TIME_
     */
    public Date getClaimTime() {
        return claimTime;
    }

    /**
     * @param claimTime
     */
    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }
}