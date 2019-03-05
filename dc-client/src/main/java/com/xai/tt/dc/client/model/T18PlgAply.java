package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t18_plg_aply")
public class T18PlgAply {
    /**
     * ID
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * 仓单编号
     */
    @Column(name = "WhRecpt_ID")
    private String whrecptId;

    /**
     * 质押单号
     */
    @Column(name = "Plg_BillNo")
    private String plgBillno;

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
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 质押申请操作人
     */
    @Column(name = "Plg_Aply_Mnplt_Psn")
    private String plgAplyMnpltPsn;

    /**
     * 质押申请时间
     */
    @Column(name = "Plg_Aply_Tm")
    private Date plgAplyTm;

    /**
     * 质押申请备注
     */
    @Column(name = "Aply_Rmrk")
    private String aplyRmrk;

    /**
     * 银行id
     */
    @Column(name = "Bnkid")
    private Long bnkid;

    /**
     * 银行公司名
     */
    @Column(name = "Bnk_Co_Nm")
    private String bnkCoNm;

    /**
     * 仓储id
     */
    @Column(name = "Stgid")
    private Long stgid;

    /**
     * 仓储公司名
     */
    @Column(name = "StgCo_Nm")
    private String stgcoNm;

    /**
     * 质押申请状态
     */
    @Column(name = "Plg_Aply_St")
    private String plgAplySt;

    /**
     * 融资企业id
     */
    @Column(name = "Fnc_Entp_Co_Id")
    private Long fncEntpCoId;

    /**
     * 融资企业公司名
     */
    @Column(name = "Fnc_Entp_Co_Nm")
    private String fncEntpCoNm;

    /**
     * 质押审核操作人
     */
    @Column(name = "Plg_Adt_Mnplt_Psn")
    private String plgAdtMnpltPsn;

    /**
     * 质押审核备注
     */
    @Column(name = "Adt_Rmrk")
    private String adtRmrk;

    /**
     * 质押审核时间
     */
    @Column(name = "Plg_Adt_Tm")
    private Date plgAdtTm;

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
     * 获取仓单编号
     *
     * @return WhRecpt_ID - 仓单编号
     */
    public String getWhrecptId() {
        return whrecptId;
    }

    /**
     * 设置仓单编号
     *
     * @param whrecptId 仓单编号
     */
    public void setWhrecptId(String whrecptId) {
        this.whrecptId = whrecptId;
    }

    /**
     * 获取质押单号
     *
     * @return Plg_BillNo - 质押单号
     */
    public String getPlgBillno() {
        return plgBillno;
    }

    /**
     * 设置质押单号
     *
     * @param plgBillno 质押单号
     */
    public void setPlgBillno(String plgBillno) {
        this.plgBillno = plgBillno;
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
     * 获取质押申请操作人
     *
     * @return Plg_Aply_Mnplt_Psn - 质押申请操作人
     */
    public String getPlgAplyMnpltPsn() {
        return plgAplyMnpltPsn;
    }

    /**
     * 设置质押申请操作人
     *
     * @param plgAplyMnpltPsn 质押申请操作人
     */
    public void setPlgAplyMnpltPsn(String plgAplyMnpltPsn) {
        this.plgAplyMnpltPsn = plgAplyMnpltPsn;
    }

    /**
     * 获取质押申请时间
     *
     * @return Plg_Aply_Tm - 质押申请时间
     */
    public Date getPlgAplyTm() {
        return plgAplyTm;
    }

    /**
     * 设置质押申请时间
     *
     * @param plgAplyTm 质押申请时间
     */
    public void setPlgAplyTm(Date plgAplyTm) {
        this.plgAplyTm = plgAplyTm;
    }

    /**
     * 获取质押申请备注
     *
     * @return Aply_Rmrk - 质押申请备注
     */
    public String getAplyRmrk() {
        return aplyRmrk;
    }

    /**
     * 设置质押申请备注
     *
     * @param aplyRmrk 质押申请备注
     */
    public void setAplyRmrk(String aplyRmrk) {
        this.aplyRmrk = aplyRmrk;
    }

    /**
     * 获取银行id
     *
     * @return Bnkid - 银行id
     */
    public Long getBnkid() {
        return bnkid;
    }

    /**
     * 设置银行id
     *
     * @param bnkid 银行id
     */
    public void setBnkid(Long bnkid) {
        this.bnkid = bnkid;
    }

    /**
     * 获取银行公司名
     *
     * @return Bnk_Co_Nm - 银行公司名
     */
    public String getBnkCoNm() {
        return bnkCoNm;
    }

    /**
     * 设置银行公司名
     *
     * @param bnkCoNm 银行公司名
     */
    public void setBnkCoNm(String bnkCoNm) {
        this.bnkCoNm = bnkCoNm;
    }

    /**
     * 获取仓储id
     *
     * @return Stgid - 仓储id
     */
    public Long getStgid() {
        return stgid;
    }

    /**
     * 设置仓储id
     *
     * @param stgid 仓储id
     */
    public void setStgid(Long stgid) {
        this.stgid = stgid;
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
     * 获取质押申请状态
     *
     * @return Plg_Aply_St - 质押申请状态
     */
    public String getPlgAplySt() {
        return plgAplySt;
    }

    /**
     * 设置质押申请状态
     *
     * @param plgAplySt 质押申请状态
     */
    public void setPlgAplySt(String plgAplySt) {
        this.plgAplySt = plgAplySt;
    }

    /**
     * 获取融资企业id
     *
     * @return Fnc_Entp_Co_Id - 融资企业id
     */
    public Long getFncEntpCoId() {
        return fncEntpCoId;
    }

    /**
     * 设置融资企业id
     *
     * @param fncEntpCoId 融资企业id
     */
    public void setFncEntpCoId(Long fncEntpCoId) {
        this.fncEntpCoId = fncEntpCoId;
    }

    /**
     * 获取融资企业公司名
     *
     * @return Fnc_Entp_Co_Nm - 融资企业公司名
     */
    public String getFncEntpCoNm() {
        return fncEntpCoNm;
    }

    /**
     * 设置融资企业公司名
     *
     * @param fncEntpCoNm 融资企业公司名
     */
    public void setFncEntpCoNm(String fncEntpCoNm) {
        this.fncEntpCoNm = fncEntpCoNm;
    }

    /**
     * 获取质押审核操作人
     *
     * @return Plg_Adt_Mnplt_Psn - 质押审核操作人
     */
    public String getPlgAdtMnpltPsn() {
        return plgAdtMnpltPsn;
    }

    /**
     * 设置质押审核操作人
     *
     * @param plgAdtMnpltPsn 质押审核操作人
     */
    public void setPlgAdtMnpltPsn(String plgAdtMnpltPsn) {
        this.plgAdtMnpltPsn = plgAdtMnpltPsn;
    }

    /**
     * 获取质押审核备注
     *
     * @return Adt_Rmrk - 质押审核备注
     */
    public String getAdtRmrk() {
        return adtRmrk;
    }

    /**
     * 设置质押审核备注
     *
     * @param adtRmrk 质押审核备注
     */
    public void setAdtRmrk(String adtRmrk) {
        this.adtRmrk = adtRmrk;
    }

    /**
     * 获取质押审核时间
     *
     * @return Plg_Adt_Tm - 质押审核时间
     */
    public Date getPlgAdtTm() {
        return plgAdtTm;
    }

    /**
     * 设置质押审核时间
     *
     * @param plgAdtTm 质押审核时间
     */
    public void setPlgAdtTm(Date plgAdtTm) {
        this.plgAdtTm = plgAdtTm;
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