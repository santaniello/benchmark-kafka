package com.example.benchmarkkafkaconsumerreactive.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {
   private Long idOrder;
   private String customerName;
   private Date creationDate;
   private AggregationStatus status;
   private List<OrderItem> itens = new ArrayList<>();

   public void addItem(OrderItem item){
      itens.add(item);
   }
}
