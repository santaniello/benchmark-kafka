package com.example.benchmarkkafkaconsumermultithread.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "orderItem")
public class OrderItem {
    @Id
    @Field("_id")
    private Long idOrderItem;
    private Long idOrder;
    private String productName;
    private Integer price;
}
