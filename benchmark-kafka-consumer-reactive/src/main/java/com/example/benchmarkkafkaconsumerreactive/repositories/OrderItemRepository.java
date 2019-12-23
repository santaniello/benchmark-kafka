package com.example.benchmarkkafkaconsumerreactive.repositories;

import com.example.benchmarkkafkaconsumerreactive.models.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, Long> {
    List<OrderItem> findByIdOrder(Long idOrder);
}
