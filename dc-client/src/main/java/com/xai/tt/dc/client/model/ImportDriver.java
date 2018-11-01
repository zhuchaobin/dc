package com.xai.tt.dc.client.model;

import java.io.Serializable;

public class ImportDriver implements Serializable{

    private String chineseName;

    private String mobile;

    private String idNum;
    
    private String companyCode;

    private Integer companyId;

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "ImportDriver [chineseName=" + chineseName + ", mobile="
				+ mobile + ", idNum=" + idNum + ", companyCode=" + companyCode
				+ ", companyId=" + companyId + "]";
	}
    
}
