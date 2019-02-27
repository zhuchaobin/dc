package com.xai.tt.dc.client.query;

import java.util.Date;

import javax.persistence.Column;

import com.tianan.common.api.mybatis.SortQuery;
import com.xai.tt.dc.client.enums.Locked;

public class CompanyQuery extends SortQuery {
    private Integer pageNo;
    
    private Integer pageSize;
    
    
    public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	private Integer id;

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
    private String usrTp;

	/**
	 * 用户名称
	 */
	private String userName;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUsrTp() {
		return usrTp;
	}

	public void setUsrTp(String usrTp) {
		this.usrTp = usrTp;
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
    
    
}
