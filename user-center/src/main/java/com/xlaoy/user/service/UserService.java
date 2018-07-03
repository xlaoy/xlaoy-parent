package com.xlaoy.user.service;

import com.xlaoy.common.exception.BizException;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/3 0003.
 */
@Service
public class UserService {

    public void test01() {
        throw new BizException("你牛逼");
    }
}
