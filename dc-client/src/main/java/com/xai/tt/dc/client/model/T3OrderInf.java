package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t3_order_inf")
public class T3OrderInf {
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
     * 订单开始日期
     */
    @Column(name = "Ordr_StDt")
    private String ordrStdt;

    /**
     * 订单结束日期
     */
    @Column(name = "Ordr_EdDt")
    private String ordrEddt;

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
     * 重量
     */
    @Column(name = "Wght")
    private Float wght;

    /**
     * 采购货款总额
     */
    @Column(name = "Pch_PymFrGds_TAmt")
    private Float pchPymfrgdsTamt;

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
     * 融资比率
     */
    @Column(name = "Fnc_Rto")
    private Float fncRto;

    /**
     * 融资金额
     */
    @Column(name = "Fnc_Amt")
    private Float fncAmt;

    /**
     * 合同总额
     */
    @Column(name = "Ctr_TAmt")
    private Float ctrTamt;

    /**
     * 预付金比率
     */
    @Column(name = "Prpy_Gld_Rto")
    private Float prpyGldRto;

    /**
     * 风控单价
     */
    @Column(name = "Rskctr_UnitPrc")
    private Float rskctrUnitprc;

    /**
     * 风控价格参考
     */
    @Column(name = "Rskctr_Prc_Ref")
    private String rskctrPrcRef;

    /**
     * 预警线
     */
    @Column(name = "WnLn")
    private Float wnln;

    /**
     * 警戒线
     */
    @Column(name = "Crdn")
    private Float crdn;

    /**
     * 平仓线
     */
    @Column(name = "Clspos_Ln")
    private Float clsposLn;

    /**
     * 溢短结转方式
     */
    @Column(name = "SplOv_CrrOv_Mod")
    private String splovCrrovMod;

    /**
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 订单状态
     */
    @Column(name = "Ordr_St")
    private String ordrSt;

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
     * 融资服务费率
     */
    @Column(name = "Fnc_SvcFee_Rate")
    private Float fncSvcfeeRate;

    /**
     * 货物名称
     */
    @Column(name = "Gds_Nm")
    private String gdsNm;

    /**
     * 货物件数
     */
    @Column(name = "Gds_Pts_Num")
    private Integer gdsPtsNum;

    /**
     * 货物重量
     */
    @Column(name = "Gds_Wght")
    private Float gdsWght;

    /**
     * 保险金额
     */
    @Column(name = "Ins_Amt")
    private Float insAmt;

    /**
     * 免赔额
     */
    @Column(name = "Dctb_Amt")
    private Float dctbAmt;

    /**
     * 特别约定
     */
    @Column(name = "EpAp")
    private String epap;

    /**
     * 起运日期
     */
    @Column(name = "Tprt_Dt")
    private String tprtDt;

    /**
     * 目的地
     */
    @Column(name = "Pps_Lnd")
    private String ppsLnd;

    /**
     * 运输方式及工具
     */
    @Column(name = "Tprt_Mod_And_Imt")
    private String tprtModAndImt;

    /**
     * 付款方式
     */
    @Column(name = "PymtMod")
    private String pymtmod;

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
     * 获取订单开始日期
     *
     * @return Ordr_StDt - 订单开始日期
     */
    public String getOrdrStdt() {
        return ordrStdt;
    }

    /**
     * 设置订单开始日期
     *
     * @param ordrStdt 订单开始日期
     */
    public void setOrdrStdt(String ordrStdt) {
        this.ordrStdt = ordrStdt;
    }

    /**
     * 获取订单结束日期
     *
     * @return Ordr_EdDt - 订单结束日期
     */
    public String getOrdrEddt() {
        return ordrEddt;
    }

