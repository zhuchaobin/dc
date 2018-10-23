package com.tianan.kltsp.dc.biz.utils;

import org.nustaq.serialization.FSTConfiguration;

public class FSTUtil {

    private static final FSTConfiguration conf = FSTConfiguration.createAndroidDefaultConfiguration();

    public static byte[] toByte(Object object) {
        return conf.asByteArray(object);
    }
}
