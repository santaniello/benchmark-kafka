package com.example.benchmarkkafkaconsumermultithread.repositories;

import com.example.benchmarkkafkaconsumermultithread.models.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface OrderItemRepository extends ReactiveCrudRepository<OrderItem, Long> {
    Flux<OrderItem> findByIdOrder(Long idOrder);
}
