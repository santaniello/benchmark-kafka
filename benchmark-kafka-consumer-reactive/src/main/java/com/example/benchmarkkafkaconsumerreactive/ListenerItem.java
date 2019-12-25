package com.example.benchmarkkafkaconsumerreactive;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class ListenerItem {
    public CountDownLatch countDownLatch0 = new CountDownLatch(3);
    public CountDownLatch countDownLatch1 = new CountDownLatch(3);
    public CountDownLatch countDownLatch2 = new CountDownLatch(3);


    @KafkaListener(id = "id0", topicPartitions = { @TopicPartition(topic = "itens", partitions = { "0" }) })
    public void listenPartition0(String message) {
        System.out.println("ListenerOrder Id0, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
       // countDownLatch0.countDown();
    }
 
    @KafkaListener(id = "id1", topicPartitions = { @TopicPartition(topic = "itens", partitions = { "1" }) })
    public void listenPartition1(String message) {
        System.out.println("ListenerOrder Id1, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
       // countDownLatch1.countDown();
    }
 
    @KafkaListener(id = "id2", topicPartitions = { @TopicPartition(topic = "itens", partitions = { "2" }) })
    public void listenPartition2(String message) {
        System.out.println("ListenerOrder Id2, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Received: " + message);
       // countDownLatch2.countDown();
    }
}