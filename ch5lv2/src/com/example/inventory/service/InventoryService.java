package com.example.inventory.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryService {

    private static final Logger logger =
            LoggerFactory.getLogger(InventoryService.class);

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public StockItem findByCode(String itemCode) {
        logger.debug("在庫検索: itemCode={}", itemCode);

        return repository.findByCode(itemCode);
    }

    public boolean isInStock(String itemCode) {
        StockItem item = repository.findByCode(itemCode);

        if (item == null) {
            return false;
        }

        return item.getQuantity() > 0;
    }

    public void receive(String itemCode, int receiveQty) {
        logger.info("入庫処理: itemCode={}, qty={}", itemCode, receiveQty);

        if (receiveQty <= 0) {
            throw new IllegalArgumentException("入庫数は1以上で指定してください");
        }

        StockItem item = repository.findByCode(itemCode);

        if (item == null) {
            throw new IllegalArgumentException(
                    "存在しない商品コードです: " + itemCode);
        }

        item.setQuantity(item.getQuantity() + receiveQty);
        repository.update(item);
    }

    public void ship(String itemCode, int shipQty) {
        logger.info("出庫処理: itemCode={}, qty={}", itemCode, shipQty);

        if (shipQty <= 0) {
            throw new IllegalArgumentException("出庫数は1以上で指定してください");
        }

        StockItem item = repository.findByCode(itemCode);

        if (item == null) {
            throw new IllegalArgumentException(
                    "存在しない商品コードです: " + itemCode);
        }

        if (item.getQuantity() < shipQty) {
            throw new InsufficientStockException(
                    itemCode, shipQty, item.getQuantity());
        }

        item.setQuantity(item.getQuantity() - shipQty);
        repository.update(item);
    }

    public List<StockItem> findBelowReorderPoint() {
        logger.info("発注点割れ商品取得");

        return repository.findBelowReorderPoint();
    }
}