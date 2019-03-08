package com.xai.tt.dc.client.vo.inVo;

import com.xai.tt.dc.client.query.UserInfoQuery;

public class IvntDtlInVo extends UserInfoQuery {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 全字段模糊检索关键字
     */
	private String keyWorlds;
	
    public String getKeyWorlds() {
		return keyWorlds;
	}

	public void setKeyWorlds(String keyWorlds) {
		this.keyWorlds = keyWorlds;
	}
	
    /**
     * 入库开始日期
     */
    private String stdt;

    /**
     * 入库结束日期
     */
    private String eddt;
    
    public String getStdt() {
		return stdt;
	}

	public void setStdt(String stdt) {
		this.stdt = stdt;
	}

	public String getEddt() {
		return eddt;
	}

	public void setEddt(String eddt) {
		this.eddt = eddt;
	}

	/**
     * 长约编号
     */
    private String arId;

    /**
     * 长约类型
     */
    private String arTp;

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
     * 长约开始日期
     */
    private String arStdt;

    /**
     * 长约结束日期
     */
    private String arEddt;

    
    // 查询类型
    private Integer queryType;
    
    // 二级服务码
    private String secSrvCd;
    
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
    
    /**
     * 入库类型
     */
    private String intrsrTp;

    /**
     * 品名id
     */
    private Long pdId;

    /**
     * 品名
     */
    private String pdNm;
    
    /**
     * 库位
     */
    private String strPos;

    /**
     * 货物归属ID
     */
    private Long gdsBlgId;

    /**
     * 货物归属公司名
     */
    private String gdsBlgNm;
    
    /**
     * 质押申请状态
     */
    private String plgAplySt;

	public String getArId() {
		return arId;
	}

	public void setArId(String arId) {
		this.arId = arId;
	}

	public String getArTp() {
		return arTp;
	}

	public void setArTp(String arTp) {
		this.arTp = arTp;
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

	public String getArStdt() {
		return arStdt;
	}

	public void setArStdt(String arStdt) {
		this.arStdt = arStdt;
	}

	public String getArEddt() {
		return arEddt;
	}

	public void setArEddt(String arEddt) {
		this.arEddt = arEddt;
	}

	public Integer getQueryType() {
		return queryType;
	}

	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}

	public String getSecSrvCd() {
		return secSrvCd;
	}

	public void setSecSrvCd(String secSrvCd) {
		this.secSrvCd = secSrvCd;
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

	public String getIntrsrTp() {
		return intrsrTp;
	}

	public void setIntrsrTp(String intrsrTp) {
		this.intrsrTp = intrsrTp;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public String getPdNm() {
		return pdNm;
	}

	public void setPdNm(String pdNm) {
		this.pdNm = pdNm;
	}

	public String getStrPos() {
		return strPos;
	}

	public void setStrPos(String strPos) {
		this.strPos = strPos;
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

	public String getPlgAplySt() {
		return plgAplySt;
	}

	public void setPlgAplySt(String plgAplySt) {
		this.plgAplySt = plgAplySt;
	}
   
}