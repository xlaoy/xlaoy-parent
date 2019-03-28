package com.xlaoy.trade.controller;

import com.xlaoy.common.support.UserGuidHolder;
import com.xlaoy.innerapi.trade.api.ITradeController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Api(tags = "交易 API")
@RestController
public class TradeTestController  {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/trade/test01")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test01() {

        return "";
    }

}
