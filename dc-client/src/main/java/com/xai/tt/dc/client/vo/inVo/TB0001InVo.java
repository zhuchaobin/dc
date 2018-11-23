package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;
import java.util.List;

import com.xai.tt.dc.client.query.UserInfoQuery;

public class TB0001InVo extends UserInfoQuery {
    /**
     * ID
     */
    private Long id;

    /**
     * 长约编号
     */
    private String arId;

    /**
     * 长约类型
     */
    private String arTp;

    /**
     * 采购方
     */
    private String pchPrty;

    /**
     * 长约开始日期
     */
    private String arStdt;

    /**
     * 长约结束日期
     */
    private String arEddt;

    /**
     * 供应商
     */
    private String splr;

    /**
     * 提货周期
     */
    private Integer pckupgdsCyc;

    /**
     * 协议仓库
     */
    private String agrmStg;

    /**
     * 业务类型
     */
    private String btp;

    /**
     * 融资比例
     */
    private Float fncPctg;

    /**
     * 预付金比率
     */
    private Float prpyGldRto;

    /**
     * 额度
     */
    private Float lmt;

    /**
     * 警戒线
     */
    private Float crdn;

    /**
     * 平仓线
     */
    private Float clsposLn;

    /**
     * 服务费收取方式
     */
    private String svcfeeCmd;

    /**
     * 溢短结转方式
     */
    private String splovCrrovMod;

    /**
     * 长约状态
     */
    private String arSt;

    /**
     * 时间戳
     */
    private Date tms;

    /**
     * 创建人
     */
    private String crtPsn;

    /**
     * 创建时间
     */
    private Date crtTm;

    /**
     * 确认人
     */
    private String cfmPsn;

    /**
     * 确认时间
     */
    private Date cfmTm;

    /**
     * 一审审核意见
     */
    private String frstinsCkop;

    /**
     * 一审审核人
     */
    private String frstinsAdtPsn;

    /**
     * 一审审核时间
     */
    private Date frstinsAdtTm;

    /**
     * 二审审核意见
     */
    private String sndinscCkop;

    /**
     * 二审审核人
     */
    private String sndinsAdtPsn;

    /**
     * 二审审核时间
     */
    private Date sndinsAdtTm;

    /**
     * 投保人
     */
    private String plchd;

    /**
     * 投保人地址
     */
    private String plchdAdr;

    /**
     * 被保险人
     */
    private String insrd;

    /**
     * 被保险人地址
     */
    private String insrdAdr;

    /**
     * 第一受益人
     */
    private String fstBenf;

    /**
     * 第一受益人地址
     */
    private String fstBenfAdr;

    /**
     * 保险财产地址
     */
    private String insPtyAdr;

    /**
     * 保险标的名称
     */
    private String insObjNm;

    /**
     * 保险金额
     */
    private Float insAmt;

    /**
     * 免赔额
     */
    private Float dctbAmt;

    /**
     * 特别约定
     */
    private String epap;

    /**
     * 保险开始日期
     */
    private String insStdt;

    /**
     * 保险结束日期
     */
    private String insEddt;
    
    /**
     * 长约附件信息
     */
    private List<TB0001SubInVo> list;
    
    /**
     * 结果排序
     */
    private String orderBy;
        
	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<TB0001SubInVo> getList() {
		return list;
	}

	public void setList(List<TB0001SubInVo> list) {
		this.list = list;
	}

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
     * 获取长约编号
     *
     * @return AR_ID - 长约编号
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
     * 获取长约类型
     *
     * @return AR_Tp - 长约类型
     */
    public String getArTp() {
        return arTp;
    }

    /**
     * 设置长约类型
     *
     * @param arTp 长约类型
     */
    public void setArTp(String arTp) {
        this.arTp = arTp;
    }

    /**
     * 获取采购方
     *
     * @return Pch_Prty - 采购方
     */
    public String getPchPrty() {
        return pchPrty;
    }

    /**
     * 设置采购方
     *
     * @param pchPrty 采购方
     */
    public void setPchPrty(String pchPrty) {
        this.pchPrty = pchPrty;
    }

    /**
     * 获取长约开始日期
     *
     * @return AR_StDt - 长约开始日期
     */
    public String getArStdt() {
        return arStdt;
    }

    /**
     * 设置长约开始日期
     *
     * @param arStdt 长约开始日期
     */
    public void setArStdt(String arStdt) {
        this.arStdt = arStdt;
    }

    /**
     * 获取长约结束日期
     *
     * @return AR_EdDt - 长约结束日期
     */
    public String getArEddt() {
        return arEddt;
    }

    /**
     * 设置长约结束日期
     *
     * @param arEddt 长约结束日期
     */
    public void setArEddt(String arEddt) {
        this.arEddt = arEddt;
    }

    /**
     * 获取供应商
     *
     * @return Splr - 供应商
     */
    public String getSplr() {
        return splr;
    }

