package com.xai.tt.dc.client.entity;

import java.io.Serializable;
import java.util.Date;

import com.xai.tt.dc.client.enums.Locked;

public class Factory implements Serializable{
    private Integer id;

    private Date createTime;

    private String code;

    private String name;

    private String managerName;

    private String email;

    private String mobile;

    private String province;

    private String city;

    private String address;

    private Locked locked;

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

	public Locked getLocked() {
		return locked;
	}

	public void setLocked(Locked locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "Factory [id=" + id + ", createTime=" + createTime + ", code="
				+ code + ", name=" + name + ", managerName=" + managerName
				+ ", email=" + email + ", mobile=" + mobile + ", province="
				+ province + ", city=" + city + ", address=" + address
				+ ", locked=" + locked + "]";
	}

}