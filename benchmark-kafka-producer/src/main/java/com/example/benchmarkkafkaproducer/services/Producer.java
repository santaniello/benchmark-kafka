package com.example.benchmarkkafkaproducer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {

    private static final String TOPIC_ORDER = "orders";

    private static final String TOPIC_ORDER_ITENS = "itens";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendOrder(String message){
        log.info(String.format("$$ -> Producing message --> %s",message));
        this.kafkaTemplate.send(TOPIC_ORDER,message);
    }

    public void sendOrderItem(String message){
        log.info(String.format("$$ -> Producing message --> %s",message));
        this.kafkaTemplate.send(TOPIC_ORDER_ITENS,message);
    }
}