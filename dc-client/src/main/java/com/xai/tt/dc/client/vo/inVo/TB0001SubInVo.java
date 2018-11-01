package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class TB0001SubInVo {
    /**
     * 长约附件ID
     */
    @Id
    @Column(name = "AR_AtchID")
    private Long arAtchid;

    /**
     * 长约协议编号
     */
    @Column(name = "AR_ID")
    private String arId;

    /**
     * 原文件名
     */
    @Column(name = "Ori_File_Nm")
    private String oriFileNm;

    /**
     * 服务器文件名
     */
    @Column(name = "Sr_File_Nm")
    private String srFileNm;

    /**
     * 服务器文件路径
     */
    @Column(name = "Sr_File_Rte")
    private String srFileRte;

    /**
     * 附件类型
     */
    @Column(name = "Atch_Tp")
    private String atchTp;

    /**
     * 备注
     */
    @Column(name = "Rmrk")
    private String rmrk;

    /**
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 操作员
     */
    @Column(name = "Crt_Psn")
    private String crtPsn;

    /**
     * 创建时间
     */
    @Column(name = "Crt_Tm")
    private Date crtTm;

	public Long getArAtchid() {
		return arAtchid;
	}

	public void setArAtchid(Long arAtchid) {
		this.arAtchid = arAtchid;
	}

	public String getArId() {
		return arId;
	}

	public void setArId(String arId) {
		this.arId = arId;
	}

	public String getOriFileNm() {
		return oriFileNm;
	}

	public void setOriFileNm(String oriFileNm) {
		this.oriFileNm = oriFileNm;
	}

	public String getSrFileNm() {
		return srFileNm;
	}

	public void setSrFileNm(String srFileNm) {
		this.srFileNm = srFileNm;
	}

	public String getSrFileRte() {
		return srFileRte;
	}

	public void setSrFileRte(String srFileRte) {
		this.srFileRte = srFileRte;
	}

	public String getAtchTp() {
		return atchTp;
	}

	public void setAtchTp(String atchTp) {
		this.atchTp = atchTp;
	}

	public String getRmrk() {
		return rmrk;
	}

	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
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
}