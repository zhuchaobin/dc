package com.xai.tt.dc.client.vo.inVo;

import java.util.Date;
import com.xai.tt.dc.client.query.UserInfoQuery;
import lombok.Data;
/**
 * 
 * <pre>
 * 融资申请请求报文
 * </pre>
 * <small> 2019-03-20 23:41:27 | zhuchaobin</small>
 */
 @Data
public class FncAplyInVo extends UserInfoQuery {
	
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


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCtcpsn() {
		return ctcpsn;
	}


	public void setCtcpsn(String ctcpsn) {
		this.ctcpsn = ctcpsn;
	}


	public String getCtcTel() {
		return ctcTel;
	}


	public void setCtcTel(String ctcTel) {
		this.ctcTel = ctcTel;
	}


	public String getFncRqmDsc() {
		return fncRqmDsc;
	}


	public void setFncRqmDsc(String fncRqmDsc) {
		this.fncRqmDsc = fncRqmDsc;
	}


	public Date getAplyTm() {
		return aplyTm;
	}


	public void setAplyTm(Date aplyTm) {
		this.aplyTm = aplyTm;
	}


	public String getAplyChnl() {
		return aplyChnl;
	}


	public void setAplyChnl(String aplyChnl) {
		this.aplyChnl = aplyChnl;
	}


	public Date getModTm() {
		return modTm;
	}


	public void setModTm(Date modTm) {
		this.modTm = modTm;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Date getPcsTm() {
		return pcsTm;
	}


	public void setPcsTm(Date pcsTm) {
		this.pcsTm = pcsTm;
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


    /** 公司全称 */
    private String companyName;


    /** 电子邮箱 */
    private String email;


    /** 联系人 */
    private String ctcpsn;


    /** 联系电话 */
    private String ctcTel;


    /** 融资需求描述 */
    private String fncRqmDsc;


    /** 申请时间 */
    private Date aplyTm;


    /** 申请渠道 */
    private String aplyChnl;


    /** 修改时间 */
    private Date modTm;


    /** 处理人 */
    private String username;


    /** 处理时间 */
    private Date pcsTm;


    /** 处理备注 */
    private String rmrk;

}
