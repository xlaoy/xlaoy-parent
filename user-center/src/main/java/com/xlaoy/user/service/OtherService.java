package com.xlaoy.user.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/12/24 0024.
 */
@Slf4j
@Service
public class OtherService {

    @KafkaListener(topics = "test", groupId = "test-1")
    public void reciver(ConsumerRecord<String, String> record) {
        log.info("收到kafka消息，record=" + record);
    }

}
