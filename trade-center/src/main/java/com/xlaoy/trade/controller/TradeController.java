package com.xlaoy.trade.controller;

import com.xlaoy.common.support.UserGuidHolder;
import com.xlaoy.innerapi.trade.api.ITradeController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Api(tags = "交易 API")
@RestController
@RequestMapping(ITradeController.BASE_REQUEST)
public class TradeController implements ITradeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${trade.test}")
    private String name;

    @Override
    @GetMapping(value = ITradeController.TEST_01)
    @ApiOperation(response = String.class, value = "获取名称")
    public String test01() {
        logger.info(">>>>>>>>>" + UserGuidHolder.getGuid());
        /*try {
            Thread.sleep(6500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //int a = 1 / 0;
        return name;
    }


}
