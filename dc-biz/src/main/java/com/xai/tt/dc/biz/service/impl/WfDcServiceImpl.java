package com.xai.tt.dc.biz.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
import com.tianan.common.api.bean.Result;
import com.xai.tt.dc.biz.mapper.ActRuTaskMapper;
import com.xai.tt.dc.biz.utils.DataConstants;
import com.xai.tt.dc.client.query.WfeQuery;
import com.xai.tt.dc.client.service.WfDcService;

@SuppressWarnings("deprecation")
@Service("wfDcService")
public class WfDcServiceImpl implements WfDcService{
	private static final Logger logger = LoggerFactory.getLogger(WfDcServiceImpl.class);
	@Autowired
	private ActRuTaskMapper actRuTaskMapper;
	@Override
	/**
	 * 描述：工作流流程部署
	 * 成功：返回部署id；失败：返回null
	 * @author zhuchaobin 2018-11-17
	 */
	public String deploymentProcessDefinition(String flowNm) {
		// TODO Auto-generated method stub
		logger.debug("部署工作流,流程名：" + flowNm);
		try {
			ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")	//
					.buildProcessEngine();
			System.out.println("processEngine:"+processEngine);
			Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的service
			.createDeployment()
			.name(flowNm)
			.addClasspathResource("diagrams/" + flowNm + ".bpmn")
			.addClasspathResource("diagrams/" + flowNm + ".png")
			.deploy();
			if(null != deployment && StringUtils.isNotBlank(deployment.getId())) {
				logger.debug("部署工作流结束,流程id：" + deployment.getId() + ",流程名:" + flowNm);
				return deployment.getId();
			} else {
				logger.error("部署工作流失败,流程名:" + flowNm);
				return null;
			}
		} catch (Exception e) {
			logger.error("部署工作流发生异常,流程名:" + flowNm + e);
			return null;
		}		
	}
	/**
	 * 描述：启动最新版本流程的流程实例
	 * 成功：返回流程实例id；失败：返回null
	 * @author zhuchaobin 2018-11-17
	 */
	@Override
	public String startProcessInstance(String processDefinitionKey) {
		// TODO Auto-generated method stub
		logger.debug("启动流程实例,流程名：" + processDefinitionKey);
		try {
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
			ProcessInstance pi = processEngine.getRuntimeService()
					.startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程，key对应bpmn文件中id的属性，使用key启动默认启动的是版本最新的流程
					
			if(null != pi && StringUtils.isNotBlank(pi.getId())) {
				logger.debug("启动流程实例结束,流程实例id：" + pi.getId() + ",流程名:" + processDefinitionKey);
				return pi.getId();
			} else {
				logger.error("启动流程实例失败,流程名:" + processDefinitionKey);
				return null;
			}
		} catch (Exception e) {
			logger.error("启动流程实例发生异常,流程名:" + processDefinitionKey + e);
			return null;
		}	
	}	
	/*
	 * 拾取并提交任务
	 * 2018-11-21
	 */
	@Override
	public void claimAndCompleteTask(String id, String username, String aplyPcstpCd, String aplyPsrltCd) {
		logger.info("拾取并完成发起任务开始");
		// 拾取并完成发起任务
		try {
			// 查询任务id
			WfeQuery wfeQuery = new WfeQuery();
			wfeQuery.setArId(id);
//			wfeQuery.setTaskDefKey(DataConstants.TASK_DEF_KEY.get(aplyPcstpCd));
			String taskId = actRuTaskMapper.queryTaskId(wfeQuery);
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
			processEngine.getTaskService()
			.claim(taskId, username);
			System.out.println("拾取任务完成");
/*			processEngine.getTaskService()
			.complete(taskId);*/
			
			Map<String, Object> variables= new HashMap<String, Object>();
			if("01".equals(aplyPsrltCd))
				variables.put("flag", 1);
			else
				variables.put("flag", 0);
			processEngine.getTaskService()
			.complete(taskId, variables);
			
			logger.info("拾取并完成发起任务成功");
		} catch (Exception e) {
			logger.error("拾取并完成发起任务异常:" + e);
		}		
	}
}
