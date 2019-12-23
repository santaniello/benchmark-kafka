package com.example.benchmarkkafkaconsumerreactive.services;

import com.example.benchmarkkafkaconsumerreactive.models.Order;
import com.example.benchmarkkafkaconsumerreactive.models.OrderItem;
import com.example.benchmarkkafkaconsumerreactive.repositories.OrderItemRepository;
import com.example.benchmarkkafkaconsumerreactive.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public void saveOrderItem(OrderItem orderItem){
        List<OrderItem> itens = orderItemRepository.findByIdOrder(orderItem.getIdOrder());
        if(itens.size() == 0){
            orderItemRepository.save(orderItem);
        }
    }
}
