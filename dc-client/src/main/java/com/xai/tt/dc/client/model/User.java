package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    private Integer id;

    private String username;

    @Column(name = "chinese_name")
    private String chineseName;

    private String nickname;

    private String password;

    private String mobile;

    @Column(name = "mobile_verified")
    private Boolean mobileVerified;

    private String email;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "head_img")
    private String headImg;

    private String birthday;

    private String sex;

    private String location;

    @Column(name = "user_type")
    private Integer userType;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 是否app登陆
     */
    @Column(name = "app_enabled")
    private Boolean appEnabled;

    private Boolean locked;

    @Column(name = "register_app")
    private String registerApp;

    @Column(name = "data_range")
    private String dataRange;

    private String memo;

    private String ext;

    private Integer version;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "SplChain_Co")
    private Integer splchainCo;

    /**
     * 用户类型
     */
    @Column(name = "Usr_Tp")
    private String usrTp;

    @Column(name = "Ctfn_Tp")
    private String ctfnTp;

    @Column(name = "CtcPsn")
    private String ctcpsn;

    @Column(name = "Ctc_Tel")
    private String ctcTel;

    @Column(name = "Adt_Ind")
    private Integer adtInd;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return chinese_name
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * @param chineseName
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return mobile_verified
     */
    public Boolean getMobileVerified() {
        return mobileVerified;
    }

    /**
     * @param mobileVerified
     */
    public void setMobileVerified(Boolean mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return email_verified
     */
    public Boolean getEmailVerified() {
        return emailVerified;
    }

    /**
     * @param emailVerified
     */
    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    /**
     * @return head_img
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * @param headImg
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return user_type
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * @param userType
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取是否app登陆
     *
     * @return app_enabled - 是否app登陆
     */
    public Boolean getAppEnabled() {
        return appEnabled;
    }

    /**
     * 设置是否app登陆
     *
     * @param appEnabled 是否app登陆
     */
    public void setAppEnabled(Boolean appEnabled) {
        this.appEnabled = appEnabled;
    }

    /**
     * @return locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * @return register_app
     */
    public String getRegisterApp() {
        return registerApp;
    }

    /**
     * @param registerApp
     */
    public void setRegisterApp(String registerApp) {
        this.registerApp = registerApp;
    }

    /**
     * @return data_range
     */
    public String getDataRange() {
        return dataRange;
    }

    /**
     * @param dataRange
     */
    public void setDataRange(String dataRange) {
        this.dataRange = dataRange;
    }

    /**
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return ext
     */
    public String getExt() {
        return ext;
    }

    /**
     * @param ext
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
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
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return SplChain_Co
     */
    public Integer getSplchainCo() {
        return splchainCo;
    }

    /**
     * @param splchainCo
     */
    public void setSplchainCo(Integer splchainCo) {
        this.splchainCo = splchainCo;
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
     * @return Ctfn_Tp
     */
    public String getCtfnTp() {
        return ctfnTp;
    }

    /**
     * @param ctfnTp
     */
    public void setCtfnTp(String ctfnTp) {
        this.ctfnTp = ctfnTp;
    }

    /**
     * @return CtcPsn
     */
    public String getCtcpsn() {
        return ctcpsn;
    }

    /**
     * @param ctcpsn
     */
    public void setCtcpsn(String ctcpsn) {
        this.ctcpsn = ctcpsn;
    }

    /**
     * @return Ctc_Tel
     */
    public String getCtcTel() {
        return ctcTel;
    }

    /**
     * @param ctcTel
     */
    public void setCtcTel(String ctcTel) {
        this.ctcTel = ctcTel;
    }

    /**
     * @return Adt_Ind
     */
    public Integer getAdtInd() {
        return adtInd;
    }

    /**
     * @param adtInd
     */
    public void setAdtInd(Integer adtInd) {
        this.adtInd = adtInd;
    }
}