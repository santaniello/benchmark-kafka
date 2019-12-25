package com.example.benchmarkkafkaconsumermultithread.repositories;

import com.example.benchmarkkafkaconsumermultithread.models.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, Long> {
    List<OrderItem> findByIdOrder(Long idOrder);
}
