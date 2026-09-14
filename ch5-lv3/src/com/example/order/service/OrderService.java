package com.example.order.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order findById(String orderId) {
        logger.debug("注文検索: orderId={}", orderId);
        return repository.findById(orderId);
    }

    public List<Order> findByCustomerId(String customerId) {
        logger.debug("顧客別注文検索: customerId={}", customerId);
        return repository.findByCustomerId(customerId);
    }

    public void place(Order order) {
        logger.info("注文受付: orderId={}, customerId={}", order.getOrderId(), order.getCustomerId());
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("注文明細が空です");
        }
        if (order.getTotalAmount() <= 0) {
            throw new IllegalArgumentException("合計金額は1円以上である必要があります");
        }
        repository.save(order);
    }

    public void cancel(String orderId) {
        logger.info("注文キャンセル: orderId={}", orderId);
        Order order = repository.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("注文が見つかりません: " + orderId);
        }
        if ("キャンセル".equals(order.getStatus())) {
            throw new OrderCancelledException(orderId);
        }
        order.setStatus("キャンセル");
        repository.update(order);
    }

    public int calcTotalAmount(String orderId) {
        Order order = repository.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("注文が見つかりません: " + orderId);
        }
        return order.getTotalAmount();
    }
}