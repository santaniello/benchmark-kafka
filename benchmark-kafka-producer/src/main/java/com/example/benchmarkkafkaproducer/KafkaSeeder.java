package com.example.benchmarkkafkaproducer;

import com.example.benchmarkkafkaproducer.models.Order;
import com.example.benchmarkkafkaproducer.models.OrderItem;
import com.example.benchmarkkafkaproducer.services.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KafkaSeeder implements CommandLineRunner {

    private Producer producer;

    @Autowired
    public KafkaSeeder(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args)  {
        for(int x = 0; x < 50; x++){
            Order order = Order.getInstance();
            producer.sendOrder(orderToJson(order));
            OrderItem orderItem = OrderItem.getInstance(order);
            producer.sendOrderItem(orderItemToJson(orderItem));
        }
    }

    private String orderToJson(Order order){
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    private String orderItemToJson(OrderItem orderItem){
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(orderItem);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}