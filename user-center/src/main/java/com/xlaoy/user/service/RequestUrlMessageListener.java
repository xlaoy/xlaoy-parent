/*
package com.xlaoy.user.service;

import com.xlaoy.common.exception.BizException;
import kafka.coordinator.group.BaseKey;
import kafka.coordinator.group.GroupMetadataManager;
import kafka.coordinator.group.GroupTopicPartition;
import kafka.coordinator.group.OffsetKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;



@Slf4j
@Component
public class RequestUrlMessageListener implements AcknowledgingMessageListener<byte[], byte[]> {


    @Override
    public void onMessage(ConsumerRecord<byte[], byte[]> record, Acknowledgment acknowledgment) {
        log.info("收到kafka RequestUrl 消息:" + record.toString());
        BaseKey key = GroupMetadataManager.readMessageKey(ByteBuffer.wrap(record.key()));
        if(key instanceof OffsetKey) {
            GroupTopicPartition groupTopicPartition = (GroupTopicPartition) key.key();
            String topic = groupTopicPartition.topicPartition().topic();
            int partition = groupTopicPartition.topicPartition().partition();
            String group = groupTopicPartition.group();
            log.info("topic=" + topic + ", partition=" + partition + ", group" + group);
        }
    }

    private byte[] getObjectBytes(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            byte[] bytes = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return bytes;
        } catch (Exception e) {
            throw new BizException("aa");
        }
    }


}
*/
