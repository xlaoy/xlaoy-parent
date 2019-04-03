package com.xlaoy.starter.config;

import io.shardingjdbc.core.api.HintManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/4/3 0003.
 */
@Aspect
@Component
public class ShardingJDBCAspect {


    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void userMaster(JoinPoint point) {
        HintManager.getInstance().setMasterRouteOnly();
    }
}
