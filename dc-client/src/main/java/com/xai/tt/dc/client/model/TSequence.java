package com.xai.tt.dc.client.model;

import javax.persistence.*;

@Table(name = "t_sequence")
public class TSequence {
    @Id
    private String name;

    @Column(name = "begin_num")
    private Integer beginNum;

    private Integer incr;

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return begin_num
     */
    public Integer getBeginNum() {
        return beginNum;
    }

    /**
     * @param beginNum
     */
    public void setBeginNum(Integer beginNum) {
        this.beginNum = beginNum;
    }

    /**
     * @return incr
     */
    public Integer getIncr() {
        return incr;
    }

    /**
     * @param incr
     */
    public void setIncr(Integer incr) {
        this.incr = incr;
    }
}