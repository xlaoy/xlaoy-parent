package com.xlaoy.starter.config;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/11 0011.
 */
@Component
public class SetupConfig implements Runnable {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicationInfoManager infoManager;

    @Override
    public void run() {
        //infoManager.setInstanceStatus(InstanceInfo.InstanceStatus.DOWN);
        //logger.info("应用状态设置为DOWN");
    }
}
