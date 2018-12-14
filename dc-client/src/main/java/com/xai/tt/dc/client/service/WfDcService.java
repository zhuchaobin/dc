package com.xai.tt.dc.client.service;

/**
 * 工作流服务
 * @author zhuchaobin
 * 2018-11-17
 */
public interface WfDcService {
	/**
	 * 描述：工作流流程部署
	 * 成功：返回部署id；失败：返回null
	 * @author zhuchaobin 2018-11-17
	 */
	String deploymentProcessDefinition(String flowNm);
	/**
	 * 描述：启动最新版本流程的流程实例
	 * 成功：返回流程实例id；失败：返回null
	 * @author zhuchaobin 2018-11-17
	 */
	String startProcessInstance(String processDefinitionKey);
	/*
	 * 拾取并提交任务
	 * 2018-11-21
	 * @author zhuchaobin
	 */
	void claimAndCompleteTask(String id, String username, String aplyPcstpCd, String aplyPsrltCd);
	/**
	 * 描述：挂起流程实例
	 * 成功：返回true；失败：返回false
	 * @author zhuchaobin 2018-12-13
	 */	
	boolean suspendProcessInstanceById(String processInstanceId);
}
