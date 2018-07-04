package com.xlaoy.user.controller;

import com.xlaoy.common.exception.BizException;
import com.xlaoy.common.support.UserGuidHolder;
import com.xlaoy.innerapi.config.BizHystrixBadRequestException;
import com.xlaoy.innerapi.trade.sao.ITradeSao;
import com.xlaoy.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Api(tags = "用户 API")
@RestController
@RefreshScope
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${xlaoy.user}")
    private String name;
    @Value("${gitreponame}")
    private String gitreponame;
    @Value("${gitrepodatabasedbpwd}")
    private String gitrepodatabasedbpwd;

    @Autowired
    private ITradeSao tradeSao;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/test01")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test01(@RequestParam("heheda") String heheda) {
        logger.info("UserGuidHolder.getGuid=" + UserGuidHolder.getGuid());
        userService.test01();
        return name;
    }

    @GetMapping(value = "/user/test02")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test02() {
        logger.info("UserGuidHolder.getGuid=" + UserGuidHolder.getGuid());
        try {
            tradeSao.test01();
        } catch (BizHystrixBadRequestException e) {
            if(e.getErrorKey().equals("1001")) {
                logger.info("尼玛海");
            } else {
                logger.info("好吧");
            }
        }
        return "qqq";
    }

    @GetMapping(value = "/user/test03")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test03() {
        logger.info("UserGuidHolder.getGuid=" + UserGuidHolder.getGuid());
        return gitreponame;
    }

    @GetMapping(value = "/user/test04")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test04() {
        logger.info("UserGuidHolder.getGuid=" + UserGuidHolder.getGuid());
        return gitrepodatabasedbpwd;
    }

}
