package com.xlaoy.common.support;

/**
 * Created by Administrator on 2018/3/1 0001.
 */
public class UserGuidHolder {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    public static String getGuid() {
        return local.get();
    }

    public static void setGuid(String guid) {
        local.set(guid);
    }
}
