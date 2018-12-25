package com.xai.tt.dc.client.vo;

import com.xai.tt.dc.client.model.T2UploadAtch;
import com.xai.tt.dc.client.vo.outVo.QueryLnkJrnlInfOutVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class T6SpgInfDetailVo implements Serializable{
	private static final long serialVersionUID = 1L;
		
	// 附件信息
	private List<T2UploadAtch> t2UploadAtch01List;	

	public List<T2UploadAtch> getT2UploadAtch01List() {
		return t2UploadAtch01List;
	}
	public void setT2UploadAtch01List(List<T2UploadAtch> t2UploadAtch01List) {
		this.t2UploadAtch01List = t2UploadAtch01List;
	}
	// 环节流转信息
	List<QueryLnkJrnlInfOutVo> list;
	public List<QueryLnkJrnlInfOutVo> getList() {
		return list;
	}
	public void setList(List<QueryLnkJrnlInfOutVo> list) {
		this.list = list;
	}
	/**
     * ID
     */
    private Long id;
    


    /**
     * 发货编号
     */
    private String spgId;

    /**
     * 流程实例ID
     */
    private String processInstId;


	// 环节信息
	private String aplyPcstpCd;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpgId() {
		return spgId;
	}

	public void setSpgId(String spgId) {
		this.spgId = spgId;
	}

	public String getProcessInstId() {
		return processInstId;
	}

	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}

	public String getAplyPcstpCd() {
		return aplyPcstpCd;
	}

	public void setAplyPcstpCd(String aplyPcstpCd) {
		this.aplyPcstpCd = aplyPcstpCd;
	}
}
