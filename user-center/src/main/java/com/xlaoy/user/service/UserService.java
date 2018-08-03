package com.xlaoy.user.service;

import com.xlaoy.common.constants.RedisHashName;
import com.xlaoy.common.exception.BizException;
import com.xlaoy.common.utils.IDWorkUtil;
import com.xlaoy.common.utils.JSONUtil;
import com.xlaoy.user.config.RabbitConfig;
import com.xlaoy.user.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/3 0003.
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void test01() {
        throw new BizException("你牛逼");
    }

    public void register(UserDTO userDTO) {
        String guid = IDWorkUtil.getUUID();
        redisTemplate.opsForHash().put(RedisHashName.USER, guid, userDTO);
    }

    public void setUserAndUrl() {
        redisTemplate.opsForHash().put(RedisHashName.USER_PERMISSION, "asdasdfasfaq243fsdf43qwef", Arrays.asList("ROLE_ORDINARY_USER", "ROLE_TRADE_USER"));
        redisTemplate.opsForHash().put(RedisHashName.URL_PERMISSION, "/api-user/user/test04", Arrays.asList("ROLE_ORDINARY_USER","ROLE_DD"));
    }

    public void rabbit() {
        UserDTO dto = new UserDTO();
        dto.setUserName("haha");
        dto.setNickName("ll");
        rabbitTemplate.convertAndSend(RabbitConfig.WO_CAO, dto);
        logger.info("消息发送成功：" + JSONUtil.toJsonString(dto));
    }

    @RabbitListener(queues = RabbitConfig.WO_CAO)
    @RabbitHandler
    public void rabbitProcess(UserDTO dto) {
        logger.info("收到消息：" + JSONUtil.toJsonString(dto));
    }

}
