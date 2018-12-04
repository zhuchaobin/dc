package com.xai.tt.dc.client.vo.outVo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class QueryLnkJrnlInfOutVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String companyName;
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 关联编号
     */
    @Column(name = "Rltv_ID")
    private String rltvId;

    /**
     * 流程类型
     */
    @Column(name = "PROCESS_TYPE")
    private String processType;

    /**
     * 流程实例编号
     */
    @Column(name = "PROCESS_INST_ID")
    private String processInstId;

    /**
     * 申请处理步骤代码
     */
    @Column(name = "Aply_PcStp_Cd")
    private String aplyPcstpCd;

    /**
     * 申请处理结果代码
     */
    @Column(name = "Aply_PsRlt_Cd")
    private String aplyPsrltCd;

    /**
     * 用户名
     */
    private String username;

    /**
     * 备注
     */
    @Column(name = "Rmrk")
    private String rmrk;

    /**
     * #初始化时间
     */
    @Column(name = "Inlz_Tm")
    private Date inlzTm;

    /**
     * #环节开始时间
     */
    @Column(name = "Lnk_StTm")
    private Date lnkSttm;

    /**
     * #环节结束时间
     */
    @Column(name = "Lnk_EdTm")
    private Date lnkEdtm;

    /**
     * 申请处理逾期状态代码
     */
    @Column(name = "Aply_Pcs_OdSt_Cd")
    private String aplyPcsOdstCd;

    /**
     * 申请处理机构编号
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * #时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * #交易发起渠道编号
     */
    @Column(name = "Txn_Itt_Chnl_ID")
    private String txnIttChnlId;

    /**
     * 申请处理结果
     */
    @Column(name = "Aply_PsRlt")
    private byte[] aplyPsrlt;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

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
