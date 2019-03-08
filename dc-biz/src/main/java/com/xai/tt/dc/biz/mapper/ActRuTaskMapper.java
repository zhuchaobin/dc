package com.xai.tt.dc.biz.mapper;

import com.xai.tt.dc.client.model.ActRuTask;
import com.xai.tt.dc.client.query.WfeQuery;
import com.xai.tt.dc.biz.core.Mapper;

public interface ActRuTaskMapper extends Mapper<ActRuTask> {
	String queryTaskId(WfeQuery wfeQuery);
	String queryOrderTaskId(WfeQuery wfeQuery);
	Integer isEndProcess(String processInstId);
	String querySpgTaskId(WfeQuery wfeQuery);
	
}