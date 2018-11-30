package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.xai.tt.dc.client.query.UserInfoQuery;

public class ArManagementInVo extends UserInfoQuery {
	
    /**
     * 是否投保
     */
    private Integer isNeedIns;

    public Integer getIsNeedIns() {
		return isNeedIns;
	}

	public void setIsNeedIns(Integer isNeedIns) {
		this.isNeedIns = isNeedIns;
	}
	
	/**
     * ID
     */
    private Long id;

    /**
     * 长约编号
     */
    private String arId;

    /**
     * 流程实例ID
     */
    private String processInstId;

    /**
     * 长约类型
     */
    private String arTp;

    /**
     * 融资企业
     */
    private Integer fncEntp;

    /**
     * 上游供应商
     */
    private Integer ustrmSplr;

    /**
     * 仓储公司
     */
    private Integer stgco;

    /**
     * 银行
     */
    private Integer bnk;

    /**
     * 物流公司
     */
    private Integer lgstcCo;

    /**
     * 保险公司
     */
    private Integer insCo;

    /**
     * 供应链公司
     */
    private Integer splchainCo;

    /**
     * 长约开始日期
     */
    private String arStdt;

    /**
     * 长约结束日期
     */
    private String arEddt;

    /**
     * 提货周期
     */
    private Integer pckupgdsCyc;

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
    
    // 附件文件名信息
    private String fileNames;

    public String getFileNames() {
        return fileNames;
    }

    public void setFileNames(String fileNames) {
        this.fileNames = fileNames;
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
     * 获取融资企业
     *
     * @return Fnc_Entp - 融资企业
     */
    public Integer getFncEntp() {
        return fncEntp;
    }

    /**
     * 设置融资企业
     *
     * @param fncEntp 融资企业
     */
    public void setFncEntp(Integer fncEntp) {
        this.fncEntp = fncEntp;
    }

    /**
     * 获取上游供应商
     *
     * @return Ustrm_Splr - 上游供应商
     */
    public Integer getUstrmSplr() {
        return ustrmSplr;
    }

    /**
     * 设置上游供应商
     *
     * @param ustrmSplr 上游供应商
     */
    public void setUstrmSplr(Integer ustrmSplr) {
        this.ustrmSplr = ustrmSplr;
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
     * 获取银行
     *
     * @return Bnk - 银行
     */
    public Integer getBnk() {
        return bnk;
    }

    /**
     * 设置银行
     *
     * @param bnk 银行
     */
    public void setBnk(Integer bnk) {
        this.bnk = bnk;
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
     * 获取保险公司
     *
     * @return Ins_Co - 保险公司
     */
    public Integer getInsCo() {
        return insCo;
    }

    /**
     * 设置保险公司
     *
     * @param insCo 保险公司
     */
    public void setInsCo(Integer insCo) {
        this.insCo = insCo;
    }

    /**
     * 获取供应链公司
     *
     * @return SplChain_Co - 供应链公司
     */
    public Integer getSplchainCo() {
        return splchainCo;
    }

    /**
     * 设置供应链公司
     *
     * @param splchainCo 供应链公司
     */
    public void setSplchainCo(Integer splchainCo) {
        this.splchainCo = splchainCo;
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