package com.example.benchmarkkafkaconsumerreactive;

import java.util.concurrent.CountDownLatch;

import com.example.benchmarkkafkaconsumerreactive.models.CalculateTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ListenerOrder {
    public CountDownLatch countDownLatch0 = new CountDownLatch(3);
    public CountDownLatch countDownLatch1 = new CountDownLatch(3);
    public CountDownLatch countDownLatch2 = new CountDownLatch(3);

    @KafkaListener(id = "id4", topicPartitions = { @TopicPartition(topic = "orders", partitions = { "0" }) })
    public void listenPartition0(String message) {
        System.out.println("ListenerOrder Id0, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
      //  countDownLatch0.countDown();
    }
 
    @KafkaListener(id = "id5", topicPartitions = { @TopicPartition(topic = "orders", partitions = { "1" }) })
    public void listenPartition1(String message) {
        System.out.println("ListenerOrder Id1, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
      //  countDownLatch1.countDown();
    }
 
    @KafkaListener(id = "id6", topicPartitions = { @TopicPartition(topic = "orders", partitions = { "2" }) })
    public void listenPartition2(String message) {
        System.out.println("ListenerOrder Id2, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
     //   countDownLatch2.countDown();
    }
}