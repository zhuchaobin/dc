package com.xai.tt.dc.client.vo.outVo;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class QueryPageSpgOutVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 长约编号
	 */
	private String arId;

	/**
	 * 流程实例ID
	 */
	private String processInstId;


	/**
	 * 订单编号
	 */
	private String ordrId;


	/**
	 * 发货编号
	 */
	private String spgId;


	/**
	 * 发货时间
	 */
	private String spgTm;


	/**
	 * 发货人
	 */
	private String spgPsn;



	/**
	 * 发货人联系电话
	 */
	private String spgPsnCtcTel;

	/**
	 * 收货人
	 */
	private String cnsgn;

	/**
	 * 收货人联系电话
	 */
	private String cnsgnCtcTel;

	/**
	 * 目的地
	 */
	private String ppsLnd;

	/**
	 * 时间戳
	 */
	private Date tms;

	/**
	 * 发货状态
	 */
	private String spgSt;

	/**
	 * 操作员
	 */
	private String username;

	/**
	 * 创建时间
	 */
	private Date crtTm;

	private String aplyPcstpCdName;


	// 查询类型
	private Integer queryType;

	// 二级服务码
	private String secSrvCd;

	// 环节信息
	private String aplyPcstpCd;


	public String getAplyPcstpCdName() {
		return aplyPcstpCdName;
	}

	public void setAplyPcstpCdName(String aplyPcstpCdName) {
		this.aplyPcstpCdName = aplyPcstpCdName;
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

	public String getAplyPcstpCd() {
		return aplyPcstpCd;
	}

	public void setAplyPcstpCd(String aplyPcstpCd) {
		this.aplyPcstpCd = aplyPcstpCd;
	}

	public String getArId() {
		return arId;
	}

	public void setArId(String arId) {
		this.arId = arId;
	}

	public String getProcessInstId() {
		return processInstId;
	}

	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}

	public String getOrdrId() {
		return ordrId;
	}

	public void setOrdrId(String ordrId) {
		this.ordrId = ordrId;
	}

	public String getSpgId() {
		return spgId;
	}

	public void setSpgId(String spgId) {
		this.spgId = spgId;
	}

	public String getSpgTm() {
		return spgTm;
	}

	public void setSpgTm(String spgTm) {
		this.spgTm = spgTm;
	}

	public String getSpgPsn() {
		return spgPsn;
	}

	public void setSpgPsn(String spgPsn) {
		this.spgPsn = spgPsn;
	}

	public String getSpgPsnCtcTel() {
		return spgPsnCtcTel;
	}

	public void setSpgPsnCtcTel(String spgPsnCtcTel) {
		this.spgPsnCtcTel = spgPsnCtcTel;
	}

	public String getCnsgn() {
		return cnsgn;
	}

	public void setCnsgn(String cnsgn) {
		this.cnsgn = cnsgn;
	}

	public String getCnsgnCtcTel() {
		return cnsgnCtcTel;
	}

	public void setCnsgnCtcTel(String cnsgnCtcTel) {
		this.cnsgnCtcTel = cnsgnCtcTel;
	}

	public String getPpsLnd() {
		return ppsLnd;
	}

	public void setPpsLnd(String ppsLnd) {
		this.ppsLnd = ppsLnd;
	}

	public Date getTms() {
		return tms;
	}

	public void setTms(Date tms) {
		this.tms = tms;
	}

	public String getSpgSt() {
		return spgSt;
	}

	public void setSpgSt(String spgSt) {
		this.spgSt = spgSt;
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
}
