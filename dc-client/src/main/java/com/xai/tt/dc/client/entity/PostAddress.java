package com.xai.tt.dc.client.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "post_address")
public class PostAddress implements Serializable{
	
	private static final long serialVersionUID = 1L;
    /**
     * 邮寄地址id
     */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   
    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;
    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 地址信息
     */
    @Column(name = "area")
    private String area;
    /**
     * 是否默认 0.非默认 1.默认
     */
    @Column(name = "preferred")
    private String preferred;
    /**
     * 车主用户id
     */
    @Column(name = "car_owner_id")
    private Integer carOwnerId;
    /**
     * 省份
     */
    @Column(name = "province")
    private String province;
    /**
     * 城市
     */
    @Column(name = "city")
    private String city;
    /**
     * 县
     */
    @Column(name = "county")
    private String county;
    /**
     * 邮编
     */
    @Column(name = "postal_code")
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
	public String getPreferred() {
		return preferred;
	}
	public void setPreferred(String preferred) {
		this.preferred = preferred;
	}
	public Integer getCarOwnerId() {
		return carOwnerId;
	}
	public void setCarOwnerId(Integer carOwnerId) {
		this.carOwnerId = carOwnerId;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}