package com.example.benchmarkkafkaconsumermultithread;

import com.example.benchmarkkafkaconsumermultithread.models.OrderItem;
import com.example.benchmarkkafkaconsumermultithread.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class ListenerItem {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private OrderService orderService;


    @KafkaListener(id = "id0", topicPartitions = { @TopicPartition(topic = "itens", partitions = { "0" }) })
    public void listenPartition0(String message) throws JsonProcessingException {
        System.out.println("ListenerOrder Id0, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
        saveOrderItem(message);
    }
 
    @KafkaListener(id = "id1", topicPartitions = { @TopicPartition(topic = "itens", partitions = { "1" }) })
    public void listenPartition1(String message) {
        System.out.println("ListenerOrder Id1, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
        saveOrderItem(message);
    }
 
    @KafkaListener(id = "id2", topicPartitions = { @TopicPartition(topic = "itens", partitions = { "2" }) })
    public void listenPartition2(String message) {
        System.out.println("ListenerOrder Id2, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
        saveOrderItem(message);
    }

    private void saveOrderItem(String message){
        try {
            var item = mapper.readValue(message, OrderItem.class);
            orderService.saveOrderItem(item);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}