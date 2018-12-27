package com.xai.tt.dc.client.vo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.tianan.common.api.mybatis.SortQuery;
import com.xai.tt.dc.client.query.UserInfoQuery;

public class UserManagementVo extends SortQuery{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 全字段模糊检索关键字
     */
	private String keyWorlds;
	
    public String getKeyWorlds() {
		return keyWorlds;
	}

	public void setKeyWorlds(String keyWorlds) {
		this.keyWorlds = keyWorlds;
	}
	
    private Integer id;

    private String username;

    private String chineseName;

    private String nickname;

    private String password;

    private String mobile;

    private Boolean mobileVerified;

    private String email;

    private Boolean emailVerified;

    private String headImg;

    private String birthday;

    private String sex;

    private String location;

    private Integer userType;

    /**
     * 公司ID
     */

    private Integer companyId;

    /**
     * 公司名称
     */

    private String companyName;

    /**
     * 是否app登陆
     */

    private Boolean appEnabled;

    private Boolean locked;

    private String registerApp;

    private String dataRange;

    private String memo;

    private String ext;

    private Integer version;

    private Date createTime;

    private Date updateTime;

    private Integer splchainCo;

    /**
     * 用户类型
     */
    private String usrTp;

    private String ctfnTp;

    private String ctcpsn;

    private String ctcTel;

    private Integer adtInd;
    
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
    private String managerName;


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
     * 注册地址
     */
    private String rgtads;

    /**
     * 纳税人识别号
     */
    private String taxpyrIdNo;

    /**
     * 开户行
     */
    private String depbnk;

    /**
     * 银行账户号
     */
    private String bnkAccNo;

    /**
     * 备注
     */
    private String rmrk;
	// 附件文件名信息
    private String fileNames;
    
    // 待删除附件文件名信息（修改长约）
    private String filesToDelete;
    
    // 查询类型
    private Integer queryType;
    
    // 二级服务码
    private String secSrvCd;
    
    
	public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}

	public String getFilesToDelete() {
		return filesToDelete;
	}

	public void setFilesToDelete(String filesToDelete) {
		this.filesToDelete = filesToDelete;
	}

	public Integer getQueryType() {
		return queryType;
	}

	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}

	public String getSecSrvCd() {
		return secSrvCd;
	}

	public void setSecSrvCd(String secSrvCd) {
		this.secSrvCd = secSrvCd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getMobileVerified() {
		return mobileVerified;
	}

	public void setMobileVerified(Boolean mobileVerified) {
		this.mobileVerified = mobileVerified;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Boolean getAppEnabled() {
		return appEnabled;
	}

	public void setAppEnabled(Boolean appEnabled) {
		this.appEnabled = appEnabled;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getRegisterApp() {
		return registerApp;
	}

	public void setRegisterApp(String registerApp) {
		this.registerApp = registerApp;
	}

	public String getDataRange() {
		return dataRange;
	}

	public void setDataRange(String dataRange) {
		this.dataRange = dataRange;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getSplchainCo() {
		return splchainCo;
	}

	public void setSplchainCo(Integer splchainCo) {
		this.splchainCo = splchainCo;
	}

	public String getUsrTp() {
		return usrTp;
	}

	public void setUsrTp(String usrTp) {
		this.usrTp = usrTp;
	}

	public String getCtfnTp() {
		return ctfnTp;
	}

	public void setCtfnTp(String ctfnTp) {
		this.ctfnTp = ctfnTp;
	}

	public String getCtcpsn() {
		return ctcpsn;
	}

	public void setCtcpsn(String ctcpsn) {
		this.ctcpsn = ctcpsn;
	}

	public String getCtcTel() {
		return ctcTel;
	}

	public void setCtcTel(String ctcTel) {
		this.ctcTel = ctcTel;
	}

	public Integer getAdtInd() {
		return adtInd;
	}

	public void setAdtInd(Integer adtInd) {
		this.adtInd = adtInd;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRgtads() {
		return rgtads;
	}

	public void setRgtads(String rgtads) {
		this.rgtads = rgtads;
	}

	public String getTaxpyrIdNo() {
		return taxpyrIdNo;
	}

	public void setTaxpyrIdNo(String taxpyrIdNo) {
		this.taxpyrIdNo = taxpyrIdNo;
	}

	public String getDepbnk() {
		return depbnk;
	}

	public void setDepbnk(String depbnk) {
		this.depbnk = depbnk;
	}

	public String getBnkAccNo() {
		return bnkAccNo;
	}

	public void setBnkAccNo(String bnkAccNo) {
		this.bnkAccNo = bnkAccNo;
	}

	public String getRmrk() {
		return rmrk;
	}

	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
	}
       
}