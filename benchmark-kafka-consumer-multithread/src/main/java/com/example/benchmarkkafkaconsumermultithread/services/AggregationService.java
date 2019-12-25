package com.example.benchmarkkafkaconsumermultithread.services;

import com.example.benchmarkkafkaconsumermultithread.models.Order;
import com.example.benchmarkkafkaconsumermultithread.models.OrderItem;
import com.example.benchmarkkafkaconsumermultithread.repositories.OrderItemRepository;
import com.example.benchmarkkafkaconsumermultithread.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.benchmarkkafkaconsumermultithread.models.AggregationStatus.AGGREGATED;
import static com.example.benchmarkkafkaconsumermultithread.models.AggregationStatus.PENDING;

@Slf4j
@Service
public class AggregationService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    // A cada 3 minutos
    @Scheduled(cron="0 0/1 * 1/1 * ?")
    public void aggregate(){
        log.info("Initializing Aggregation");
        List<Order> orders = orderRepository.findByStatus(PENDING);
        if(orders.size() > 0) {
            orders.forEach(order -> {
                List<OrderItem> itens = orderItemRepository.findByIdOrder(order.getIdOrder());
                if(itens != null && itens.size() > 0) {
                    updateItem(order, itens.get(0));
                    orderItemRepository.deleteById(itens.get(0).getIdOrderItem());
                }
            });
        }
        log.info("Ending Aggregation");
    }

    public void updateItem(Order order, OrderItem item){
        if(item != null){
            order.addItem(item);
            order.setStatus(AGGREGATED);
            orderRepository.save(order);
        }
    }
}
