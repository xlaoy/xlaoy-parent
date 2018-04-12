package com.xlaoy.innerapi.trade;

import com.xlaoy.innerapi.config.ApplactionName;
import com.xlaoy.innerapi.trade.fallback.ITradeSaoFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
@FeignClient(
    name = ApplactionName.TRADE_SERVER,
    configuration = TradeFeignConfig.class,
    fallback = ITradeSaoFallBack.class
)
public interface ITradeSao {

    /**
     * com.xlaoy.trade.controller.TradeController.test01
     * @return
     */
    @GetMapping(value = "/trade/test01")
    String getHH();
}
