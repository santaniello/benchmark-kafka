package com.example.benchmarkkafkareactive.services;

import com.example.benchmarkkafkareactive.models.Order;
import com.example.benchmarkkafkareactive.models.OrderItem;
import com.example.benchmarkkafkareactive.repositories.OrderItemRepository;
import com.example.benchmarkkafkareactive.repositories.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.ReceiverRecord;

import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void save(Order order){
        orderRepository.save(order).subscribe();
    }

//    public void saveOrderItem(OrderItem orderItem){
//        List<OrderItem> itens = orderItemRepository.findByIdOrder(orderItem.getIdOrder());
//        if(itens.size() == 0){
//            orderItemRepository.save(orderItem);
//        }
//    }
}
