package com.xlaoy.innerapi.trade.api;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2018/6/19 0019.
 */
public interface ITradeController {

    //@Cacheable(value = "test01", keyGenerator = "keyGenerator")
    @GetMapping("/trade/test01/{userId}/{uid}")
    String test01(@PathVariable("userId")String userId, @PathVariable("uid")String uid);
}