    /**
     * 设置订单结束日期
     *
     * @param ordrEddt 订单结束日期
     */
    public void setOrdrEddt(String ordrEddt) {
        this.ordrEddt = ordrEddt;
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
     * 获取重量
     *
     * @return Wght - 重量
     */
    public Float getWght() {
        return wght;
    }

    /**
     * 设置重量
     *
     * @param wght 重量
     */
    public void setWght(Float wght) {
        this.wght = wght;
    }

    /**
     * 获取采购货款总额
     *
     * @return Pch_PymFrGds_TAmt - 采购货款总额
     */
    public Float getPchPymfrgdsTamt() {
        return pchPymfrgdsTamt;
    }

    /**
     * 设置采购货款总额
     *
     * @param pchPymfrgdsTamt 采购货款总额
     */
    public void setPchPymfrgdsTamt(Float pchPymfrgdsTamt) {
        this.pchPymfrgdsTamt = pchPymfrgdsTamt;
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
     * 获取融资比率
     *
     * @return Fnc_Rto - 融资比率
     */
    public Float getFncRto() {
        return fncRto;
    }

    /**
     * 设置融资比率
     *
     * @param fncRto 融资比率
     */
    public void setFncRto(Float fncRto) {
        this.fncRto = fncRto;
    }

    /**
     * 获取融资金额
     *
     * @return Fnc_Amt - 融资金额
     */
    public Float getFncAmt() {
        return fncAmt;
    }

    /**
     * 设置融资金额
     *
     * @param fncAmt 融资金额
     */
    public void setFncAmt(Float fncAmt) {
        this.fncAmt = fncAmt;
    }

    /**
     * 获取合同总额
     *
     * @return Ctr_TAmt - 合同总额
     */
    public Float getCtrTamt() {
        return ctrTamt;
    }

    /**
     * 设置合同总额
     *
     * @param ctrTamt 合同总额
     */
    public void setCtrTamt(Float ctrTamt) {
        this.ctrTamt = ctrTamt;
    }

    /**
     * 获取预付金比率
     *
     * @return Prpy_Gld_Rto - 预付金比率
     */
    public Float getPrpyGldRto() {
        return prpyGldRto;
    }

    /**
     * 设置预付金比率
     *
     * @param prpyGldRto 预付金比率
     */
    public void setPrpyGldRto(Float prpyGldRto) {
        this.prpyGldRto = prpyGldRto;
    }

    /**
     * 获取风控单价
     *
     * @return Rskctr_UnitPrc - 风控单价
     */
    public Float getRskctrUnitprc() {
        return rskctrUnitprc;
    }

    /**
     * 设置风控单价
     *
     * @param rskctrUnitprc 风控单价
     */
    public void setRskctrUnitprc(Float rskctrUnitprc) {
        this.rskctrUnitprc = rskctrUnitprc;
    }

    /**
     * 获取风控价格参考
     *
     * @return Rskctr_Prc_Ref - 风控价格参考
     */
    public String getRskctrPrcRef() {
        return rskctrPrcRef;
    }

    /**
     * 设置风控价格参考
     *
     * @param rskctrPrcRef 风控价格参考
     */
    public void setRskctrPrcRef(String rskctrPrcRef) {
        this.rskctrPrcRef = rskctrPrcRef;
    }

    /**
     * 获取预警线
     *
     * @return WnLn - 预警线
     */
    public Float getWnln() {
        return wnln;
    }

    /**
     * 设置预警线
     *
     * @param wnln 预警线
     */
    public void setWnln(Float wnln) {
        this.wnln = wnln;
    }

    /**
     * 获取警戒线
     *
     * @return Crdn - 警戒线
     */
    public Float getCrdn() {
        return crdn;
    }

    /**
     * 设置警戒线
     *
     * @param crdn 警戒线
     */
    public void setCrdn(Float crdn) {
        this.crdn = crdn;
    }

    /**
     * 获取平仓线
     *
     * @return Clspos_Ln - 平仓线
     */
    public Float getClsposLn() {
        return clsposLn;
    }

    /**
     * 设置平仓线
     *
     * @param clsposLn 平仓线
     */
    public void setClsposLn(Float clsposLn) {
        this.clsposLn = clsposLn;
    }

    /**
     * 获取溢短结转方式
     *
     * @return SplOv_CrrOv_Mod - 溢短结转方式
     */
    public String getSplovCrrovMod() {
        return splovCrrovMod;
    }

    /**
     * 设置溢短结转方式
     *
     * @param splovCrrovMod 溢短结转方式
     */
    public void setSplovCrrovMod(String splovCrrovMod) {
        this.splovCrrovMod = splovCrrovMod;
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
     * 获取订单状态
     *
     * @return Ordr_St - 订单状态
     */
    public String getOrdrSt() {
        return ordrSt;
    }

    /**
     * 设置订单状态
     *
     * @param ordrSt 订单状态
     */
    public void setOrdrSt(String ordrSt) {
        this.ordrSt = ordrSt;
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
     * 获取融资服务费率
     *
     * @return Fnc_SvcFee_Rate - 融资服务费率
     */
    public Float getFncSvcfeeRate() {
        return fncSvcfeeRate;
    }

    /**
     * 设置融资服务费率
     *
     * @param fncSvcfeeRate 融资服务费率
     */
    public void setFncSvcfeeRate(Float fncSvcfeeRate) {
        this.fncSvcfeeRate = fncSvcfeeRate;
    }

    /**
     * 获取货物名称
     *
     * @return Gds_Nm - 货物名称
     */
    public String getGdsNm() {
        return gdsNm;
    }

    /**
     * 设置货物名称
     *
     * @param gdsNm 货物名称
     */
    public void setGdsNm(String gdsNm) {
        this.gdsNm = gdsNm;
    }

    /**
     * 获取货物件数
     *
     * @return Gds_Pts_Num - 货物件数
     */
    public Integer getGdsPtsNum() {
        return gdsPtsNum;
    }

    /**
     * 设置货物件数
     *
     * @param gdsPtsNum 货物件数
     */
    public void setGdsPtsNum(Integer gdsPtsNum) {
        this.gdsPtsNum = gdsPtsNum;
    }

    /**
     * 获取货物重量
     *
     * @return Gds_Wght - 货物重量
     */
    public Float getGdsWght() {
        return gdsWght;
    }

    /**
     * 设置货物重量
     *
     * @param gdsWght 货物重量
     */
    public void setGdsWght(Float gdsWght) {
        this.gdsWght = gdsWght;
    }

    /**
     * 获取保险金额
     *
     * @return Ins_Amt - 保险金额
     */
    public Float getInsAmt() {
        return insAmt;
    }

    /**
     * 设置保险金额
     *
     * @param insAmt 保险金额
     */
    public void setInsAmt(Float insAmt) {
        this.insAmt = insAmt;
    }

    /**
     * 获取免赔额
     *
     * @return Dctb_Amt - 免赔额
     */
    public Float getDctbAmt() {
        return dctbAmt;
    }

    /**
     * 设置免赔额
     *
     * @param dctbAmt 免赔额
     */
    public void setDctbAmt(Float dctbAmt) {
        this.dctbAmt = dctbAmt;
    }

    /**
     * 获取特别约定
     *
     * @return EpAp - 特别约定
     */
    public String getEpap() {
        return epap;
    }

    /**
     * 设置特别约定
     *
     * @param epap 特别约定
     */
    public void setEpap(String epap) {
        this.epap = epap;
    }

    /**
     * 获取起运日期
     *
     * @return Tprt_Dt - 起运日期
     */
    public String getTprtDt() {
        return tprtDt;
    }

    /**
     * 设置起运日期
     *
     * @param tprtDt 起运日期
     */
    public void setTprtDt(String tprtDt) {
        this.tprtDt = tprtDt;
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
     * 获取运输方式及工具
     *
     * @return Tprt_Mod_And_Imt - 运输方式及工具
     */
    public String getTprtModAndImt() {
        return tprtModAndImt;
    }

    /**
     * 设置运输方式及工具
     *
     * @param tprtModAndImt 运输方式及工具
     */
    public void setTprtModAndImt(String tprtModAndImt) {
        this.tprtModAndImt = tprtModAndImt;
    }

    /**
     * 获取付款方式
     *
     * @return PymtMod - 付款方式
     */
    public String getPymtmod() {
        return pymtmod;
    }

    /**
     * 设置付款方式
     *
     * @param pymtmod 付款方式
     */
    public void setPymtmod(String pymtmod) {
        this.pymtmod = pymtmod;
    }
}