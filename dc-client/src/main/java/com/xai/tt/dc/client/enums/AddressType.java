package com.xai.tt.dc.client.enums;

/**
 * 地址类型
 *
 * @author feng.xu on 2018/6/20.
 */
public enum AddressType {

    OTHER(0, "其他"), COMPANY(1, "公司"), HOME(2, "家");

    private int code;
    private String desc;

    AddressType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 用户维度唯一的地址类型
     */
    public static boolean isUserUnique(int code) {
        return code == HOME.getCode() || code == COMPANY.getCode();
    }

    public static AddressType byCode(int code) {
        for (AddressType temp : AddressType.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
