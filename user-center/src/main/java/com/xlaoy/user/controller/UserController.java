package com.xlaoy.user.controller;

import com.xlaoy.common.support.UserGuidHolder;
import com.xlaoy.innerapi.trade.sao.ITradeSao;
import com.xlaoy.user.config.RefreshValue;
import com.xlaoy.user.dto.UserDTO;
import com.xlaoy.user.service.UserService;
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
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Value("${xlaoy.user:}")
    private String name;
    @Value("${gitrepodatabasedbpwd:}")
    private String gitrepodatabasedbpwd;*/

    @Autowired
    private ITradeSao tradeSao;
    @Autowired
    private UserService userService;
    @Autowired
    private RefreshValue refreshValueConfig;

    @GetMapping(value = "/user/test01")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test01(@RequestParam("heheda") String heheda) {
        logger.info("UserGuidHolder.getGuid=" + UserGuidHolder.getGuid());
        userService.test01();
        return "";
    }

    @GetMapping(value = "/user/test02/{userId}/{uid}")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test02(@PathVariable("userId")String userId, @PathVariable("uid")String uid) {
        logger.info("UserGuidHolder.getGuid=" + UserGuidHolder.getGuid());
        return tradeSao.test01(userId, uid);
    }

    @GetMapping(value = "/user/test03")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test03() {
        logger.info("UserGuidHolder.getGuid=" + UserGuidHolder.getGuid());
        return refreshValueConfig.getGitreponame();
    }

    @GetMapping(value = "/user/test04")
    @ApiOperation(response = String.class, value = "获取名称")
    public String test04() {
        logger.info("UserGuidHolder.getGuid=" + UserGuidHolder.getGuid());
        return "长哈哈";
    }

    @PostMapping(value = "/user/register")
    @ApiOperation(response = void.class, value = "注册用户")
    public void register(@RequestBody UserDTO userDTO) {
        userService.register(userDTO);
    }

    @PostMapping(value = "/user/rabbit")
    @ApiOperation(response = void.class, value = "注册用户")
    public void rabbit() {
        userService.rabbit();
    }

    @PostMapping(value = "/user/setUserAndUrl")
    @ApiOperation(response = void.class, value = "setUserAndUrl")
    public void setUserAndUrl() {
        userService.setUserAndUrl();
    }

    /*@PostMapping(value = "/user/registerDelayTask")
    @ApiOperation(response = void.class, value = "registerDelayTask")
    public void registerDelayTask() throws Exception {
        userService.registerDelayTask();
    }

    @PostMapping(value = "/user/DelayTaskcancel/{taskId}")
    @ApiOperation(response = void.class, value = "DelayTaskcancel")
    public void cancel(@PathVariable("taskId")String taskId) {
        userService.cancel(taskId);
    }*/

}
