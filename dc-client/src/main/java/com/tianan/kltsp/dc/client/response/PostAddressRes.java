package com.tianan.kltsp.dc.client.response;

import java.io.Serializable;

public class PostAddressRes implements Serializable {
	private static final long serialVersionUID = 1L;
	// 邮寄地址id
	private Integer id;
	// 姓名
	private String name;
	// 电话
	private String phone;
	// 地址信息
	private String area;
	// 是否默认 0.非默认 1.默认
	private Integer preferred;
	// 车主用户id
	private Integer carOwnerId;
	// 省份
	private String province;
	// 城市
	private String city;
	// 县
	private String county;
	// 邮编
	private String postalCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getPreferred() {
		return preferred;
	}

	public void setPreferred(Integer preferred) {
		this.preferred = preferred;
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Integer getCarOwnerId() {
		return carOwnerId;
	}

	public void setCarOwnerId(Integer carOwnerId) {
		this.carOwnerId = carOwnerId;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "PostAddressVo [id=" + id + ", name=" + name + ", phone=" + phone + ", area=" + area + ", preferred=" 
	+ preferred + ", car_owner_id=" + carOwnerId + ",province=" + province + ",city=" + city + ",county=" + county 
	+ ",postal_code=" + postalCode +"]";
	}	
}
