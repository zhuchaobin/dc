package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t12_inv_inf")
public class T12InvInf {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 付款方
     */
    @Column(name = "Pyr")
    private Integer pyr;

    /**
     * 收款方
     */
    @Column(name = "RcvPrt")
    private Integer rcvprt;

    /**
     * 金额
     */
    @Column(name = "Amt")
    private Float amt;

    /**
     * 支付时间
     */
    @Column(name = "Py_Tm")
    private Date pyTm;

    /**
     * 支付原因
     */
    @Column(name = "Py_Rsn")
    private String pyRsn;

    /**
     * 审批人
     */
    @Column(name = "Aprv_Psn")
    private String aprvPsn;

    /**
     * 审批时间
     */
    @Column(name = "Aprv_Tm")
    private Date aprvTm;

    /**
     * 审批备注
     */
    @Column(name = "Rmrk")
    private String rmrk;

    /**
     * 联系电话
     */
    @Column(name = "Ctc_Tel")
    private String ctcTel;

    /**
     * 建议发票抬头
     */
    @Column(name = "Prpsl_Inv_Hd")
    private String prpslInvHd;

    /**
     * 关联编号
     */
    @Column(name = "Rltv_ID")
    private String rltvId;

    /**
     * 关联类型
     */
    @Column(name = "Rltv_Tp")
    private String rltvTp;

    /**
     * 开票人
     */
    @Column(name = "IssuBill_Psn")
    private String issubillPsn;

    /**
     * 开票时间
     */
    @Column(name = "IssuBill_Tm")
    private Date issubillTm;

    /**
     * 收票人
     */
    @Column(name = "BilRecr")
    private String bilrecr;

    /**
     * 收票时间
     */
    @Column(name = "Inv_Tm")
    private Date invTm;

    /**
     * 获取ID
     *
     * @return id - ID
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
     * 获取付款方
     *
     * @return Pyr - 付款方
     */
    public Integer getPyr() {
        return pyr;
    }

    /**
     * 设置付款方
     *
     * @param pyr 付款方
     */
    public void setPyr(Integer pyr) {
        this.pyr = pyr;
    }

    /**
     * 获取收款方
     *
     * @return RcvPrt - 收款方
     */
    public Integer getRcvprt() {
        return rcvprt;
    }

    /**
     * 设置收款方
     *
     * @param rcvprt 收款方
     */
    public void setRcvprt(Integer rcvprt) {
        this.rcvprt = rcvprt;
    }

    /**
     * 获取金额
     *
     * @return Amt - 金额
     */
    public Float getAmt() {
        return amt;
    }

    /**
     * 设置金额
     *
     * @param amt 金额
     */
    public void setAmt(Float amt) {
        this.amt = amt;
    }

    /**
     * 获取支付时间
     *
     * @return Py_Tm - 支付时间
     */
    public Date getPyTm() {
        return pyTm;
    }

    /**
     * 设置支付时间
     *
     * @param pyTm 支付时间
     */
    public void setPyTm(Date pyTm) {
        this.pyTm = pyTm;
    }

    /**
     * 获取支付原因
     *
     * @return Py_Rsn - 支付原因
     */
    public String getPyRsn() {
        return pyRsn;
    }

    /**
     * 设置支付原因
     *
     * @param pyRsn 支付原因
     */
    public void setPyRsn(String pyRsn) {
        this.pyRsn = pyRsn;
    }

    /**
     * 获取审批人
     *
     * @return Aprv_Psn - 审批人
     */
    public String getAprvPsn() {
        return aprvPsn;
    }

    /**
     * 设置审批人
     *
     * @param aprvPsn 审批人
     */
    public void setAprvPsn(String aprvPsn) {
        this.aprvPsn = aprvPsn;
    }

    /**
     * 获取审批时间
     *
     * @return Aprv_Tm - 审批时间
     */
    public Date getAprvTm() {
        return aprvTm;
    }

    /**
     * 设置审批时间
     *
     * @param aprvTm 审批时间
     */
    public void setAprvTm(Date aprvTm) {
        this.aprvTm = aprvTm;
    }

    /**
     * 获取审批备注
     *
     * @return Rmrk - 审批备注
     */
    public String getRmrk() {
        return rmrk;
    }

    /**
     * 设置审批备注
     *
     * @param rmrk 审批备注
     */
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    /**
     * 获取联系电话
     *
     * @return Ctc_Tel - 联系电话
     */
    public String getCtcTel() {
        return ctcTel;
    }

    /**
     * 设置联系电话
     *
     * @param ctcTel 联系电话
     */
    public void setCtcTel(String ctcTel) {
        this.ctcTel = ctcTel;
    }

    /**
     * 获取建议发票抬头
     *
     * @return Prpsl_Inv_Hd - 建议发票抬头
     */
    public String getPrpslInvHd() {
        return prpslInvHd;
    }

    /**
     * 设置建议发票抬头
     *
     * @param prpslInvHd 建议发票抬头
     */
    public void setPrpslInvHd(String prpslInvHd) {
        this.prpslInvHd = prpslInvHd;
    }

    /**
     * 获取关联编号
     *
     * @return Rltv_ID - 关联编号
     */
    public String getRltvId() {
        return rltvId;
    }

    /**
     * 设置关联编号
     *
     * @param rltvId 关联编号
     */
    public void setRltvId(String rltvId) {
        this.rltvId = rltvId;
    }

    /**
     * 获取关联类型
     *
     * @return Rltv_Tp - 关联类型
     */
    public String getRltvTp() {
        return rltvTp;
    }

    /**
     * 设置关联类型
     *
     * @param rltvTp 关联类型
     */
    public void setRltvTp(String rltvTp) {
        this.rltvTp = rltvTp;
    }

    /**
     * 获取开票人
     *
     * @return IssuBill_Psn - 开票人
     */
    public String getIssubillPsn() {
        return issubillPsn;
    }

    /**
     * 设置开票人
     *
     * @param issubillPsn 开票人
     */
    public void setIssubillPsn(String issubillPsn) {
        this.issubillPsn = issubillPsn;
    }

    /**
     * 获取开票时间
     *
     * @return IssuBill_Tm - 开票时间
     */
    public Date getIssubillTm() {
        return issubillTm;
    }

    /**
     * 设置开票时间
     *
     * @param issubillTm 开票时间
     */
    public void setIssubillTm(Date issubillTm) {
        this.issubillTm = issubillTm;
    }

    /**
     * 获取收票人
     *
     * @return BilRecr - 收票人
     */
    public String getBilrecr() {
        return bilrecr;
    }

    /**
     * 设置收票人
     *
     * @param bilrecr 收票人
     */
    public void setBilrecr(String bilrecr) {
        this.bilrecr = bilrecr;
    }

    /**
     * 获取收票时间
     *
     * @return Inv_Tm - 收票时间
     */
    public Date getInvTm() {
        return invTm;
    }

    /**
     * 设置收票时间
     *
     * @param invTm 收票时间
     */
    public void setInvTm(Date invTm) {
        this.invTm = invTm;
    }
}