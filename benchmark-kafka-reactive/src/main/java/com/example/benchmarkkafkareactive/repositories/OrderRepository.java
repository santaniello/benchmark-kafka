package com.example.benchmarkkafkareactive.repositories;

import com.example.benchmarkkafkareactive.models.AggregationStatus;
import com.example.benchmarkkafkareactive.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, Long> {
    Flux<Order> findByStatus(AggregationStatus status);
}
