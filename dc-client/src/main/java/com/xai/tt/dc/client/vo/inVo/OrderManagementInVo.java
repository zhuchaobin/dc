package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.xai.tt.dc.client.model.T8OrderDetail;
import com.xai.tt.dc.client.query.UserInfoQuery;

public class OrderManagementInVo extends UserInfoQuery {
	
	/**
     * 全字段模糊检索关键字
     */
	private String keyWorlds;
	
    public String getKeyWorlds() {
		return keyWorlds;
	}

	public void setKeyWorlds(String keyWorlds) {
		this.keyWorlds = keyWorlds;
	}
	// 订单明细信息
	List<T8OrderDetail> t8OrderDetailList;
	
	
	public List<T8OrderDetail> getT8OrderDetailList() {
		return t8OrderDetailList;
	}

	public void setT8OrderDetailList(List<T8OrderDetail> t8OrderDetailList) {
		this.t8OrderDetailList = t8OrderDetailList;
	}
	
	/**
     * 合同编号
     */
    private String ctrId;
    

	public String getCtrId() {
		return ctrId;
	}

	public void setCtrId(String ctrId) {
		this.ctrId = ctrId;
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
     * 订单编号
     */
    private String ordrId;

    /**
     * 品名
     */
    private String pdNm;

    /**
     * 规格
     */
    private String spec;

    /**
     * 质量标准
     */
    private String qlyStd;

    /**
     * 品牌
     */
    private String brnd;

    /**
     * 订单开始日期
     */
    private String ordrStdt;

    /**
     * 订单结束日期
     */
    private String ordrEddt;

    /**
     * 生产厂家
     */
    private String pdFctr;

    /**
     * 采购单价
     */
    private Float pchUnitprc;

    /**
     * 重量
     */
    private Float wght;

    /**
     * 采购货款总额
     */
    private Float pchPymfrgdsTamt;

    /**
     * 交易差价
     */
    private Float txnPrcdif;

    /**
     * 销售暂定价
     */
    private Float saleTntvPrc;

    /**
     * 融资比率
     */
    private Float fncRto;

    /**
     * 融资金额
     */
    private Float fncAmt;

    /**
     * 合同总额
     */
    private Float ctrTamt;

    /**
     * 预付金比率
     */
    private Float prpyGldRto;

    /**
     * 风控单价
     */
    private Float rskctrUnitprc;

    /**
     * 风控价格参考
     */
    private String rskctrPrcRef;

    /**
     * 预警线
     */
    private Float wnln;

    /**
     * 警戒线
     */
    private Float crdn;

    /**
     * 平仓线
     */
    private Float clsposLn;

    /**
     * 溢短结转方式
     */
    private String splovCrrovMod;

    /**
     * 时间戳
     */
    private Date tms;

    /**
     * 订单状态
     */
    private String ordrSt;

    /**
     * 操作员
     */
    private String username;

    /**
     * 创建时间
     */
    private Date crtTm;

    /**
     * 融资服务费率
     */
    private Float fncSvcfeeRate;

    /**
     * 货物名称
     */
    private String gdsNm;

    /**
     * 货物件数
     */
    private Integer gdsPtsNum;

    /**
     * 货物重量
     */
    private Float gdsWght;

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
     * 起运日期
     */
    private String tprtDt;

    /**
     * 目的地
     */
    private String ppsLnd;

    /**
     * 运输方式及工具
     */
    private String tprtModAndImt;

    /**
     * 付款方式
     */
    private String pymtmod;
    
    /**
     * 流程实例ID
     */
    private String processInstId;
  
    
    public String getProcessInstId() {
		return processInstId;
	}

	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}

	// 附件文件名信息
    private String fileNames;
    
    // 待删除附件文件名信息（修改长约）
    private String filesToDelete;
    
    // 查询类型
    private Integer queryType;
    
    // 二级服务码
    private String secSrvCd;

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

	public String getOrdrId() {
		return ordrId;
	}

	public void setOrdrId(String ordrId) {
		this.ordrId = ordrId;
	}

	public String getPdNm() {
		return pdNm;
	}

