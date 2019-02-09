package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t11_ivnt_inf")
public class T11IvntInf {
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
     * 运单编号
     */
    @Column(name = "Tprt_Bl_ID")
    private String tprtBlId;

    /**
     * 发货编号
     */
    @Column(name = "Spg_ID")
    private String spgId;

    /**
     * 发货人
     */
    @Column(name = "Spg_Psn")
    private String spgPsn;

    /**
     * 发货联系电话
     */
    @Column(name = "Spg_Ctc_Tel")
    private String spgCtcTel;

    /**
     * 发货备注
     */
    @Column(name = "Spg_Rmrk")
    private String spgRmrk;

    /**
     * 收货人
     */
    @Column(name = "Cnsgn")
    private String cnsgn;

    /**
     * 收货联系电话
     */
    @Column(name = "RcvG_Ctc_Tel")
    private String rcvgCtcTel;

    /**
     * 目的地
     */
    @Column(name = "Pps_Lnd")
    private String ppsLnd;

    /**
     * 生产厂家
     */
    @Column(name = "Pd_Fctr")
    private String pdFctr;

    /**
     * 发货时间
     */
    @Column(name = "Spg_Tm")
    private Date spgTm;

    /**
     * 车辆数目
     */
    @Column(name = "Vhcl_Num")
    private Integer vhclNum;

    /**
     * 运输方式及工具
     */
    @Column(name = "Tprt_Mod_And_Imt")
    private String tprtModAndImt;

    /**
     * 物流公司
     */
    @Column(name = "Lgstc_Co")
    private Integer lgstcCo;

    /**
     * 接货人
     */
    @Column(name = "Rev_Mny_Psn")
    private String revMnyPsn;

    /**
     * 接货联系电话
     */
    @Column(name = "Rev_Mny_Ctc_Tel")
    private String revMnyCtcTel;

    /**
     * 接货时间
     */
    @Column(name = "Rev_Mny_Tm")
    private Date revMnyTm;

    /**
     * 接货备注
     */
    @Column(name = "Rev_Mny_Rmrk")
    private String revMnyRmrk;

    /**
     * 仓储公司
     */
    @Column(name = "StgCo")
    private Integer stgco;

    /**
     * 入库人
     */
    @Column(name = "InTrsr_Psn")
    private String intrsrPsn;

    /**
     * 入库时间
     */
    @Column(name = "InTrsr_Tm")
    private Date intrsrTm;

    /**
     * 入库备注
     */
    @Column(name = "InTrsr_Rmrk")
    private String intrsrRmrk;

    /**
     * 出库时间
     */
    @Column(name = "OutStg_Tm")
    private Date outstgTm;

    /**
     * 质押状态
     */
    @Column(name = "Plg_St")
    private Integer plgSt;

    /**
     * 库位
     */
    @Column(name = "Str_Bit")
    private String strBit;

    /**
     * 仓单编号
     */
    @Column(name = "WhRecpt_ID")
    private String whrecptId;

    /**
     * 库存状态
     */
    @Column(name = "Ivnt_St")
    private String ivntSt;

    /**
     * 质押预警状态代码
     */
    @Column(name = "Plg_Warn_StCd")
    private String plgWarnStcd;

    /**
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 操作员
     */
    private String username;

    /**
     * 自有货物编号
     */
    @Column(name = "SlfOwn_Gds_ID")
    private String slfownGdsId;

    /**
     * 存入人
     */
    @Column(name = "Dep_Psn")
    private String depPsn;

    /**
     * 存入时间
     */
    @Column(name = "Dep_Tm")
    private Date depTm;

    /**
     * 货物归属
     */
    @Column(name = "Gds_Blg")
    private Integer gdsBlg;

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
     * 获取运单编号
     *
     * @return Tprt_Bl_ID - 运单编号
     */
    public String getTprtBlId() {
        return tprtBlId;
    }

