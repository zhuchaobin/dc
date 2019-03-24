package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;
import com.xai.tt.dc.client.query.UserInfoQuery;
import lombok.Data;
/**
 * 
 * <pre>
 * 品名指导价请求报文
 * </pre>
 * <small> 2019-03-21 15:23:49 | zhuchaobin</small>
 */
 @Data
public class PdNmDrcPrcInVo extends UserInfoQuery {
	
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


	public Long getPdId() {
		return pdId;
	}


	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}


	public String getAcqDt() {
		return acqDt;
	}


	public void setAcqDt(String acqDt) {
		this.acqDt = acqDt;
	}


	public String getSrcTpcd() {
		return srcTpcd;
	}


	public void setSrcTpcd(String srcTpcd) {
		this.srcTpcd = srcTpcd;
	}


	public String getSrcDsc() {
		return srcDsc;
	}


	public void setSrcDsc(String srcDsc) {
		this.srcDsc = srcDsc;
	}


	public Float getDrcPrc() {
		return drcPrc;
	}


	public void setDrcPrc(Float drcPrc) {
		this.drcPrc = drcPrc;
	}


	public Date getTms() {
		return tms;
	}


	public void setTms(Date tms) {
		this.tms = tms;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


    /** ID */
    private Long id;


    /** 品名ID */
    private Long pdId;


    /** 获取日期 */
    private String acqDt;


    /** 来源类型代码 */
    private String srcTpcd;


    /** 来源描述 */
    private String srcDsc;


    /** 指导价 */
    private Float drcPrc;


    /** 时间戳 */
    private Date tms;


    /** 操作员 */
    private String username;


    /** 备注 */
    private String rmrk;

}
