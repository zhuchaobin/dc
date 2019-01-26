package com.xai.tt.dc.client.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.xai.tt.dc.client.query.UserInfoQuery;

public class MsgVo  extends UserInfoQuery implements Serializable {
	private static final long serialVersionUID = 1L;
    /**
     * 查询开始日期
     */
	 private String queryStdt;
	/**
	 * 查询结束日期
	 */
	private String queryEddt;
	
    public String getQueryStdt() {
		return queryStdt;
	}

	public void setQueryStdt(String queryStdt) {
		this.queryStdt = queryStdt;
	}

	public String getQueryEddt() {
		return queryEddt;
	}

	public void setQueryEddt(String queryEddt) {
		this.queryEddt = queryEddt;
	}

	/**
     * 消息接收状态代码
     */
    private String msgRevStcd;
    
    /**
     * 消息接收id
     */
    private Long msgRevId;
    
    /**
     * 操作员id
     */
    private Integer currentUserId;
    
    
    public Integer getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}

	public Long getMsgRevId() {
		return msgRevId;
	}

	public void setMsgRevId(Long msgRevId) {
		this.msgRevId = msgRevId;
	}

	public String getMsgRevStcd() {
		return msgRevStcd;
	}

	public void setMsgRevStcd(String msgRevStcd) {
		this.msgRevStcd = msgRevStcd;
	}

	private Long id;
    
    // 二级服务码 01：发件箱查询  02： 收件箱查询 03：草稿箱查询 04：删除查询 
    // 05：逻辑删除 06：物理删除 07：保存草稿 08：发送 09：读取消息
    private String secSrvCd;
	/**
     * 全字段模糊检索关键字
     */
	private String keyWorlds;
    /**
     * 消息编号
     */
    private Integer msgId;

    /**
     * 接收人ID
     */
    private Long rcvPsnId;

    /**
     * 消息状态代码
     */
    private String msgStcd;

    /**
     * 时间戳
     */
    private Date tms;

    /**
     * 操作员
     */
    private String username;
    /**
     * 消息发送时间
     */
    private Date msgSndTm;

    /**
     * 消息标题
     */
    private String msgTitle;

    /**
     * 发送人ID
     */
    private Long sndPsnId;

    /**
     * 接收人列表
     */
    private String rcvPsnList;

    /**
     * 消息类型代码
     */
    private String msgTpcd;

    /**
     * 群发标志
     */
    private Boolean mulInd;
    
    /**
     * 消息内容
     */
    private String msgCntnt;
    
    /**
     * 发送人公司
     */
    private String sndPsnCo;
    
    /**
     * 发送人角色
     */
    private Integer sndPsnUsrtype;
    
    /**
     * 发送人username
     */
    private String sndPsnUserName;

	public String getSndPsnUserName() {
		return sndPsnUserName;
	}

	public void setSndPsnUserName(String sndPsnUserName) {
		this.sndPsnUserName = sndPsnUserName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Long getRcvPsnId() {
		return rcvPsnId;
	}

	public void setRcvPsnId(Long rcvPsnId) {
		this.rcvPsnId = rcvPsnId;
	}

	public String getMsgStcd() {
		return msgStcd;
	}

	public void setMsgStcd(String msgStcd) {
		this.msgStcd = msgStcd;
	}

	public Date getTms() {
		return tms;
	}

	public void setTms(Date tms) {
		this.tms = tms;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getMsgSndTm() {
		return msgSndTm;
	}

	public void setMsgSndTm(Date msgSndTm) {
		this.msgSndTm = msgSndTm;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public Long getSndPsnId() {
		return sndPsnId;
	}

	public void setSndPsnId(Long sndPsnId) {
		this.sndPsnId = sndPsnId;
	}

	public String getRcvPsnList() {
		return rcvPsnList;
	}

	public void setRcvPsnList(String rcvPsnList) {
		this.rcvPsnList = rcvPsnList;
	}

	public String getMsgTpcd() {
		return msgTpcd;
	}

	public void setMsgTpcd(String msgTpcd) {
		this.msgTpcd = msgTpcd;
	}

	public Boolean getMulInd() {
		return mulInd;
	}

	public void setMulInd(Boolean mulInd) {
		this.mulInd = mulInd;
	}

	public String getMsgCntnt() {
		return msgCntnt;
	}

	public void setMsgCntnt(String msgCntnt) {
		this.msgCntnt = msgCntnt;
	}

	public String getSndPsnCo() {
		return sndPsnCo;
	}

	public void setSndPsnCo(String sndPsnCo) {
		this.sndPsnCo = sndPsnCo;
	}

	public Integer getSndPsnUsrtype() {
		return sndPsnUsrtype;
	}

	public void setSndPsnUsrtype(Integer sndPsnUsrtype) {
		this.sndPsnUsrtype = sndPsnUsrtype;
	}

	public String getSecSrvCd() {
		return secSrvCd;
	}

	public void setSecSrvCd(String secSrvCd) {
		this.secSrvCd = secSrvCd;
	}

	public String getKeyWorlds() {
		return keyWorlds;
	}

	public void setKeyWorlds(String keyWorlds) {
		this.keyWorlds = keyWorlds;
	}
	
	
}