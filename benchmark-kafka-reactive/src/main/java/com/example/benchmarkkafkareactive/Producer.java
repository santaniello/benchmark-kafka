package com.example.benchmarkkafkareactive;

import com.example.benchmarkkafkareactive.models.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Slf4j
@Service
public class Producer{ // implements ApplicationRunner {
//    @Autowired
//    private KafkaSender<Integer, String> kafkaProducer;
//
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("Executado");
//        String payload = new ObjectMapper().writeValueAsString(new Order("Teste"));
//        SenderRecord<Integer, String, Integer> message = SenderRecord.create(new ProducerRecord<>("lala", payload),1);
//        //kafkaProducer.send(Mono.just(message)).next().subscribe();
//        kafkaProducer.send(Mono.just(message)).next();
//    }
}