    /**
     * 设置运单编号
     *
     * @param tprtBlId 运单编号
     */
    public void setTprtBlId(String tprtBlId) {
        this.tprtBlId = tprtBlId;
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
     * 获取发货联系电话
     *
     * @return Spg_Ctc_Tel - 发货联系电话
     */
    public String getSpgCtcTel() {
        return spgCtcTel;
    }

    /**
     * 设置发货联系电话
     *
     * @param spgCtcTel 发货联系电话
     */
    public void setSpgCtcTel(String spgCtcTel) {
        this.spgCtcTel = spgCtcTel;
    }

    /**
     * 获取发货备注
     *
     * @return Spg_Rmrk - 发货备注
     */
    public String getSpgRmrk() {
        return spgRmrk;
    }

    /**
     * 设置发货备注
     *
     * @param spgRmrk 发货备注
     */
    public void setSpgRmrk(String spgRmrk) {
        this.spgRmrk = spgRmrk;
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
     * 获取收货联系电话
     *
     * @return RcvG_Ctc_Tel - 收货联系电话
     */
    public String getRcvgCtcTel() {
        return rcvgCtcTel;
    }

    /**
     * 设置收货联系电话
     *
     * @param rcvgCtcTel 收货联系电话
     */
    public void setRcvgCtcTel(String rcvgCtcTel) {
        this.rcvgCtcTel = rcvgCtcTel;
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
     * 获取车辆数目
     *
     * @return Vhcl_Num - 车辆数目
     */
    public Integer getVhclNum() {
        return vhclNum;
    }

    /**
     * 设置车辆数目
     *
     * @param vhclNum 车辆数目
     */
    public void setVhclNum(Integer vhclNum) {
        this.vhclNum = vhclNum;
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
     * 获取物流公司
     *
     * @return Lgstc_Co - 物流公司
     */
    public Integer getLgstcCo() {
        return lgstcCo;
    }

    /**
     * 设置物流公司
     *
     * @param lgstcCo 物流公司
     */
    public void setLgstcCo(Integer lgstcCo) {
        this.lgstcCo = lgstcCo;
    }

    /**
     * 获取接货人
     *
     * @return Rev_Mny_Psn - 接货人
     */
    public String getRevMnyPsn() {
        return revMnyPsn;
    }

    /**
     * 设置接货人
     *
     * @param revMnyPsn 接货人
     */
    public void setRevMnyPsn(String revMnyPsn) {
        this.revMnyPsn = revMnyPsn;
    }

    /**
     * 获取接货联系电话
     *
     * @return Rev_Mny_Ctc_Tel - 接货联系电话
     */
    public String getRevMnyCtcTel() {
        return revMnyCtcTel;
    }

    /**
     * 设置接货联系电话
     *
     * @param revMnyCtcTel 接货联系电话
     */
    public void setRevMnyCtcTel(String revMnyCtcTel) {
        this.revMnyCtcTel = revMnyCtcTel;
    }

    /**
     * 获取接货时间
     *
     * @return Rev_Mny_Tm - 接货时间
     */
    public Date getRevMnyTm() {
        return revMnyTm;
    }

    /**
     * 设置接货时间
     *
     * @param revMnyTm 接货时间
     */
    public void setRevMnyTm(Date revMnyTm) {
        this.revMnyTm = revMnyTm;
    }

    /**
     * 获取接货备注
     *
     * @return Rev_Mny_Rmrk - 接货备注
     */
    public String getRevMnyRmrk() {
        return revMnyRmrk;
    }

    /**
     * 设置接货备注
     *
     * @param revMnyRmrk 接货备注
     */
    public void setRevMnyRmrk(String revMnyRmrk) {
        this.revMnyRmrk = revMnyRmrk;
    }

    /**
     * 获取仓储公司
     *
     * @return StgCo - 仓储公司
     */
    public Integer getStgco() {
        return stgco;
    }

    /**
     * 设置仓储公司
     *
     * @param stgco 仓储公司
     */
    public void setStgco(Integer stgco) {
        this.stgco = stgco;
    }

    /**
     * 获取入库人
     *
     * @return InTrsr_Psn - 入库人
     */
    public String getIntrsrPsn() {
        return intrsrPsn;
    }

    /**
     * 设置入库人
     *
     * @param intrsrPsn 入库人
     */
    public void setIntrsrPsn(String intrsrPsn) {
        this.intrsrPsn = intrsrPsn;
    }

    /**
     * 获取入库时间
     *
     * @return InTrsr_Tm - 入库时间
     */
    public Date getIntrsrTm() {
        return intrsrTm;
    }

    /**
     * 设置入库时间
     *
     * @param intrsrTm 入库时间
     */
    public void setIntrsrTm(Date intrsrTm) {
        this.intrsrTm = intrsrTm;
    }

    /**
     * 获取入库备注
     *
     * @return InTrsr_Rmrk - 入库备注
     */
    public String getIntrsrRmrk() {
        return intrsrRmrk;
    }

    /**
     * 设置入库备注
     *
     * @param intrsrRmrk 入库备注
     */
    public void setIntrsrRmrk(String intrsrRmrk) {
        this.intrsrRmrk = intrsrRmrk;
    }

    /**
     * 获取出库时间
     *
     * @return OutStg_Tm - 出库时间
     */
    public Date getOutstgTm() {
        return outstgTm;
    }

    /**
     * 设置出库时间
     *
     * @param outstgTm 出库时间
     */
    public void setOutstgTm(Date outstgTm) {
        this.outstgTm = outstgTm;
    }

    /**
     * 获取质押状态
     *
     * @return Plg_St - 质押状态
     */
    public Integer getPlgSt() {
        return plgSt;
    }

    /**
     * 设置质押状态
     *
     * @param plgSt 质押状态
     */
    public void setPlgSt(Integer plgSt) {
        this.plgSt = plgSt;
    }

    /**
     * 获取库位
     *
     * @return Str_Bit - 库位
     */
    public String getStrBit() {
        return strBit;
    }

    /**
     * 设置库位
     *
     * @param strBit 库位
     */
    public void setStrBit(String strBit) {
        this.strBit = strBit;
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
     * 获取库存状态
     *
     * @return Ivnt_St - 库存状态
     */
    public String getIvntSt() {
        return ivntSt;
    }

    /**
     * 设置库存状态
     *
     * @param ivntSt 库存状态
     */
    public void setIvntSt(String ivntSt) {
        this.ivntSt = ivntSt;
    }

    /**
     * 获取质押预警状态代码
     *
     * @return Plg_Warn_StCd - 质押预警状态代码
     */
    public String getPlgWarnStcd() {
        return plgWarnStcd;
    }

    /**
     * 设置质押预警状态代码
     *
     * @param plgWarnStcd 质押预警状态代码
     */
    public void setPlgWarnStcd(String plgWarnStcd) {
        this.plgWarnStcd = plgWarnStcd;
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
     * 获取自有货物编号
     *
     * @return SlfOwn_Gds_ID - 自有货物编号
     */
    public String getSlfownGdsId() {
        return slfownGdsId;
    }

    /**
     * 设置自有货物编号
     *
     * @param slfownGdsId 自有货物编号
     */
    public void setSlfownGdsId(String slfownGdsId) {
        this.slfownGdsId = slfownGdsId;
    }

    /**
     * 获取存入人
     *
     * @return Dep_Psn - 存入人
     */
    public String getDepPsn() {
        return depPsn;
    }

    /**
     * 设置存入人
     *
     * @param depPsn 存入人
     */
    public void setDepPsn(String depPsn) {
        this.depPsn = depPsn;
    }

    /**
     * 获取存入时间
     *
     * @return Dep_Tm - 存入时间
     */
    public Date getDepTm() {
        return depTm;
    }

    /**
     * 设置存入时间
     *
     * @param depTm 存入时间
     */
    public void setDepTm(Date depTm) {
        this.depTm = depTm;
    }

    /**
     * 获取货物归属
     *
     * @return Gds_Blg - 货物归属
     */
    public Integer getGdsBlg() {
        return gdsBlg;
    }

    /**
     * 设置货物归属
     *
     * @param gdsBlg 货物归属
     */
    public void setGdsBlg(Integer gdsBlg) {
        this.gdsBlg = gdsBlg;
    }
}