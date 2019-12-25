package com.example.benchmarkkafkaconsumerreactive.services;

import com.example.benchmarkkafkaconsumerreactive.models.CalculateTime;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Teste {


    private ObjectMapper mapper = new ObjectMapper();

    private CalculateTime calculate = new CalculateTime();


//    @KafkaListener(topics = "orders")
//    public void listenOrders(@Payload String message) throws JsonProcessingException {
//        long startTime = calculate.getTime();
//        log.info(String.format("$$ -> Consumed Message -> %s",message));
//        var order = mapper.readValue(message, Order.class);
//        order.setStatus(PENDING);
//        //orderService.saveOrder(order);
//        long endTime = calculate.getTime();
//        calculate.sumTimeOrder(endTime - startTime);
//        log.info("Actual time consumeOrders "+ calculate.getTimeConsumeOrder() + " in milliseconds!");
//    }
//
//    @KafkaListener(topics = "itens")
//    public void listenOrderItens(@Payload String message) throws JsonProcessingException {
//        long startTime = calculate.getTime();
//        log.info(String.format("$$ -> Consumed Message -> %s",message));
//        var orderItem = mapper.readValue(message, OrderItem.class);
//        //orderService.saveOrderItem(orderItem);
//        long endTime = calculate.getTime();
//        calculate.sumTimeOrderItem(endTime - startTime);
//        log.info("Actual time consumeItens "+ calculate.getTimeConsumeOrderItem() + " in milliseconds!");
//    }
}
