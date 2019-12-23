package com.example.benchmarkkafkaconsumerreactive.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "order")
public class Order {
   @Id
   @Field("_id")
   private Long idOrder;
   private String customerName;
   private Date creationDate;
   private AggregationStatus status;
   private List<OrderItem> itens = new ArrayList<>();

   public void addItem(OrderItem item){
      itens.add(item);
   }
}
