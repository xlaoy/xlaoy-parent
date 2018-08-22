package com.xlaoy.trade.task;

import com.task.client.SecheduledTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Administrator on 2018/8/19 0019.
 */
@Component
public class TradeTask implements SecheduledTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String cron() {
        return "0 0/5 * * * ?";
    }

    @Override
    public void execute(String parameters) {
        logger.info(">>>TradeTask:" + parameters);
    }
}
