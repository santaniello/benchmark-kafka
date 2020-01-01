package com.example.benchmarkkafkareactive;

import com.example.benchmarkkafkareactive.models.Order;
import com.example.benchmarkkafkareactive.properties.KafkaProperties;
import com.example.benchmarkkafkareactive.repositories.OrderRepository;
import com.example.benchmarkkafkareactive.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;

@Slf4j
@Service
public class Consumer implements ApplicationRunner {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Autowired
    private KafkaReceiver<String,String> kafkaReceiver;

//    @Autowired
//    private OrderService orderService;

    @Autowired
    private OrderRepository repository;

    @Override
    public void run(ApplicationArguments args){
        getRecordsByTopic("orders").doOnNext(r -> {
            Order order = toOrder(r.value());
            System.out.println(order);
            repository.save(order).subscribe();
            r.receiverOffset().acknowledge();
        }).doOnError(e-> {
            log.error(e.getMessage());
        }).subscribe();
    }

    private Order toOrder(String message){
        Order order = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            order = mapper.readValue(message,Order.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return order;
    }

    private Flux<ReceiverRecord<String, String>> getRecordsByTopic(String topicName){
        return kafkaReceiver.receive()
                            .filter(record -> record.topic().equals("orders"));
    }
}
