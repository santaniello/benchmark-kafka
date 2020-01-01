package com.example.benchmarkkafkareactive.repositories;

import com.example.benchmarkkafkareactive.models.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface OrderItemRepository extends ReactiveMongoRepository<OrderItem, Long> {
    Flux<OrderItem> findByIdOrder(Long idOrder);
}
