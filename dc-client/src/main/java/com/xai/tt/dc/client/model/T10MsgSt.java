package com.xai.tt.dc.client.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t10_msg_st")
public class T10MsgSt {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 消息编号
     */
    @Column(name = "Msg_ID")
    private Integer msgId;

    /**
     * 接收人ID
     */
    @Column(name = "Rcv_Psn_ID")
    private Long rcvPsnId;

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
     * 获取消息编号
     *
     * @return Msg_ID - 消息编号
     */
    public Integer getMsgId() {
        return msgId;
    }

    /**
     * 设置消息编号
     *
     * @param msgId 消息编号
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     * 获取接收人ID
     *
     * @return Rcv_Psn_ID - 接收人ID
     */
    public Long getRcvPsnId() {
        return rcvPsnId;
    }

    /**
     * 设置接收人ID
     *
     * @param rcvPsnId 接收人ID
     */
    public void setRcvPsnId(Long rcvPsnId) {
        this.rcvPsnId = rcvPsnId;
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
}