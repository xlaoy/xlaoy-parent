package com.xlaoy.user.controller;

import com.xlaoy.innerapi.trade.sao.ITradeSao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Api(tags = "用户Other API")
@RestController
public class UserOtherController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${gitrepodatabasedbpwd:}")
    private String gitrepodatabasedbpwd;

    @GetMapping(value = "/user_other/test01")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test01() {
        return gitrepodatabasedbpwd;
    }

}
