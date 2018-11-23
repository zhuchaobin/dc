package com.xai.tt.dc.client.query;

import java.util.Date;

import com.tianan.common.api.mybatis.SortQuery;
import com.xai.tt.dc.client.enums.Locked;

public class T1ARInfQuery extends SortQuery {
	private Integer id;
	
    private Date createTimeStart;
    
    private Date createTimeEnd;

    private String code;

    private String name;

    private String managerName;

    private String email;

    private String mobile;
    
    private String province;

    private String city;

    private String address;

    private Locked locked;

    private String codeLike;
    private String nameLike;
    private String managerNameLike;
    private String mobileLike;

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
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

	public Locked getLocked() {
		return locked;
	}

	public void setLocked(Locked locked) {
		this.locked = locked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCodeLike() {
		return codeLike;
	}

	public void setCodeLike(String codeLike) {
		this.codeLike = codeLike;
	}

	public String getNameLike() {
		return nameLike;
	}

	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}

	public String getManagerNameLike() {
		return managerNameLike;
	}

	public void setManagerNameLike(String managerNameLike) {
		this.managerNameLike = managerNameLike;
	}

	public String getMobileLike() {
		return mobileLike;
	}

	public void setMobileLike(String mobileLike) {
		this.mobileLike = mobileLike;
	}

	@Override
	public String toString() {
		return "FactoryQuery [id=" + id + ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd
				+ ", code=" + code + ", name=" + name + ", managerName=" + managerName + ", email=" + email
				+ ", mobile=" + mobile + ", province=" + province + ", city=" + city + ", address=" + address
				+ ", locked=" + locked + ", codeLike=" + codeLike + ", nameLike=" + nameLike + ", managerNameLike="
				+ managerNameLike + ", mobileLike=" + mobileLike + "]";
	}
}
