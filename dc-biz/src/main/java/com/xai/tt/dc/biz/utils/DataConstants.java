package com.xai.tt.dc.biz.utils;

import java.util.HashMap;

public class DataConstants {
	// 长约流程名
	public static final String PROCESS_NAME_AR = "ARFlow";
	// 订单流程名
	public static final String PROCESS_NAME_ORDER = "OrderFlow";
	// 发货流程名
	public static final String PROCESS_NAME_SPG = "SpgFlow";
	
	// 环节
	public static final HashMap<String, String> APLY_PCSTP_CD = new HashMap<String, String>();
	static {
		// 长约发起（平台）
		APLY_PCSTP_CD.put("AR_Itt_Pltfrm", "01");
		// 长约确认(供应链)
		APLY_PCSTP_CD.put("AR_Cfm_SplChain", "02");
		// 长约确认(下游)
		APLY_PCSTP_CD.put("AR_Cfm_Dwstr_Entp", "03");
		// 确认承保（保险公司）
		APLY_PCSTP_CD.put("AR_Cfm_Ins_Co", "04");
		// 长约一审（平台）
		APLY_PCSTP_CD.put("AR_FrstIns_Pltfrm", "05");
		// 长约二审（平台）
		APLY_PCSTP_CD.put("AR_SndInsc_Pltfrm", "06");
		// 长约终止（平台）
		APLY_PCSTP_CD.put("AR_Tmt_Pltfrm", "07");
	}

	// 环节
	public static final HashMap<String, String> TASK_DEF_KEY = new HashMap<String, String>();
	static {
		// 长约发起（平台）
		TASK_DEF_KEY.put("01", "AR_Itt_Pltfrm");
		// 长约确认(供应链)
		TASK_DEF_KEY.put("02", "AR_Cfm_SplChain");
		// 长约确认(下游)
		TASK_DEF_KEY.put("03", "AR_Cfm_Dwstr_Entp");
		// 确认承保（保险公司）
		TASK_DEF_KEY.put("04", "AR_Cfm_Ins_Co");
		// 长约一审（平台）
		TASK_DEF_KEY.put("05", "AR_FrstIns_Pltfrm");
		// 长约二审（平台）
		TASK_DEF_KEY.put("06", "AR_SndInsc_Pltfrm");
		// 长约终止（平台）
		TASK_DEF_KEY.put("07", "AR_Tmt_Pltfrm");
	}
	
	// 用户类型
	public static final HashMap<Integer, String> USER_TYPE_2_USR_TP = new HashMap<Integer, String>();
	static {
		// 平台
		USER_TYPE_2_USR_TP.put(1, "01");
		// 上游供应商
		USER_TYPE_2_USR_TP.put(2, "02");
		// 供应链公司
		USER_TYPE_2_USR_TP.put(3, "03");
		// 融资企业
		USER_TYPE_2_USR_TP.put(4, "04");
		// 保险公司
		USER_TYPE_2_USR_TP.put(5, "05");
		// 银行
		USER_TYPE_2_USR_TP.put(6, "06");
		// 物流公司
		USER_TYPE_2_USR_TP.put(7, "07");
		// 仓储公司
		USER_TYPE_2_USR_TP.put(8, "08");
	}
	
	// 用户类型
	public static final HashMap<String, String> APLY_PCSTPCD_2_CHS = new HashMap<String, String>();
	static {
		// 长约发起（平台）
		APLY_PCSTPCD_2_CHS.put("01", "长约发起（平台）");
		// 长约确认(供应链)
		APLY_PCSTPCD_2_CHS.put("02", "长约确认(供应链)");
		// 长约确认(下游)
		APLY_PCSTPCD_2_CHS.put("03", "长约确认(下游)");
		// 确认承保（保险公司）
		APLY_PCSTPCD_2_CHS.put("04", "确认承保（保险公司）");
		// 长约一审（平台）
		APLY_PCSTPCD_2_CHS.put("05", "长约一审（平台）");
		// 长约二审（平台）
		APLY_PCSTPCD_2_CHS.put("06", "长约二审（平台）");
		// 长约终止（平台）
		APLY_PCSTPCD_2_CHS.put("07", "长约终止（平台）");
		// 订单发起(供应链)
		APLY_PCSTPCD_2_CHS.put("31", "订单发起(供应链)");
		// 订单审核(平台)
		APLY_PCSTPCD_2_CHS.put("32", "订单审核(平台)");
		// 保证金支付(下游)
		APLY_PCSTPCD_2_CHS.put("33", "保证金支付(下游)");
		// 融资发放(银行)
		APLY_PCSTPCD_2_CHS.put("34", "融资发放(银行)");
		// 货款支付(下游)
		APLY_PCSTPCD_2_CHS.put("35", "货款支付(下游)");
		// 货款支付(供应链)
		APLY_PCSTPCD_2_CHS.put("36", "货款支付(供应链)");
		// 确认收款(供应链)
		APLY_PCSTPCD_2_CHS.put("37", "确认收款(供应链)");
		// 确认承保(保险公司)
		APLY_PCSTPCD_2_CHS.put("38", "确认承保(保险公司)");
		// 订单终止(供应链)
		APLY_PCSTPCD_2_CHS.put("39", "订单终止(供应链)");
		// 发货发起(上游)
		APLY_PCSTPCD_2_CHS.put("61", "发货发起(上游)");
		// 接货承运(物流)
		APLY_PCSTPCD_2_CHS.put("62", "接货承运(物流)");
		// 接货入库(仓储)
		APLY_PCSTPCD_2_CHS.put("63", "接货入库(仓储)");
		// 货款支付(供应链)
		APLY_PCSTPCD_2_CHS.put("64", "货款支付(供应链)");
		// 选择赎货方式(供应链)
		APLY_PCSTPCD_2_CHS.put("65", "选择赎货方式(供应链)");
		// 选择赎货方式并支付(供应链)
		APLY_PCSTPCD_2_CHS.put("66", "选择赎货方式并支付(供应链)");
		// 回款赎货(下游)
		APLY_PCSTPCD_2_CHS.put("67", "回款赎货(下游)");
		// 质押置换(供应链)
		APLY_PCSTPCD_2_CHS.put("68", "质押置换(供应链)");
		// 出质通知转货权(银行)
		APLY_PCSTPCD_2_CHS.put("69", "出质通知转货权(银行)");
		// 通知转货权(银行)
		APLY_PCSTPCD_2_CHS.put("70", "通知转货权(银行)");
		// 通知转货权(供应链)
		APLY_PCSTPCD_2_CHS.put("71", "通知转货权(供应链)");
		// 转货权1(仓储)
		APLY_PCSTPCD_2_CHS.put("72", "转货权1(仓储)");
		// 转货权1确定质押(仓储)
		APLY_PCSTPCD_2_CHS.put("73", "转货权1确定质押(仓储)");
		// 存入自有货物回款赎货(下游)
		APLY_PCSTPCD_2_CHS.put("74", "存入自有货物回款赎货(下游)");
		// 通知解押(银行)
		APLY_PCSTPCD_2_CHS.put("75", "通知解押(银行)");
		// 转货权2(仓储)
		APLY_PCSTPCD_2_CHS.put("76", "转货权2(仓储)");
		// 提取货物(下游)
		APLY_PCSTPCD_2_CHS.put("77", "提取货物(下游)");
		// 发货终止(供应链)
		APLY_PCSTPCD_2_CHS.put("79", "发货终止(供应链)");

	}
}
