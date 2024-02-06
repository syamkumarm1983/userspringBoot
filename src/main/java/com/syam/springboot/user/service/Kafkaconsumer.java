package com.syam.springboot.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syam.springboot.user.dao.DBUser;
import com.syam.springboot.user.model.DBUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class Kafkaconsumer {

    @Autowired
    private DBUserRepository dbuesrRepository;

    @KafkaListener(topics = "userinsert-events",groupId = "myuser")
    public void consumeUserinsertEvents(String message) throws JsonProcessingException, JSONException {
        System.out.println("Message received "+message);
        log.info(message + " Received");
        ObjectMapper mapper = new ObjectMapper();
        DBUser user = mapper.readValue(message, DBUser.class);
        System.out.println("After convertion "+user.toString());
        user.setID(UUID.randomUUID());
        System.out.println("After convertion "+user.toString());
        dbuesrRepository.save(user);
    }

    @KafkaListener(topics = "userupdate-events",groupId = "myuser")
    public void consumeuserUpdateEvents(String message) throws JsonProcessingException, JSONException {
        System.out.println("Message received "+message);
        log.info(message + " Received");
        ObjectMapper mapper = new ObjectMapper();
        DBUser user = mapper.readValue(message, DBUser.class);
        dbuesrRepository.save(user);
    }

    @KafkaListener(topics = "userdelete-events",groupId = "myuser")
    public void consumeuserDeleteEvents(String email) throws JsonProcessingException, JSONException {
        System.out.println("Message received  to delete"+email);
        log.info(email + " Received");
        dbuesrRepository.deleteByemail(email);
    }
}


/*

 */