package com.syam.springboot.user.service;

import com.syam.springboot.user.dao.DBUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class KafkaProducer {

    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        log.info("Sending message "+message );
        kafkaTemplate.send(topic,message);
        log.info(" Message sent to "+topic+ " topic");
    }
}
