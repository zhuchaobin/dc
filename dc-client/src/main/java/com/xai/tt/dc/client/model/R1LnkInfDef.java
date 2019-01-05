package com.xai.tt.dc.client.model;

import javax.persistence.*;

@Table(name = "r1_lnk_inf_def")
public class R1LnkInfDef {
    /**
     * ID
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * 申请处理步骤代码
     */
    @Column(name = "Aply_PcStp_Cd")
    private String aplyPcstpCd;

    /**
     * 流程步骤英文名
     */
    @Column(name = "Pcs_Step_Eng_Nm")
    private String pcsStepEngNm;

    /**
     * 申请处理步骤中文名
     */
    @Column(name = "Aply_PcStp_Chn_Nm")
    private String aplyPcstpChnNm;

    /**
     * 审批结论个性化字段初始化
     */
    @Column(name = "Aply_PsRlt")
    private String aplyPsrlt;

    /**
     * 获取ID
     *
     * @return ID - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取流程步骤英文名
     *
     * @return Pcs_Step_Eng_Nm - 流程步骤英文名
     */
    public String getPcsStepEngNm() {
        return pcsStepEngNm;
    }

    /**
     * 设置流程步骤英文名
     *
     * @param pcsStepEngNm 流程步骤英文名
     */
    public void setPcsStepEngNm(String pcsStepEngNm) {
        this.pcsStepEngNm = pcsStepEngNm;
    }

    /**
     * 获取申请处理步骤中文名
     *
     * @return Aply_PcStp_Chn_Nm - 申请处理步骤中文名
     */
    public String getAplyPcstpChnNm() {
        return aplyPcstpChnNm;
    }

    /**
     * 设置申请处理步骤中文名
     *
     * @param aplyPcstpChnNm 申请处理步骤中文名
     */
    public void setAplyPcstpChnNm(String aplyPcstpChnNm) {
        this.aplyPcstpChnNm = aplyPcstpChnNm;
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