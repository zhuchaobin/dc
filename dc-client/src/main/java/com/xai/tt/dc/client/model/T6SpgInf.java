package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t6_spg_inf")
public class T6SpgInf {
	
    /**
     * 赎货方式
     */
    @Column(name = "Sel_RdmGds_Mod")
    private String selRdmgdsMod;
    
    public String getSelRdmgdsMod() {
		return selRdmgdsMod;
	}

	public void setSelRdmgdsMod(String selRdmgdsMod) {
		this.selRdmgdsMod = selRdmgdsMod;
	}

	/**
     * ID
     */
    @Id
    private Long id;

    /**
     * 长约编号
     */
    @Column(name = "Ar_ID")
    private String arId;

    /**
     * 订单编号
     */
    @Column(name = "Ordr_ID")
    private String ordrId;

    /**
     * 发货编号
     */
    @Column(name = "Spg_ID")
    private String spgId;

    /**
     * 流程实例ID
     */
    @Column(name = "PROCESS_INST_ID")
    private String processInstId;

    /**
     * 发货时间
     */
    @Column(name = "Spg_Tm")
    private Date spgTm;

    /**
     * 发货人
     */
    @Column(name = "Spg_Psn")
    private String spgPsn;

    /**
     * 发货人联系电话
     */
    @Column(name = "Spg_Psn_Ctc_Tel")
    private String spgPsnCtcTel;

    /**
     * 收货人
     */
    @Column(name = "Cnsgn")
    private String cnsgn;

    /**
     * 收货人联系电话
     */
    @Column(name = "Cnsgn_Ctc_Tel")
    private String cnsgnCtcTel;

    /**
     * 目的地
     */
    @Column(name = "Pps_Lnd")
    private String ppsLnd;

    /**
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 发货状态
     */
    @Column(name = "Spg_St")
    private String spgSt;

    /**
     * 操作员
     */
    private String username;

    /**
     * 创建时间
     */
    @Column(name = "Crt_Tm")
    private Date crtTm;




    /**
     * 付款方式
     */
    @Column(name = "PymtMod")
    private String pymtMod;




    public String getPymtMod() {
        return pymtMod;
    }

    public void setPymtMod(String pymtMod) {
        this.pymtMod = pymtMod;
    }

    /**
     * 获取ID
     *
     * @return id - ID
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
     * 获取长约编号
     *
     * @return Ar_ID - 长约编号
     */
    public String getArId() {
        return arId;
    }

    /**
     * 设置长约编号
     *
     * @param arId 长约编号
     */
    public void setArId(String arId) {
        this.arId = arId;
    }

    /**
     * 获取订单编号
     *
     * @return Ordr_ID - 订单编号
     */
    public String getOrdrId() {
        return ordrId;
    }

    /**
     * 设置订单编号
     *
     * @param ordrId 订单编号
     */
    public void setOrdrId(String ordrId) {
        this.ordrId = ordrId;
    }

    /**
     * 获取发货编号
     *
     * @return Spg_ID - 发货编号
     */
    public String getSpgId() {
        return spgId;
    }

    /**
     * 设置发货编号
     *
     * @param spgId 发货编号
     */
    public void setSpgId(String spgId) {
        this.spgId = spgId;
    }

    /**
     * 获取流程实例ID
     *
     * @return PROCESS_INST_ID - 流程实例ID
     */
    public String getProcessInstId() {
        return processInstId;
    }

    /**
     * 设置流程实例ID
     *
     * @param processInstId 流程实例ID
     */
    public void setProcessInstId(String processInstId) {
        this.processInstId = processInstId;
    }

    /**
     * 获取发货时间
     *
     * @return Spg_Tm - 发货时间
     */
    public Date getSpgTm() {
        return spgTm;
    }

    /**
     * 设置发货时间
     *
     * @param spgTm 发货时间
     */
    public void setSpgTm(Date spgTm) {
        this.spgTm = spgTm;
    }

    /**
     * 获取发货人
     *
     * @return Spg_Psn - 发货人
     */
    public String getSpgPsn() {
        return spgPsn;
    }

    /**
     * 设置发货人
     *
     * @param spgPsn 发货人
     */
    public void setSpgPsn(String spgPsn) {
        this.spgPsn = spgPsn;
    }

    /**
     * 获取发货人联系电话
     *
     * @return Spg_Psn_Ctc_Tel - 发货人联系电话
     */
    public String getSpgPsnCtcTel() {
        return spgPsnCtcTel;
    }

    /**
     * 设置发货人联系电话
     *
     * @param spgPsnCtcTel 发货人联系电话
     */
    public void setSpgPsnCtcTel(String spgPsnCtcTel) {
        this.spgPsnCtcTel = spgPsnCtcTel;
    }

    /**
     * 获取收货人
     *
     * @return Cnsgn - 收货人
     */
    public String getCnsgn() {
        return cnsgn;
    }

    /**
     * 设置收货人
     *
     * @param cnsgn 收货人
     */
    public void setCnsgn(String cnsgn) {
        this.cnsgn = cnsgn;
    }

    /**
     * 获取收货人联系电话
     *
     * @return Cnsgn_Ctc_Tel - 收货人联系电话
     */
    public String getCnsgnCtcTel() {
        return cnsgnCtcTel;
    }

    /**
     * 设置收货人联系电话
     *
     * @param cnsgnCtcTel 收货人联系电话
     */
    public void setCnsgnCtcTel(String cnsgnCtcTel) {
        this.cnsgnCtcTel = cnsgnCtcTel;
    }

    /**
     * 获取目的地
     *
     * @return Pps_Lnd - 目的地
     */
    public String getPpsLnd() {
        return ppsLnd;
    }

    /**
     * 设置目的地
     *
     * @param ppsLnd 目的地
     */
    public void setPpsLnd(String ppsLnd) {
        this.ppsLnd = ppsLnd;
    }

    /**
     * 获取时间戳
     *
     * @return Tms - 时间戳
     */
    public Date getTms() {
        return tms;
    }

    /**
     * 设置时间戳
     *
     * @param tms 时间戳
     */
    public void setTms(Date tms) {
        this.tms = tms;
    }

    /**
     * 获取发货状态
     *
     * @return Spg_St - 发货状态
     */
    public String getSpgSt() {
        return spgSt;
    }

    /**
     * 设置发货状态
     *
     * @param spgSt 发货状态
     */
    public void setSpgSt(String spgSt) {
        this.spgSt = spgSt;
    }

    /**
     * 获取操作员
     *
     * @return username - 操作员
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作员
     *
     * @param username 操作员
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取创建时间
     *
     * @return Crt_Tm - 创建时间
     */
    public Date getCrtTm() {
        return crtTm;
    }

    /**
     * 设置创建时间
     *
     * @param crtTm 创建时间
     */
    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }
}