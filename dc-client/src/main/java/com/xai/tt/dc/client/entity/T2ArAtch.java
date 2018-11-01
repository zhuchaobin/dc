package com.xai.tt.dc.client.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t2_ar_atch")
public class T2ArAtch {
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
     * 订单ID
     */
    @Column(name = "Crt_Tm")
    private Date crtTm;

    /**
     * 附件内容
     */
    @Column(name = "Atch_Cntnt")
    private byte[] atchCntnt;

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
     * 获取订单ID
     *
     * @return Crt_Tm - 订单ID
     */
    public Date getCrtTm() {
        return crtTm;
    }

    /**
     * 设置订单ID
     *
     * @param crtTm 订单ID
     */
    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }

    /**
     * 获取附件内容
     *
     * @return Atch_Cntnt - 附件内容
     */
    public byte[] getAtchCntnt() {
        return atchCntnt;
    }

    /**
     * 设置附件内容
     *
     * @param atchCntnt 附件内容
     */
    public void setAtchCntnt(byte[] atchCntnt) {
        this.atchCntnt = atchCntnt;
    }
}