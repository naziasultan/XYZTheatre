package com.theatre.xyz.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class TheatreEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public TheatreEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTheatreUpdateEvent(String message) {
        log.info("Topic sent to theatre-update-topic");
        kafkaTemplate.send("theatre-update-topic", message);
    }
}
