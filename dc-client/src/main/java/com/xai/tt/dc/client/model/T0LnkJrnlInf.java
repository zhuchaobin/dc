package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t0_lnk_jrnl_inf")
public class T0LnkJrnlInf {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 关联编号
     */
    @Column(name = "Rltv_ID")
    private String rltvId;

    /**
     * 流程类型
     */
    @Column(name = "PROCESS_TYPE")
    private String processType;

    /**
     * 流程实例编号
     */
    @Column(name = "PROCESS_INST_ID")
    private String processInstId;

    /**
     * 申请处理步骤代码
     */
    @Column(name = "Aply_PcStp_Cd")
    private String aplyPcstpCd;

    /**
     * 申请处理结果代码
     */
    @Column(name = "Aply_PsRlt_Cd")
    private String aplyPsrltCd;

    /**
     * 用户名
     */
    private String username;

    /**
     * 备注
     */
    @Column(name = "Rmrk")
    private String rmrk;

    /**
     * #初始化时间
     */
    @Column(name = "Inlz_Tm")
    private Date inlzTm;

    /**
     * #环节开始时间
     */
    @Column(name = "Lnk_StTm")
    private Date lnkSttm;

    /**
     * #环节结束时间
     */
    @Column(name = "Lnk_EdTm")
    private Date lnkEdtm;

    /**
     * 申请处理逾期状态代码
     */
    @Column(name = "Aply_Pcs_OdSt_Cd")
    private String aplyPcsOdstCd;

    /**
     * 申请处理机构编号
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * #时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * #交易发起渠道编号
     */
    @Column(name = "Txn_Itt_Chnl_ID")
    private String txnIttChnlId;

    /**
     * 申请处理结果
     */
    @Column(name = "Aply_PsRlt")
    private String aplyPsrlt;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取关联编号
     *
     * @return Rltv_ID - 关联编号
     */
    public String getRltvId() {
        return rltvId;
    }

    /**
     * 设置关联编号
     *
     * @param rltvId 关联编号
     */
    public void setRltvId(String rltvId) {
        this.rltvId = rltvId;
    }

    /**
     * 获取流程类型
     *
     * @return PROCESS_TYPE - 流程类型
     */
    public String getProcessType() {
        return processType;
    }

    /**
     * 设置流程类型
     *
     * @param processType 流程类型
     */
    public void setProcessType(String processType) {
        this.processType = processType;
    }

    /**
     * 获取流程实例编号
     *
     * @return PROCESS_INST_ID - 流程实例编号
     */
    public String getProcessInstId() {
        return processInstId;
    }

    /**
     * 设置流程实例编号
     *
     * @param processInstId 流程实例编号
     */
    public void setProcessInstId(String processInstId) {
        this.processInstId = processInstId;
    }

    /**
     * 获取申请处理步骤代码
     *
     * @return Aply_PcStp_Cd - 申请处理步骤代码
     */
    public String getAplyPcstpCd() {
        return aplyPcstpCd;
    }

    /**
     * 设置申请处理步骤代码
     *
     * @param aplyPcstpCd 申请处理步骤代码
     */
    public void setAplyPcstpCd(String aplyPcstpCd) {
        this.aplyPcstpCd = aplyPcstpCd;
    }

    /**
     * 获取申请处理结果代码
     *
     * @return Aply_PsRlt_Cd - 申请处理结果代码
     */
    public String getAplyPsrltCd() {
        return aplyPsrltCd;
    }

    /**
     * 设置申请处理结果代码
     *
     * @param aplyPsrltCd 申请处理结果代码
     */
    public void setAplyPsrltCd(String aplyPsrltCd) {
        this.aplyPsrltCd = aplyPsrltCd;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取备注
     *
     * @return Rmrk - 备注
     */
    public String getRmrk() {
        return rmrk;
    }

    /**
     * 设置备注
     *
     * @param rmrk 备注
     */
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    /**
     * 获取#初始化时间
     *
     * @return Inlz_Tm - #初始化时间
     */
    public Date getInlzTm() {
        return inlzTm;
    }

    /**
     * 设置#初始化时间
     *
     * @param inlzTm #初始化时间
     */
    public void setInlzTm(Date inlzTm) {
        this.inlzTm = inlzTm;
    }

    /**
     * 获取#环节开始时间
     *
     * @return Lnk_StTm - #环节开始时间
     */
    public Date getLnkSttm() {
        return lnkSttm;
    }

    /**
     * 设置#环节开始时间
     *
     * @param lnkSttm #环节开始时间
     */
    public void setLnkSttm(Date lnkSttm) {
        this.lnkSttm = lnkSttm;
    }

    /**
     * 获取#环节结束时间
     *
     * @return Lnk_EdTm - #环节结束时间
     */
    public Date getLnkEdtm() {
        return lnkEdtm;
    }

    /**
     * 设置#环节结束时间
     *
     * @param lnkEdtm #环节结束时间
     */
    public void setLnkEdtm(Date lnkEdtm) {
        this.lnkEdtm = lnkEdtm;
    }

    /**
     * 获取申请处理逾期状态代码
     *
     * @return Aply_Pcs_OdSt_Cd - 申请处理逾期状态代码
     */
    public String getAplyPcsOdstCd() {
        return aplyPcsOdstCd;
    }

    /**
     * 设置申请处理逾期状态代码
     *
     * @param aplyPcsOdstCd 申请处理逾期状态代码
     */
    public void setAplyPcsOdstCd(String aplyPcsOdstCd) {
        this.aplyPcsOdstCd = aplyPcsOdstCd;
    }

    /**
     * 获取申请处理机构编号
     *
     * @return company_id - 申请处理机构编号
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置申请处理机构编号
     *
     * @param companyId 申请处理机构编号
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取#时间戳
     *
     * @return Tms - #时间戳
     */
    public Date getTms() {
        return tms;
    }

    /**
     * 设置#时间戳
     *
     * @param tms #时间戳
     */
    public void setTms(Date tms) {
        this.tms = tms;
    }

    /**
     * 获取#交易发起渠道编号
     *
     * @return Txn_Itt_Chnl_ID - #交易发起渠道编号
     */
    public String getTxnIttChnlId() {
        return txnIttChnlId;
    }

    /**
     * 设置#交易发起渠道编号
     *
     * @param txnIttChnlId #交易发起渠道编号
     */
    public void setTxnIttChnlId(String txnIttChnlId) {
        this.txnIttChnlId = txnIttChnlId;
    }

    /**
     * 获取申请处理结果
     *
     * @return Aply_PsRlt - 申请处理结果
     */
    public String getAplyPsrlt() {
        return aplyPsrlt;
    }

    /**
     * 设置申请处理结果
     *
     * @param aplyPsrlt 申请处理结果
     */
    public void setAplyPsrlt(String aplyPsrlt) {
        this.aplyPsrlt = aplyPsrlt;
    }
}