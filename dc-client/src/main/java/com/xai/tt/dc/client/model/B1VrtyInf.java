package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "b1_vrty_inf")
public class B1VrtyInf {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 品种名
     */
    @Column(name = "Vrty_Nm")
    private String vrtyNm;

    /**
     * 俗名
     */
    @Column(name = "Comm_Nm")
    private String commNm;

    /**
     * 学名
     */
    @Column(name = "Ty_Nm")
    private String tyNm;

    /**
     * 是否常用
     */
    @Column(name = "Wthr_CmnUsed")
    private Integer wthrCmnused;

    /**
     * 父品种id
     */
    @Column(name = "Prn_Vrtyid")
    private Long prnVrtyid;

    /**
     * 品种介绍
     */
    @Column(name = "Vrty_Intd")
    private String vrtyIntd;

    /**
     * 用户名
     */
    private String username;

    /**
     * 更新时间
     */
    @Column(name = "Udt_Tm")
    private Date udtTm;

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
     * 获取品种名
     *
     * @return Vrty_Nm - 品种名
     */
    public String getVrtyNm() {
        return vrtyNm;
    }

    /**
     * 设置品种名
     *
     * @param vrtyNm 品种名
     */
    public void setVrtyNm(String vrtyNm) {
        this.vrtyNm = vrtyNm;
    }

    /**
     * 获取俗名
     *
     * @return Comm_Nm - 俗名
     */
    public String getCommNm() {
        return commNm;
    }

    /**
     * 设置俗名
     *
     * @param commNm 俗名
     */
    public void setCommNm(String commNm) {
        this.commNm = commNm;
    }

    /**
     * 获取学名
     *
     * @return Ty_Nm - 学名
     */
    public String getTyNm() {
        return tyNm;
    }

    /**
     * 设置学名
     *
     * @param tyNm 学名
     */
    public void setTyNm(String tyNm) {
        this.tyNm = tyNm;
    }

    /**
     * 获取是否常用
     *
     * @return Wthr_CmnUsed - 是否常用
     */
    public Integer getWthrCmnused() {
        return wthrCmnused;
    }

    /**
     * 设置是否常用
     *
     * @param wthrCmnused 是否常用
     */
    public void setWthrCmnused(Integer wthrCmnused) {
        this.wthrCmnused = wthrCmnused;
    }

    /**
     * 获取父品种id
     *
     * @return Prn_Vrtyid - 父品种id
     */
    public Long getPrnVrtyid() {
        return prnVrtyid;
    }

    /**
     * 设置父品种id
     *
     * @param prnVrtyid 父品种id
     */
    public void setPrnVrtyid(Long prnVrtyid) {
        this.prnVrtyid = prnVrtyid;
    }

    /**
     * 获取品种介绍
     *
     * @return Vrty_Intd - 品种介绍
     */
    public String getVrtyIntd() {
        return vrtyIntd;
    }

    /**
     * 设置品种介绍
     *
     * @param vrtyIntd 品种介绍
     */
    public void setVrtyIntd(String vrtyIntd) {
        this.vrtyIntd = vrtyIntd;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取更新时间
     *
     * @return Udt_Tm - 更新时间
     */
    public Date getUdtTm() {
        return udtTm;
    }

    /**
     * 设置更新时间
     *
     * @param udtTm 更新时间
     */
    public void setUdtTm(Date udtTm) {
        this.udtTm = udtTm;
    }
}