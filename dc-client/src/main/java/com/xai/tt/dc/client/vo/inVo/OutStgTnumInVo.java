package com.xai.tt.dc.client.vo.inVo;

import java.util.List;

import com.xai.tt.dc.client.query.UserInfoQuery;

public class OutStgTnumInVo extends UserInfoQuery{
	// 出库总货值
	private float outPlgPdValue;
	/**
     * ID
     */
    private Long id;
    
	/**
     * 长约编号
     */
    private String arId;

    /**
     * 融资企业
     */
    private Integer fncEntp;

    /**
     * 上游供应商
     */
    private Integer ustrmSplr;

    /**
     * 仓储公司
     */
    private Integer stgco;

    /**
     * 银行
     */
    private Integer bnk;

    /**
     * 物流公司
     */
    private Integer lgstcCo;

    /**
     * 保险公司
     */
    private Integer insCo;

    /**
     * 供应链公司
     */
    private Integer splchainCo;
        
    /**
     * 发货编号
     */
    private String spgId;
    
    /**
     * 仓单编号
     */
    private String whrecptId;

    /**
     * 质押单号
     */
    private String plgBillno;
    
	List<OutStgTnumSubInVo> outStgTnumSubInVoList;

	public float getOutPlgPdValue() {
		return outPlgPdValue;
	}

	public void setOutPlgPdValue(float outPlgPdValue) {
		this.outPlgPdValue = outPlgPdValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArId() {
		return arId;
	}

	public void setArId(String arId) {
		this.arId = arId;
	}

	public Integer getFncEntp() {
		return fncEntp;
	}

	public void setFncEntp(Integer fncEntp) {
		this.fncEntp = fncEntp;
	}

	public Integer getUstrmSplr() {
		return ustrmSplr;
	}

	public void setUstrmSplr(Integer ustrmSplr) {
		this.ustrmSplr = ustrmSplr;
	}

	public Integer getStgco() {
		return stgco;
	}

	public void setStgco(Integer stgco) {
		this.stgco = stgco;
	}

	public Integer getBnk() {
		return bnk;
	}

	public void setBnk(Integer bnk) {
		this.bnk = bnk;
	}

	public Integer getLgstcCo() {
		return lgstcCo;
	}

	public void setLgstcCo(Integer lgstcCo) {
		this.lgstcCo = lgstcCo;
	}

	public Integer getInsCo() {
		return insCo;
	}

	public void setInsCo(Integer insCo) {
		this.insCo = insCo;
	}

	public Integer getSplchainCo() {
		return splchainCo;
	}

	public void setSplchainCo(Integer splchainCo) {
		this.splchainCo = splchainCo;
	}

	public String getSpgId() {
		return spgId;
	}

	public void setSpgId(String spgId) {
		this.spgId = spgId;
	}

	public String getWhrecptId() {
		return whrecptId;
	}

	public void setWhrecptId(String whrecptId) {
		this.whrecptId = whrecptId;
	}

	public String getPlgBillno() {
		return plgBillno;
	}

	public void setPlgBillno(String plgBillno) {
		this.plgBillno = plgBillno;
	}

	public List<OutStgTnumSubInVo> getOutStgTnumSubInVoList() {
		return outStgTnumSubInVoList;
	}

	public void setOutStgTnumSubInVoList(List<OutStgTnumSubInVo> outStgTnumSubInVoList) {
		this.outStgTnumSubInVoList = outStgTnumSubInVoList;
	}
  
}