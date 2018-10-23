package com.tianan.kltsp.dc.client.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "user_info")
public class UserInfo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 车主Id
     */
    @Column(name = "car_owner_id")
    private String carOwnerId;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;


    /**
     * 身份证Id号
     */
    @Column(name = "card_id")
    private String cardId;

    /**
     * 身份证有效期开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Column(name = "card_begin_date")
    private Date cardBeginDate;

    /**
     * 身份证有效期结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Column(name = "card_end_date")
    private Date cardEndDate;

    /**
     * 证件照1
     */
    @Column(name = "card_pic_one")
    private String cardPicOne;

    /**
     * 证件照2
     */
    @Column(name = "card_pic_two")
    private String cardPicTwo;

    /**
     * 数据逻辑状态 0-无效，1-有效
     */
    private Boolean status;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取车主Id
     *
     * @return car_owner_id - 车主Id
     */
    public String getCarOwnerId() {
        return carOwnerId;
    }

    /**
     * 设置车主Id
     *
     * @param carOwnerId 车主Id
     */
    public void setCarOwnerId(String carOwnerId) {
        this.carOwnerId = carOwnerId;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取身份证Id号
     *
     * @return card_id - 身份证Id号
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 设置身份证Id号
     *
     * @param cardId 身份证Id号
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * 获取身份证有效期开始时间
     *
     * @return card_begin_date - 身份证有效期开始时间
     */
    public Date getCardBeginDate() {
        return cardBeginDate;
    }

    /**
     * 设置身份证有效期开始时间
     *
     * @param cardBeginDate 身份证有效期开始时间
     */
    public void setCardBeginDate(Date cardBeginDate) {
        this.cardBeginDate = cardBeginDate;
    }

    /**
     * 获取身份证有效期结束时间
     *
     * @return card_end_date - 身份证有效期结束时间
     */
    public Date getCardEndDate() {
        return cardEndDate;
    }

    /**
     * 设置身份证有效期结束时间
     *
     * @param cardEndDate 身份证有效期结束时间
     */
    public void setCardEndDate(Date cardEndDate) {
        this.cardEndDate = cardEndDate;
    }

    /**
     * 获取证件照1
     *
     * @return card_pic_one - 证件照1
     */
    public String getCardPicOne() {
        return cardPicOne;
    }

    /**
     * 设置证件照1
     *
     * @param cardPicOne 证件照1
     */
    public void setCardPicOne(String cardPicOne) {
        this.cardPicOne = cardPicOne;
    }

    /**
     * 获取证件照2
     *
     * @return card_pic_two - 证件照2
     */
    public String getCardPicTwo() {
        return cardPicTwo;
    }

    /**
     * 设置证件照2
     *
     * @param cardPicTwo 证件照2
     */
    public void setCardPicTwo(String cardPicTwo) {
        this.cardPicTwo = cardPicTwo;
    }

    /**
     * 获取数据逻辑状态 0-无效，1-有效
     *
     * @return status - 数据逻辑状态 0-无效，1-有效
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置数据逻辑状态 0-无效，1-有效
     *
     * @param status 数据逻辑状态 0-无效，1-有效
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}