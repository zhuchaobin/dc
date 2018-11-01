package com.xai.tt.dc.client.vo;

import java.io.Serializable;

public class ProvinceVo implements Serializable {
	
	private String provinceCode;
	
	private String provinceName;
	
	public String getProvinceCode() {
		return provinceCode;
	}
	
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	@Override
	public String toString() {
		return "ProvinceVo [provinceCode=" + provinceCode + ", provinceName="
				+ provinceName + "]";
	}
	
}
