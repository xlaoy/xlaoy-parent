package com.xlaoy.innerapi.trade.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2018/6/19 0019.
 */
public interface ITradeController {

    public static final String BASE_REQUEST = "/trade";

    public static final String TEST_01 = "/test01";

    @GetMapping(value = BASE_REQUEST + TEST_01)
    String test01();
}
