package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;
import com.xai.tt.dc.client.query.UserInfoQuery;
import lombok.Data;
/**
 * 
 * <pre>
 * 企业信息2请求报文
 * </pre>
 * <small> 2019-03-23 23:10:26 | zhuchaobin</small>
 */
 @Data
public class Company2InVo extends UserInfoQuery {
	
	public String getKeyWorlds() {
		return keyWorlds;
	}


	public void setKeyWorlds(String keyWorlds) {
		this.keyWorlds = keyWorlds;
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


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
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


	public Boolean getLocked() {
		return locked;
	}


	public void setLocked(Boolean locked) {
		this.locked = locked;
	}


	public String getUsrTp() {
		return usrTp;
	}


	public void setUsrTp(String usrTp) {
		this.usrTp = usrTp;
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


	public String getEntpSocCrCd() {
		return entpSocCrCd;
	}


	public void setEntpSocCrCd(String entpSocCrCd) {
		this.entpSocCrCd = entpSocCrCd;
	}


	/**
     * 全字段模糊检索关键字
     */
	private String keyWorlds;
	/**
     * 全字段模糊检索关键字
     */
	private String secSrvCd;


    /**  */
    private Integer id;


    /**  */
    private Date createTime;


    /** 代码 */
    private String code;


    /** 名称 */
    private String name;


    /** 负责人 */
    private String managerName;


    /** 邮件 */
    private String email;


    /** 电话号 */
    private String mobile;


    /** 省份 */
    private String province;


    /** 城市 */
    private String city;


    /** 地址信息 */
    private String address;


    /** 是否冻结 冻结:TRUE  ;未冻结：FALSE */
    private Boolean locked;


    /** 用户类型 */
    private String usrTp;


    /** 注册地址 */
    private String rgtads;


    /** 纳税人识别号 */
    private String taxpyrIdNo;


    /** 开户行 */
    private String depbnk;


    /** 银行账户号 */
    private String bnkAccNo;


    /** 备注 */
    private String rmrk;


    /** 企业社会信用代码 */
    private String entpSocCrCd;

}
