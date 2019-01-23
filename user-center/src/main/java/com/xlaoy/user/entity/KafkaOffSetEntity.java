package com.xlaoy.user.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2018/12/26 0026.
 */
@Data
@Document(collection = "kafka_offset")
public class KafkaOffSetEntity {

    private String topic;

    private String groupId;

    private Long offset;

}
