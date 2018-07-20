package com.xlaoy.user.fallback;

import com.xlaoy.innerapi.trade.sao.ITradeSao;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/20 0020.
 */
//@Component("ITradeSaoFallBack")
public class ITradeSaoFallback implements ITradeSao {

    @Override
    public String test01() {
        return "test";
    }
}
