package com.tianan.kltsp.dc.biz.utils;

/**
 * Created by linkun on 2017/12/27.
 */
public class LikeStrBuilder {

    public static final String LIKE = "%";


    public static String getLikeStr(String param) {
        StringBuilder sb = new StringBuilder();
        sb.append(LIKE).append(param).append(LIKE);
        return sb.toString();
    }
}
