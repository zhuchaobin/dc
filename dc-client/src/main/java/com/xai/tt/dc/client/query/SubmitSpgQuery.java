package com.xai.tt.dc.client.query;

import com.xai.tt.dc.client.model.T13GdsDetail;
import com.xai.tt.dc.client.model.T7SpgDetail;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class SubmitSpgQuery extends UserInfoQuery {
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

	// 赎货方式
    private String selRdmgdsMod;


	public String getSelRdmgdsMod() {
		return selRdmgdsMod;
	}

	public void setSelRdmgdsMod(String selRdmgdsMod) {
		this.selRdmgdsMod = selRdmgdsMod;
	}

	// 付款方式
    private String pymtMod;


	public String getPymtMod() {
		return pymtMod;
	}

	public void setPymtMod(String pymtMod) {
		this.pymtMod = pymtMod;
	}

	/**
  * id
  */
 private Long id;
 
 /**
  * 发货编号
  */
 private String spgId;
 
public String getSpgId() {
	return spgId;
}

public void setSpgId(String spgId) {
	this.spgId = spgId;
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
	private String aplyPsrlt;




	private Integer vhclNum;

	public String getRevMnyRmrk() {
		return revMnyRmrk;
	}

	public void setRevMnyRmrk(String revMnyRmrk) {
		this.revMnyRmrk = revMnyRmrk;
	}


	/*接货承运*/
	private String tprtModAndImt;
	private Integer lgstcCo;
	private String revMnyPsn;
	private String revMnyRmrk;

	/*接货入仓*/

	/**
	 * 仓储公司
	 */
	private Integer stgco;

	/**
	 * 入库人
	 */
	private String intrsrPsn;

	/**
	 * 入库时间
	 */
	private Date intrsrTm;

	/**
	 * 入库备注
	 */
	private String intrsrRmrk;

	/**
	 * 出库时间
	 */
	private Date outstgTm;

	/**
	 * 质押状态
	 */
	private Integer plgSt;

	/**
	 * 库位
	 */
	private String strBit;

	/**
	 * 仓单编号
	 */
	private String whrecptId;

	/**
	 * 库存状态
	 */
	private String ivntSt;

	/**
	 * 质押预警状态代码
	 */
	private String plgWarnStcd;



	List<T13GdsDetail> t13GdsDetailList;


	private String arId;


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

	public List<T13GdsDetail> getT13GdsDetailList() {
		return t13GdsDetailList;
	}

	public void setT13GdsDetailList(List<T13GdsDetail> t13GdsDetailList) {
		this.t13GdsDetailList = t13GdsDetailList;
	}

	public Integer getStgco() {
		return stgco;
	}

	public void setStgco(Integer stgco) {
		this.stgco = stgco;
	}

	public String getIntrsrPsn() {
		return intrsrPsn;
	}

	public void setIntrsrPsn(String intrsrPsn) {
		this.intrsrPsn = intrsrPsn;
	}

	public Date getIntrsrTm() {
		return intrsrTm;
	}

	public void setIntrsrTm(Date intrsrTm) {
		this.intrsrTm = intrsrTm;
	}

	public String getIntrsrRmrk() {
		return intrsrRmrk;
	}

	public void setIntrsrRmrk(String intrsrRmrk) {
		this.intrsrRmrk = intrsrRmrk;
	}

	public Date getOutstgTm() {
		return outstgTm;
	}

	public void setOutstgTm(Date outstgTm) {
		this.outstgTm = outstgTm;
	}

	public Integer getPlgSt() {
		return plgSt;
	}

	public void setPlgSt(Integer plgSt) {
		this.plgSt = plgSt;
	}

	public String getStrBit() {
		return strBit;
	}

	public void setStrBit(String strBit) {
		this.strBit = strBit;
	}

	public String getWhrecptId() {
		return whrecptId;
	}

	public void setWhrecptId(String whrecptId) {
		this.whrecptId = whrecptId;
	}

	public String getIvntSt() {
		return ivntSt;
	}

	public void setIvntSt(String ivntSt) {
		this.ivntSt = ivntSt;
	}

	public String getPlgWarnStcd() {
		return plgWarnStcd;
	}

	public void setPlgWarnStcd(String plgWarnStcd) {
		this.plgWarnStcd = plgWarnStcd;
	}

	public Integer getVhclNum() {
		return vhclNum;
	}

	public void setVhclNum(Integer vhclNum) {
		this.vhclNum = vhclNum;
	}

	public String getTprtModAndImt() {
		return tprtModAndImt;
	}

	public void setTprtModAndImt(String tprtModAndImt) {
		this.tprtModAndImt = tprtModAndImt;
	}

	public Integer getLgstcCo() {
		return lgstcCo;
	}

	public void setLgstcCo(Integer lgstcCo) {
		this.lgstcCo = lgstcCo;
	}

	public String getRevMnyPsn() {
		return revMnyPsn;
	}

	public void setRevMnyPsn(String revMnyPsn) {
		this.revMnyPsn = revMnyPsn;
	}

	public String getRevMnyCtcTel() {
		return revMnyCtcTel;
	}

	public void setRevMnyCtcTel(String revMnyCtcTel) {
		this.revMnyCtcTel = revMnyCtcTel;
	}

	private String revMnyCtcTel;


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

	public String getAplyPsrlt() {
		return aplyPsrlt;
	}

	public void setAplyPsrlt(String aplyPsrlt) {
		this.aplyPsrlt = aplyPsrlt;
	}
}
