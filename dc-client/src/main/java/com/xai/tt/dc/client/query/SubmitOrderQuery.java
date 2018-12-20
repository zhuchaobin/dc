package com.xai.tt.dc.client.query;

import java.util.Date;

public class SubmitOrderQuery extends UserInfoQuery {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    // 附件文件名信息
    private String fileNames;
    
    public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}

/**
  * id
  */
 private Long id;
 
 /**
  * 长约编号
  */
 private String arId;
 
 /**
  * 订单编号
  */
 private String ordrId;


public String getOrdrId() {
	return ordrId;
}

public void setOrdrId(String ordrId) {
	this.ordrId = ordrId;
}

public String getArId() {
	return arId;
}

public void setArId(String arId) {
	this.arId = arId;
}

/**
  * 关联编号
  */
 private String rltvId;

 /**
  * 流程类型
  */
 private String processType;

 /**
  * 流程实例编号
  */
 private String processInstId;

 /**
  * 申请处理步骤代码
  */
 private String aplyPcstpCd;

 /**
  * 申请处理结果代码
  */
 private String aplyPsrltCd;

 /**
  * 用户名
  */
 private String username;

 /**
  * 备注
  */
 private String rmrk;

 /**
  * #初始化时间
  */
 private Date inlzTm;

 /**
  * #环节开始时间
  */
 private Date lnkSttm;

 /**
  * #环节结束时间
  */
 private Date lnkEdtm;

 /**
  * 申请处理逾期状态代码
  */
 private String aplyPcsOdstCd;

 /**
  * 申请处理机构编号
  */
 private Integer companyId;

 /**
  * #时间戳
  */
 private Date tms;

 /**
  * #交易发起渠道编号
  */
 private String txnIttChnlId;

 /**
  * 申请处理结果
  */
 private byte[] aplyPsrlt;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getRltvId() {
	return rltvId;
}

public void setRltvId(String rltvId) {
	this.rltvId = rltvId;
}

public String getProcessType() {
	return processType;
}

public void setProcessType(String processType) {
	this.processType = processType;
}

public String getProcessInstId() {
	return processInstId;
}

public void setProcessInstId(String processInstId) {
	this.processInstId = processInstId;
}

public String getAplyPcstpCd() {
	return aplyPcstpCd;
}

public void setAplyPcstpCd(String aplyPcstpCd) {
	this.aplyPcstpCd = aplyPcstpCd;
}

public String getAplyPsrltCd() {
	return aplyPsrltCd;
}

public void setAplyPsrltCd(String aplyPsrltCd) {
	this.aplyPsrltCd = aplyPsrltCd;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getRmrk() {
	return rmrk;
}

public void setRmrk(String rmrk) {
	this.rmrk = rmrk;
}

public Date getInlzTm() {
	return inlzTm;
}

public void setInlzTm(Date inlzTm) {
	this.inlzTm = inlzTm;
}

public Date getLnkSttm() {
	return lnkSttm;
}

public void setLnkSttm(Date lnkSttm) {
	this.lnkSttm = lnkSttm;
}

public Date getLnkEdtm() {
	return lnkEdtm;
}

public void setLnkEdtm(Date lnkEdtm) {
	this.lnkEdtm = lnkEdtm;
}

public String getAplyPcsOdstCd() {
	return aplyPcsOdstCd;
}

public void setAplyPcsOdstCd(String aplyPcsOdstCd) {
	this.aplyPcsOdstCd = aplyPcsOdstCd;
}

public Integer getCompanyId() {
	return companyId;
}

public void setCompanyId(Integer companyId) {
	this.companyId = companyId;
}

public Date getTms() {
	return tms;
}

public void setTms(Date tms) {
	this.tms = tms;
}

public String getTxnIttChnlId() {
	return txnIttChnlId;
}

public void setTxnIttChnlId(String txnIttChnlId) {
	this.txnIttChnlId = txnIttChnlId;
}

public byte[] getAplyPsrlt() {
	return aplyPsrlt;
}

public void setAplyPsrlt(byte[] aplyPsrlt) {
	this.aplyPsrlt = aplyPsrlt;
}

}
