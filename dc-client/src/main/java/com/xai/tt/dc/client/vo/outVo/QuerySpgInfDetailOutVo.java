package com.xai.tt.dc.client.vo.outVo;

import com.xai.tt.dc.client.model.T2UploadAtch;
import com.xai.tt.dc.client.model.T6SpgInf;
import com.xai.tt.dc.client.model.T7SpgDetail;

import java.io.Serializable;
import java.util.List;


public class QuerySpgInfDetailOutVo extends T6SpgInf implements Serializable{
	private static final long serialVersionUID = 1L;
		
	// 附件信息
	private List<T2UploadAtch> t2UploadAtch01List;	

	// 环节流转信息
	List<QueryLnkJrnlInfOutVo> list;


	List<T7SpgDetail> t7SpgDetailList;

	// 用户角色参数权限信息
	List<String> roleParmsList;

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

	// 付款方式
	private String pymtMod;

	public String getSpecialDiv() {
		return specialDiv;
	}

	public void setSpecialDiv(String specialDiv) {
		this.specialDiv = specialDiv;
	}

	private String specialDiv;

	public String getPymtMod() {
		return pymtMod;
	}

	public void setPymtMod(String pymtMod) {
		this.pymtMod = pymtMod;
	}

	public List<QueryLnkJrnlInfOutVo> getList() {
		return list;
	}
	public void setList(List<QueryLnkJrnlInfOutVo> list) {
		this.list = list;
	}

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


	public List<T2UploadAtch> getT2UploadAtch01List() {
		return t2UploadAtch01List;
	}
	public void setT2UploadAtch01List(List<T2UploadAtch> t2UploadAtch01List) {
		this.t2UploadAtch01List = t2UploadAtch01List;
	}

	public List<T7SpgDetail> getT7SpgDetailList() {
		return t7SpgDetailList;
	}

	public void setT7SpgDetailList(List<T7SpgDetail> t7SpgDetailList) {
		this.t7SpgDetailList = t7SpgDetailList;
	}

	public List<String> getRoleParmsList() {
		return roleParmsList;
	}

	public void setRoleParmsList(List<String> roleParmsList) {
		this.roleParmsList = roleParmsList;
	}
}
