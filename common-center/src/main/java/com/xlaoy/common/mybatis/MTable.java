package com.xlaoy.common.mybatis;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2019/3/28 0028.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MTable {

    String name();
}
