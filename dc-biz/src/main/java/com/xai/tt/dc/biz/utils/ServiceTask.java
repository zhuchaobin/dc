package com.xai.tt.dc.biz.utils;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;

import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

public class ServiceTask implements JavaDelegate {
	// 流程变量
//	private Expression text1;
	private static final Logger logger = LoggerFactory.getLogger(ServiceTask.class);
	
	@Override

	public void execute(DelegateExecution execution) {
	/*	try {*/
			logger.info("serviceTask开始执行！");	
			String processInstanceId = execution.getProcessInstanceId();
			String spgId = (String) execution.getVariable("Spg_ID");
			logger.info("自动质押服务processInstanceId=" + processInstanceId + "， spgId=" + spgId);
			if(StringUtils.isNoneBlank(spgId)) {
/*				// 自动设置质押
				Condition condition = new Condition(T17IvntDtl.class);
				Example.Criteria criteria = condition.createCriteria();
				criteria.andCondition("Spg_ID = '" + spgId + "'");
				criteria.andCondition("Plg_Aply_St = '03'");
				List<T17IvntDtl> t17List = t17IvntDtlMapper.selectByCondition(condition);
				if(null != t17List && t17List.size() > 0) {
					for(T17IvntDtl t17 : t17List) {
						if(null != t17) {
							t17.setPlgAplySt("04");
							t17IvntDtlMapper.updateByPrimaryKeySelective(t17);
						}
					}
				} else {
					logger.error("自动质押服务, 查询不到库存信息！");
				}*/
/*				 execution.getClass();
				boolean rlt = plgAplyDcService.autoPlg(spgId);
				logger.info("rlt=" + rlt);*/
				logger.info("自动质押完成，发货id：" + spgId + ", processInstanceId=" + processInstanceId );
			} else {
				logger.error("获取发货ID失败，自动质押失败。");
			}
/*		} catch (Exception e) {
			logger.error("自动质押发生异常：" + e.toString());
		}*/
	}

}
