package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t9_msg_snd")
public class T9MsgSnd {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 消息发送时间
     */
    @Column(name = "Msg_Snd_Tm")
    private Date msgSndTm;

    /**
     * 消息标题
     */
    @Column(name = "Msg_Title")
    private String msgTitle;

    /**
     * 发送人ID
     */
    @Column(name = "Snd_Psn_ID")
    private Long sndPsnId;

    /**
     * 接收人列表
     */
    @Column(name = "Rcv_Psn_List")
    private String rcvPsnList;

    /**
     * 接收人id列表
     */
    @Column(name = "Rcv_Psn_Id_List")
    private String rcvPsnIdList;

    /**
     * 消息类型代码
     */
    @Column(name = "Msg_TpCd")
    private String msgTpcd;

    /**
     * 群发标志
     */
    @Column(name = "Mul_Ind")
    private Boolean mulInd;

    /**
     * 消息状态代码
     */
    @Column(name = "Msg_StCd")
    private String msgStcd;

    /**
     * 时间戳
     */
    @Column(name = "Tms")
    private Date tms;

    /**
     * 操作员
     */
    private String username;

    /**
     * 消息内容
     */
    @Column(name = "Msg_Cntnt")
    private String msgCntnt;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取消息发送时间
     *
     * @return Msg_Snd_Tm - 消息发送时间
     */
    public Date getMsgSndTm() {
        return msgSndTm;
    }

    /**
     * 设置消息发送时间
     *
     * @param msgSndTm 消息发送时间
     */
    public void setMsgSndTm(Date msgSndTm) {
        this.msgSndTm = msgSndTm;
    }

    /**
     * 获取消息标题
     *
     * @return Msg_Title - 消息标题
     */
    public String getMsgTitle() {
        return msgTitle;
    }

    /**
     * 设置消息标题
     *
     * @param msgTitle 消息标题
     */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    /**
     * 获取发送人ID
     *
     * @return Snd_Psn_ID - 发送人ID
     */
    public Long getSndPsnId() {
        return sndPsnId;
    }

    /**
     * 设置发送人ID
     *
     * @param sndPsnId 发送人ID
     */
    public void setSndPsnId(Long sndPsnId) {
        this.sndPsnId = sndPsnId;
    }

    /**
     * 获取接收人列表
     *
     * @return Rcv_Psn_List - 接收人列表
     */
    public String getRcvPsnList() {
        return rcvPsnList;
    }

    /**
     * 设置接收人列表
     *
     * @param rcvPsnList 接收人列表
     */
    public void setRcvPsnList(String rcvPsnList) {
        this.rcvPsnList = rcvPsnList;
    }

    /**
     * 获取接收人id列表
     *
     * @return Rcv_Psn_Id_List - 接收人id列表
     */
    public String getRcvPsnIdList() {
        return rcvPsnIdList;
    }

    /**
     * 设置接收人id列表
     *
     * @param rcvPsnIdList 接收人id列表
     */
    public void setRcvPsnIdList(String rcvPsnIdList) {
        this.rcvPsnIdList = rcvPsnIdList;
    }

    /**
     * 获取消息类型代码
     *
     * @return Msg_TpCd - 消息类型代码
     */
    public String getMsgTpcd() {
        return msgTpcd;
    }

    /**
     * 设置消息类型代码
     *
     * @param msgTpcd 消息类型代码
     */
    public void setMsgTpcd(String msgTpcd) {
        this.msgTpcd = msgTpcd;
    }

    /**
     * 获取群发标志
     *
     * @return Mul_Ind - 群发标志
     */
    public Boolean getMulInd() {
        return mulInd;
    }

    /**
     * 设置群发标志
     *
     * @param mulInd 群发标志
     */
    public void setMulInd(Boolean mulInd) {
        this.mulInd = mulInd;
    }

    /**
     * 获取消息状态代码
     *
     * @return Msg_StCd - 消息状态代码
     */
    public String getMsgStcd() {
        return msgStcd;
    }

    /**
     * 设置消息状态代码
     *
     * @param msgStcd 消息状态代码
     */
    public void setMsgStcd(String msgStcd) {
        this.msgStcd = msgStcd;
    }

    /**
     * 获取时间戳
     *
     * @return Tms - 时间戳
     */
    public Date getTms() {
        return tms;
    }

    /**
     * 设置时间戳
     *
     * @param tms 时间戳
     */
    public void setTms(Date tms) {
        this.tms = tms;
    }

    /**
     * 获取操作员
     *
     * @return username - 操作员
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作员
     *
     * @param username 操作员
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取消息内容
     *
     * @return Msg_Cntnt - 消息内容
     */
    public String getMsgCntnt() {
        return msgCntnt;
    }

    /**
     * 设置消息内容
     *
     * @param msgCntnt 消息内容
     */
    public void setMsgCntnt(String msgCntnt) {
        this.msgCntnt = msgCntnt;
    }
}