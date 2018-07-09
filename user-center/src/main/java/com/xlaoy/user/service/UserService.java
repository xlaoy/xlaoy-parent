package com.xlaoy.user.service;

import com.xlaoy.common.constants.RedisHashName;
import com.xlaoy.common.exception.BizException;
import com.xlaoy.common.utils.IDWorkUtil;
import com.xlaoy.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/3 0003.
 */
@Service
public class UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void test01() {
        throw new BizException("你牛逼");
    }

    public void register(UserDTO userDTO) {
        String guid = IDWorkUtil.getUUID();
        redisTemplate.opsForHash().put(RedisHashName.USER, guid, userDTO);
    }
}
