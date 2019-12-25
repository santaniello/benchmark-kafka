package com.example.benchmarkkafkaconsumermultithread;

import com.example.benchmarkkafkaconsumermultithread.models.Order;
import com.example.benchmarkkafkaconsumermultithread.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import static com.example.benchmarkkafkaconsumermultithread.models.AggregationStatus.PENDING;

@Slf4j
@Component
public class ListenerOrder {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private OrderService orderService;

    @KafkaListener(id = "id4", topicPartitions = { @TopicPartition(topic = "orders", partitions = { "0" }) })
    public void listenPartition0(String message) throws JsonProcessingException {
        System.out.println("ListenerOrder Id0, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
        saveOrder(message);
    }
 
    @KafkaListener(id = "id5", topicPartitions = { @TopicPartition(topic = "orders", partitions = { "1" }) })
    public void listenPartition1(String message) throws JsonProcessingException {
        System.out.println("ListenerOrder Id1, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
        saveOrder(message);
    }
 
    @KafkaListener(id = "id6", topicPartitions = { @TopicPartition(topic = "orders", partitions = { "2" }) })
    public void listenPartition2(String message) throws JsonProcessingException {
        System.out.println("ListenerOrder Id2, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
        saveOrder(message);
    }

    private void saveOrder(String message) throws JsonProcessingException {
        var order = mapper.readValue(message, Order.class);
        order.setStatus(PENDING);
        orderService.saveOrder(order);
    }
}