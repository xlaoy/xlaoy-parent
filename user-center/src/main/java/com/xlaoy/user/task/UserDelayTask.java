
package com.xlaoy.user.task;

import com.task.client.DelayTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2018/8/21 0021.
 */

@Component
public class UserDelayTask implements DelayTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String bizName() {
        return "usernot444ify";
    }

    @Override
    public void execute(String bizParameters) {
        logger.info("DelayTask>>>" + bizParameters);
    }
}