    /**
     * 设置供应商
     *
     * @param splr 供应商
     */
    public void setSplr(String splr) {
        this.splr = splr;
    }

    /**
     * 获取提货周期
     *
     * @return PckUpGds_Cyc - 提货周期
     */
    public Integer getPckupgdsCyc() {
        return pckupgdsCyc;
    }

    /**
     * 设置提货周期
     *
     * @param pckupgdsCyc 提货周期
     */
    public void setPckupgdsCyc(Integer pckupgdsCyc) {
        this.pckupgdsCyc = pckupgdsCyc;
    }

    /**
     * 获取协议仓库
     *
     * @return Agrm_Stg - 协议仓库
     */
    public String getAgrmStg() {
        return agrmStg;
    }

    /**
     * 设置协议仓库
     *
     * @param agrmStg 协议仓库
     */
    public void setAgrmStg(String agrmStg) {
        this.agrmStg = agrmStg;
    }

    /**
     * 获取业务类型
     *
     * @return BTp - 业务类型
     */
    public String getBtp() {
        return btp;
    }

    /**
     * 设置业务类型
     *
     * @param btp 业务类型
     */
    public void setBtp(String btp) {
        this.btp = btp;
    }

    /**
     * 获取融资比例
     *
     * @return Fnc_Pctg - 融资比例
     */
    public Float getFncPctg() {
        return fncPctg;
    }

