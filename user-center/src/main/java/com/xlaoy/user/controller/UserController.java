package com.xlaoy.user.controller;

import com.xlaoy.innerapi.trade.sao.ITradeSao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Api(tags = "用户 API")
@RestController
@RequestMapping("/user")
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

    @GetMapping(value = "/test01")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test01() {
        return name;
    }

    @GetMapping(value = "/test02")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test02() {
        return tradeSao.test01();
    }

    @GetMapping(value = "/test03")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test03() {
        return gitreponame;
    }

    @GetMapping(value = "/test04")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test04() {
        return gitrepodatabasedbpwd;
    }

}
