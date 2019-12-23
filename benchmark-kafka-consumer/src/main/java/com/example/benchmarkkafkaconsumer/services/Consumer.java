package com.example.benchmarkkafkaconsumer.services;

import com.example.benchmarkkafkaconsumer.models.AggregationStatus;
import com.example.benchmarkkafkaconsumer.models.Order;
import com.example.benchmarkkafkaconsumer.models.OrderItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.example.benchmarkkafkaconsumer.models.AggregationStatus.*;

@Slf4j
@Service
public class Consumer {

    @Autowired
    private OrderService orderService;

    private ObjectMapper mapper = new ObjectMapper();

    public static long timeConsumeOrder;

    public static long timeConsumeOrderItem;

    @KafkaListener(topics = "orders", groupId = "benchmark")
    public void consumeOrders(String message) throws JsonProcessingException {
        long startTime = System.currentTimeMillis();
        log.info(String.format("$$ -> Consumed Message -> %s",message));
        var order = mapper.readValue(message, Order.class);
        order.setStatus(PENDING);
        orderService.saveOrder(order);
        long endTime = System.currentTimeMillis();
        timeConsumeOrder += endTime - startTime;
        log.info("Actual time consumeOrders "+ timeConsumeOrder + " in milliseconds!");
    }

    @KafkaListener(topics = "itens", groupId = "benchmark")
    public void consumeItens(String message) throws JsonProcessingException {
        long startTime = System.currentTimeMillis();
        log.info(String.format("$$ -> Consumed Message -> %s",message));
        var orderItem = mapper.readValue(message, OrderItem.class);
        orderService.saveOrderItem(orderItem);
        long endTime = System.currentTimeMillis();
        timeConsumeOrderItem += endTime - startTime;
        log.info("Actual time consumeItens "+ timeConsumeOrderItem + " in milliseconds!");
    }
}