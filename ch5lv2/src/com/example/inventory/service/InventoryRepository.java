package com.example.inventory.service;

import java.util.List;

public interface InventoryRepository {
    StockItem findByCode(String itemCode);
    List<StockItem> findAll();
    List<StockItem> findBelowReorderPoint();
    void save(StockItem item);
    void update(StockItem item);
}