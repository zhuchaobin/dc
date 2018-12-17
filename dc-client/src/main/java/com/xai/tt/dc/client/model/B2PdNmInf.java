package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "b2_pd_nm_inf")
public class B2PdNmInf {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 品名
     */
    @Column(name = "Pd_Nm")
    private String pdNm;

    /**
     * 俗名
     */
    @Column(name = "Comm_Nm")
    private String commNm;

    /**
     * 学名
     */
    @Column(name = "Ty_Nm")
    private String tyNm;

    /**
     * 是否常用
     */
    @Column(name = "Wthr_CmnUsed")
    private Integer wthrCmnused;

    /**
     * 品种介绍
     */
    @Column(name = "Vrty_Intd")
    private Date vrtyIntd;

    /**
     * 价格上限
     */
    @Column(name = "Prc_UpLm")
    private String prcUplm;

    /**
     * 价格下限
     */
    @Column(name = "Prc_LwrLmt")
    private Date prcLwrlmt;

    /**
     * 计量单位
     */
    @Column(name = "MsUnit")
    private String msunit;

    /**
     * 质量标准
     */
    @Column(name = "Qly_Std")
    private String qlyStd;

    /**
     * 规格
     */
    @Column(name = "Spec")
    private String spec;

    /**
     * 品牌
     */
    @Column(name = "Brnd")
    private String brnd;

    /**
     * 生产厂家
     */
    @Column(name = "Pd_Fctr")
    private String pdFctr;

    /**
     * 用户名
     */
    private String username;

    /**
     * 更新时间
     */
    @Column(name = "Udt_Tm")
    private String udtTm;

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
     * 获取品名
     *
     * @return Pd_Nm - 品名
     */
    public String getPdNm() {
        return pdNm;
    }

    /**
     * 设置品名
     *
     * @param pdNm 品名
     */
    public void setPdNm(String pdNm) {
        this.pdNm = pdNm;
    }

    /**
     * 获取俗名
     *
     * @return Comm_Nm - 俗名
     */
    public String getCommNm() {
        return commNm;
    }

    /**
     * 设置俗名
     *
     * @param commNm 俗名
     */
    public void setCommNm(String commNm) {
        this.commNm = commNm;
    }

    /**
     * 获取学名
     *
     * @return Ty_Nm - 学名
     */
    public String getTyNm() {
        return tyNm;
    }

    /**
     * 设置学名
     *
     * @param tyNm 学名
     */
    public void setTyNm(String tyNm) {
        this.tyNm = tyNm;
    }

    /**
     * 获取是否常用
     *
     * @return Wthr_CmnUsed - 是否常用
     */
    public Integer getWthrCmnused() {
        return wthrCmnused;
    }

    /**
     * 设置是否常用
     *
     * @param wthrCmnused 是否常用
     */
    public void setWthrCmnused(Integer wthrCmnused) {
        this.wthrCmnused = wthrCmnused;
    }

    /**
     * 获取品种介绍
     *
     * @return Vrty_Intd - 品种介绍
     */
    public Date getVrtyIntd() {
        return vrtyIntd;
    }

    /**
     * 设置品种介绍
     *
     * @param vrtyIntd 品种介绍
     */
    public void setVrtyIntd(Date vrtyIntd) {
        this.vrtyIntd = vrtyIntd;
    }

    /**
     * 获取价格上限
     *
     * @return Prc_UpLm - 价格上限
     */
    public String getPrcUplm() {
        return prcUplm;
    }

    /**
     * 设置价格上限
     *
     * @param prcUplm 价格上限
     */
    public void setPrcUplm(String prcUplm) {
        this.prcUplm = prcUplm;
    }

    /**
     * 获取价格下限
     *
     * @return Prc_LwrLmt - 价格下限
     */
    public Date getPrcLwrlmt() {
        return prcLwrlmt;
    }

    /**
     * 设置价格下限
     *
     * @param prcLwrlmt 价格下限
     */
    public void setPrcLwrlmt(Date prcLwrlmt) {
        this.prcLwrlmt = prcLwrlmt;
    }

    /**
     * 获取计量单位
     *
     * @return MsUnit - 计量单位
     */
    public String getMsunit() {
        return msunit;
    }

    /**
     * 设置计量单位
     *
     * @param msunit 计量单位
     */
    public void setMsunit(String msunit) {
        this.msunit = msunit;
    }

    /**
     * 获取质量标准
     *
     * @return Qly_Std - 质量标准
     */
    public String getQlyStd() {
        return qlyStd;
    }

    /**
     * 设置质量标准
     *
     * @param qlyStd 质量标准
     */
    public void setQlyStd(String qlyStd) {
        this.qlyStd = qlyStd;
    }

    /**
     * 获取规格
     *
     * @return Spec - 规格
     */
    public String getSpec() {
        return spec;
    }

    /**
     * 设置规格
     *
     * @param spec 规格
     */
    public void setSpec(String spec) {
        this.spec = spec;
    }

    /**
     * 获取品牌
     *
     * @return Brnd - 品牌
     */
    public String getBrnd() {
        return brnd;
    }

    /**
     * 设置品牌
     *
     * @param brnd 品牌
     */
    public void setBrnd(String brnd) {
        this.brnd = brnd;
    }

    /**
     * 获取生产厂家
     *
     * @return Pd_Fctr - 生产厂家
     */
    public String getPdFctr() {
        return pdFctr;
    }

    /**
     * 设置生产厂家
     *
     * @param pdFctr 生产厂家
     */
    public void setPdFctr(String pdFctr) {
        this.pdFctr = pdFctr;
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
     * 获取更新时间
     *
     * @return Udt_Tm - 更新时间
     */
    public String getUdtTm() {
        return udtTm;
    }

    /**
     * 设置更新时间
     *
     * @param udtTm 更新时间
     */
    public void setUdtTm(String udtTm) {
        this.udtTm = udtTm;
    }
}