package com.example.benchmarkkafkaconsumerreactive.repositories;

import com.example.benchmarkkafkaconsumerreactive.models.AggregationStatus;
import com.example.benchmarkkafkaconsumerreactive.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
    List<Order> findByStatus(AggregationStatus status);
}
