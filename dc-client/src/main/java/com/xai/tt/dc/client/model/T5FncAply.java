package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t5_fnc_aply")
public class T5FncAply {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 公司全称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 电子邮箱
     */
    @Column(name = "Email")
    private String email;

    /**
     * 联系人
     */
    @Column(name = "CtcPsn")
    private String ctcpsn;

    /**
     * 联系电话
     */
    @Column(name = "Ctc_Tel")
    private String ctcTel;

    /**
     * 融资需求描述
     */
    @Column(name = "Fnc_Rqm_Dsc")
    private String fncRqmDsc;

    /**
     * 申请时间
     */
    @Column(name = "Aply_Tm")
    private Date aplyTm;

    /**
     * 申请渠道
     */
    @Column(name = "Aply_Chnl")
    private String aplyChnl;

    /**
     * 修改时间
     */
    @Column(name = "Mod_Tm")
    private Date modTm;

    /**
     * 处理人
     */
    private String username;

    /**
     * 处理时间
     */
    @Column(name = "Pcs_Tm")
    private Date pcsTm;

    /**
     * 处理备注
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
     * 获取公司全称
     *
     * @return company_name - 公司全称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司全称
     *
     * @param companyName 公司全称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取电子邮箱
     *
     * @return Email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系人
     *
     * @return CtcPsn - 联系人
     */
    public String getCtcpsn() {
        return ctcpsn;
    }

    /**
     * 设置联系人
     *
     * @param ctcpsn 联系人
     */
    public void setCtcpsn(String ctcpsn) {
        this.ctcpsn = ctcpsn;
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
     * 获取融资需求描述
     *
     * @return Fnc_Rqm_Dsc - 融资需求描述
     */
    public String getFncRqmDsc() {
        return fncRqmDsc;
    }

    /**
     * 设置融资需求描述
     *
     * @param fncRqmDsc 融资需求描述
     */
    public void setFncRqmDsc(String fncRqmDsc) {
        this.fncRqmDsc = fncRqmDsc;
    }

    /**
     * 获取申请时间
     *
     * @return Aply_Tm - 申请时间
     */
    public Date getAplyTm() {
        return aplyTm;
    }

    /**
     * 设置申请时间
     *
     * @param aplyTm 申请时间
     */
    public void setAplyTm(Date aplyTm) {
        this.aplyTm = aplyTm;
    }

    /**
     * 获取申请渠道
     *
     * @return Aply_Chnl - 申请渠道
     */
    public String getAplyChnl() {
        return aplyChnl;
    }

    /**
     * 设置申请渠道
     *
     * @param aplyChnl 申请渠道
     */
    public void setAplyChnl(String aplyChnl) {
        this.aplyChnl = aplyChnl;
    }

    /**
     * 获取修改时间
     *
     * @return Mod_Tm - 修改时间
     */
    public Date getModTm() {
        return modTm;
    }

    /**
     * 设置修改时间
     *
     * @param modTm 修改时间
     */
    public void setModTm(Date modTm) {
        this.modTm = modTm;
    }

    /**
     * 获取处理人
     *
     * @return username - 处理人
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置处理人
     *
     * @param username 处理人
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取处理时间
     *
     * @return Pcs_Tm - 处理时间
     */
    public Date getPcsTm() {
        return pcsTm;
    }

    /**
     * 设置处理时间
     *
     * @param pcsTm 处理时间
     */
    public void setPcsTm(Date pcsTm) {
        this.pcsTm = pcsTm;
    }

    /**
     * 获取处理备注
     *
     * @return Rmrk - 处理备注
     */
    public String getRmrk() {
        return rmrk;
    }

    /**
     * 设置处理备注
     *
     * @param rmrk 处理备注
     */
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }
}