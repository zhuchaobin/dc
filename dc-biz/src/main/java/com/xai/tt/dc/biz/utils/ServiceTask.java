package com.xai.tt.dc.biz.utils;

import org.activiti.engine.delegate.DelegateExecution;

import org.activiti.engine.delegate.Expression;

import org.activiti.engine.delegate.JavaDelegate;

 

/**  

 *   

 * 项目名称：lightmvc  

 * 类名称：ServiceTask  

 * 类描述：  

 * 创建人：邓家海  

 * 创建时间：2017年6月4日 下午6:18:11  

 * 修改人：deng  

 * 修改时间：2017年6月4日 下午6:18:11  

 * 修改备注：  

 * @version   

 *   

 */

 

public class ServiceTask implements JavaDelegate{

//流程变量

private Expression text1;

 

//重写委托的提交方法

@Override

public void execute(DelegateExecution execution) {

System.out.println("serviceTask已经执行已经执行！");

String value1 = (String) text1.getValue(execution);

System.out.println(value1);

    execution.setVariable("var1", new StringBuffer(value1).reverse().toString());

}

 

}
