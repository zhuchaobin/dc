package com.xai.tt.dc.client.vo.outVo;

import java.io.Serializable;
import java.util.Date;

public class GdsBlgOutVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long gdsBlgId;
	private String gdsBlgNm;
	// 当前质押总货值
	private float plgPdValue;
	// 合作银行
	private String bnkNm;
	// 合作仓储
	private String stgNm;
	// 相关长约
	private String arId; 
	
	public String getArId() {
		return arId;
	}
	public void setArId(String arId) {
		this.arId = arId;
	}
	public Long getGdsBlgId() {
		return gdsBlgId;
	}
	public void setGdsBlgId(Long gdsBlgId) {
		this.gdsBlgId = gdsBlgId;
	}
	public String getGdsBlgNm() {
		return gdsBlgNm;
	}
	public void setGdsBlgNm(String gdsBlgNm) {
		this.gdsBlgNm = gdsBlgNm;
	}
	public float getPlgPdValue() {
		return plgPdValue;
	}
	public void setPlgPdValue(float plgPdValue) {
		this.plgPdValue = plgPdValue;
	}
	public String getBnkNm() {
		return bnkNm;
	}
	public void setBnkNm(String bnkNm) {
		this.bnkNm = bnkNm;
	}
	public String getStgNm() {
		return stgNm;
	}
	public void setStgNm(String stgNm) {
		this.stgNm = stgNm;
	}

}
