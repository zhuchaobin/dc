package com.xai.tt.dc.client.vo.inVo;

import com.xai.tt.dc.client.query.UserInfoQuery;

import javax.persistence.Column;

public class KcManagementInVo extends UserInfoQuery {



    /**
     * 运单编号
     */

    private String tprtBlId;

    /**
     * 发货编号
     */
    private String spgId;


    /**
     * 库存状态
     */
    private String ivntSt;



    public String getIvntSt() {
        return ivntSt;
    }

    public void setIvntSt(String ivntSt) {
        this.ivntSt = ivntSt;
    }

    public String getTprtBlId() {
        return tprtBlId;
    }

    public void setTprtBlId(String tprtBlId) {
        this.tprtBlId = tprtBlId;
    }

    public String getSpgId() {
        return spgId;
    }

    public void setSpgId(String spgId) {
        this.spgId = spgId;
    }
}
