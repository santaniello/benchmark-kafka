package com.example.benchmarkkafkaproducer.models;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItem {
    private Long idOrder;
    private Long idOrderItem;
    private String productName;
    private Integer price;

    public static OrderItem getInstance(Order order){
        OrderItem orderItem = new OrderItem();
        Faker faker = new Faker();
        orderItem.setIdOrder(order.getIdOrder());
        orderItem.setIdOrderItem(faker.number().randomNumber());
        orderItem.setProductName(faker.rockBand().name());
        orderItem.setPrice(faker.number().randomDigit());
        return orderItem;
    }
}
