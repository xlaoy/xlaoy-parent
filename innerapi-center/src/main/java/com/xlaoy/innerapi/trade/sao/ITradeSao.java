package com.xlaoy.innerapi.trade.sao;

import com.xlaoy.innerapi.config.ApplactionName;
import com.xlaoy.innerapi.trade.TradeFeignConfig;
import com.xlaoy.innerapi.trade.api.ITradeController;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
@FeignClient(
    name = ApplactionName.TRADE_SERVER,
    configuration = TradeFeignConfig.class
)
public interface ITradeSao extends ITradeController {

}
