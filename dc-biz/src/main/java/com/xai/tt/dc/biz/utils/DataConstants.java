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
	
	// 环节
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
}
