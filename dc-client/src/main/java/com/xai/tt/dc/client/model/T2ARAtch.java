package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t2_ar_atch")
public class T2ARAtch {
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

    /**
     * 获取长约附件ID
     *
     * @return AR_AtchID - 长约附件ID
     */
    public Long getArAtchid() {
        return arAtchid;
    }

    /**
     * 设置长约附件ID
     *
     * @param arAtchid 长约附件ID
     */
    public void setArAtchid(Long arAtchid) {
        this.arAtchid = arAtchid;
    }

    /**
     * 获取长约协议编号
     *
     * @return AR_ID - 长约协议编号
     */
    public String getArId() {
        return arId;
    }

    /**
     * 设置长约协议编号
     *
     * @param arId 长约协议编号
     */
    public void setArId(String arId) {
        this.arId = arId;
    }

    /**
     * 获取原文件名
     *
     * @return Ori_File_Nm - 原文件名
     */
    public String getOriFileNm() {
        return oriFileNm;
    }

    /**
     * 设置原文件名
     *
     * @param oriFileNm 原文件名
     */
    public void setOriFileNm(String oriFileNm) {
        this.oriFileNm = oriFileNm;
    }

    /**
     * 获取服务器文件名
     *
     * @return Sr_File_Nm - 服务器文件名
     */
    public String getSrFileNm() {
        return srFileNm;
    }

    /**
     * 设置服务器文件名
     *
     * @param srFileNm 服务器文件名
     */
    public void setSrFileNm(String srFileNm) {
        this.srFileNm = srFileNm;
    }

    /**
     * 获取服务器文件路径
     *
     * @return Sr_File_Rte - 服务器文件路径
     */
    public String getSrFileRte() {
        return srFileRte;
    }

    /**
     * 设置服务器文件路径
     *
     * @param srFileRte 服务器文件路径
     */
    public void setSrFileRte(String srFileRte) {
        this.srFileRte = srFileRte;
    }

    /**
     * 获取附件类型
     *
     * @return Atch_Tp - 附件类型
     */
    public String getAtchTp() {
        return atchTp;
    }

    /**
     * 设置附件类型
     *
     * @param atchTp 附件类型
     */
    public void setAtchTp(String atchTp) {
        this.atchTp = atchTp;
    }

    /**
     * 获取备注
     *
     * @return Rmrk - 备注
     */
    public String getRmrk() {
        return rmrk;
    }

    /**
     * 设置备注
     *
     * @param rmrk 备注
     */
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
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
     * @return Crt_Psn - 操作员
     */
    public String getCrtPsn() {
        return crtPsn;
    }

    /**
     * 设置操作员
     *
     * @param crtPsn 操作员
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
}