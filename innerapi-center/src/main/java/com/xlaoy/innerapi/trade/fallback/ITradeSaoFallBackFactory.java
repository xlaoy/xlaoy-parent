package com.xlaoy.innerapi.trade.fallback;

import com.xlaoy.innerapi.trade.sao.ITradeSao;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
@Component
public class ITradeSaoFallBackFactory implements FallbackFactory<ITradeSao> {

    @Autowired
    private ApplicationContext context;

    @Override
    public ITradeSao create(Throwable throwable) {
        if(context.containsBean("ITradeSaoFallBack")) {
            return (ITradeSao)context.getBean("ITradeSaoFallBack");
        }
        return new ITradeSao() {
            @Override
            public String test01() {
                return "FallbackFactory";
            }
        };
    }
}
