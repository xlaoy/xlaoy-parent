/*
package com.xlaoy.user.service;

import com.xlaoy.user.repository.IKafkaOffSetRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.ConsumerAwareRebalanceListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
public class SaveOffsetsOnRebalance implements ConsumerAwareRebalanceListener {

    //@Autowired
    //private IKafkaOffSetRepository offSetRepository;

    @Override
    public void onPartitionsRevokedBeforeCommit(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {

    }

    @Override
    public void onPartitionsRevokedAfterCommit(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {

    }

    */
/**
     * 分区分配完成后
     * 重新设置offset
     *//*

    @Override
    public void onPartitionsAssigned(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
        for(TopicPartition partition : partitions) {
            OffsetAndMetadata offset = consumer.committed(partition);
            log.info("onPartitionsAssigned>>>" + partition.toString() + "|" + offset.toString());
            consumer.seek(partition, offset.offset());
        }
    }
}
*/
