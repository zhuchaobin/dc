package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;
import com.xai.tt.dc.client.query.UserInfoQuery;
import lombok.Data;
/**
 * 
 * <pre>
 * 质押指导价请求报文
 * </pre>
 * <small> 2019-03-16 01:56:08 | xai-auto</small>
 */
 @Data
public class PlgDrcPrcInVo extends UserInfoQuery {
	
	public String getKeyWorlds() {
		return keyWorlds;
	}


	public void setKeyWorlds(String keyWorlds) {
		this.keyWorlds = keyWorlds;
	}


	public String getSecSrvCd() {
		return secSrvCd;
	}


	public void setSecSrvCd(String secSrvCd) {
		this.secSrvCd = secSrvCd;
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


	public String getOrdrId() {
		return ordrId;
	}


	public void setOrdrId(String ordrId) {
		this.ordrId = ordrId;
	}


	public Long getBnk() {
		return bnk;
	}


	public void setBnk(Long bnk) {
		this.bnk = bnk;
	}


	public String getBnkNm() {
		return bnkNm;
	}


	public void setBnkNm(String bnkNm) {
		this.bnkNm = bnkNm;
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


	public String getSpec() {
		return spec;
	}


	public void setSpec(String spec) {
		this.spec = spec;
	}


	public Float getPlgDrcPrc() {
		return plgDrcPrc;
	}


	public void setPlgDrcPrc(Float plgDrcPrc) {
		this.plgDrcPrc = plgDrcPrc;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Date getCrtTm() {
		return crtTm;
	}


	public void setCrtTm(Date crtTm) {
		this.crtTm = crtTm;
	}


	public Date getUdtTm() {
		return udtTm;
	}


	public void setUdtTm(Date udtTm) {
		this.udtTm = udtTm;
	}


	public Date getTms() {
		return tms;
	}


	public void setTms(Date tms) {
		this.tms = tms;
	}


	public String getRmrk() {
		return rmrk;
	}


	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
	}


	/**
     * 全字段模糊检索关键字
     */
	private String keyWorlds;
	/**
     * 全字段模糊检索关键字
     */
	private String secSrvCd;


    /** id */
    private Long id;


    /** 长约编号 */
    private String arId;


    /** 订单编号 */
    private String ordrId;


    /** 银行id */
    private Long bnk;


    /** 银行名称 */
    private String bnkNm;


    /** 品名id */
    private Long pdId;


    /** 品名 */
    private String pdNm;


    /** 规格 */
    private String spec;


    /** 质押指导价 */
    private Float plgDrcPrc;


    /** 操作员 */
    private String username;


    /** 创建时间 */
    private Date crtTm;


    /** 更新时间 */
    private Date udtTm;


    /** 时间戳 */
    private Date tms;


    /** 备注 */
    private String rmrk;

}
