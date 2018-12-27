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
}
