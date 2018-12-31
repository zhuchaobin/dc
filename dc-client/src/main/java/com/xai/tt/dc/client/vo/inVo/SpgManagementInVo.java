package com.xai.tt.dc.client.vo.inVo;

import com.xai.tt.dc.client.model.T7SpgDetail;
import com.xai.tt.dc.client.query.UserInfoQuery;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public class SpgManagementInVo extends UserInfoQuery {



    List<T7SpgDetail> t7SpgDetailList;
	
	/**
     * 全字段模糊检索关键字
     */
	private String keyWorlds;
	


    /**
     * ID
     */
    private Long id;

    /**
     * 长约编号
     */
    private String arId;

    /**
     * 订单编号
     */
    private String ordrId;

    /**
     * 发货编号
     */
    private String spgId;

    /**
     * 流程实例ID
     */
    private String processInstId;

    /**
     * 发货时间
     */
    private Date spgTm;

    /**
     * 发货人
     */
    private String spgPsn;

    /**
     * 发货人联系电话
     */
    private String spgPsnCtcTel;

    /**
     * 收货人
     */
    private String cnsgn;

    /**
     * 收货人联系电话
     */
    private String cnsgnCtcTel;

    /**
     * 目的地
     */
    private String ppsLnd;

    /**
     * 时间戳
     */
    private Date tms;

    /**
     * 发货状态
     */
    private String spgSt;



    // 附件文件名信息
    private String fileNames;

    // 待删除附件文件名信息（修改长约）
    private String filesToDelete;

    // 预警线
    private Float wnln;

    // 查询类型
    private Integer queryType;

    // 二级服务码
    private String secSrvCd;


    /**
     * 融资企业
     */
    private Integer fncEntp;


    /**
     * 上游供应商
     */
    private Integer ustrmSplr;



    /**
     * 供应链公司
     */
    private Integer splchainCo;


    /**
     * 仓储公司
     */
    private Integer stgco;

    /**
     * 银行
     */
    private Integer bnk;

    /**
     * 物流公司
     */
    private Integer lgstcCo;

    /**
     * 保险公司
     */
    private Integer insCo;


    /**
     * 付款方式
     */
    private String pymtmod;



    public String getKeyWorlds() {
        return keyWorlds;
    }

    public void setKeyWorlds(String keyWorlds) {
        this.keyWorlds = keyWorlds;
    }

    public List<T7SpgDetail> getT7SpgDetailList() {
        return t7SpgDetailList;
    }

    public void setT7SpgDetailList(List<T7SpgDetail> t7SpgDetailList) {
        this.t7SpgDetailList = t7SpgDetailList;
    }

    public String getPymtmod() {
        return pymtmod;
    }

    public void setPymtmod(String pymtmod) {
        this.pymtmod = pymtmod;
    }

    public Integer getStgco() {
        return stgco;
    }

    public void setStgco(Integer stgco) {
        this.stgco = stgco;
    }

    public Integer getBnk() {
        return bnk;
    }

    public void setBnk(Integer bnk) {
        this.bnk = bnk;
    }

    public Integer getLgstcCo() {
        return lgstcCo;
    }

    public void setLgstcCo(Integer lgstcCo) {
        this.lgstcCo = lgstcCo;
    }

    public Integer getInsCo() {
        return insCo;
    }

    public void setInsCo(Integer insCo) {
        this.insCo = insCo;
    }

    public Integer getUstrmSplr() {
        return ustrmSplr;
    }

    public void setUstrmSplr(Integer ustrmSplr) {
        this.ustrmSplr = ustrmSplr;
    }

    @Override
    public Integer getSplchainCo() {
        return splchainCo;
    }

    @Override
    public void setSplchainCo(Integer splchainCo) {
        this.splchainCo = splchainCo;
    }

    public Integer getFncEntp() {
        return fncEntp;
    }

    public void setFncEntp(Integer fncEntp) {
        this.fncEntp = fncEntp;
    }

    public String getFileNames() {
        return fileNames;
    }

    public void setFileNames(String fileNames) {
        this.fileNames = fileNames;
    }

    public String getFilesToDelete() {
        return filesToDelete;
    }

    public void setFilesToDelete(String filesToDelete) {
        this.filesToDelete = filesToDelete;
    }

    public Float getWnln() {
        return wnln;
    }

    public void setWnln(Float wnln) {
        this.wnln = wnln;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    public String getSecSrvCd() {
        return secSrvCd;
    }

    public void setSecSrvCd(String secSrvCd) {
        this.secSrvCd = secSrvCd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId;
    }

    public String getOrdrId() {
        return ordrId;
    }

    public void setOrdrId(String ordrId) {
        this.ordrId = ordrId;
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

    public Date getSpgTm() {
        return spgTm;
    }

    public void setSpgTm(Date spgTm) {
        this.spgTm = spgTm;
    }

    public String getSpgPsn() {
        return spgPsn;
    }

    public void setSpgPsn(String spgPsn) {
        this.spgPsn = spgPsn;
    }

    public String getSpgPsnCtcTel() {
        return spgPsnCtcTel;
    }

    public void setSpgPsnCtcTel(String spgPsnCtcTel) {
        this.spgPsnCtcTel = spgPsnCtcTel;
    }

    public String getCnsgn() {
        return cnsgn;
    }

    public void setCnsgn(String cnsgn) {
        this.cnsgn = cnsgn;
    }

    public String getCnsgnCtcTel() {
        return cnsgnCtcTel;
    }

    public void setCnsgnCtcTel(String cnsgnCtcTel) {
        this.cnsgnCtcTel = cnsgnCtcTel;
    }

    public String getPpsLnd() {
        return ppsLnd;
    }

    public void setPpsLnd(String ppsLnd) {
        this.ppsLnd = ppsLnd;
    }

    public Date getTms() {
        return tms;
    }

    public void setTms(Date tms) {
        this.tms = tms;
    }

    public String getSpgSt() {
        return spgSt;
    }

    public void setSpgSt(String spgSt) {
        this.spgSt = spgSt;
    }
}