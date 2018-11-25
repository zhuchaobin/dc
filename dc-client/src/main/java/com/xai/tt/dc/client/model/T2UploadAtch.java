package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t2_upload_atch")
public class T2UploadAtch {
    /**
     * 附件ID
     */
    @Id
    private Long id;

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
     * 用户名
     */
    private String username;

    /**
     * 创建时间
     */
    @Column(name = "Crt_Tm")
    private Date crtTm;

    /**
     * 获取附件ID
     *
     * @return id - 附件ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置附件ID
     *
     * @param id 附件ID
     */
    public void setId(Long id) {
        this.id = id;
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