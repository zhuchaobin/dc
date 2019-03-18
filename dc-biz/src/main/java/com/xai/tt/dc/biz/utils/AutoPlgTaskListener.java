package com.xai.tt.dc.biz.utils;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.delegate.TaskListener;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xai.tt.dc.biz.mapper.T17IvntDtlMapper;
import com.xai.tt.dc.client.model.T17IvntDtl;
import com.xai.tt.dc.client.service.PlgAplyDcService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

/**
 * 
 * 
 * 
 * 项目名称：lightmvc
 * 
 * 类名称：ServiceTask
 * 
 * 类描述：
 * 
 * 创建人：邓家海
 * 
 * 修改备注：
 * 
 * @version
 * 
 * 
 * 
 */
/*@SuppressWarnings("deprecation")
@Service(value = "serviceTask")  */
@Component //组件 可以把这放到spring容器中
public class AutoPlgTaskListener  implements TaskListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7290556008496226716L;

	// 流程变量
//	private Expression text1;
	private static final Logger logger = LoggerFactory.getLogger(AutoPlgTaskListener.class);

	@Autowired
	private T17IvntDtlMapper t17IvntDtlMapper;
	@Autowired
	private PlgAplyDcService plgAplyDcService;
	

	@Override
	public void notify(DelegateTask delegateTask) {
		logger.info("notify开始执行！");	
		String processInstanceId = delegateTask.getProcessInstanceId();
		String spgId = (String) delegateTask.getVariable("Spg_ID");
		logger.info("自动质押服务processInstanceId=" + processInstanceId + "， spgId=" + spgId);
		if(StringUtils.isNoneBlank(spgId)) {
			boolean rlt = plgAplyDcService.autoPlg(spgId);
			logger.info("rlt=" + rlt);
			logger.info("自动质押完成，发货id：" + spgId + ", processInstanceId=" + processInstanceId );
		} else {
			logger.error("获取发货ID失败，自动质押失败。");
		}
			
	}


}
