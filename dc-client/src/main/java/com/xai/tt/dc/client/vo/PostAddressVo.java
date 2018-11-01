package com.xai.tt.dc.client.vo;

import java.io.Serializable;

public class PostAddressVo implements Serializable {
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
	// 买家账号
	private String userName;
	// 用户名
	private String chineseName;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

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
}
