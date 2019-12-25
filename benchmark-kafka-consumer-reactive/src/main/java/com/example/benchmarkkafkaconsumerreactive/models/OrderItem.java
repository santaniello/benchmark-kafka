package com.example.benchmarkkafkaconsumerreactive.models;

import lombok.Data;

@Data
public class OrderItem {
    private Long idOrderItem;
    private Long idOrder;
    private String productName;
    private Integer price;
}
