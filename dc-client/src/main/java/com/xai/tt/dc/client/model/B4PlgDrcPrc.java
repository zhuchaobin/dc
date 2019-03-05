package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "b4_plg_drc_prc")
public class B4PlgDrcPrc {
    /**
     * id
     */
    @Id
    @Column(name = "ID")
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
     * 银行id
     */
    @Column(name = "Bnk_id")
    private Long bnkId;

    /**
     * 银行名称
     */
    @Column(name = "Bnk_Nm")
    private String bnkNm;

    /**
     * 品名id
     */
    @Column(name = "Pd_ID")
    private Long pdId;

    /**
     * 品名
     */
    @Column(name = "Pd_Nm")
    private String pdNm;

    /**
     * 规格
     */
    @Column(name = "Spec")
    private String spec;

    /**
     * 质押指导价
     */
    @Column(name = "Plg_Drc_Prc")
    private Float plgDrcPrc;

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
     * 更新时间
     */
    @Column(name = "Udt_Tm")
    private Date udtTm;

    /**
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 备注
     */
    @Column(name = "Rmrk")
    private String rmrk;

    /**
     * 获取id
     *
     * @return ID - id
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
     * 获取银行id
     *
     * @return Bnk_id - 银行id
     */
    public Long getBnkId() {
        return bnkId;
    }

    /**
     * 设置银行id
     *
     * @param bnkId 银行id
     */
    public void setBnkId(Long bnkId) {
        this.bnkId = bnkId;
    }

    /**
     * 获取银行名称
     *
     * @return Bnk_Nm - 银行名称
     */
    public String getBnkNm() {
        return bnkNm;
    }

    /**
     * 设置银行名称
     *
     * @param bnkNm 银行名称
     */
    public void setBnkNm(String bnkNm) {
        this.bnkNm = bnkNm;
    }

    /**
     * 获取品名id
     *
     * @return Pd_ID - 品名id
     */
    public Long getPdId() {
        return pdId;
    }

    /**
     * 设置品名id
     *
     * @param pdId 品名id
     */
    public void setPdId(Long pdId) {
        this.pdId = pdId;
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
     * 获取质押指导价
     *
     * @return Plg_Drc_Prc - 质押指导价
     */
    public Float getPlgDrcPrc() {
        return plgDrcPrc;
    }

    /**
     * 设置质押指导价
     *
     * @param plgDrcPrc 质押指导价
     */
    public void setPlgDrcPrc(Float plgDrcPrc) {
        this.plgDrcPrc = plgDrcPrc;
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
     * 获取更新时间
     *
     * @return Udt_Tm - 更新时间
     */
    public Date getUdtTm() {
        return udtTm;
    }

    /**
     * 设置更新时间
     *
     * @param udtTm 更新时间
     */
    public void setUdtTm(Date udtTm) {
        this.udtTm = udtTm;
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
}