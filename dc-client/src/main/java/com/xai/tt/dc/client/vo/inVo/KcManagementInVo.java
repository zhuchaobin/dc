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
