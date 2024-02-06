package com.syam.springboot.user.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaConfig {

    @Bean
    public NewTopic topicuserinsertEvents() {
        return TopicBuilder.name("userinsert-events")
                .partitions(5)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicuserUpdateEvents() {
        return TopicBuilder.name("userupdate-events")
                .partitions(5)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicuserDeleteEvents() {
        return TopicBuilder.name("userdelete-events")
                .partitions(5)
                .replicas(1)
                .build();
    }
}
