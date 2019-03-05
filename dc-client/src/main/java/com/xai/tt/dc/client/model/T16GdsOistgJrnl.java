package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t16_gds_oistg_jrnl")
public class T16GdsOistgJrnl {
    /**
     * ID
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * 操作流水号
     */
    @Column(name = "Mnplt_TrcNo")
    private String mnpltTrcno;

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
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 操作员
     */
    @Column(name = "Opr")
    private String opr;

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
     * 备注
     */
    @Column(name = "Rmrk")
    private String rmrk;

    /**
     * 仓储id
     */
    @Column(name = "Stg_id")
    private Long stgId;

    /**
     * 仓储公司名
     */
    @Column(name = "StgCo_Nm")
    private String stgcoNm;

    /**
     * 库位
     */
    @Column(name = "Str_Pos")
    private String strPos;

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
     * 获取操作流水号
     *
     * @return Mnplt_TrcNo - 操作流水号
     */
    public String getMnpltTrcno() {
        return mnpltTrcno;
    }

    /**
     * 设置操作流水号
     *
     * @param mnpltTrcno 操作流水号
     */
    public void setMnpltTrcno(String mnpltTrcno) {
        this.mnpltTrcno = mnpltTrcno;
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
     * 获取操作员
     *
     * @return Opr - 操作员
     */
    public String getOpr() {
        return opr;
    }

    /**
     * 设置操作员
     *
     * @param opr 操作员
     */
    public void setOpr(String opr) {
        this.opr = opr;
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
     * 获取仓储id
     *
     * @return Stg_id - 仓储id
     */
    public Long getStgId() {
        return stgId;
    }

    /**
     * 设置仓储id
     *
     * @param stgId 仓储id
     */
    public void setStgId(Long stgId) {
        this.stgId = stgId;
    }

    /**
     * 获取仓储公司名
     *
     * @return StgCo_Nm - 仓储公司名
     */
    public String getStgcoNm() {
        return stgcoNm;
    }

    /**
     * 设置仓储公司名
     *
     * @param stgcoNm 仓储公司名
     */
    public void setStgcoNm(String stgcoNm) {
        this.stgcoNm = stgcoNm;
    }

    /**
     * 获取库位
     *
     * @return Str_Pos - 库位
     */
    public String getStrPos() {
        return strPos;
    }

    /**
     * 设置库位
     *
     * @param strPos 库位
     */
    public void setStrPos(String strPos) {
        this.strPos = strPos;
    }
}