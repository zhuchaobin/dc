package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "b3_pd_nm_drc_prc")
public class B3PdNmDrcPrc {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 品名ID
     */
    @Column(name = "Pd_ID")
    private Long pdId;

    /**
     * 获取日期
     */
    @Column(name = "Acq_Dt")
    private String acqDt;

    /**
     * 来源类型代码
     */
    @Column(name = "Src_TpCd")
    private String srcTpcd;

    /**
     * 来源描述
     */
    @Column(name = "Src_Dsc")
    private String srcDsc;

    /**
     * 指导价
     */
    @Column(name = "Drc_Prc")
    private Float drcPrc;

    /**
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 操作员
     */
    private String username;

    /**
     * 备注
     */
    @Column(name = "Rmrk")
    private String rmrk;

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
     * 获取品名ID
     *
     * @return Pd_ID - 品名ID
     */
    public Long getPdId() {
        return pdId;
    }

    /**
     * 设置品名ID
     *
     * @param pdId 品名ID
     */
    public void setPdId(Long pdId) {
        this.pdId = pdId;
    }

    /**
     * 获取获取日期
     *
     * @return Acq_Dt - 获取日期
     */
    public String getAcqDt() {
        return acqDt;
    }

    /**
     * 设置获取日期
     *
     * @param acqDt 获取日期
     */
    public void setAcqDt(String acqDt) {
        this.acqDt = acqDt;
    }

    /**
     * 获取来源类型代码
     *
     * @return Src_TpCd - 来源类型代码
     */
    public String getSrcTpcd() {
        return srcTpcd;
    }

    /**
     * 设置来源类型代码
     *
     * @param srcTpcd 来源类型代码
     */
    public void setSrcTpcd(String srcTpcd) {
        this.srcTpcd = srcTpcd;
    }

    /**
     * 获取来源描述
     *
     * @return Src_Dsc - 来源描述
     */
    public String getSrcDsc() {
        return srcDsc;
    }

    /**
     * 设置来源描述
     *
     * @param srcDsc 来源描述
     */
    public void setSrcDsc(String srcDsc) {
        this.srcDsc = srcDsc;
    }

    /**
     * 获取指导价
     *
     * @return Drc_Prc - 指导价
     */
    public Float getDrcPrc() {
        return drcPrc;
    }

    /**
     * 设置指导价
     *
     * @param drcPrc 指导价
     */
    public void setDrcPrc(Float drcPrc) {
        this.drcPrc = drcPrc;
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
     * @return username - 操作员
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作员
     *
     * @param username 操作员
     */
    public void setUsername(String username) {
        this.username = username;
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
}