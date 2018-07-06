package com.xlaoy.common.utils;

import java.util.UUID;

/**
 * Created by Administrator on 2018/7/6 0006.
 */
public class IDWorkUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
