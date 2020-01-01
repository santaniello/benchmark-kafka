package com.example.benchmarkkafkareactive.services;

import com.example.benchmarkkafkareactive.models.Order;
import com.example.benchmarkkafkareactive.models.OrderItem;
import com.example.benchmarkkafkareactive.repositories.OrderItemRepository;
import com.example.benchmarkkafkareactive.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.benchmarkkafkareactive.models.AggregationStatus.AGGREGATED;

@Slf4j
@Service
public class AggregationService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    // A cada 3 minutos
//    @Scheduled(cron="0 0/1 * 1/1 * ?")
//    public void aggregate(){
//        log.info("Initializing Aggregation");
//        List<Order> orders = orderRepository.findByStatus(PENDING);
//        if(orders.size() > 0) {
//            orders.forEach(order -> {
//                List<OrderItem> itens = orderItemRepository.findByIdOrder(order.getIdOrder());
//                if(itens != null && itens.size() > 0) {
//                    updateItem(order, itens.get(0));
//                    orderItemRepository.deleteById(itens.get(0).getIdOrderItem());
//                }
//            });
//        }
//        log.info("Ending Aggregation");
//    }

    public void updateItem(Order order, OrderItem item){
        if(item != null){
            order.addItem(item);
            order.setStatus(AGGREGATED);
            orderRepository.save(order);
        }
    }
}
