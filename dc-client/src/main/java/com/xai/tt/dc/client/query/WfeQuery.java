package com.xai.tt.dc.client.query;

import com.tianan.common.api.mybatis.SortQuery;

public class WfeQuery extends SortQuery {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 长约编号
	private String arId;
	// 订单编号
	private String ordrId;
	// 订单编号
	private String username;
	// 任务名称KEY
	private String taskDefKey;
	// 流程实例编号
	private String procInstId;
	
	
	public String getTaskDefKey() {
		return taskDefKey;
	}
	public void setTaskDefKey(String taskDefKey) {
		this.taskDefKey = taskDefKey;
	}
	public String getProcInstId() {
		return procInstId;
	}
	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
}
