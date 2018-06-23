package com.xlaoy.starter.controller;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/6/22 0022.
 */
@Api(tags = "系统设置 API")
@RestController
@RequestMapping("/system_app")
public class SystemAppController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicationInfoManager infoManager;

    @Autowired
    Environment env;

    @GetMapping("/getInstanceInfo")
    @ApiOperation(response = String.class, value = "获取服务信息")
    public InstanceInfo getInstanceInfo() {
        return infoManager.getInfo();
    }

    @GetMapping("/getProperty")
    @ApiOperation(response = String.class, value = "获取服务信息")
    public String getProperty(@RequestParam("key") String key) {
        return env.getProperty(key);
    }

    @PostMapping("/setInstanceUp")
    @ApiOperation(response = String.class, value = "设置服务上线")
    public void setInstanceUp() {
        infoManager.setInstanceStatus(InstanceInfo.InstanceStatus.UP);
    }

    @PostMapping("/setInstanceDown")
    @ApiOperation(response = String.class, value = "设置服务下线")
    public void setInstanceDown() {
        infoManager.setInstanceStatus(InstanceInfo.InstanceStatus.DOWN);
    }
}
