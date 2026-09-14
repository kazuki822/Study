package com.example.order.service;

import java.util.List;

public interface OrderRepository {
    Order findById(String orderId);
    List<Order> findByCustomerId(String customerId);
    void save(Order order);
    void update(Order order);
}
