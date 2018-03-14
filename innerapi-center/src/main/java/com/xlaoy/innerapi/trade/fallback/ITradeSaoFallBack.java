package com.xlaoy.innerapi.trade.fallback;

import com.xlaoy.innerapi.trade.ITradeSao;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
@Component
public class ITradeSaoFallBack implements ITradeSao {

    @Override
    public String getHH() {
        return "error";
    }
}
