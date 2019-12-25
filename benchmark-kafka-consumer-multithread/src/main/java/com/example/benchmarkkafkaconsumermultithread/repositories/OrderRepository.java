package com.example.benchmarkkafkaconsumermultithread.repositories;

import com.example.benchmarkkafkaconsumermultithread.models.AggregationStatus;
import com.example.benchmarkkafkaconsumermultithread.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    Flux<Order> findByStatus(AggregationStatus status);
}