    /**
     * 设置融资比例
     *
     * @param fncPctg 融资比例
     */
    public void setFncPctg(Float fncPctg) {
        this.fncPctg = fncPctg;
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
     * 获取额度
     *
     * @return Lmt - 额度
     */
    public Float getLmt() {
        return lmt;
    }

    /**
     * 设置额度
     *
     * @param lmt 额度
     */
    public void setLmt(Float lmt) {
        this.lmt = lmt;
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
     * 获取服务费收取方式
     *
     * @return SvcFee_CMd - 服务费收取方式
     */
    public String getSvcfeeCmd() {
        return svcfeeCmd;
    }

    /**
     * 设置服务费收取方式
     *
     * @param svcfeeCmd 服务费收取方式
     */
    public void setSvcfeeCmd(String svcfeeCmd) {
        this.svcfeeCmd = svcfeeCmd;
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
     * 获取长约状态
     *
     * @return AR_St - 长约状态
     */
    public String getArSt() {
        return arSt;
    }

    /**
     * 设置长约状态
     *
     * @param arSt 长约状态
     */
    public void setArSt(String arSt) {
        this.arSt = arSt;
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
     * 获取创建人
     *
     * @return Crt_Psn - 创建人
     */
    public String getCrtPsn() {
        return crtPsn;
    }

    /**
     * 设置创建人
     *
     * @param crtPsn 创建人
     */
    public void setCrtPsn(String crtPsn) {
        this.crtPsn = crtPsn;
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
     * 获取确认人
     *
     * @return Cfm_Psn - 确认人
     */
    public String getCfmPsn() {
        return cfmPsn;
    }

    /**
     * 设置确认人
     *
     * @param cfmPsn 确认人
     */
    public void setCfmPsn(String cfmPsn) {
        this.cfmPsn = cfmPsn;
    }

    /**
     * 获取确认时间
     *
     * @return Cfm_Tm - 确认时间
     */
    public Date getCfmTm() {
        return cfmTm;
    }

    /**
     * 设置确认时间
     *
     * @param cfmTm 确认时间
     */
    public void setCfmTm(Date cfmTm) {
        this.cfmTm = cfmTm;
    }

    /**
     * 获取一审审核意见
     *
     * @return FrstIns_CkOp - 一审审核意见
     */
    public String getFrstinsCkop() {
        return frstinsCkop;
    }

    /**
     * 设置一审审核意见
     *
     * @param frstinsCkop 一审审核意见
     */
    public void setFrstinsCkop(String frstinsCkop) {
        this.frstinsCkop = frstinsCkop;
    }

    /**
     * 获取一审审核人
     *
     * @return FrstIns_Adt_Psn - 一审审核人
     */
    public String getFrstinsAdtPsn() {
        return frstinsAdtPsn;
    }

    /**
     * 设置一审审核人
     *
     * @param frstinsAdtPsn 一审审核人
     */
    public void setFrstinsAdtPsn(String frstinsAdtPsn) {
        this.frstinsAdtPsn = frstinsAdtPsn;
    }

    /**
     * 获取一审审核时间
     *
     * @return FrstIns_Adt_Tm - 一审审核时间
     */
    public Date getFrstinsAdtTm() {
        return frstinsAdtTm;
    }

    /**
     * 设置一审审核时间
     *
     * @param frstinsAdtTm 一审审核时间
     */
    public void setFrstinsAdtTm(Date frstinsAdtTm) {
        this.frstinsAdtTm = frstinsAdtTm;
    }

    /**
     * 获取二审审核意见
     *
     * @return SndInsc_CkOp - 二审审核意见
     */
    public String getSndinscCkop() {
        return sndinscCkop;
    }

    /**
     * 设置二审审核意见
     *
     * @param sndinscCkop 二审审核意见
     */
    public void setSndinscCkop(String sndinscCkop) {
        this.sndinscCkop = sndinscCkop;
    }

    /**
     * 获取二审审核人
     *
     * @return SndIns_Adt_Psn - 二审审核人
     */
    public String getSndinsAdtPsn() {
        return sndinsAdtPsn;
    }

    /**
     * 设置二审审核人
     *
     * @param sndinsAdtPsn 二审审核人
     */
    public void setSndinsAdtPsn(String sndinsAdtPsn) {
        this.sndinsAdtPsn = sndinsAdtPsn;
    }

    /**
     * 获取二审审核时间
     *
     * @return SndIns_Adt_Tm - 二审审核时间
     */
    public Date getSndinsAdtTm() {
        return sndinsAdtTm;
    }

    /**
     * 设置二审审核时间
     *
     * @param sndinsAdtTm 二审审核时间
     */
    public void setSndinsAdtTm(Date sndinsAdtTm) {
        this.sndinsAdtTm = sndinsAdtTm;
    }

    /**
     * 获取投保人
     *
     * @return Plchd - 投保人
     */
    public String getPlchd() {
        return plchd;
    }

    /**
     * 设置投保人
     *
     * @param plchd 投保人
     */
    public void setPlchd(String plchd) {
        this.plchd = plchd;
    }

    /**
     * 获取投保人地址
     *
     * @return Plchd_Adr - 投保人地址
     */
    public String getPlchdAdr() {
        return plchdAdr;
    }

    /**
     * 设置投保人地址
     *
     * @param plchdAdr 投保人地址
     */
    public void setPlchdAdr(String plchdAdr) {
        this.plchdAdr = plchdAdr;
    }

    /**
     * 获取被保险人
     *
     * @return Insrd - 被保险人
     */
    public String getInsrd() {
        return insrd;
    }

    /**
     * 设置被保险人
     *
     * @param insrd 被保险人
     */
    public void setInsrd(String insrd) {
        this.insrd = insrd;
    }

    /**
     * 获取被保险人地址
     *
     * @return Insrd_Adr - 被保险人地址
     */
    public String getInsrdAdr() {
        return insrdAdr;
    }

    /**
     * 设置被保险人地址
     *
     * @param insrdAdr 被保险人地址
     */
    public void setInsrdAdr(String insrdAdr) {
        this.insrdAdr = insrdAdr;
    }

    /**
     * 获取第一受益人
     *
     * @return Fst_Benf - 第一受益人
     */
    public String getFstBenf() {
        return fstBenf;
    }

    /**
     * 设置第一受益人
     *
     * @param fstBenf 第一受益人
     */
    public void setFstBenf(String fstBenf) {
        this.fstBenf = fstBenf;
    }

    /**
     * 获取第一受益人地址
     *
     * @return Fst_Benf_Adr - 第一受益人地址
     */
    public String getFstBenfAdr() {
        return fstBenfAdr;
    }

    /**
     * 设置第一受益人地址
     *
     * @param fstBenfAdr 第一受益人地址
     */
    public void setFstBenfAdr(String fstBenfAdr) {
        this.fstBenfAdr = fstBenfAdr;
    }

    /**
     * 获取保险财产地址
     *
     * @return Ins_Pty_Adr - 保险财产地址
     */
    public String getInsPtyAdr() {
        return insPtyAdr;
    }

    /**
     * 设置保险财产地址
     *
     * @param insPtyAdr 保险财产地址
     */
    public void setInsPtyAdr(String insPtyAdr) {
        this.insPtyAdr = insPtyAdr;
    }

    /**
     * 获取保险标的名称
     *
     * @return Ins_Obj_Nm - 保险标的名称
     */
    public String getInsObjNm() {
        return insObjNm;
    }

    /**
     * 设置保险标的名称
     *
     * @param insObjNm 保险标的名称
     */
    public void setInsObjNm(String insObjNm) {
        this.insObjNm = insObjNm;
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
     * 获取保险开始日期
     *
     * @return Ins_StDt - 保险开始日期
     */
    public String getInsStdt() {
        return insStdt;
    }

    /**
     * 设置保险开始日期
     *
     * @param insStdt 保险开始日期
     */
    public void setInsStdt(String insStdt) {
        this.insStdt = insStdt;
    }

    /**
     * 获取保险结束日期
     *
     * @return Ins_EdDt - 保险结束日期
     */
    public String getInsEddt() {
        return insEddt;
    }

    /**
     * 设置保险结束日期
     *
     * @param insEddt 保险结束日期
     */
    public void setInsEddt(String insEddt) {
        this.insEddt = insEddt;
    }
}