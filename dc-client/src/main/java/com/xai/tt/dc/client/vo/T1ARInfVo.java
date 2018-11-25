package com.xai.tt.dc.client.vo;

import java.io.Serializable;
import java.util.Date;

public class T1ARInfVo implements Serializable {
	private static final long serialVersionUID = 1L;
	// 供应链
	private Integer splchain;
	
	public Integer getSplchain() {
		return splchain;
	}
	public void setSplchain(Integer splchain) {
		this.splchain = splchain;
	}
	// ID
	private Integer id;
	// 长约编号
	private String arId;
	// 长约类型
	private String arTp;
	// 采购方
	private String pchPrty;
	// 长约开始日期
	private String arStdt;
	// 长约结束日期
	private String arEddt;
	// 供应商
	private String splr;
	// 提货周期
	private Integer pckupgdsCyc;
	// 协议仓库
	private String agrmStg;
	// 业务类型
	private String btp;
	// 融资比例
	private String fncPctg;
	// 预付金比率
	private String prpyGldRto;
	// 额度
	private String lmt;
	// 警戒线
	private String crdn;
	// 平仓线
	private String clsposLn;
	// 服务费收取方式
	private String svcfeeCmd;
	// 溢短结转方式
	private String splovCrrovMod;
	// 长约状态
	private String arSt;
	// 时间戳
	private Date tms;
	// 创建人
	private String crtPsn;
	// 创建时间
	private Date crtTm;
	// 确认人
	private String cfmPsn;
	// 确认时间
	private Date cfmTm;
	// 一审审核意见
	private String frstinsCkop;
	// 一审审核人
	private String frstinsAdtPsn;
	// 一审审核时间
	private Date frstinsAdtTm;
	// 二审审核意见
	private String sndinscCkop;
	// 二审审核人
	private String sndinsAdtPsn;
	// 二审审核时间
	private Date sndinsAdtTm;
	// 环节信息
	private String aplyPcstpCd;
	
	public String getAplyPcstpCd() {
		return aplyPcstpCd;
	}
	public void setAplyPcstpCd(String aplyPcstpCd) {
		this.aplyPcstpCd = aplyPcstpCd;
	}
	// 排序字段
	private String orderBy;
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArId() {
		return arId;
	}
	public void setArId(String arId) {
		this.arId = arId;
	}
	public String getArTp() {
		return arTp;
	}
	public void setArTp(String arTp) {
		this.arTp = arTp;
	}
	public String getPchPrty() {
		return pchPrty;
	}
	public void setPchPrty(String pchPrty) {
		this.pchPrty = pchPrty;
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
	public String getSplr() {
		return splr;
	}
	public void setSplr(String splr) {
		this.splr = splr;
	}
	public Integer getPckupgdsCyc() {
		return pckupgdsCyc;
	}
	public void setPckupgdsCyc(Integer pckupgdsCyc) {
		this.pckupgdsCyc = pckupgdsCyc;
	}
	public String getAgrmStg() {
		return agrmStg;
	}
	public void setAgrmStg(String agrmStg) {
		this.agrmStg = agrmStg;
	}
	public String getBtp() {
		return btp;
	}
	public void setBtp(String btp) {
		this.btp = btp;
	}
	public String getFncPctg() {
		return fncPctg;
	}
	public void setFncPctg(String fncPctg) {
		this.fncPctg = fncPctg;
	}
	public String getPrpyGldRto() {
		return prpyGldRto;
	}
	public void setPrpyGldRto(String prpyGldRto) {
		this.prpyGldRto = prpyGldRto;
	}
	public String getLmt() {
		return lmt;
	}
	public void setLmt(String lmt) {
		this.lmt = lmt;
	}
	public String getCrdn() {
		return crdn;
	}
	public void setCrdn(String crdn) {
		this.crdn = crdn;
	}
	public String getClsposLn() {
		return clsposLn;
	}
	public void setClsposLn(String clsposLn) {
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
	public String getCfmPsn() {
		return cfmPsn;
	}
	public void setCfmPsn(String cfmPsn) {
		this.cfmPsn = cfmPsn;
	}
	public Date getCfmTm() {
		return cfmTm;
	}
	public void setCfmTm(Date cfmTm) {
		this.cfmTm = cfmTm;
	}
	public String getFrstinsCkop() {
		return frstinsCkop;
	}
	public void setFrstinsCkop(String frstinsCkop) {
		this.frstinsCkop = frstinsCkop;
	}
	public String getFrstinsAdtPsn() {
		return frstinsAdtPsn;
	}
	public void setFrstinsAdtPsn(String frstinsAdtPsn) {
		this.frstinsAdtPsn = frstinsAdtPsn;
	}
	public Date getFrstinsAdtTm() {
		return frstinsAdtTm;
	}
	public void setFrstinsAdtTm(Date frstinsAdtTm) {
		this.frstinsAdtTm = frstinsAdtTm;
	}
	public String getSndinscCkop() {
		return sndinscCkop;
	}
	public void setSndinscCkop(String sndinscCkop) {
		this.sndinscCkop = sndinscCkop;
	}
	public String getSndinsAdtPsn() {
		return sndinsAdtPsn;
	}
	public void setSndinsAdtPsn(String sndinsAdtPsn) {
		this.sndinsAdtPsn = sndinsAdtPsn;
	}
	public Date getSndinsAdtTm() {
		return sndinsAdtTm;
	}
	public void setSndinsAdtTm(Date sndinsAdtTm) {
		this.sndinsAdtTm = sndinsAdtTm;
	}

}
