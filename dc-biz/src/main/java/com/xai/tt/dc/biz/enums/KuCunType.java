package com.xai.tt.dc.biz.enums;

/**
 * 银行卡状态
 * @author wangzhongbin
 * Date: 2018/10/29
 * Email:wangzhongbin@didichuxing.com
 * Description:
 */
public enum KuCunType {

    FA_HUO_KU_CUN("01", "发货形成库存"),
    ZI_YOU_KU_CUN("02", "非自有货物");


    private String code;
    private String desc;

    KuCunType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


}
