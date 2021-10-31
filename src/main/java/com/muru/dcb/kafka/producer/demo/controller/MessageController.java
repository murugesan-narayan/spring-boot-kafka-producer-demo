package com.muru.dcb.kafka.producer.demo.controller;

import com.muru.dcb.kafka.producer.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate;

    private final String TOPIC_NAME = "TestTopic";

    @PostMapping("/publish")
    public String publish(@RequestBody Book book) {
        kafkaTemplate.send(TOPIC_NAME, book);
        return "Message Published Successfully";
    }

}
