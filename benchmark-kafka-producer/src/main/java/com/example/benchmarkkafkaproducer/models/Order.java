package com.example.benchmarkkafkaproducer.models;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Order {
   private Long idOrder;
   private String customerName;
   private Date creationDate;

   public static Order getInstance(){
      Order order = new Order();
      Faker faker = new Faker();
      order.setIdOrder(faker.number().randomNumber());
      order.setCustomerName(faker.name().fullName());
      order.setCreationDate(new Date());
      return order;
   }
}
