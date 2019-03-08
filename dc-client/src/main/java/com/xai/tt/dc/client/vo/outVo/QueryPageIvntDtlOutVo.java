package com.xai.tt.dc.client.vo.outVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.xai.tt.dc.client.model.T13GdsDetail;
import com.xai.tt.dc.client.model.T17IvntDtl;

public class QueryPageIvntDtlOutVo implements Serializable {
	private static final long serialVersionUID = 1L;
	List<T17IvntDtl> t17IvntDtlList;
	public List<T17IvntDtl> getT17IvntDtlList() {
		return t17IvntDtlList;
	}
	public void setT17IvntDtlList(List<T17IvntDtl> t17IvntDtlList) {
		this.t17IvntDtlList = t17IvntDtlList;
	}
}
