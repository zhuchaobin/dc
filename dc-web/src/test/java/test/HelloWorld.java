/*package test;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xai.tt.dc.client.service.WfDcService;
部署流程定义
public class HelloWorld {
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	@Autowired
	private WfDcService wfDcService;
	
	@Test
	public void deploymentProcessDefinition() {
		wfDcService.deploymentProcessDefinition();
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("diagrams/activiti.cfg.xml")	//
									.buildProcessEngine();
		System.out.println("processEngine:"+processEngine);
		Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的service
		.createDeployment()
		.name("helloworld入门程序")
		.addClasspathResource("diagrams/helloworld.bpmn")
		.addClasspathResource("diagrams/helloworld.png")
		.deploy();
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
	}
	启动流程实例
	@Test
	public void startProcessInstance() {
		String processDefinitionKey = "helloworld";
		ProcessInstance pi =processEngine.getRuntimeService()
		.startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程，key对应helloworld.bpmn文件中id的属性，使用key启动默认启动的是版本最新的流程
		System.out.println(pi.getId());
		System.out.println(pi.getProcessDefinitionId());
	}
	查询当前人的个人任务
	@Test
	public void findMyPersonalTadk() {
		String assignee = "张三";
		List<Task> list = processEngine.getTaskService()
			.createTaskQuery()
			.taskAssignee(assignee)
			.list();
		if(null != list && list.size() > 0) {
			for(Task task:list) {
				System.out.println("任务Id" + task.getId());
				System.out.println("任务名称" + task.getName());
				System.out.println("任务创建时间" + task.getCreateTime());
				System.out.println("任务办理人" + task.getAssignee());
				System.out.println("任务实例id" + task.getProcessInstanceId());
				System.out.println("执行对象id" + task.getExecutionId());
				System.out.println("流程定义id" + task.getProcessDefinitionId());
			}
		}
	}
	完成我的任务
	@Test
	public void completeMyPersonalTask() {
		String taskId = "302";
		processEngine.getTaskService()
		.complete(taskId);
		System.out.println("完成任务，任务ID" + taskId);
	}
	部署流程定义，从zip
	@Test
	public void deploymentProcessDefinnition_zip() {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("diagrams/diagrams.zip");
		ZipInputStream zipInputStream = new ZipInputStream(in);
		Deployment deployment = processEngine.getRepositoryService()
				.createDeployment()
				.name("流程定义")
				.addZipInputStream(zipInputStream)
				.deploy();
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
	}
	查询流程定义
	@Test
	public void findProcessDefinition() {
		String deploymentId = "801";
	List<ProcessDefinition>	list = processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
//		.processDefinitionId(processDefinitionId)
		//.orderByProcessDefinitionKey()
//		.processDefinitionNameLike(processDefinitionNameLike)
		.orderByProcessDefinitionVersion().asc()
		.list();
		
//		.deploymentId(deploymentId)
//		.list();
	if(null != list && list.size() > 0) {
		for(ProcessDefinition pd:list) {
			System.out.println("流程定义id=" + pd.getId());
			System.out.println("流程部署id=" + pd.getDeploymentId());
			System.out.println("流程定义描述id=" + pd.getDescription());
			System.out.println("流程定名称=" + pd.getName());
			System.out.println("资源名称bpmn" + pd.getResourceName());
			System.out.println("资源名称png" + pd.getDiagramResourceName());
		}
	}
	
	}
	查看流程图
	@Test
	public void viewPic() throws IOException {
		String deploymentId = "101";
		String resourceName = "";
		List<String> list = processEngine.getRepositoryService()
			.getDeploymentResourceNames(deploymentId);
		if(null != list && list.size() > 0) {
			for(String str:list) {
				if(str.indexOf(".png") >= 0)
					resourceName = str;
			}
		}
		
		//获取图片输入流
		InputStream in = processEngine.getRepositoryService()
				.getResourceAsStream(deploymentId, resourceName);
		File file = new File("D://" + resourceName);
//		FileUtils.copyFile(in, file);
	}
	查询最新版本流程定义
	@Test
	public void findLastVersionProcessDefinition() {
		List<ProcessDefinition> list = processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.processDefinitionName("helloworldProcess")
		.orderByProcessDefinitionVersion().asc()
		.list();
		Map<String, ProcessDefinition> map = new LinkedHashMap<String ,ProcessDefinition>();
		if(null != list  && list.size() > 0) {
			for(ProcessDefinition pd : list) {
				map.put(pd.getKey(), pd);
			}
		}
		List<ProcessDefinition> pdList = new ArrayList<ProcessDefinition>(map.values());
		if(pdList != null && pdList.size() > 0) {
			for(ProcessDefinition pd : pdList) {
				System.out.println("流程定义id=" + pd.getId());
				System.out.println("流程部署id=" + pd.getDeploymentId());
				System.out.println("流程定义描述id=" + pd.getDescription());
				System.out.println("流程定名称=" + pd.getName());
				System.out.println("资源名称bpmn" + pd.getResourceName());
				System.out.println("资源名称png" + pd.getDiagramResourceName());
				System.out.println("#####################");
			}
		}
	}
	
}
*/