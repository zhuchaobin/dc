package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t13_gds_detail")
public class T13GdsDetail {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 关联编号
     */
    @Column(name = "Rltv_ID")
    private String rltvId;

    /**
     * 关联类型
     */
    @Column(name = "Rltv_Tp")
    private String rltvTp;

    /**
     * 序号
     */
    private Long ids;

    /**
     * 品名
     */
    @Column(name = "Pd_Nm")
    private String pdNm;

    /**
     * 数量
     */
    @Column(name = "Num")
    private Float num;

    /**
     * 规格
     */
    @Column(name = "Spec")
    private String spec;

    /**
     * 型号
     */
    @Column(name = "Modl")
    private String modl;

    /**
     * 质量标准
     */
    @Column(name = "Qly_Std")
    private String qlyStd;

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
     * 采购单价
     */
    @Column(name = "Pch_UnitPrc")
    private Float pchUnitprc;

    /**
     * 交易差价
     */
    @Column(name = "Txn_PrcDif")
    private Float txnPrcdif;

    /**
     * 销售暂定价
     */
    @Column(name = "Sale_Tntv_Prc")
    private Float saleTntvPrc;

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
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 计量单位
     */
    @Column(name = "MsUnit")
    private String msunit;

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
     * 获取关联类型
     *
     * @return Rltv_Tp - 关联类型
     */
    public String getRltvTp() {
        return rltvTp;
    }

    /**
     * 设置关联类型
     *
     * @param rltvTp 关联类型
     */
    public void setRltvTp(String rltvTp) {
        this.rltvTp = rltvTp;
    }

    /**
     * 获取序号
     *
     * @return ids - 序号
     */
    public Long getIds() {
        return ids;
    }

    /**
     * 设置序号
     *
     * @param ids 序号
     */
    public void setIds(Long ids) {
        this.ids = ids;
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
     * 获取数量
     *
     * @return Num - 数量
     */
    public Float getNum() {
        return num;
    }

    /**
     * 设置数量
     *
     * @param num 数量
     */
    public void setNum(Float num) {
        this.num = num;
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
     * 获取型号
     *
     * @return Modl - 型号
     */
    public String getModl() {
        return modl;
    }

    /**
     * 设置型号
     *
     * @param modl 型号
     */
    public void setModl(String modl) {
        this.modl = modl;
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
     * 获取采购单价
     *
     * @return Pch_UnitPrc - 采购单价
     */
    public Float getPchUnitprc() {
        return pchUnitprc;
    }

    /**
     * 设置采购单价
     *
     * @param pchUnitprc 采购单价
     */
    public void setPchUnitprc(Float pchUnitprc) {
        this.pchUnitprc = pchUnitprc;
    }

    /**
     * 获取交易差价
     *
     * @return Txn_PrcDif - 交易差价
     */
    public Float getTxnPrcdif() {
        return txnPrcdif;
    }

    /**
     * 设置交易差价
     *
     * @param txnPrcdif 交易差价
     */
    public void setTxnPrcdif(Float txnPrcdif) {
        this.txnPrcdif = txnPrcdif;
    }

    /**
     * 获取销售暂定价
     *
     * @return Sale_Tntv_Prc - 销售暂定价
     */
    public Float getSaleTntvPrc() {
        return saleTntvPrc;
    }

    /**
     * 设置销售暂定价
     *
     * @param saleTntvPrc 销售暂定价
     */
    public void setSaleTntvPrc(Float saleTntvPrc) {
        this.saleTntvPrc = saleTntvPrc;
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
}