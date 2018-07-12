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
public class SystemAppController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicationInfoManager infoManager;

    @Autowired
    Environment env;

    @GetMapping("/system_app/get_instance_info")
    @ApiOperation(response = String.class, value = "获取服务信息")
    public InstanceInfo getInstanceInfo() {
        return infoManager.getInfo();
    }

    @GetMapping("/system_app/get_property")
    @ApiOperation(response = String.class, value = "获取服务信息")
    public String getProperty(@RequestParam("key") String key) {
        return env.getProperty(key);
    }

    @PostMapping("/actuator/set_instance_status/{status}")
    @ApiOperation(response = String.class, value = "设置服务状态")
    public void setInstanceStatus(@PathVariable("status") String status) {
        if("up".equals(status)) {
            infoManager.setInstanceStatus(InstanceInfo.InstanceStatus.UP);
        }
        if("down".equals(status)) {
            infoManager.setInstanceStatus(InstanceInfo.InstanceStatus.DOWN);
        }
    }

}
