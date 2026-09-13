package com.example.inventory.service;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String itemCode, int requested, int available) {
        super(String.format("在庫不足: itemCode=%s, 要求=%d, 現在庫=%d", itemCode, requested, available));
    }
}