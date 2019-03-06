package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t17_ivnt_dtl")
public class T17IvntDtl {
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
     * 序号
     */
    private Long ids;

    /**
     * 入库类型
     */
    @Column(name = "InTrsr_Tp")
    private String intrsrTp;

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
     * 入库操作员
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
     * 入库总量
     */
    @Column(name = "InTrsr_TNum")
    private Float intrsrTnum;

    /**
     * 出库总量
     */
    @Column(name = "OutStg_TNum")
    private Float outstgTnum;

    /**
     * 在库总量
     */
    @Column(name = "InTheStg_TNum")
    private Float inthestgTnum;

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
     * 质押单号
     */
    @Column(name = "Plg_BillNo")
    private String plgBillno;

    /**
     * 银行id
     */
    @Column(name = "Bnk")
    private Long bnk;

    /**
     * 银行名称
     */
    @Column(name = "Bnk_Nm")
    private String bnkNm;

    /**
     * 仓储id
     */
    @Column(name = "StgCo")
    private Long stgco;

    /**
     * 仓储名称
     */
    @Column(name = "StgCo_Nm")
    private String stgcoNm;

    /**
     * 库位
     */
    @Column(name = "Str_Pos")
    private String strPos;

    /**
     * 货物归属ID
     */
    @Column(name = "Gds_Blg_ID")
    private Long gdsBlgId;

    /**
     * 货物归属公司名
     */
    @Column(name = "Gds_Blg_Nm")
    private String gdsBlgNm;

    /**
     * 质押申请状态
     */
    @Column(name = "Plg_Aply_St")
    private String plgAplySt;

    /**
     * 上游供应商id
     */
    @Column(name = "Ustrm_Splr")
    private Long ustrmSplr;

    /**
     * 上游供应商公司名
     */
    @Column(name = "Ustrm_Splr_Nm")
    private String ustrmSplrNm;

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
     * 获取入库类型
     *
     * @return InTrsr_Tp - 入库类型
     */
    public String getIntrsrTp() {
        return intrsrTp;
    }

    /**
     * 设置入库类型
     *
     * @param intrsrTp 入库类型
     */
    public void setIntrsrTp(String intrsrTp) {
        this.intrsrTp = intrsrTp;
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
     * 获取入库操作员
     *
     * @return username - 入库操作员
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置入库操作员
     *
     * @param username 入库操作员
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

    /**
     * 获取入库总量
     *
     * @return InTrsr_TNum - 入库总量
     */
    public Float getIntrsrTnum() {
        return intrsrTnum;
    }

    /**
     * 设置入库总量
     *
     * @param intrsrTnum 入库总量
     */
    public void setIntrsrTnum(Float intrsrTnum) {
        this.intrsrTnum = intrsrTnum;
    }

    /**
     * 获取出库总量
     *
     * @return OutStg_TNum - 出库总量
     */
    public Float getOutstgTnum() {
        return outstgTnum;
    }

    /**
     * 设置出库总量
     *
     * @param outstgTnum 出库总量
     */
    public void setOutstgTnum(Float outstgTnum) {
        this.outstgTnum = outstgTnum;
    }

    /**
     * 获取在库总量
     *
     * @return InTheStg_TNum - 在库总量
     */
    public Float getInthestgTnum() {
        return inthestgTnum;
    }

    /**
     * 设置在库总量
     *
     * @param inthestgTnum 在库总量
     */
    public void setInthestgTnum(Float inthestgTnum) {
        this.inthestgTnum = inthestgTnum;
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
     * 获取银行id
     *
     * @return Bnk - 银行id
     */
    public Long getBnk() {
        return bnk;
    }

    /**
     * 设置银行id
     *
     * @param bnk 银行id
     */
    public void setBnk(Long bnk) {
        this.bnk = bnk;
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
     * 获取仓储id
     *
     * @return StgCo - 仓储id
     */
    public Long getStgco() {
        return stgco;
    }

    /**
     * 设置仓储id
     *
     * @param stgco 仓储id
     */
    public void setStgco(Long stgco) {
        this.stgco = stgco;
    }

    /**
     * 获取仓储名称
     *
     * @return StgCo_Nm - 仓储名称
     */
    public String getStgcoNm() {
        return stgcoNm;
    }

    /**
     * 设置仓储名称
     *
     * @param stgcoNm 仓储名称
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

    /**
     * 获取货物归属ID
     *
     * @return Gds_Blg_ID - 货物归属ID
     */
    public Long getGdsBlgId() {
        return gdsBlgId;
    }

    /**
     * 设置货物归属ID
     *
     * @param gdsBlgId 货物归属ID
     */
    public void setGdsBlgId(Long gdsBlgId) {
        this.gdsBlgId = gdsBlgId;
    }

    /**
     * 获取货物归属公司名
     *
     * @return Gds_Blg_Nm - 货物归属公司名
     */
    public String getGdsBlgNm() {
        return gdsBlgNm;
    }

    /**
     * 设置货物归属公司名
     *
     * @param gdsBlgNm 货物归属公司名
     */
    public void setGdsBlgNm(String gdsBlgNm) {
        this.gdsBlgNm = gdsBlgNm;
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
     * 获取上游供应商id
     *
     * @return Ustrm_Splr - 上游供应商id
     */
    public Long getUstrmSplr() {
        return ustrmSplr;
    }

    /**
     * 设置上游供应商id
     *
     * @param ustrmSplr 上游供应商id
     */
    public void setUstrmSplr(Long ustrmSplr) {
        this.ustrmSplr = ustrmSplr;
    }

    /**
     * 获取上游供应商公司名
     *
     * @return Ustrm_Splr_Nm - 上游供应商公司名
     */
    public String getUstrmSplrNm() {
        return ustrmSplrNm;
    }

    /**
     * 设置上游供应商公司名
     *
     * @param ustrmSplrNm 上游供应商公司名
     */
    public void setUstrmSplrNm(String ustrmSplrNm) {
        this.ustrmSplrNm = ustrmSplrNm;
    }
}