package com.xlaoy.innerapi.trade.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2018/6/19 0019.
 */
public interface ITradeController {

    @GetMapping("/trade/test01")
    String test01();
}
