package com.example.order.service;

public class OrderItem {

    private String productId;
    private String productName;
    private int unitPrice;
    private int quantity;

    public OrderItem(String productId, String productName, int unitPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getProductId()   { return productId; }
    public String getProductName() { return productName; }
    public int getUnitPrice()      { return unitPrice; }
    public int getQuantity()       { return quantity; }
    public int getSubtotal()       { return unitPrice * quantity; }
}