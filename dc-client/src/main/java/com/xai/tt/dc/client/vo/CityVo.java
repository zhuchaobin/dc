package com.xai.tt.dc.client.vo;

import java.io.Serializable;

public class CityVo implements Serializable {
	
	private String cityCode;
	
	private String cityName;
	
	private String provinceCode;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	@Override
	public String toString() {
		return "CityVo [cityCode=" + cityCode + ", cityName=" + cityName
				+ ", provinceCode=" + provinceCode + "]";
	}

}
