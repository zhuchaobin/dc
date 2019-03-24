package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "company")
public class Company {
    @Id
    private Integer id;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 负责人
     */
    @Column(name = "manager_name")
    private String managerName;

    /**
     * 邮件
     */
    private String email;

    /**
     * 电话号
     */
    private String mobile;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 地址信息
     */
    private String address;

    /**
     * 是否冻结 冻结:TRUE  ;未冻结：FALSE
     */
    private Boolean locked;

    /**
     * 用户类型
     */
    @Column(name = "Usr_Tp")
    private String usrTp;

    /**
     * 注册地址
     */
    @Column(name = "RgtAds")
    private String rgtads;

    /**
     * 纳税人识别号
     */
    @Column(name = "Taxpyr_Id_No")
    private String taxpyrIdNo;

    /**
     * 开户行
     */
    @Column(name = "DepBnk")
    private String depbnk;

    /**
     * 银行账户号
     */
    @Column(name = "Bnk_Acc_No")
    private String bnkAccNo;

    /**
     * 备注
     */
    @Column(name = "Rmrk")
    private String rmrk;
    
    /**
     * 企业社会信用代码
     */
    @Column(name = "Entp_Soc_Cr_Cd")
    private String entpSocCrCd;
    			
    public String getEntpSocCrCd() {
		return entpSocCrCd;
	}

	public void setEntpSocCrCd(String entpSocCrCd) {
		this.entpSocCrCd = entpSocCrCd;
	}

	/**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取代码
     *
     * @return code - 代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置代码
     *
     * @param code 代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取负责人
     *
     * @return manager_name - 负责人
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * 设置负责人
     *
     * @param managerName 负责人
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * 获取邮件
     *
     * @return email - 邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件
     *
     * @param email 邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取电话号
     *
     * @return mobile - 电话号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置电话号
     *
     * @param mobile 电话号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取地址信息
     *
     * @return address - 地址信息
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址信息
     *
     * @param address 地址信息
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取是否冻结 冻结:TRUE  ;未冻结：FALSE
     *
     * @return locked - 是否冻结 冻结:TRUE  ;未冻结：FALSE
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * 设置是否冻结 冻结:TRUE  ;未冻结：FALSE
     *
     * @param locked 是否冻结 冻结:TRUE  ;未冻结：FALSE
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * 获取用户类型
     *
     * @return Usr_Tp - 用户类型
     */
    public String getUsrTp() {
        return usrTp;
    }

    /**
     * 设置用户类型
     *
     * @param usrTp 用户类型
     */
    public void setUsrTp(String usrTp) {
        this.usrTp = usrTp;
    }

    /**
     * 获取注册地址
     *
     * @return RgtAds - 注册地址
     */
    public String getRgtads() {
        return rgtads;
    }

    /**
     * 设置注册地址
     *
     * @param rgtads 注册地址
     */
    public void setRgtads(String rgtads) {
        this.rgtads = rgtads;
    }

    /**
     * 获取纳税人识别号
     *
     * @return Taxpyr_Id_No - 纳税人识别号
     */
    public String getTaxpyrIdNo() {
        return taxpyrIdNo;
    }

    /**
     * 设置纳税人识别号
     *
     * @param taxpyrIdNo 纳税人识别号
     */
    public void setTaxpyrIdNo(String taxpyrIdNo) {
        this.taxpyrIdNo = taxpyrIdNo;
    }

    /**
     * 获取开户行
     *
     * @return DepBnk - 开户行
     */
    public String getDepbnk() {
        return depbnk;
    }

    /**
     * 设置开户行
     *
     * @param depbnk 开户行
     */
    public void setDepbnk(String depbnk) {
        this.depbnk = depbnk;
    }

    /**
     * 获取银行账户号
     *
     * @return Bnk_Acc_No - 银行账户号
     */
    public String getBnkAccNo() {
        return bnkAccNo;
    }

    /**
     * 设置银行账户号
     *
     * @param bnkAccNo 银行账户号
     */
    public void setBnkAccNo(String bnkAccNo) {
        this.bnkAccNo = bnkAccNo;
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