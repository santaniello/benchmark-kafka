package com.example.benchmarkkafkaconsumermultithread.repositories;

import com.example.benchmarkkafkaconsumermultithread.models.AggregationStatus;
import com.example.benchmarkkafkaconsumermultithread.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
    List<Order> findByStatus(AggregationStatus status);
}