	public void setPdNm(String pdNm) {
		this.pdNm = pdNm;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getQlyStd() {
		return qlyStd;
	}

	public void setQlyStd(String qlyStd) {
		this.qlyStd = qlyStd;
	}

	public String getBrnd() {
		return brnd;
	}

	public void setBrnd(String brnd) {
		this.brnd = brnd;
	}

	public String getOrdrStdt() {
		return ordrStdt;
	}

	public void setOrdrStdt(String ordrStdt) {
		this.ordrStdt = ordrStdt;
	}

	public String getOrdrEddt() {
		return ordrEddt;
	}

	public void setOrdrEddt(String ordrEddt) {
		this.ordrEddt = ordrEddt;
	}

	public String getPdFctr() {
		return pdFctr;
	}

	public void setPdFctr(String pdFctr) {
		this.pdFctr = pdFctr;
	}

	public Float getPchUnitprc() {
		return pchUnitprc;
	}

	public void setPchUnitprc(Float pchUnitprc) {
		this.pchUnitprc = pchUnitprc;
	}

	public Float getWght() {
		return wght;
	}

	public void setWght(Float wght) {
		this.wght = wght;
	}

	public Float getPchPymfrgdsTamt() {
		return pchPymfrgdsTamt;
	}

	public void setPchPymfrgdsTamt(Float pchPymfrgdsTamt) {
		this.pchPymfrgdsTamt = pchPymfrgdsTamt;
	}

	public Float getTxnPrcdif() {
		return txnPrcdif;
	}

	public void setTxnPrcdif(Float txnPrcdif) {
		this.txnPrcdif = txnPrcdif;
	}

	public Float getSaleTntvPrc() {
		return saleTntvPrc;
	}

	public void setSaleTntvPrc(Float saleTntvPrc) {
		this.saleTntvPrc = saleTntvPrc;
	}

	public Float getFncRto() {
		return fncRto;
	}

	public void setFncRto(Float fncRto) {
		this.fncRto = fncRto;
	}

	public Float getFncAmt() {
		return fncAmt;
	}

	public void setFncAmt(Float fncAmt) {
		this.fncAmt = fncAmt;
	}

	public Float getCtrTamt() {
		return ctrTamt;
	}

	public void setCtrTamt(Float ctrTamt) {
		this.ctrTamt = ctrTamt;
	}

	public Float getPrpyGldRto() {
		return prpyGldRto;
	}

	public void setPrpyGldRto(Float prpyGldRto) {
		this.prpyGldRto = prpyGldRto;
	}

	public Float getRskctrUnitprc() {
		return rskctrUnitprc;
	}

	public void setRskctrUnitprc(Float rskctrUnitprc) {
		this.rskctrUnitprc = rskctrUnitprc;
	}

	public String getRskctrPrcRef() {
		return rskctrPrcRef;
	}

	public void setRskctrPrcRef(String rskctrPrcRef) {
		this.rskctrPrcRef = rskctrPrcRef;
	}

	public Float getWnln() {
		return wnln;
	}

	public void setWnln(Float wnln) {
		this.wnln = wnln;
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

	public String getSplovCrrovMod() {
		return splovCrrovMod;
	}

	public void setSplovCrrovMod(String splovCrrovMod) {
		this.splovCrrovMod = splovCrrovMod;
	}

	public Date getTms() {
		return tms;
	}

	public void setTms(Date tms) {
		this.tms = tms;
	}

	public String getOrdrSt() {
		return ordrSt;
	}

	public void setOrdrSt(String ordrSt) {
		this.ordrSt = ordrSt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCrtTm() {
		return crtTm;
	}

	public void setCrtTm(Date crtTm) {
		this.crtTm = crtTm;
	}

	public Float getFncSvcfeeRate() {
		return fncSvcfeeRate;
	}

	public void setFncSvcfeeRate(Float fncSvcfeeRate) {
		this.fncSvcfeeRate = fncSvcfeeRate;
	}

	public String getGdsNm() {
		return gdsNm;
	}

	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}

	public Integer getGdsPtsNum() {
		return gdsPtsNum;
	}

	public void setGdsPtsNum(Integer gdsPtsNum) {
		this.gdsPtsNum = gdsPtsNum;
	}

	public Float getGdsWght() {
		return gdsWght;
	}

	public void setGdsWght(Float gdsWght) {
		this.gdsWght = gdsWght;
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

	public String getTprtDt() {
		return tprtDt;
	}

	public void setTprtDt(String tprtDt) {
		this.tprtDt = tprtDt;
	}

	public String getPpsLnd() {
		return ppsLnd;
	}

	public void setPpsLnd(String ppsLnd) {
		this.ppsLnd = ppsLnd;
	}

	public String getTprtModAndImt() {
		return tprtModAndImt;
	}

	public void setTprtModAndImt(String tprtModAndImt) {
		this.tprtModAndImt = tprtModAndImt;
	}

	public String getPymtmod() {
		return pymtmod;
	}

	public void setPymtmod(String pymtmod) {
		this.pymtmod = pymtmod;
	}

	public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}

	public String getFilesToDelete() {
		return filesToDelete;
	}

	public void setFilesToDelete(String filesToDelete) {
		this.filesToDelete = filesToDelete;
	}

	public Integer getQueryType() {
		return queryType;
	}

	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}

	public String getSecSrvCd() {
		return secSrvCd;
	}

	public void setSecSrvCd(String secSrvCd) {
		this.secSrvCd = secSrvCd;
	}
       
}