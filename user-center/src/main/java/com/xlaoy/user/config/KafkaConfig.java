package com.xlaoy.user.config;

/*import com.xlaoy.user.service.RequestUrlMessageListener;
import com.xlaoy.user.service.SaveOffsetsOnRebalance;
import com.xlaoy.user.service.TestMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.adapter.RecordMessagingMessageListenerAdapter;
import org.springframework.kafka.listener.config.ContainerProperties;*/

/**
 * Created by Administrator on 2018/12/21 0021.
 */
//@Configuration
public class KafkaConfig {

    /*@Autowired
    private ConsumerFactory consumerFactory;
    @Autowired
    private SaveOffsetsOnRebalance saveOffsetsOnRebalance;
    @Autowired
    private RequestUrlMessageListener requestUrlMessageListener;*/

    /*@Bean
    public KafkaMessageListenerContainer requestUrlMessageListenerContainer() {
        ContainerProperties containerProperties = new ContainerProperties("request_url");
        containerProperties.setGroupId("xlaoy-1");
        containerProperties.setConsumerRebalanceListener(saveOffsetsOnRebalance);
        containerProperties.setMessageListener(requestUrlMessageListener);
        //containerProperties.setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL);
        //containerProperties.setSyncCommits(false);
        KafkaMessageListenerContainer requestUrlMessageListenerContainer = new KafkaMessageListenerContainer(consumerFactory, containerProperties);
        return requestUrlMessageListenerContainer;
    }*/

    /*@Bean
    public KafkaMessageListenerContainer testMessageListenerContainer() {
        ContainerProperties containerProperties = new ContainerProperties("test");
        containerProperties.setGroupId("test-1");
        containerProperties.setConsumerRebalanceListener(saveOffsetsOnRebalance);
        containerProperties.setMessageListener(testMessageListener);
        //containerProperties.setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL);
        //containerProperties.setSyncCommits(false);
        KafkaMessageListenerContainer testMessageListenerContainer = new KafkaMessageListenerContainer(consumerFactory, containerProperties);
        return testMessageListenerContainer;
    }*/
}
