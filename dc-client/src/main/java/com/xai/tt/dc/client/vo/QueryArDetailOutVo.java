package com.xai.tt.dc.client.vo;

import java.io.Serializable;
import java.util.Date;

public class QueryArDetailOutVo implements Serializable {
	private static final long serialVersionUID = 1L;
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
	// 环节信息
	private String aplyPcstpCd;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArId() {
		return arId;
	}
	public void setArId(String arId) {
		this.arId = arId;
	}
	public String getProcessInstId() {
		return processInstId;
	}
	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}
	public String getArTp() {
		return arTp;
	}
	public void setArTp(String arTp) {
		this.arTp = arTp;
	}
	public Integer getFncEntp() {
		return fncEntp;
	}
	public void setFncEntp(Integer fncEntp) {
		this.fncEntp = fncEntp;
	}
	public Integer getUstrmSplr() {
		return ustrmSplr;
	}
	public void setUstrmSplr(Integer ustrmSplr) {
		this.ustrmSplr = ustrmSplr;
	}
	public Integer getStgco() {
		return stgco;
	}
	public void setStgco(Integer stgco) {
		this.stgco = stgco;
	}
	public Integer getBnk() {
		return bnk;
	}
	public void setBnk(Integer bnk) {
		this.bnk = bnk;
	}
	public Integer getLgstcCo() {
		return lgstcCo;
	}
	public void setLgstcCo(Integer lgstcCo) {
		this.lgstcCo = lgstcCo;
	}
	public Integer getInsCo() {
		return insCo;
	}
	public void setInsCo(Integer insCo) {
		this.insCo = insCo;
	}
	public Integer getSplchainCo() {
		return splchainCo;
	}
	public void setSplchainCo(Integer splchainCo) {
		this.splchainCo = splchainCo;
	}
	public String getArStdt() {
		return arStdt;
	}
	public void setArStdt(String arStdt) {
		this.arStdt = arStdt;
	}
	public String getArEddt() {
		return arEddt;
	}
	public void setArEddt(String arEddt) {
		this.arEddt = arEddt;
	}
	public Integer getPckupgdsCyc() {
		return pckupgdsCyc;
	}
	public void setPckupgdsCyc(Integer pckupgdsCyc) {
		this.pckupgdsCyc = pckupgdsCyc;
	}
	public String getBtp() {
		return btp;
	}
	public void setBtp(String btp) {
		this.btp = btp;
	}
	public Float getFncPctg() {
		return fncPctg;
	}
	public void setFncPctg(Float fncPctg) {
		this.fncPctg = fncPctg;
	}
	public Float getPrpyGldRto() {
		return prpyGldRto;
	}
	public void setPrpyGldRto(Float prpyGldRto) {
		this.prpyGldRto = prpyGldRto;
	}
	public Float getLmt() {
		return lmt;
	}
	public void setLmt(Float lmt) {
		this.lmt = lmt;
	}
	public Float getCrdn() {
		return crdn;
	}
	public void setCrdn(Float crdn) {
		this.crdn = crdn;
	}
	public Float getClsposLn() {
		return clsposLn;
	}
	public void setClsposLn(Float clsposLn) {
		this.clsposLn = clsposLn;
	}
	public String getSvcfeeCmd() {
		return svcfeeCmd;
	}
	public void setSvcfeeCmd(String svcfeeCmd) {
		this.svcfeeCmd = svcfeeCmd;
	}
	public String getSplovCrrovMod() {
		return splovCrrovMod;
	}
	public void setSplovCrrovMod(String splovCrrovMod) {
		this.splovCrrovMod = splovCrrovMod;
	}
	public String getArSt() {
		return arSt;
	}
	public void setArSt(String arSt) {
		this.arSt = arSt;
	}
	public Date getTms() {
		return tms;
	}
	public void setTms(Date tms) {
		this.tms = tms;
	}
	public String getCrtPsn() {
		return crtPsn;
	}
	public void setCrtPsn(String crtPsn) {
		this.crtPsn = crtPsn;
	}
	public Date getCrtTm() {
		return crtTm;
	}
	public void setCrtTm(Date crtTm) {
		this.crtTm = crtTm;
	}
	public String getPlchd() {
		return plchd;
	}
	public void setPlchd(String plchd) {
		this.plchd = plchd;
	}
	public String getPlchdAdr() {
		return plchdAdr;
	}
	public void setPlchdAdr(String plchdAdr) {
		this.plchdAdr = plchdAdr;
	}
	public String getInsrd() {
		return insrd;
	}
	public void setInsrd(String insrd) {
		this.insrd = insrd;
	}
	public String getInsrdAdr() {
		return insrdAdr;
	}
	public void setInsrdAdr(String insrdAdr) {
		this.insrdAdr = insrdAdr;
	}
	public String getFstBenf() {
		return fstBenf;
	}
	public void setFstBenf(String fstBenf) {
		this.fstBenf = fstBenf;
	}
	public String getFstBenfAdr() {
		return fstBenfAdr;
	}
	public void setFstBenfAdr(String fstBenfAdr) {
		this.fstBenfAdr = fstBenfAdr;
	}
	public String getInsPtyAdr() {
		return insPtyAdr;
	}
	public void setInsPtyAdr(String insPtyAdr) {
		this.insPtyAdr = insPtyAdr;
	}
	public String getInsObjNm() {
		return insObjNm;
	}
	public void setInsObjNm(String insObjNm) {
		this.insObjNm = insObjNm;
	}
	public Float getInsAmt() {
		return insAmt;
	}
	public void setInsAmt(Float insAmt) {
		this.insAmt = insAmt;
	}
	public Float getDctbAmt() {
		return dctbAmt;
	}
	public void setDctbAmt(Float dctbAmt) {
		this.dctbAmt = dctbAmt;
	}
	public String getEpap() {
		return epap;
	}
	public void setEpap(String epap) {
		this.epap = epap;
	}
	public String getInsStdt() {
		return insStdt;
	}
	public void setInsStdt(String insStdt) {
		this.insStdt = insStdt;
	}
	public String getInsEddt() {
		return insEddt;
	}
	public void setInsEddt(String insEddt) {
		this.insEddt = insEddt;
	}
	public String getAplyPcstpCd() {
		return aplyPcstpCd;
	}
	public void setAplyPcstpCd(String aplyPcstpCd) {
		this.aplyPcstpCd = aplyPcstpCd;
	}
}
