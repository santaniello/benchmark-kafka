package com.example.benchmarkkafkaconsumer.repositories;

import com.example.benchmarkkafkaconsumer.models.AggregationStatus;
import com.example.benchmarkkafkaconsumer.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
    List<Order> findByStatus(AggregationStatus status);
}
