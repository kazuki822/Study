package com.example.order.service;

public class OrderCancelledException extends RuntimeException {
    public OrderCancelledException(String orderId) {
        super("キャンセル済みの注文です: " + orderId);
    }
}